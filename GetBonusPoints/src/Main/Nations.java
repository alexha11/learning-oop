package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Nations {
    HashMap<String, Integer> nations = new HashMap<String, Integer>();
    HashMap<String, Integer> customList = new HashMap<String, Integer>();
    BufferedReader reader = null;
    List<Map.Entry<String, Integer>> nationsList = null;
    void creatNationsList() {
        try {
            reader = new BufferedReader(new FileReader("src/Main/nations.txt"));
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                nations.put(line, count);
                count++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    void sortNationsList() {
        nationsList = new ArrayList<>(nations.entrySet());
        Collections.sort(nationsList, Comparator.comparing(Map.Entry::getValue));
    }
    void printNationsList() {
        for (Map.Entry<String, Integer> key : nationsList) {
            System.out.print(key.getValue() + ") " + key.getKey() + " ");
        }
        System.out.println();
        //nations.forEach((key, value) -> System.out.println(value + ") " + key));
    }
    void removeNationsList(int index) {
        Iterator<Map.Entry<String, Integer>> iterator = nationsList.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() == index) {
                customList.put(entry.getKey(), entry.getValue());
                iterator.remove();
            }
        }
    }
    void printCustomList() {
        customList.forEach((key, value) -> System.out.print(value + ") " + key + " "));
        System.out.println();
    }
    void searchNations(String nameNation) {
        for(Map.Entry<String, Integer> entry : nationsList) {
            if (entry.getKey().toLowerCase().contains(nameNation))
                System.out.println(entry.getKey());
        }
    }
    void cleancustomList() {
        customList.forEach((key, value) -> nations.put(key, value));
        customList.clear();
    }
}
