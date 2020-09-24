package com.cjp.utlis;

import com.cjp.exception.MyException;

import java.io.*;

public class FileUtils {
    /**
     * 将文本转换为字符串
     * @param path
     * @return
     */
    public static String getText(String path) throws Exception{

        if(path == null || "".equals(path)){
            throw new MyException("您的文件路径为空");
        }


        StringBuffer sb = new StringBuffer();

        BufferedReader br = null;
        try {
            File srcFile = new File(path);
            FileReader fr = new FileReader(srcFile);

            br = new BufferedReader(fr);

            /**
             *
             *
             * br.readLine() 每次读一行
             */
            String data;
            while ((data = br.readLine()) != null) {

                data.replaceAll("\\s*", "");
                data.replaceAll("[\\pP\\p{Punct}]","");
                sb.append(data);
                sb.append("\n");

            }

        } catch (Exception e) {
            throw new MyException("您的文件为空");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
        return sb.toString();
    }

    public static void writeFiletoDisk(String fileName, String result) throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new MyException("您输入的路径可能存在错误");
            }
        }
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(result.getBytes());
        System.out.println("相似度为:" + result + "  已经写入" + fileName);
    }
}
