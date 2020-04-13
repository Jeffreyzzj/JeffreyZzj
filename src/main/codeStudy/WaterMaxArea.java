package main.codeStudy;

/**
 * @program: java-code-study
 * @description: leetcode查找水池面积最大
 * @author: zijie.zeng
 * @create: 2020-04-02 09:49
 */
public class WaterMaxArea {
    public static void main(String[] args) {
        int res = preMaxArea();
        System.out.println("结果为："+ res);
    }

    public static int preMaxArea() {
        int[] weight = {1,8,6,2,5,4,8,3,7};
        return maxArea(weight);
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int areaMax = 0;
        while (i<j) {
            boolean flag = height[i]<height[j];
            int minWight = flag ? height[i] : height[j];
            areaMax = Math.max(areaMax, (j-i)*minWight);
            if (flag) {
                i++;
            } else {
                j--;
            }
        }
        return areaMax;
    }
}
