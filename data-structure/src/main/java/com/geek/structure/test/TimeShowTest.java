package com.geek.structure.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: TODO
 * @author: yxb
 * @since: 2019-11-26 14:58
 */
public class TimeShowTest {

    public static void main(String[] args) {


    }

    public int getSum(int n) {
        int sum = 0;
        for (int i =0; i<n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    int getTotal(int n) {
        int total = 0;
        for (int i = 1; i <= n;  i++) {
            for (int j = 1; j <= i; j ++) {
                total = total + i * j;
            }
        }
        return total;
    }

    public void demo() {
        List<String> list = new ArrayList<String>();
    }
}
