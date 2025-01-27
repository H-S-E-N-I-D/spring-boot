package com.shdinesh.springcrud.util;

import com.shdinesh.springcrud.db1.entity.Product;
import com.shdinesh.springcrud.vo.ProductRequestVo;
import com.shdinesh.springcrud.vo.ProductVo;
import org.springframework.beans.BeanUtils;

import java.text.ParseException;

public class ProductUtil {

    public static ProductVo convertToProductVo(Product product) {
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(product, productVo);
        return productVo;
    }

    public static Product convertToProductDto(Product product, ProductRequestVo productRequest) throws ParseException {
        BeanUtils.copyProperties(productRequest, product);
        return product;
    }
}
