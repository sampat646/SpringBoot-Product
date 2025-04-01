package com.jsp.product.product.Iservice;

import com.jsp.product.product.entity.Product;

import java.util.List;

public interface IProductService {
    public Product addProduct(Product product);
    public Product findById(int id);
    public Product deleteById(int id);
//    public Product updateById(int id);

    Product updateById(int productId, Product updateProduct);

    List<Product> findAllProduct(Product product);
}
