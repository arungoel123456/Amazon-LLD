package com.demo.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class Review {
    private static final AtomicInteger x = new AtomicInteger(0);
    private final int id;
    private String content;
    private String userId;
    private String productId;

    int star;

    public Review(String content, String userId, String productId) {
        this.content = content;
        this.userId = userId;
        this.productId = productId;
        id=x.incrementAndGet();

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
