package Main;

public abstract class Animal {
    public String name;
    public String species;
    public int ageAnimal;
    public void introduceNameSpecies() {
        System.out.println("Hi, I am " + species + " and my name is " + name + ".");
    }

    public void speak() {
        System.out.println(name + " is having a lot of fun.");
    }
}
