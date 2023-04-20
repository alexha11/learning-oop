package Main;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        Nations nations = new Nations();
        nations.creatNationsList();
        nations.sortNationsList();
        while (ok) {
            System.out.println("1) List all the nations, 2) Search for a nation, 3) Pick nations to custom list, 4) List custom list nations, 5) Clean custom list, 0) Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    nations.printNationsList();
                    break;
                case 2:
                    System.out.println("Give a string to search:");
                    String nameNation = sc.next();
                    System.out.println("The following nations include string '"+ nameNation +"':");
                    nations.searchNations(nameNation);
                    break;
                case 3:
                    System.out.println("Give a country ID to move:");
                    int index = sc.nextInt();
                    nations.removeNationsList(index);
                    break;
                case 4:
                    nations.printCustomList();
                    break;
                case 5:
                    nations.cleancustomList();
                    nations.sortNationsList();
                    break;
                case 0:
                    ok = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}