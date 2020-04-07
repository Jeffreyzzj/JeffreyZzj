package main.designModel.celue;

/**
 * @program: java-code-study
 * @description: 酒店策略模式
 * @author: zijie.zeng
 * @create: 2020-03-29 18:26
 */
public class HotelStrategy implements MyStrategy {
    @Override
    public int supplierPrice(int supplierId) {
        System.out.println("酒店供应商相关操作,供应商为：" + supplierId);
        return 5;
    }
}
