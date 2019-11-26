/**
 * @author: xu_yh
 * @date: 2019/11/26 14:10
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *
 * 拓展：
 * 用两个队列实现一个栈的功能?要求给出算法和思路!*
 * 入栈：将元素进队列A
 * 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素，以此出队列并放入队列B，直到队列A中的元素留下一个，然后队列A出队列，再把队列B中的元素出队列以此放入队列A中。
 *
 * @author: xu_yh
 * @date: 2019/11/26 14:10
 * @version: V1.0
 */
public class StackPushAndPop {

    @Test
    public void test() {
        Queue1 queue = new Queue1();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
    }

    /**
     * 解法一：利用栈和队列相反的特性，两个栈反反得正，
     * 队列push时，判断栈2是否有数据，若没有则将数据push到栈1中，若有数据则先将栈2中所有的数据pop到栈1中，再将新数据push到栈一中，最后将栈一中的数据pop到栈2中
     * 队列pop时，返回栈2pop。
     */
    class Queue1 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        public int pop() {
            return stack2.pop();
        }
    }

    /**
     * 解法二：
     * 入队：将元素进栈A
     * 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
     * 如果不为空，栈B直接出栈。
     */
    class Queue2 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

}

