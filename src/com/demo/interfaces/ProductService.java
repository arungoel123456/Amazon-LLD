package com.demo.interfaces;

import com.demo.dto.Product;

import java.util.Map;

public interface ProductService {
    boolean createProduct(String name, int price, int stock);
    boolean updateProduct(int id, String name, int price, int stock);
    Map<Integer, Product> getProducts();
    boolean checkQuantity(int productId, int quantity);
}
