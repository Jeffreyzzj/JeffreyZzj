package main.niuke;

/**
 * @program: java-code-study
 * @description: 最小路径和
 * @URL https://leetcode-cn.com/problems/minimum-path-sum/
 * @author: zijie.zeng
 * @create: 2020-04-09 23:09
 */
public class MinPathSumLeetCode {
    public static void main(String[] args) {
        preMinPath();
    }

    public static int preMinPath() {
        //int[][] grid = new int[3][3];
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        //int res = minPathSumOne(grid);
        int res = minPathSumTwo(grid);
        System.out.println("===");
        return res;
    }

    public static int minPathSumOne(int[][] grid) {
        int[][] gif = new int[grid.length][grid[0].length];
        int x = grid.length-1;
        int y = grid[0].length-1;
        for (int i = x; i >= 0; i--) {
            for (int j = y; j >= 0; j--) {
                if (i == x && j != y) {
                    //最下一层的数组
                    gif[i][j] = grid[i][j] + gif[i][j+1];
                } else if (i != x && j == y) {
                    //最右一层的数组
                    gif[i][j] = grid[i][j]+ gif[i+1][j];
                } else if (i != x) {
                    //去掉边界值的数组
                    //当前值
                    /*int value = grid[i][j];
                    int min = Math.min(grid[i+1][j], grid[i][j+1]);*/
                    gif[i][j] = grid[i][j] + Math.min(gif[i+1][j], gif[i][j+1]);
                } else {
                    gif[i][j] = grid[i][j];
                }
            }
        }
        return gif[0][0];
    }

    public static int minPathSumTwo(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[i].length; j++) {
                if (i==0 && j==0) continue;
                else if (i==0 && j<grid[i].length) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if (i<grid.length && j==0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
