package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lab01 {
    public static void main(String[] args) {
        String input = "data/src.txt";
        String output = "data/result.txt";

        try {
            BufferedReader r = new BufferedReader( new InputStreamReader(new FileInputStream(input),"utf-8"));
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output),"utf-8"));

            String line;
            while((line=r.readLine())!=null) {
                String replace = line.replace("무인기", "드론");
                w.write(replace);
                w.newLine();
            }
            w.close();
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
