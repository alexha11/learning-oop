package Main;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ReservedNameException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the zoo a name:");
        String name = sc.nextLine();
        System.out.println("Give the manager a name:");
        String nameManager = sc.nextLine();
        Zoo zoo = new Zoo(name, nameManager);
        while(true) {
            System.out.println("1) Add an animal to the Zoo, 2) List all the animals, 3) Let animals play, 4) Go to the next year, 5) Save data, 6) Load data 0) Exit");
            int num = sc.nextInt();
            if (num == 0) {
                System.out.println("The zoo has closed. " + zoo.countAnimal + " animals were created.");
                break;
            }
            else if (num == 1) {
                System.out.println("1) Add a hedgehog, 2) Add a cat, 3) Add a lion");
                int choiceAnimal = sc.nextInt();
                if (choiceAnimal == 1) {
                    boolean ok = false;
                    System.out.println("Give it a name:");
                    sc.nextLine();
                    String nameAnimal = sc.nextLine();
                    try {
                        zoo.validateAnimal(nameAnimal);
                    } catch (ReservedNameException e) {
                        System.out.println(e.getMessage());
                        ok = true;
                    }
                    //System.out.println("mark: " + nameAnimal);
                    if(ok == false) {
                        System.out.println("How old it is:");
                        int ageAnimal = sc.nextInt();
                        System.out.println("How many spikes it has:");
                        int numberSpike = sc.nextInt();
                        Hedgehogs hed = new Hedgehogs(nameAnimal, ageAnimal, numberSpike, "Hedgehog");
                        hed.introduceNameSpecies();
                        zoo.addAnimal(hed);
                    }

                }
                else if (choiceAnimal == 2) {
                    boolean ok = false;
                    System.out.println("Give it a name:");
                    sc.nextLine();
                    String nameAnimal = sc.nextLine();
                    try {
                        zoo.validateAnimal(nameAnimal);
                    } catch (ReservedNameException e) {
                        System.out.println(e.getMessage());
                        ok = true;
                    }
                    if (ok == false) {
                        System.out.println("How old it is:");
                        int ageAnimal = sc.nextInt();
                        System.out.println("Give it a color:");
                        String colorAnimal = sc.next();

                        Cats cat = new Cats(nameAnimal, ageAnimal, colorAnimal, "Cat");
                        cat.introduceNameSpecies();
                        zoo.addAnimal(cat);
                    }

                }
                else {
                    boolean ok = false;
                    System.out.println("Give it a name:");
                    sc.nextLine();
                    String nameAnimal = sc.nextLine();
                    try {
                        zoo.validateAnimal(nameAnimal);
                    } catch (ReservedNameException e) {
                        System.out.println(e.getMessage());
                        ok = true;
                    }
                    if(ok == false) {
                        System.out.println("How old it is:");
                        int ageAnimal = sc.nextInt();
                        Lions lion = new Lions(nameAnimal, ageAnimal, "Lion");
                        lion.introduceNameSpecies();
                        zoo.addAnimal(lion);
                    }
                }
            }
            else if (num == 2) {
                System.out.println(zoo.name + " is lead by " + zoo.nameManager +  " and it has the following animals:");
                zoo.listAnimalInZoo();

            }
            else if (num == 3) {
                zoo.playAnimalInZoo();
            }
            else if (num == 4) {
                System.out.println("One year has passed.");
                zoo.addAgeAnimal();
                zoo.checkDieOrAlive();
            }
            else if (num == 5) {
                try {
                    FileOutputStream fileOut = new FileOutputStream("zoo.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    //System.out.println("duong23423");
                    out.writeObject(zoo);
                    //System.out.println("duong");
                    out.close();
                    fileOut.close();
                    System.out.println("Zoo has been saved.");
                }
                catch(IOException ex)
                {
                    System.out.println("Zoo has been saved.");
                }
            }
            else if (num == 6) {
                try {
                    File file = new File("zoo.ser");
                    if(!file.exists()) {
                        System.out.println("File not found.");
                    }
                    FileInputStream fileIn = new FileInputStream(file);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    zoo = (Zoo) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Zoo has been loaded from a file.");
            }
                catch(IOException ex)
                {
                    //System.out.println("File not found.");
                }
                catch(ClassNotFoundException ex)
                {
                    System.out.println("ClassNotFoundException is caught");
                }
            }
        }
    }
}