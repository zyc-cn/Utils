package com.zyc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouyongcai
 * @create_time 2020/4/26 9:58
 * @note：
 */
public class ListUtils {

    public static void main(String[] args) {
        String[] aa = new String[]{"a","b"};
        List<String> strings1 = Arrays.asList(aa);

        ArrayList<String> strings = new ArrayList<String>();
        strings.add("aaaa");
        strings.add("aaab");
        strings.add("aaac");

        String s = listMkString(strings1, "||");
        System.out.println(s);

    }

    /**
     * 相当于scala中的mkstring,将list中的元素使用指定分隔符进行拼接，饭后返回，如果是数组，则可以先
     * @param list
     * @param splitStr
     * @return
     */
    public static String listMkString(List<String> list, String splitStr) {
        if (list == null || list.size() == 0) {
            return "";
        } else {
            StringBuilder sbuf = new StringBuilder(list.get(0));

            for (int idx = 1; idx < list.size(); ++idx) {
                sbuf.append(splitStr);
                sbuf.append(list.get(idx));
            }
            return sbuf.toString();
        }
    }
}
