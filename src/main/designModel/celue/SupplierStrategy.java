package main.designModel.celue;

/**
 * @program: java-code-study
 * @description: 学习策略模式
 * @author: zijie.zeng
 * @create: 2020-03-29 18:21
 */
public class SupplierStrategy {
    private MyStrategy myStrategy;

    public SupplierStrategy(MyStrategy myStrategy) {
        this.myStrategy = myStrategy;
    }

    public int getCommission(int supplierId) {
        return this.myStrategy.supplierPrice(supplierId);
    }

}
