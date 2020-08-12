package com.sample.dockermicroservice.multidatasource.product.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dockermicroservice.multidatasource.exception.ValidationException;
import com.sample.dockermicroservice.multidatasource.product.domain.Product;
import com.sample.dockermicroservice.multidatasource.product.repository.ProductRepository;
import com.sample.dockermicroservice.multidatasource.user.service.UserServiceImpl;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
		
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProductDetails(Long id) {
		LOGGER.debug("Getting Product details for id {}",id);
		return productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public Product createProduct(Product product)  {
		 LOGGER.debug("Creating Product details");
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) throws ValidationException {
		 LOGGER.debug("Updating Product details for product id {}",product.getId());
	        if(!productRepository.findById(product.getId()).isPresent()) {
	            throw new ValidationException("User id not found for update");
	        }
			return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		 productRepository.deleteById(id);

	}

}
