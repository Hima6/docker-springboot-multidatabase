package com.sample.dockermicroservice.multidatasource.product.service;

import com.sample.dockermicroservice.multidatasource.exception.ValidationException;
import com.sample.dockermicroservice.multidatasource.product.domain.Product;

public interface ProductService {

	public Product getProductDetails(Long id);
	
	public Product createProduct(Product product);
	
	public Product updateProduct(Product product) throws ValidationException;
	
	public void deleteProduct(Long id);
}
