package com.jlouceiro;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheName;
import io.quarkus.cache.CaffeineCache;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    @CacheName("libseq-cache")
    Cache cache;

    public BigInteger getLabseqResult(int n) {
        if (n < 0) {
            throw new LabseqException("Input must be a non-negative integer.");
        }

        return cache.get(n, k -> {
            if (n == 0 || n == 2) {
                return BigInteger.ZERO;
            }

            if (n == 1 || n == 3) {
                return BigInteger.ONE;
            }

            BigInteger prev4 = BigInteger.ZERO;
            BigInteger prev3 = BigInteger.ONE;
            BigInteger prev2 = BigInteger.ZERO;
            BigInteger prev1 = BigInteger.ONE;
            BigInteger current = prev4;

            for (int i = 4; i <= n; i++) {
                current = prev4.add(prev3);
                prev4 = prev3;
                prev3 = prev2;
                prev2 = prev1;
                prev1 = current;
            }
            return current;
        }).await().indefinitely();

    }

}
