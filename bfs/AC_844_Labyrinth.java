package com.xhxc.demo;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Leet {

    private static int[][] g; // 存储图
    private static int[][] d; // 存储到起点的距离
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {

        n = m = 5;
        g = new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}};


        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = -1;
            }
        }



        System.out.println(bfs());

    }

    private static int bfs() {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        d[0][0] = 0;
        // 枚举四个方向
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.fir + dx[i], y = p.sec + dy[i];
                if (0 <= x && x < n && 0 <= y && y < m && g[x][y] == 0 && d[x][y] == -1) {
                    // 添加节点
                    d[x][y] = d[p.fir][p.sec] + 1;
                    queue.offer(new Pair(x, y));
                }
            }
        }

        return d[n - 1][m - 1];
    }


    static class Pair {
        int fir;
        int sec;

        public Pair(int a, int b) {
            this.fir = a;
            this.sec = b;
        }
    }
}
