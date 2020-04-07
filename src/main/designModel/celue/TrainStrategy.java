package main.designModel.celue;

/**
 * @program: java-code-study
 * @description: 火车票供应商策略模式
 * @author: zijie.zeng
 * @create: 2020-03-29 18:31
 */
public class TrainStrategy implements MyStrategy {

    @Override
    public int supplierPrice(int supplierId) {
        System.out.println("火车票供应商相关操作,供应商为：" + supplierId);
        return 1;
    }
}
