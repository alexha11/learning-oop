package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Zoo {
    public String name;
    public String nameManager;
    static int countAnimal = 0;
    public ArrayList<Object> animalArray = new ArrayList<>();

    public Zoo(String name, String nameManager) {
        this.name = name;
        this.nameManager = nameManager;
    }


    public void listAnimalInZoo() {
        for (int i = 0; i < animalArray.size(); i++) {
            Object obj = animalArray.get(i);
            if (obj instanceof Cats) {
                Cats cat = (Cats) obj;
                cat.introduceMyself();
            } else if (obj instanceof Lions) {
                Lions lion = (Lions) obj;
                lion.introduceMyself();
            }
            else {
                Hedgehogs hed = (Hedgehogs) obj;
                hed.introduceMyself();
            }
        }
    }

    public void playAnimalInZoo() {
        for (int i = 0; i < animalArray.size(); i++) {
            Object obj = animalArray.get(i);
            if (obj instanceof Cats) {
                Cats cat = (Cats) obj;
                cat.speak();
                cat.jump();
                cat.land();
            } else if (obj instanceof Lions) {
                Lions lion = (Lions) obj;
                lion.speak();
                lion.jump();
                lion.land();
            }
            else {
                Hedgehogs hed = (Hedgehogs) obj;
                hed.speak();
            }
        }
    }

    public void addAgeAnimal() {
        for (int i = 0; i < animalArray.size();i++) {
            Object obj = animalArray.get(i);
            if (obj instanceof Cats) {
                Cats cat = (Cats) obj;
                cat.addAgeCat();

            } else if (obj instanceof Lions) {
                Lions lion = (Lions) obj;
                lion.addAgeLion();
            }
            else {
                Hedgehogs hed = (Hedgehogs) obj;
                hed.addAgeHed();
            }
        }
    }

    public void checkDieOrAlive() {
        for (int i = 0; i < animalArray.size(); i++) {
            Object obj = animalArray.get(i);
            if (obj instanceof Cats) {
                Cats cat = (Cats) obj;
                if (cat.check() == false) {
                    int index = animalArray.indexOf(cat);
                    animalArray.remove(index);
                    int temp = cat.ageAnimal - 1;
                    System.out.println("Cat " + cat.name +" passed away at the age of " + temp + ".");
                }
            } else if (obj instanceof Lions) {
                Lions lion = (Lions) obj;
                if (lion.check() == false) {
                    int index = animalArray.indexOf(lion);
                    animalArray.remove(index);
                    int temp = lion.ageAnimal - 1;
                    System.out.println("Lion " + lion.name +" passed away at the age of " + temp + ".");
                }
            }
            else {
                Hedgehogs hed = (Hedgehogs) obj;
                if (hed.check() == false) {
                    int index = animalArray.indexOf(hed);
                    animalArray.remove(index);
                    int temp = hed.ageAnimal - 1;
                    System.out.println("Hedgehog " + hed.name +" passed away at the age of " + temp + ".");
                }
            }
        }
    }
    public void addAnimal(Object animal) {
        animalArray.add(animal);
        countAnimal++;
    }
    public void validateAnimal (String animal) throws ReservedNameException {
        if (animal.toLowerCase().contains("pikseli") || animal.toLowerCase().contains("pehmo") || animal.toLowerCase().contains("leo"))  {
            throw new ReservedNameException("The name " + animal + " is reserved.");
        }
    }
}
