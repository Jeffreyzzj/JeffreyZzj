package main.codeStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 螺旋矩阵
 * @URL https://leetcode-cn.com/problems/spiral-matrix/
 * @author: zijie.zeng
 * @create: 2020-04-12 15:10
 */
public class SpiralMatrixLeetCode {
    public static void main(String[] args) {
        pre();
    }
    public static void pre() {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        //List<Integer> resList = spiralOrder(matrix);
        List<Integer> resList = answer(matrix);
        System.out.println("===");

    }

    public static List<Integer> answer(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        if (matrix.length == 0) {
            return resList;
        }

        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int under = matrix.length-1;
        while (true) {
            for (int i=left; i<=right; i++) {
                resList.add(matrix[top][i]);
            }
            if (++top > under) break;
            for (int i= top; i<=under; i++) {
                resList.add(matrix[i][right]);
            }
            if(--right<left) break;
            for (int i=right; i>=left; i--) {
                resList.add(matrix[under][i]);
            }
            if (--under<top) break;
            for (int i=under; i>=top; i--) {
                resList.add(matrix[i][left]);
            }
            if (++left >right) break;
        }
        return resList;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        if (matrix.length == 0) {
            return resList;
        }

        boolean left = false;
        boolean right = true;
        boolean top = false;
        boolean under = false;
        boolean[][] gif = new boolean[matrix.length][matrix[0].length];

        int x = 0;
        int y = 0;
        while (gif[x][y]==false) {
            if (left) {
                resList.add(matrix[x][y]);
                gif[x][y] = true;

                if (y==0|| gif[x][y-1]) {
                    x--;
                    left=false;
                    top = true;
                    continue;
                }
                y--;
            } else if (right) {
                resList.add(matrix[x][y]);
                gif[x][y] = true;
                if (y==matrix[0].length-1 || gif[x][y+1]) {
                    if (y==matrix[0].length-1 && x+1==matrix.length) {
                        break;
                    }
                    x++;

                    right=false;
                    under=true;
                    continue;
                }
                y++;
            } else if (top) {
                resList.add(matrix[x][y]);
                gif[x][y] = true;
                if (gif[x+1][y]) {
                    y++;
                    top=false;
                    right=true;
                    continue;
                }
                x++;
            } else if (under) {
                resList.add(matrix[x][y]);
                gif[x][y] = true;
                if (x==matrix.length-1 || gif[x+1][y]) {
                    y--;
                    under=false;
                    left=true;
                    continue;
                }
                x++;
            }
        }

        return resList;
    }
}
