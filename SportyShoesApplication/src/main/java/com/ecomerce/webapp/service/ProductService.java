package com.ecomerce.webapp.service;

import java.util.List;

import com.ecomerce.webapp.entity.Product;

public interface ProductService {

	public Product createProduct(Product product);
	public List<Product> getAllProducts();
	public void deleteByProductId(int pId);
	public Product findByProductId(int pId);
	public Product updateProduct(Product product);
	public List<Product> findByProductCategory(String productCategory);
}