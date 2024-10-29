package com.saturn.springbootjpatutorial.jpaTutorial;

import com.saturn.springbootjpatutorial.jpaTutorial.entities.ProductEntity;
import com.saturn.springbootjpatutorial.jpaTutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Gems")
				.price(BigDecimal.valueOf(23.5))
				.quantity(14)
				.build();
		ProductEntity savedEntity = productRepository.save(productEntity);
		System.out.println(savedEntity);

	}

	@Test
	void getReporitory(){
		List<ProductEntity> productEntities = productRepository.findAll();
		System.out.println(productEntities);
		ProductEntity productEntity = productRepository.findByTitle("Gems");
		System.out.println(productEntity);
	}

}
