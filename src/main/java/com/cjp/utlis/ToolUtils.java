package com.cjp.utlis;

import java.util.*;

import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.Word;
import cn.hutool.extra.tokenizer.engine.hanlp.HanLPEngine;

public class ToolUtils {


    /**
     * 计算词频
     * @param text1
     * @param text2
     * @return
     */
    public static Map<String,int[]> getFrequency(String text1, String text2){
        Map<String,int[]> wordMap = new HashMap<>();
        TokenizerEngine engine = new HanLPEngine();

        Result textList1 = engine.parse(text1);
        Result textList2 = engine.parse(text2);


        Iterator<Word> iterator1 = textList1.iterator();
        Iterator<Word> iterator2 = textList2.iterator();

        while (iterator1.hasNext()){
            String word = iterator1.next().toString();
            String afterWord = "";

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                //只判断中文
                if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
                    afterWord += c;
                }

            }

            if (wordMap.containsKey(afterWord)){
                wordMap.get(afterWord)[0] ++;
            } else {
                int[] sum = new int[2];
                sum[0] = 1;
                wordMap.put(afterWord,sum);

            }
        }

        while (iterator2.hasNext()){
            String word = iterator2.next().toString();
            String afterWord = "";

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                //只判断中文
                if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
                    afterWord += c;
                }

            }

            if (wordMap.containsKey(afterWord)){
                wordMap.get(afterWord)[1] ++;
            } else {
                int[] sum = new int[2];
                sum[1] = 1;
                wordMap.put(afterWord,sum);

            }
        }

        return wordMap;

    }


    /**
     * 计算分子
     * @param map
     * @return
     */
    public static double getMolecular(Map<String,int[]> map){

        double result = 0;
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry<String,int[]> entry = (Map.Entry<String, int[]>) i.next();
//            int[] a = entry.getValue();
//            for (int b=0;b<a.length;b++){
//                System.out.println(a[b]);
//            }
//            System.out.println(entry.getKey()+"=="+entry.getValue()[0]);
//            System.out.println(entry.getKey()+"=="+entry.getValue()[1]);
            result += (entry.getValue()[0] * entry.getValue()[1]);
//            System.out.println("***********");
        }
        return result;
    }


    /**
     * 计算分母
     * @param map
     * @return
     */
    public static double getDenominator(Map<String,int[]> map){
        double result = 0;
        double result1 = 0;
        double result2 = 0;
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry<String,int[]> entry = (Map.Entry<String, int[]>) i.next();
            result1 += entry.getValue()[0] * entry.getValue()[0];
            result2 += entry.getValue()[1] * entry.getValue()[1];
        }

        result = Math.sqrt(result1) * Math.sqrt(result2);

        return result;
    }



}

