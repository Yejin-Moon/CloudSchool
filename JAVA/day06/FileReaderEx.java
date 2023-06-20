package day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("data/score.txt");
        BufferedReader  br = new BufferedReader(fr);
        String line = "";

        int average=0;
        while(line != null){
            line = br.readLine();
            if(line==null) break;
            String[] score = line.split(" ");
            for(int i=1; i<=3; i++){
                average+=Integer.parseInt(score[i]);
            }
            System.out.println(score[0]+"의 평균 : "+average/3);
            average=0;
        }
        br.close(); fr.close();
    }
}
