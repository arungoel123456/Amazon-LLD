package com.demo.services;

import com.demo.dto.Product;
import com.demo.interfaces.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    Map<Integer, Product> products;
    public ProductServiceImpl() {
        products = new HashMap<>();
    }
    @Override
    public boolean createProduct(String name, int price, int stock) {
        Product product = new Product(name, price, stock);
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public boolean updateProduct(int id, String name, int price, int stock) {
        // add the updation logic here;
        return false;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }
}
