package com.sloyt.leetcode.java.p1718;

import java.util.*;

public class Solution {
    public int[] constructDistancedSequence(int n) {
        int maxCharsInResult = (n -1) * 2 + 1;
        List<int[]> variants = new ArrayList<>();

        variants.add(new int[] { 1 });

        for (int i = 2; i <= n; i++) {
            List<int[]> newVariants = new ArrayList<>();

            for (int[] variant : variants) {
                for (int j = -i + 1; j < variant.length; j++) {
                    boolean isLeftOk = true;

                    if (j >= 0) {
                        // check left border
                        if (variant[j] > 0) {
                            isLeftOk = false;
                        }
                    }

                    boolean isRightOk = true;

                    if ((j + i) < variant.length) {
                        // check right border
                        if (variant[j + i] > 0) {
                            isRightOk = false;
                        }
                    }

                    if (isLeftOk && isRightOk) {
                        int newVariantLength = variant.length;

                        // increase left border
                        if (j < 0) {
                            newVariantLength += -j;
                        }

                        // increase right border
                        if ((j + i) >= variant.length) {
                            newVariantLength += j + i - variant.length + 1;
                        }

                        // check borders aren't oversized
                        if (newVariantLength <= maxCharsInResult) {
                            int[] newVariant = new int[newVariantLength];

                            // put values

                            for (int k = 0; k < variant.length; k++) {
                                newVariant[k + (j < 0 ? -j : 0)] = variant[k];
                            }

                            newVariant[j >= 0 ? j : 0] = i;
                            newVariant[j >= 0 ? j + i : i] = i;

                            newVariants.add(newVariant);
                        }
                    }
                }

                // check borders aren't oversized

                if (variant.length + i + 1 <= maxCharsInResult) {
                    // add right shifted variant

                    int[] newVariant = new int[variant.length + i + 1];

                    for (int k = 0; k < variant.length + i + 1; k++) {
                        if (k == 0 || k == i) {
                            newVariant[k] = i;
                        } else if (k > i) {
                            newVariant[k] = variant[k - i - 1];
                        } else {
                            newVariant[k] = 0;
                        }
                    }

                    newVariants.add(newVariant);

                    // add left shifted variant

                    newVariant = new int[variant.length + i + 1];

                    for (int k = 0; k < variant.length + i + 1; k++) {
                        if (k == variant.length || k == variant.length + i) {
                            newVariant[k] = i;
                        } else if (k < variant.length) {
                            newVariant[k] = variant[k];
                        } else {
                            newVariant[k] = 0;
                        }
                    }

                    newVariants.add(newVariant);
                }
            }

            // replace resulting arrays

            variants = newVariants;
        }

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < (n -1) * 2 + 1; i++) {
            int max = 0;

            if (indices.size() > 0) {
                List<Integer> newIndices = new ArrayList<>();

                for (int num: indices) {
                    if (variants.get(num)[i] > max) {
                        newIndices.clear();
                        newIndices.add(num);
                        max = variants.get(num)[i];
                    } else if (variants.get(num)[i] == max) {
                        newIndices.add(num);
                    }
                }

                indices = newIndices;
            } else {
                // first round
                for (int j = 0; j < variants.size(); j++) {
                    if (variants.get(j)[i] > max) {
                        indices.clear();
                        indices.add(j);
                        max = variants.get(j)[i];
                    } else if (variants.get(j)[i] == max) {
                        indices.add(j);
                    }
                }
            }
        }

        System.out.println("### RESULT : " + (indices.size() > 0 ? Arrays.toString(variants.get(indices.get(0))) : "[]"));

        return indices.size() > 0 ? variants.get(indices.get(0)) : new int[0];
    }
}
