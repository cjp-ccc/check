package com.cjp;

import com.cjp.utlis.ToolUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FrequencyTest {
    @Test
    public void test1(){
        String s1 = "今天是周天，天气晴朗，我晚上要去看电影。";
        String s2 = "今天是星期天，天气晴，今天晚上我要去看电影。";
        Map<String,int[]> map = new HashMap<>();
        map = ToolUtils.getFrequency(s1,s2);
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry<String,int[]> entry = (Map.Entry<String, int[]>) i.next();
            System.out.println("第一个句子关键词："+entry.getKey()+"，出现的次数"+entry.getValue()[0]);
            System.out.println("第二个句子关键词："+entry.getKey()+"，出现的次数"+entry.getValue()[1]);

        }
    }
}
