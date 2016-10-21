/**
 * Created by 张巍 on 2016/10/11.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class BigNum {
    public static boolean ifGood;

    static void result(int input) {
        BigInteger bigNum = new BigInteger("1"), Addon = new BigInteger("1"), ONE = new BigInteger("1");
        int Times = 0;
        for (; Times < input; Times++) {
            bigNum = bigNum.multiply(Addon);
            Addon = Addon.add(ONE);
        }
        System.out.println("输出结果：");
        System.out.println(bigNum.toString());
    }

    static void subResult(int input, int start, int end) {
        if (start > end) {
            System.out.println("请检查截取数字位数。");
            return;
        }

        BigInteger bigNum = new BigInteger("1"), Addon = new BigInteger("1"), ONE = new BigInteger("1");
        int Times = 0;
        for (; Times < input; Times++) {
            bigNum = bigNum.multiply(Addon);
            Addon = Addon.add(ONE);
        }
        String imBig = bigNum.toString();
        int length = imBig.length();
        if (length <= end == false) {
            System.out.println("输出结果：");
            System.out.print(length+"位数字中的第"+start+"项到第"+end+"项，共"+(end-start+1)+"项：");
            System.out.print(imBig.substring(start - 1, end));
            ifGood = true;
        } else {
            System.out.println("数字没那么多位，只有" + length + "位，请检查输入~");
            ifGood = false;
        }

    }

    public static void main(String[] args) {
        Scanner modeSelect = new Scanner(System.in);
        System.out.println("请输入您想进入的模式：");
        System.out.println("输出阶乘（1）      " + "阶乘后截取相应位数数字（2）");
        int mode = modeSelect.nextInt();
        Scanner input = new Scanner(System.in);
        switch (mode) {
            case 1:
                System.out.println("阶乘模式\n请输入阶乘结束点（n）");
                int in1 = input.nextInt();
                result(in1);
                break;
            case 2:
                System.out.println("截取模式\n请输入阶乘结束点（n）");
                int in2 = input.nextInt();
                do {
                    System.out.println("请输入截取起始数字位（不包含该位）");
                    int start = input.nextInt();
                    System.out.println("请输入结束位数");
                    int end = input.nextInt();
                    subResult(in2, start, end);
                } while (ifGood = false);
                break;
        }
        System.out.println("感谢使用请挂机（划掉）关闭~");
    }

}