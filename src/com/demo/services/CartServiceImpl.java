package com.demo.services;

import com.demo.dto.Cart;
import com.demo.dto.CartProduct;
import com.demo.dto.Product;
import com.demo.interfaces.CartService;
import com.demo.interfaces.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {
    Map<Integer, Product> products;
    Map<Integer, CartProduct> cartProducts;
    Map<Integer, Cart> carts;
    ProductService productService;

    public CartServiceImpl(Map<Integer, Product> products, ProductService productService) {
        this.products = products;
        cartProducts = new HashMap<>();
        this.productService= productService;
    }

    @Override
    public boolean addToCart(int cartId, int productId, int quantity) {
        Product product = products.get(productId);
        if (product.getStock() <= 0) {
            return false;
        }
        else {
            CartProduct cartProduct = new CartProduct(products.get(productId), quantity, cartId);
            cartProducts.put(cartId, cartProduct);
            carts.get(cartId).getCartProducts().add(cartProduct);
        }
        return false;
    }

    @Override
    public boolean removeFromCart(int cartProductId) {
        CartProduct cartProduct = cartProducts.get(cartProductId);
        cartProducts.remove(cartProductId);
        carts.get(cartProductId).getCartProducts().remove(cartProduct);
        return true;
    }

    public List<CartProduct> fetchCartProducts(int cartId){
        return carts.get(cartId).getCartProducts();
    }

    @Override
    public Cart getCart(int cartId) {
        return carts.get(cartId);
    }

    public boolean validateCart(int cartId){

        return true;
    }

}
