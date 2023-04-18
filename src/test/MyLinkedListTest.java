package test;

import implementation.dataStructures.linkedList.SinglyLinkedList;

import java.util.NoSuchElementException;

public class MyLinkedListTest implements CallableTest{
    @Override
    public void call() throws Exception {

    }

    private void getByIndexTest_null() throws Exception {
        SinglyLinkedList<Integer> a = new SinglyLinkedList<>();

        a.add(10);

        try {
            var integer = a.get(0);
            throw new Exception("getByIndexTest_null should return NoSuchElementException");
        } catch (NoSuchElementException ne) {
            System.out.println("getByIndexTest_null is Ok");
        }
    }
}
