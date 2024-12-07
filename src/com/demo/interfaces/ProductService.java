package com.demo.interfaces;

import com.demo.dto.Product;

public interface ProductService {
    boolean createProduct(String name, int price, int stock);
    boolean updateProduct(int id, String name, int price, int stock);
}
