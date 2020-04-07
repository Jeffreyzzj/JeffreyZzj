package main.designModel.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 生成素数
 * @author: zijie.zeng
 * @create: 2020-04-02 20:32
 */
public class PrimeNumber {
    int num;
    boolean[] flag;

    public PrimeNumber() {
        initMy();
        flag = new boolean[10];
    }

    public PrimeNumber(int num) {
        this.num = num;
        flag = new boolean[num];
        initMy();
    }

    public void initMy() {
        for (int i = 0; i < num; i++) {
            flag[i] = false;
        }
    }

    public boolean[] getPrimeArray() {
        for (int i = 2; i < num; i++) {
            if (flag[i] == false) {
                for (int j = i + i; j < num; j += i) {
                    flag[j] = true;
                }
            }
        }
        return flag;
    }

    public List<Integer> getPrimeNum() {
        List<Integer> lists = new ArrayList<Integer>();
        getPrimeArray();
        for (int i = 2; i < num; i++) {
            if (!flag[i])
                lists.add(i);
        }
        return lists;
    }
}
