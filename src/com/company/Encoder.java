package com.company;

import java.util.Base64;

class Encoder {
    private Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};

    String encode(String str) {
        return split(ttm(str));
    }

    String decode(String str) {
        return mtt(unsplit(str));
    }

    private String split(String str) {
        StringBuilder ret = new StringBuilder(str.substring(0, primes[0])).append(Integer.parseInt(Integer.toString(primes[0]).substring(0, 1)));
        int a = 1;
        while (sum(a) <= str.length()) {
            ret.append(str, primes[(a - 1) % primes.length], primes[a % primes.length]).append(Integer.parseInt(Integer.toString(primes[a % primes.length]).substring(0, 1)));
            a++;
        }
        ret.append(str.substring(primes[(a - 1) % primes.length]));
        return ret.toString();
    }

    private String unsplit(String str) {
        StringBuilder ret = new StringBuilder(str.substring(0, primes[0]));
        int a = 1;
        while (sum(a) <= str.length()) {
            ret.append(str, a + primes[(a - 1) % primes.length], a + primes[a % primes.length]);
            a++;
        }
        ret.append(str.substring((a - 1) + primes[(a - 1) % primes.length]));
        return ret.toString();
    }

    private String ttm(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    private String mtt(String str) {
        return new String(Base64.getDecoder().decode(str));
    }

    private int sum(int a) {
        int b = 0;
        for (int i = 0; i <= a; i++) {
            b += primes[i % primes.length];
        }
        return b;
    }
}
