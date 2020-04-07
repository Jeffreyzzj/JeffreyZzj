package main.designModel.celue;

/**
 * @program: java-code-study
 * @description: 机票供应商操作
 * @author: zijie.zeng
 * @create: 2020-03-29 18:29
 */
public class FlightStrategy implements MyStrategy {
    @Override
    public int supplierPrice(int supplierId) {
        System.out.println("机票供应商相关操作,供应商为：" + supplierId);
        return 10;
    }
}
