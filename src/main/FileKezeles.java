package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileKezeles {
    public static void main(String[] args) throws IOException {
        List<String> szoveg = Files.readAllLines(Path.of("C:\\java_feladat\\szoveg.txt"));
        System.out.println("szoveg.txt = " + szoveg);
        
        /*
        List<String> relativ = Files.readAllLines(Path.of("relativ.txt"));
        System.out.println("relativ.txt = " + relativ);*/
        
        InputStream is = FileKezeles.class.getClassLoader().getResourceAsStream("res/res.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        String sor;
        while ((sor = bf.readLine()) != null) {
            System.out.println("sor = " + sor);
        }
    }
}
