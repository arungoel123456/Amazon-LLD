package com.demo.interfaces;

import com.demo.dto.Review;

public interface ReviewService {
    void addReview(String content, String userId, String productId);
}
