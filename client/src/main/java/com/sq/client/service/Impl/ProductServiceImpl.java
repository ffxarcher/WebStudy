package com.sq.client.service.Impl;

import com.sq.client.dto.CartDto;
import com.sq.client.dataobject.ProductInfo;
import com.sq.client.enums.ProductStatusEnum;
import com.sq.client.enums.ResultEnum;
import com.sq.client.exception.ProductException;
import com.sq.client.repository.ProductInfoRepository;
import com.sq.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

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
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto : cartDtoList) {
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

        }
    }
}
