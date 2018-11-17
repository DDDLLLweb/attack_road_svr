package com.el.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Danfeng
 * @since 2018/10/31
 */
public class LinkListTest {

    /**
     * 1,实现 Deque 接口，为 add、poll 提供先进先出队列操作，以及其他堆栈和双端队列操作
     * 2,LinkedList 实现所有可选的列表操作，并允许所有的元素包括 null。
     * 3,在 LinkedList 中提供了两个基本属性 size、header
     * 其中 size 表示的 LinkedList 的大小，header 表示链表的表头，Entry 为节点对象。
     */
    @Test
    public void testLinkList() {
        LinkedList<String> linkedList = new LinkedList<>();
        // Adding elements to the linked list
        linkedList.add("A");
        linkedList.add("B");
        System.out.println("Linked list : " + linkedList);
        linkedList.addLast("C");
        linkedList.addFirst("D");
        linkedList.add(2, "E");
        linkedList.add("F");
        linkedList.add("G");
        // 遍历linkList
        // 1. Iterator
        for (Iterator iter = linkedList.iterator(); iter.hasNext(); )
            System.out.println("iterator: " + iter.next());
        // 2. For
        for (String str : linkedList)
            System.out.println("for: " + str);
        // 3.
        while (linkedList.pollFirst() != null) {
            System.out.println("while: " + linkedList.pollFirst());
        }
        // Removing elements from the linked list
//        linkedList.remove("B");
//        System.out.println("Linked list : " + linkedList);
//        linkedList.remove(3);
//        System.out.println("before remove 3 Linked list : " + linkedList);
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        System.out.println("Linked list after deletion: " + linkedList);

        // Finding elements in the linked list
//        boolean status = linkedList.contains("E");
//
//        if (status)
//            System.out.println("List contains the element 'E' ");
//        else
//            System.out.println("List doesn't contain the element 'E'");
//
//        // Number of elements in the linked list
//        int size = linkedList.size();
//        System.out.println("Size of linked list = " + size);
//
//        // Get and set elements from linked list
//        Object element = linkedList.get(2);
//        System.out.println("Element returned by get() : " + element);
//        linkedList.set(2, "Y");
//        System.out.println("Linked list after change : " + linkedList);

    }

}
