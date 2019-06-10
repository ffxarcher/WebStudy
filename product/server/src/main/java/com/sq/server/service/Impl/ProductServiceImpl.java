package com.sq.server.service.Impl;



import com.sq.DecreaseStockInput;
import com.sq.ProductInfoOutput;
import com.sq.server.dataobject.ProductInfo;
import com.sq.server.enums.ProductStatusEnum;
import com.sq.server.enums.ResultEnum;
import com.sq.server.exception.ProductException;
import com.sq.server.repository.ProductInfoRepository;
import com.sq.server.service.ProductService;
import com.sq.server.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findAllByProductStatus(ProductStatusEnum.up.getCode());
    }

    /**
     * 返回对应Id的商品信息
     *
     * @param productIdList
     * @return
     */
    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> cartDtoList) {
        for (DecreaseStockInput cartDto : cartDtoList)
        {
            Optional<ProductInfo> productInfoOptional =
                    productInfoRepository.findById(cartDto.getProductId());

            /**
             * 判断商品是否存在
             */
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断库存是否足够
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

            //添加发送mq消息  6-10  测试成功发送对象为可以暴露的公共对象
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(productInfo,productInfoOutput);
            amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutput));

        }
    }
}
