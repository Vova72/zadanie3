package com.company;

import java.io.*;

public class Main3 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException, FileNotFoundException {
        Tester ts = new Tester(2, "Some text");
        String path = "serialized.txt";

        String data = Serializer.serialize(ts);
        System.out.println(data);
        PrintWriter pr = new PrintWriter(path);
        pr.println(data);
        pr.close();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String data2 = null;
        try {
            data2 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Tester newData = Deserializer.deserialize(data2, ts);
        System.out.println(newData.toString());
    }
}
