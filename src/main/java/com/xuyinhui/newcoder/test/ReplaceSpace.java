/**
 * @author: xu_yh
 * @date: 2019/11/20 13:06
 * @Copyright ©2019 xu_yh. All rights reserved.
 */
package com.xuyinhui.newcoder.test;

import org.junit.Test;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author: xu_yh
 * @date: 2019/11/20 13:06
 * @version: V1.0
 */
public class ReplaceSpace {

    @Test
    public void test() {
        StringBuffer origin = new StringBuffer("We Are Happy");
        String target = method1(origin);
        System.out.println(target);
    }

    /**
     * 解法一，在源StringBuffer上操作
     *
     * @param origin
     * @return
     */
    public String method1(StringBuffer origin) {
        for (int i = 0; i < origin.length(); i++) {
            if (' ' == origin.charAt(i)) {
                origin.replace(i, i + 1, "%20");
                i += 2;
            }
        }

        return origin.toString();
    }

    /**
     * 解法二，在新的StringBuffer上操作
     *
     * @param origin
     * @return
     */
    public String method2(StringBuffer origin) {
        if (origin == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == ' ') {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else {
                newStr.append(origin.charAt(i));
            }
        }
        return newStr.toString();
    }

}