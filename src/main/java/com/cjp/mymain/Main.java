
package com.cjp.mymain;

import com.cjp.exception.MyException;
import com.cjp.utlis.FileUtils;
import com.cjp.utlis.MySimilary;


public class Main{
    public static void main(String[] args) throws Exception {
        // 程序运行开始时间
        long start = System.currentTimeMillis();

        // 参数校验
        int argsLength = args.length;
        if (argsLength != 3) {
            System.out.println("请输入三个正确的参数");
            throw new MyException("参数异常");
        }


        // 将txt文件转化为String类
        String str1 = FileUtils.getText(args[0]);
        String str2 = FileUtils.getText(args[1]);
        // 创建文本查重器对象
        MySimilary mySimilary = new MySimilary();
        // 调用综合算法计算文本相似度
        double result = mySimilary.getSimilarity(str1, str2);
        FileUtils.writeFiletoDisk(args[2], Double.toString(result));
        // 程序运行结束时间
        long end = System.currentTimeMillis();
        // 计算程序运行时间（单位为秒）
        System.out.println("一共用时：" + (end - start) / 1000.0 + "秒");

    }
}
