package com.sloyt.leetcode.java.p1352;

import java.util.*;

public class Solution {
    private Deque<Integer> list;

    public Solution() {
        list = new ArrayDeque<>();
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
        } else {
            if (list.isEmpty()) {
                list.add(num);
            } else {
                list.add(num * list.getLast());
            }
        }
    }

    public int getProduct(int k) {
        if (k > list.size()) {
            return 0;
        }

        if (k == list.size()) {
            return list.getLast();
        }

        Iterator<Integer> iter = list.descendingIterator();

        while (k-- > 0) iter.next();

        return list.getLast() / iter.next();
    }
}
