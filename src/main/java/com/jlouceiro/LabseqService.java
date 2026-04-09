package com.jlouceiro;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheName;
import io.quarkus.cache.CaffeineCache;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LabseqService {

    @Inject
    @CacheName("libseq-cache")
    Cache cache;

    @PostConstruct
    public void initialize() {
        cache.as(CaffeineCache.class).put(0, CompletableFuture.completedFuture(BigInteger.ZERO));
        cache.as(CaffeineCache.class).put(1, CompletableFuture.completedFuture(BigInteger.ONE));
        cache.as(CaffeineCache.class).put(2, CompletableFuture.completedFuture(BigInteger.ZERO));
        cache.as(CaffeineCache.class).put(3, CompletableFuture.completedFuture(BigInteger.ONE));
    }

    public BigInteger getLabseqResult(int n) {
        if (n < 0) {
            throw new LabseqException("Input must be a non-negative integer.");
        }

        for (int i = 4; i <= n; i++) {
            CompletableFuture<BigInteger> futureA = cache.as(CaffeineCache.class).getIfPresent(i - 4);
            CompletableFuture<BigInteger> futureB = cache.as(CaffeineCache.class).getIfPresent(i - 3);

            BigInteger sum = futureA.resultNow().add(futureB.resultNow());

            cache.as(CaffeineCache.class).put(i, CompletableFuture.completedFuture(sum));
        }

        return getIfPresent(n);

    }

    private BigInteger getIfPresent(Object key) {
        CompletableFuture<BigInteger> future = cache.as(CaffeineCache.class).getIfPresent(key);
        return future.resultNow();
    }

    private void putInCache(int key, BigInteger value) {
        cache.as(CaffeineCache.class).put(key, CompletableFuture.completedFuture(BigInteger.ZERO));
    }
}
