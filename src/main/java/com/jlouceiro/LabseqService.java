package com.jlouceiro;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {

    private static Map<Integer, BigInteger> cache = new HashMap<>();
    static {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

    public BigInteger getLabseqResult(int n) {
        if (n < 0) {
            throw new LabseqException("Input must be a non-negative integer.");
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        for (int i = 4; i <= n; i++) {
            cache.put(i, calcCurrentIndex(i));
        }
        return calcCurrentIndex(n);
    }

    private BigInteger calcCurrentIndex(int i) {
        return cache.get(i - 4).add(cache.get(i - 3));
    }

}
