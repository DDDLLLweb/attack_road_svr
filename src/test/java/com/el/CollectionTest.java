package com.el;

import com.el.lottery.Gift;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author danfeng
 * @since 2018/4/4
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionTest {

    /**
     * 在方法调用返回一个只包含指定对象的不可变列表。
     */
    @Test
    public void testSingletonList() {
        String init[] = {"One", "Two", "Three", "One", "Two", "Three"};
        List list = new ArrayList(Arrays.asList(init));
        System.out.println("List value before: " + list);
        list = Collections.singletonList("TP");
        System.out.println("List value after: " + list);
    }

    @Test
    public void testForEach() {
        Gift gift1 = new Gift() {{
            setId(1);
            setName("礼品1");
        }};
        Gift gift2 = new Gift() {{
            setId(2);
            setName("礼品2");
        }};
        Gift gift3 = new Gift() {{
            setId(3);
            setName("礼品3");
        }};

        List<Gift> lists = new ArrayList<>();
        lists.add(gift1);
        lists.add(gift2);
        lists.add(gift3);

//        for (Gift gift: lists) {
//            if(gift.getId()==1) {
//                lists.remove(gift);
//            }
//        }
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).getId() == 1) {
                lists.remove(i);
            }
        }
    }

    public static void main(String[] args) {
//        int a=1,b=2,c=3;
//        int a1 = a + b * c;
//        int b1 = a * (b + c);
//        int c1 = a * b * c;
//        int d1 = (a + b) * c;
//        int tmpl = a1;
//        if (tmpl<b1) {
//            tmpl = b1;
//        }
//        if(tmpl<c1) {
//            tmpl = c1;
//        }
//        if(tmpl<d1) {
//            tmpl = d1;
//        }
//        System.out.println(tmpl);
        int m = 2, n=2,k=6;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<m;i++) {
            str.append("a");
        }
        for (int i=0;i<n;i++) {
            str.append("z");
        }

    }


    @Test
    public ListNode testArray(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (null != head.next) {
            list.add(head.next);
        }
        if (k < list.size()) {
            return list.get(list.size() - k - 1);
        }
        return null;
    }


}
