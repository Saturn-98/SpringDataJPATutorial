package com.saturn.springbootjpatutorial.jpaTutorial.controllers;

import com.saturn.springbootjpatutorial.jpaTutorial.entities.ProductEntity;
import com.saturn.springbootjpatutorial.jpaTutorial.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {


    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path="/")
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortField){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC,sortField, "price", "quantity"));
    }

    @GetMapping(path = "/asc")
    public List<ProductEntity> getProductInAsc(){
        return productRepository.findAllByOrderByPriceAsc();

    }

    @GetMapping(path = "/desc")
    public List<ProductEntity> getProductInDesc(){
        return productRepository.findAllByOrderByPriceDesc();
    }

    @GetMapping(path = "/sku")
    public List<ProductEntity> getProductBySku(@RequestParam String sku){
        return productRepository.findBySkuContainingIgnoreCaseOrderByPriceDesc(sku);
    }



}
