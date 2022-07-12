package com.Day07.demo;
/*有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个，以后每天猴子都吃了其中的一半，然后再多吃一个，当吃到第10天想再吃时，还没吃
* 发现只剩1个桃子。猴子最初有多少个桃子？*/
public class Demo_猴子吃桃 {
    public static void main(String[] args) {
        System.out.println(getPeach(1));
    }
    public static int getPeach(int days) {
        if (days == 10) {
            return 1;
        } else if (days >= 1 && days <= 9) {
            return (getPeach(days + 1) + 1 ) * 2;
        } else {
            System.out.println("输入范围不对");
            return -1;
        }
    }
}
