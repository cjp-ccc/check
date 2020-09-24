package com.cjp;

import com.cjp.utlis.FileUtils;
import com.cjp.utlis.MySimilary;
import com.cjp.utlis.ToolUtils;
import org.junit.Test;

public class SimilaryTest {
    @Test
    public void test1() throws Exception {
        String content9="今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，而且特别的小，关键价格还贵";

        String content10="今天小小和妈妈一起去草原里采草莓，今天的草莓味道特别好，而且价格还挺实惠的";

        String content1 = FileUtils.getText("article\\orig.txt");
        String content2 = FileUtils.getText("article\\orig_0.8_add.txt");
        String content3 = FileUtils.getText("article\\orig_0.8_del.txt");
        String content4 = FileUtils.getText("article\\orig_0.8_dis_1.txt");

        String content5 = FileUtils.getText("article\\orig_0.8_dis_10.txt");
        String content6 = FileUtils.getText("article\\orig_0.8_dis_15.txt");


        String content7 = "这只皮靴号码大了。那只号码合适。";
        String content8 = "这只皮靴号码不小，那只更合适。";


        MySimilary m = new MySimilary();
        double result = m.getSimilarity(content1,content3);
        System.out.println(result);

    }
}
