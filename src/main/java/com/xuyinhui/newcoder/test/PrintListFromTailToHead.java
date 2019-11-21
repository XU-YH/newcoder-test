/**
 * @author: xu_yh
 * @date: 2019/11/21 9:56
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @author: xu_yh
 * @date: 2019/11/21 9:56
 * @version: V1.0
 */
public class PrintListFromTailToHead {

    /**
     * 测试方法
     */
    @Test
    public void test() {
        // 创建链表
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 解法一
        // ArrayList<Integer> list = printListFromTailToHead1(node);
        // 解法二
        // ArrayList<Integer> list = printListFromTailToHead2(node);
        // 解法三
        ArrayList<Integer> list = printListFromTailToHead3(node);

        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }

    /**
     * 解法三：使用Stack类last-in-first-out的特性，遍历链表，存入栈-Stack类中，再取出
     *
     * @param listNode
     * @return
     */
    private ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 解法二：方法递归实现，不修改链表，不依赖已有的类和方法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        recursive(listNode, list);

        return list;
    }

    /**
     * 递归方法
     *
     * @param listNode
     */
    private void recursive(ListNode listNode, ArrayList<Integer> list) {
        if (listNode.next != null) {
            recursive(listNode.next, list);
        }
        list.add(listNode.val);
    }

    /**
     * 解法一：反转链表，pre -> next =>  pre <- next，再遍历链表即可
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList();
        ListNode preNode = null;
        ListNode nextNode = listNode;
        ListNode tempNode;

        while (nextNode != null) {
            tempNode = nextNode.next;
            nextNode.next = preNode;
            preNode = nextNode;
            nextNode = tempNode;
        }

        while (preNode != null) {
            list.add(preNode.val);
            preNode = preNode.next;
        }

        return list;
    }

}

/**
 * 链表类
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}