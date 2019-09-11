package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.domain.model.Product;
import com.example.domain.repository.ProductRepository;

@Service
public class DetailService {
	@Autowired
	ProductRepository productRepository;

	public void execute(Model model, String id) {
		Product product = new Product();
		product = productRepository.findOne(id);
		
		model.addAttribute("product", product);
	}
}
