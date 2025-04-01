package com.jsp.product.product.controller;

import com.jsp.product.product.entity.Product;
import com.jsp.product.product.serviceimpl.ProductService;
import com.jsp.product.product.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produts")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
	Product product1=productService.addProduct(product);

	ResponseStructure<Product> rs = new ResponseStructure<>();
	rs.setStatuscode(HttpStatus.ACCEPTED.value());
	rs.setMessage("Project object created");
	rs.setData(product1);

	return new ResponseEntity<>(rs,HttpStatus.ACCEPTED);
	}

	@GetMapping("/id")
	public ResponseEntity<ResponseStructure<Product>> findById(int productId) {
	Product product=productService.findById(productId);

	ResponseStructure<Product> rs = new ResponseStructure<>();
	rs.setStatuscode(HttpStatus.FOUND.value());
	rs.setMessage("Object Found");
	rs.setData(product);

	return  new ResponseEntity<>(rs, HttpStatus.FOUND);
	}

	@PutMapping("/id")
	public ResponseEntity<ResponseStructure<Product>>  updateById(int productId, @RequestBody Product updateProduct) {
		Product product = productService.updateById(productId, updateProduct);

		ResponseStructure<Product> rs = new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Object got updated");
		rs.setData(product);

		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@DeleteMapping("/id")
	public ResponseEntity<ResponseStructure<Product>> deleteById(int productId) {
		Product product = productService.deleteById(productId);
		ResponseStructure<Product> rs = new ResponseStructure<>();
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Object got deleted");
		rs.setData(product);
		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts(Product product) {
		List<Product> productList = productService.findAllProduct(product);
		ResponseStructure<List<Product>> rs = new ResponseStructure<List<Product>>();
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Products are found");
		rs.setData(productList);

		return new ResponseEntity<>(rs,HttpStatus.FOUND);

	}

}
