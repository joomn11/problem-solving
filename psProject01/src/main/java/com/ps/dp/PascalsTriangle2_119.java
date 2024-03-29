package com.ps.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_119 {

    // time complexity - o(n^2)
    // dynamic programming - bottom up
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rst = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {

                if (j == 0) {
                    list.add(1);
                } else if (j == i) {
                    list.add(1);
                } else {
                    int tmp = rst.get(0).get(j - 1) + rst.get(0).get(j);
                    list.add(tmp);
                }
            }
            rst.add(list);
            if (i != 0) {
                rst.remove(0);
            }

        }
        return rst.get(0);
    }

    public List<Integer> getRow_2(int rowIndex) {

        List<Integer> prev = null;

        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    list.add(1);
                } else if (j == i) {
                    list.add(1);
                } else {
                    int tmp = prev.get(j - 1) + prev.get(j);
                    list.add(tmp);
                }
            }
            prev = list;
        }
        return prev;
    }

}
