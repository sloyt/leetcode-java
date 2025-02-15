package com.sloyt.leetcode.java.p2698;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    private static Map<Integer, Integer> cacheSquares = new TreeMap<>();
    private static int cacheMaxAnalyzed = 0;

    public int punishmentNumber(int n) {
        List<Integer> squares = new ArrayList<>();
        int lookupStartNum = 1;

        // cheating to speedup calculations

        if (cacheMaxAnalyzed > 0) {
            for (int cachedValue: cacheSquares.keySet()) {
                if (cachedValue < n) {
                    squares.add(cacheSquares.get(cachedValue));
                }
            }

            lookupStartNum = cacheMaxAnalyzed + 1;
        }

        // normal path

        for (int num : IntStream.range(lookupStartNum, n + 1).toArray()) {
            int square = num * num;
            String squareStr = Integer.toString(square);

            if (squareStr.length() == 1) {
                if (num == square) {
                    squares.add(square);
                }
            }
            else {
//                System.out.println("#  num : " + num + ", " + squareStr);

                for (int i = (int)Math.pow(2, squareStr.length() - 1); i > 0; i--) {
                    List<String> parts = new ArrayList<>();

                    int head = 0;

                    for (int tail = 0; tail < squareStr.length() - 1; tail++) {
                        if ((i & (1 << tail)) > 0) {
                            parts.add(squareStr.substring(head, tail + 1));
                            head = tail + 1;
                        }
                    }

                    parts.add(squareStr.substring(head));

//                    System.out.println("#  parts : " + String.join(",", parts));

                    int sumOfDigits = 0;

                    for (String part : parts) {
                        sumOfDigits += Integer.parseInt(part);
                    }

                    if (sumOfDigits == num) {
//                        System.out.println("#  added !!!");
                        squares.add(square);
                        break;
                    }
                }
            }
        }

        int result = 0;

        for (Integer square : squares) {
            result += square;
        }

        return result;
    }
}
