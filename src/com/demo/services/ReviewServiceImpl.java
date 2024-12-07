package com.demo.services;

import com.demo.dto.Product;
import com.demo.dto.Review;
import com.demo.interfaces.ProductService;
import com.demo.interfaces.ReviewService;

import java.util.HashMap;
import java.util.Map;

public class ReviewServiceImpl implements ReviewService {
    Map<Integer, Product> products;
    Map<Integer, Review> reviews;

    public ReviewServiceImpl(Map<Integer, Product> products) {
        this.products = products;
        reviews = new HashMap<>();
    }

    @Override
    public void addReview(String content, String userId, String productId) {
        Review review = new Review(content, userId, productId);
        reviews.put(review.getId(), review);
        products.get(productId).getReviews().add(review);
    }

    public void editReview(String content, String id){
        Review review = reviews.get(id);
        review.setContent(content);
    }

    public void deleteReview(String id){
        // need to remove the references first. Then need to delete the object.
        Review review = reviews.get(id);
        reviews.remove(id);
        products.get(review.getProductId()).getReviews().remove(review);
        review = null;
        System.gc();
    }


}
