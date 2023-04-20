package Main;

public class Lions extends Animal implements Jumpable{
    public int numberSpike;

   public int maxAge = 25;
   static int ageLion;
    public Lions(String name, int ageAnimal, String species) {
        this.name = name;
        this.ageAnimal = ageAnimal;
        this.species = species;
    }
    public void introduceMyself() {
        System.out.println("The Lion " + name + " is " + ageAnimal + " years old (" + ageAnimal * 2 + " in human years).");
    }

    public void addAgeLion() {
        this.ageAnimal++;
    }
    boolean check() {
        if (ageAnimal> maxAge) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void jump() {
        System.out.println("Lion is jumping!");
    }

    @Override
    public void land() {
        System.out.println("Lion is landing!");
    }
}
