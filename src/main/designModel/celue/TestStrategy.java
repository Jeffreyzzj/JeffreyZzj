package main.designModel.celue;

/**
 * @program: java-code-study
 * @description: 测试策略模式
 * @author: zijie.zeng
 * @create: 2020-03-29 18:36
 */
public class TestStrategy {
    public static void main(String[] args) {
        HotelStrategy hotelStrategy = new HotelStrategy();
        publicGetCommission(1, new SupplierStrategy(hotelStrategy));
        System.out.println("end");
    }
    public static int publicGetCommission(int supplierId, SupplierStrategy studyStrtegy) {
        return studyStrtegy.getCommission(supplierId);
    }
}
