package com.shdinesh.springcrud.controller;

import com.shdinesh.springcrud.db1.entity.Product;
import com.shdinesh.springcrud.db1.repo.ProductRepository;
import com.shdinesh.springcrud.util.ProductUtil;
import com.shdinesh.springcrud.vo.EmployeeResponseVo;
import com.shdinesh.springcrud.vo.ProductRequestVo;
import com.shdinesh.springcrud.vo.ProductResponseVo;
import com.shdinesh.springcrud.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<EmployeeResponseVo> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductVo> productVos = new ArrayList<>();
        products.forEach(product -> {
            ProductVo productVo = ProductUtil.convertToProductVo(product);
            productVos.add(productVo);
        });
        ProductResponseVo productResponseVo = new ProductResponseVo();
        productResponseVo.setProducts(productVos);
        return new ResponseEntity(productResponseVo, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<EmployeeResponseVo> registerProduct(@RequestBody ProductRequestVo productRequestVo) throws ParseException {
        ProductResponseVo productResponseVo = new ProductResponseVo();
        Product product = new Product();
        product = ProductUtil.convertToProductDto(product, productRequestVo);
        product = productRepository.save(product);
        productResponseVo.setProduct(
                ProductUtil.convertToProductVo(product)
        );
        return new ResponseEntity(productResponseVo, HttpStatus.CREATED);

    }
}
