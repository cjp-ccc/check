package com.cjp.utlis;

import java.text.DecimalFormat;
import java.util.Map;

public class MySimilary {
    /**
     * 计算相似度
     * @param text1
     * @param text2
     * @return
     */
    public static double getSimilarity(String text1,String text2){
        Map<String,int[]> map = ToolUtils.getFrequency(text1,text2);
        double result = 0;
        result = ToolUtils.getMolecular(map) / ToolUtils.getDenominator(map);

        //将结果保留2位小数
        DecimalFormat df = new DecimalFormat("#.00");

        return Double.parseDouble(df.format(result));

    }
}
