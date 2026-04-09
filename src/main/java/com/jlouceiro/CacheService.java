package com.jlouceiro;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheName;
import io.quarkus.cache.CaffeineCache;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class CacheService {

    @CacheName("libseq-cache")
    Cache cache;

    @PostConstruct
    public void initialize() {
        cache.as(CaffeineCache.class).put(0, CompletableFuture.completedFuture(BigInteger.ZERO));
        cache.as(CaffeineCache.class).put(1, CompletableFuture.completedFuture(BigInteger.ONE));
        cache.as(CaffeineCache.class).put(2, CompletableFuture.completedFuture(BigInteger.ZERO));
        cache.as(CaffeineCache.class).put(3, CompletableFuture.completedFuture(BigInteger.ONE));
    }
}
