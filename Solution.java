package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Integer, Integer> map = new HashMap();
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            run();

        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try{
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0){
                    int data = fileInputStream.read();
                    Integer value =  map.get(data);
                    map.put(data, value == null ? 1 : value + 1);
                }
                fileInputStream.close();
                Integer max = Collections.max(map.values());
                for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                    if (entry.getValue().equals(max)) resultMap.put(fileName, entry.getKey());
                }
            }catch (IOException e){ e.printStackTrace();}

        }



    }
}
