package com.songsir.algorithm;

/**
 * @packageName com.songsir.controller
 * @projectName songsir-demoboot
 * @author: SongYapeng
 * @date: Create in 17:34 2019/5/16
 * @description: 斐波那契数列 实现方式
 * @copyright Copyright (c) 2019, songyapeng@shopin.cn All Rights Reserved.
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int n = 50;
        long l = System.currentTimeMillis();
        long fibonacci = fibonacci(n);
        System.out.println("斐波那契数列第 " + n + " 位结果："+ fibonacci);
        System.out.println("动态规划耗时：" + (System.currentTimeMillis() - l) + "\n");

        long l2 = System.currentTimeMillis();
        long fibonacci2 = fibonacci2(n);
        System.out.println("斐波那契数列第 " + n + " 位结果："+ fibonacci2);
        System.out.println("普通递归耗时：" + (System.currentTimeMillis() - l2) + "\n");

        long l3 = System.currentTimeMillis();
        long lastFibonacci = lastFibonacci(n, 1, 1);
        System.out.println("斐波那契数列第 " + n + " 位结果："+ lastFibonacci);
        System.out.println("尾递归耗时：" + (System.currentTimeMillis() - l3) + "\n");

        long l4 = System.currentTimeMillis();
        long fibonacci3 = fibonacci3(n);
        System.out.println("斐波那契数列第 " + n + " 位结果："+ fibonacci3);
        System.out.println("低空间复杂度耗时：" + (System.currentTimeMillis() - l4) + "\n");

    }

    /**
     * @MethodName fibonacci
     * @Description 动态规划
     * @Author SongYapeng
     * @Date 2019/5/16 18:02
     * @param n
     * @Since JDK 1.8       
     */
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long[] fib = new long[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    /**
     * @MethodName Fibonacci
     * @Description 空间复杂度 O(1)
     * @Author SongYapeng
     * @Date 2019/5/16 18:05
     * @param n
     * @Since JDK 1.8
     */
    public static long fibonacci3(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    /**
     * @MethodName fibonacci2
     * @Description 普通递归              
     * @Author SongYapeng
     * @Date 2019/5/16 18:01
     * @param n
     * @Since JDK 1.8       
     */
    public static long fibonacci2(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci2(n - 1) + fibonacci2(n - 2);
        }

    }

    /**
     * @MethodName lastFibonacci
     * @Description 尾递归
     * @Author SongYapeng
     * @Date 2019/5/16 18:07
     * @param n
     * @param ret1
     * @param ret2
     * @Since JDK 1.8
     */
    public static long lastFibonacci(int n, long ret1, long ret2) {
        if(n == 1) {
            return ret1;
        }
        return lastFibonacci(n - 1, ret2, ret1 + ret2);
    }
}
