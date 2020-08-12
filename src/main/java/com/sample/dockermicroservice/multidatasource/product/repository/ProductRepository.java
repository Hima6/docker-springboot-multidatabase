package com.sample.dockermicroservice.multidatasource.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sample.dockermicroservice.multidatasource.product.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

}
