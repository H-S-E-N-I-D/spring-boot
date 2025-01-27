package com.shdinesh.springcrud.vo;

import java.util.List;

public class ProductResponseVo {

    private ProductVo product;
    private List<ProductVo> products;


    public List<ProductVo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductVo> products) {
        this.products = products;
    }

    public ProductVo getProduct() {
        return product;
    }

    public void setProduct(ProductVo product) {
        this.product = product;
    }
}
