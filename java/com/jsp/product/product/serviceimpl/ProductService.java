package com.jsp.product.product.serviceimpl;

import com.jsp.product.product.Iservice.IProductService;
import com.jsp.product.product.entity.Product;
import com.jsp.product.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
      Optional<Product> product = productRepository.findById(id);
      return product.get();
    }

    @Override
    public Product deleteById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            return null;
        }else{
           productRepository.delete(product.get());
        }
        return product.get();
    }

    @Override
    public Product updateById(int productId, Product updateProduct) {
        Optional<Product> optional = productRepository.findById(productId);
        if (optional.isEmpty()){
            return null;
        }else{
            Product existingProduct = optional.get();
            return productRepository.save(updateProduct);
        }
    }

    @Override
    public List<Product> findAllProduct(Product product) {
        return productRepository.findAll();
    }
}
