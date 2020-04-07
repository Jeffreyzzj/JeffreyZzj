package main.niuke;

/**
 * @program: java-code-study
 * @description: 股票最佳时机买卖
 * @author: zijie.zeng
 * @create: 2020-04-02 09:22
 */
public class GuPiaoBuy {
    public static void main(String[] args) {
        int res = preMaxProfit();
        System.out.println("结果为：" + res);
    }
    public static int preMaxProfit() {
        int[] res = {7,1,5,3,6,4};
        return maxProfit(res);
    }
    public static int maxProfit(int[] prices) {

        if (prices.length<2) {
            return 0;
        } else if(prices.length==2) {
            return prices[0]<prices[1] ? prices[1]-prices[0] : 0;
        }

        int min = prices[0];
        int max = 0;
        for (int i=1; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}
