package com.wdx.backstage.util;

import java.util.Random;

public class CommonUtil {
    public static String getYanzheng(){
        //生成5位随机数
        //1.找出所有的字符
        String str = "ABCDEFGHIJKLMNOPQRSJUVWXYZ";
        str.toLowerCase();
        String str1 = "0123456789";
        str = str + str.toLowerCase();
        str += str1;

        //2.生成字符中的随机一个数
        // int R = new Random().nextInt(str.length());
        //3.进行5次循环
        StringBuilder sb = new StringBuilder(5);
        for(int i = 0; i < 5; i++){
            int R = new Random().nextInt(str.length());
            char ch = str.charAt(R);//获取位置
            sb.append(ch);
        }
        return sb.toString();
    }
}
