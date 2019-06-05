package com.sq.order.service.impl;

import com.sq.DecreaseStockInput;
import com.sq.ProductInfoOutput;
import com.sq.client.ProductClient;
import com.sq.order.Enums.OrderStatus;
import com.sq.order.Enums.PayStatus;
import com.sq.order.dataobject.OrderDetail;
import com.sq.order.dataobject.OrderMaster;
import com.sq.order.dataobject.ProductInfo;
import com.sq.order.dto.OrderDto;
import com.sq.order.repository.OrderDetailRepository;
import com.sq.order.repository.OrderMasterRepository;
import com.sq.order.service.OrderService;
import com.sq.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductClient productClient;


    @Override
    public OrderDto create(OrderDto orderDto) {

        String orderId = KeyUtil.getUniqueKey();
        //查询商品信息（调用查询服务）
        List<String> productList = orderDto.getOrderDetailList().stream()
                .map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productList);

        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);

        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
            for (ProductInfoOutput productInfo : productInfoList) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    orderAmout = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmout);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.getUniqueKey());

                    //订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        //扣库存（调用商品服务）

        List<DecreaseStockInput> cartDtoList = orderDto.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDtoList);


        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMaster.setCreateTime((new Date()));
        orderMaster.setUpdateTime(new Date());
        orderMasterRepository.save(orderMaster);

        return orderDto;
    }
}
