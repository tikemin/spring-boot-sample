package com.example.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.domain.model.Product;
import com.example.domain.repository.ProductRepository;

@Service
public class HelloService {

	@Autowired
	ProductRepository productRepository;

	public void execute(Model model) {
		List<Product> product_list = new ArrayList<Product>();
		product_list = productRepository.findAll();

		if (product_list.isEmpty() || product_list != null) {
			model.addAttribute("product_list", product_list);
		}

	}
}
