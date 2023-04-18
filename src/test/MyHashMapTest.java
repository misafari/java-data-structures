package test;

import implementation.dataStructures.map.MyHashMap;

public class MyHashMapTest {

    public static void run() throws Exception {
        var map = new MyHashMapTest();
        map.validTest_1();
        map.validTest_2();
        map.validTest_3();
    }

    public void validTest_1() throws Exception {
        MyHashMap map = new MyHashMap();

        map.put(1, "sample");

        if (!map.get(1).equals("sample"))
            throw new Exception("should return sample but don't");
    }

    public void validTest_2() throws Exception {
        MyHashMap map = new MyHashMap();

        map.put(1, "sample");
        map.put(1, "sample2");

        if (!map.get(1).equals("sample2"))
            throw new Exception("should return sample2 but don't");
    }

    public void validTest_3() throws Exception {
        MyHashMap map = new MyHashMap();

        if (map.get(1) != null)
            throw new Exception("should return null but don't");
    }
}
