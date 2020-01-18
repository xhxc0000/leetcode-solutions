package com.xhxc.demo;

import java.io.*;
import java.util.*;

public class Leet {
    public static void main(String[] args) {
        System.out.println(test(13));
    }


    public static int test(int n) {
        long i = 1, s = 9, base = 1; // 几位数，数量，底数
        while (n > i * s) {
            n -= i * s;
            i++;
            s *= 10;
            base *= 10;
        }
        // 此时确定为i位数, base作为0的第n个数

        int num = (int) (base + (n + i - 1) / i) - 1;
        // 确定数字num, 要向上取整

        int r = (int) (n % i == 0 ? i : n % i);
        // 确定为第几位

        // 答案为num的第r位
        // 去掉末尾i - r个数字
        for (int k = 0; k < i - r; k++) {
            num /= 10;
        }

        return num % 10;
    }







}
