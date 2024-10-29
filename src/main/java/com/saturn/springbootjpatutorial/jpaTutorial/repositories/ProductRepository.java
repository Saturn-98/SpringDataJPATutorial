package com.saturn.springbootjpatutorial.jpaTutorial.repositories;

import com.saturn.springbootjpatutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByTitle(String title);
}
