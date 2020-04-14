package main.codeStudy;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

/**
 * @program: java-code-study
 * @description: 学习Java的map
 * @author: zijie.zeng
 * @create: 2020-04-14 09:53
 */
public class StudyJavaMap {
    public static void main(String[] args) {

    }
    public void testMapFun() {
        HashMap hashMap = new HashMap();
        hashMap.put("1","1");

        Hashtable hashtable = new Hashtable();
        hashtable.put("1", "1");

        TreeMap treeMap = new TreeMap();
        treeMap.put("1","1");

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("1", "1");


        LinkedHashSet linkedHashSet = new LinkedHashSet();
    }
}
