package main.codeStudy;

/**
 * @program: java-code-study
 * @description: 动态规划，0-1背包
 * @author: zijie.zeng
 * @create: 2020-04-10 20:22
 */
public class DPQuestionPackage {
    public static void main(String[] args) {
        pre();
    }
    public static int pre() {
        int[][] things = new int[][]{
                {2,6},{2,3},{6,5},{5,4},{4,6}
                /*{2,3}, {1,2}, {3,4}, {2,2}*/
        };
        int res = packageQuestion(things, 8);
        System.out.println("===");
        return res;
    }

    public static int packageQuestion(int[][] things, int weight) {
        int[][] gif = new int[things.length+1][weight+1];

        for (int i=1; i<things.length+1; i++) {
            int thingWeight = things[i-1][0];
            int thingValue = things[i-1][1];
            for (int j=1; j<weight+1; j++) {
                if(j<thingWeight) {
                    //放不进去
                    gif[i][j] = gif[i-1][j];
                } else {
                    //重量为j时，获得j-thingWeight重量的值
                    int midValueAddJ = gif[i-1][j-thingWeight]+thingValue;
                    int midValueNoAdd = gif[i-1][j];
                    int midValue = Math.max(midValueAddJ, midValueNoAdd);
                    gif[i][j] = midValue;
                }
            }
        }
        return gif[things.length][weight];

    }
}
