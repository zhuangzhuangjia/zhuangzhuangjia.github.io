package com.Day07.demo;

public class 递归_迷宫 {
    public static void main(String[] args) {
        // 使用二维数组创建迷宫地图
        // 创建一个八行七列的地图 行 列
        int[][] arr = new int[8][7];

        // 设定迷宫的边界
        // 设置左边界、下边界 和 右边界
        for (int i = 0; i < 7; i++) {
            arr[i][0] = 1;
            arr[7][i] = 1;
            arr[i][6] = 1;
        }
        // 设置上边界
        for (int i = 0; i < 6; i++) {
            arr[0][i] = 1;
        }
        // 设定迷宫中的障碍
        arr[2][1] = 1;
        arr[2][2] = 1;

        arr[5][3] = 1;
        arr[5][4] = 1;



        // 打印迷宫地图
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=====迷宫结果=====");
        Findway f = new Findway();
        // 创建对象
        f.findWay(arr,1,1);
        // 打印最终结果
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*制定迷宫规则:
 * 0代表可以走的路，1代表障碍，2代表到达出口，3代表走过但走不通的路
 * 设定棋子的行动优先顺序为：下->右->上->左*/
class Findway {
    // 创建一个自动走迷宫的方法，（a,b）为起始坐标位置。
    // 设定（6，5）为迷宫出口
    public boolean findWay(int[][] arr, int a, int b) {

        if (arr[6][5] == 2) { // 如果到达出口
            return true;
        } else {
            if (arr[a][b] == 0) { // 如果当前位置可以走
                arr[a][b] = 2; // 假设可以走,路径踪迹为2
                // 下->右->上->左
                if (findWay(arr, a + 1, b)) { // 如果为真，先走下
                    return true;
                } else if (findWay(arr, a, b + 1)) { // 走右
                    return true;
                } else if (findWay(arr, a - 1, b)) { // 走上
                    return true;
                } else if (findWay(arr,a,b - 1)) { // 走左
                    return true;
                } else {
                    arr[a][b] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}