package main.codeStudy;

/**
 * @program: java-code-study
 * @description: 动态规划，01背包问题
 * @author: zijie.zeng
 * @create: 2019-12-26 00:31
 * @URL https://yq.aliyun.com/articles/714964
 * @URL https://www.itqiankun.com/article/1564909352?spm=a2c4e.10696291.0.0.1c6e19a4uriAeJ
 * @URL https://www.kancloud.cn/kancloud/pack/70125
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int n = 5, w = 9;                    //物品个数，背包容量
        // 红色代码注释开始
        int[] value = {0,6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0,2, 2, 6, 5, 4};    //各个物品的重量

        int maxValue = getMaxValue(weight, value, w, n);
        System.out.println(maxValue);
    }

    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] tables = new int[n+1][w+1];

        for(int i=1; i<n; i++) {
            for(int j=1; j<w; j++) {
                if (weight[i]>j) {
                    tables[i][j] = tables[i-1][j];
                } else {
                    tables[i][j] = Math.max(tables[i-1][j], tables[i][j-weight[i]]+value[i]);
                }
            }
        }
        return tables[n][w];
    }
}
