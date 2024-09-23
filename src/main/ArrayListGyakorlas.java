package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayListGyakorlas {
    
    private static ArrayList<Integer> szamok;
    private static HashSet<Integer> egyedi;
    
    public static void main(String[] args) throws IOException {
        int min = 10;
        int max = 20;
        szamok = new ArrayList<>();
        int range = max - min + 1;
        
        feltolt(range, min);
        KiirLista("Páros és páratlan:");
        kiveszParatlan();
        KiirLista("Csak páros: ");
        kulonbozoek();
        KiirEgyedi("Amilyen számok maradtak:");
        mibolMennyi();
        fajlBeolvasas();
        
    }

    private static void feltolt(int range, int min) {
        for (int i = 0; i < 20; i++) {
            int szam = (int) (Math.random() * range) + min;
            szamok.add(szam);
        }
    }
    
    private static void kiveszParatlan() {
        for (int i = szamok.size() - 1; i > 0; i--) {
            if (szamok.get(i) % 2 == 1) {
                szamok.remove(i);
            }
        }
    }

    private static void KiirLista(String uzenet) {
        uzenet += "\n";
        for (int i = 0; i < szamok.size(); i++) {
            uzenet += szamok.get(i) + " ";
        }
        System.out.println(uzenet);
    }
    
    private static void KiirEgyedi(String uzenet) {
        uzenet += "\n";
        for (int szam: egyedi) {
            uzenet += szam + " ";
        }
        System.out.println(uzenet);
    }

    private static void kulonbozoek() {
        egyedi = new HashSet<>(szamok);
    }
    
    private static void mibolMennyi() {
        System.out.println("Az alábbi számok ennyiszer fordulnak elő:");
        HashMap<Integer, Integer> statisztika = new HashMap<>();
        
        for (int kulcs : szamok) {
            if(statisztika.containsKey(kulcs)) {
                //
                int ertek = statisztika.get(kulcs);
                statisztika.put(kulcs, ++ertek);
            } else {
                statisztika.put(kulcs, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : statisztika.entrySet()) {
            int kulcs = entry.getKey();
            int ertek = entry.getValue();
            String s = "[%d] = %d%n".formatted(kulcs, ertek);
            System.out.printf(s);
        }
        
        Set<Map.Entry<Integer, Integer>> entry = statisztika.entrySet();
    }
    
    private static void fajlBeolvasas() throws IOException {
        List<String> szoveg = Files.readAllLines(Path.of("C:\\java_feladat\\szoveg.txt"));
        System.out.println("szoveg.txt = " + szoveg);
    }
}
