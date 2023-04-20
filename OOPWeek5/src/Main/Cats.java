package Main;

public class Cats extends Animal implements Jumpable{
    public String color;

    public int maxAge = 20;
    static int ageCat;
    public Cats(String name, int ageAnimal,  String color, String species) {
        this.name = name;
        this.ageAnimal = ageAnimal;
        this.color = color;
        this.species = species;
    }
    private void doNastyThings() {
        System.out.println("...and doing nasty things...");
    }
    public void speak() {
        System.out.println(color + " " + name + " is having fun.");
        doNastyThings();
    }

    public void introduceMyself() {
        System.out.println("The " + color + " Cat " + name + " is "+ ageAnimal +" years old (" + ageAnimal * 6 + " in human years).");
    }
    public void addAgeCat() {
        this.ageAnimal++;
    }
    boolean check() {
        if (ageAnimal >= maxAge) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void jump() {
        System.out.println("Cat is jumping!");
    }

    @Override
    public void land() {
        System.out.println("Cat is landing!");
    }
}
