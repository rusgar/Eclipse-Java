package com.erc.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class URLShortener {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = BASE62.length();
    private final Map<String, String> urlMap = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    public String shortenURL(String longUrl) {
        int id = idCounter.incrementAndGet();
        String shortUrl = encode(id);
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String getOriginalURL(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    private String encode(int id) {
        StringBuilder shortUrl = new StringBuilder();
        while (id > 0) {
            shortUrl.append(BASE62.charAt(id % BASE));
            id /= BASE;
        }
        return shortUrl.reverse().toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String longUrl = "https://www.google.com/maps?q=40.7128,-74.0060";
        String shortUrl = shortener.shortenURL(longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Original URL: " + shortener.getOriginalURL(shortUrl));
    }
}
