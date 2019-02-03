package com.company;

import java.util.Base64;

class Encoder {
    private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};

    /**
     * @param str string
     * @return encoded string
     */
    public static String encode(String str) {
        return base64Ecnode(split(str));
    }

    /**
     *
     * @param str encoded string
     * @return decoded string
     */
    public static String decode(String str) {
        return unsplit(base64Decode(str));
    }

    /**
     *
     * @param str string
     * @return encoding first step: adding random letters in prime indices
     */
    private static String split(String str) {
        int i = 0;
        for (int prime : primes) {
            if (prime + i > str.length()) {
                return str;
            }
            str = str.substring(0, prime + i) + randomise() + str.substring(prime + i);
            i++;
        }
        return str;
    }

    private static String base64Ecnode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    private static String base64Decode(String str) {
        return new String(Base64.getDecoder().decode(str));
    }

    /**
     * @param str string
     * @return decoding second step: removing random letters from prime indices
     */
    private static String unsplit(String str) {
        for (int prime : primes) {
            if (prime > str.length()) {
                return str;
            }
            str = str.substring(0, prime) + str.substring(prime + 1);
        }
        return str;
    }

    /**
     * @return random letter
     */
    private static String randomise() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w"};
        int rand = (int) (Math.random() * 23);
        return letters[rand];
    }
}
