package com.saturn.springbootjpatutorial.jpaTutorial.repositories;

import com.saturn.springbootjpatutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {


    List<ProductEntity> findAll(Sort sort);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after );

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

    List<ProductEntity> findAllByOrderByPriceAsc();

    List<ProductEntity> findAllByOrderByPriceDesc();

    List<ProductEntity> findBySkuContainingIgnoreCaseOrderByPriceDesc(String title);




}
