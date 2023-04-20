package Main;

public class Hedgehogs extends Animal{
    public int numberSpike;
    static int ageHed;
    public int maxAge = 7;
    public Hedgehogs(String name, int ageAnimal, int numberSpike, String species) {
        this.name = name;
        this.ageAnimal = ageAnimal;
        this.numberSpike = numberSpike;
        this.species = species;
        this.ageHed = ageAnimal;
    }
    public void introduceMyself() {
        System.out.println("The Hedgehog " + name + " is " + ageAnimal + " years old ("+ ageAnimal*20 + " in human years) and has " + numberSpike + " spikes.");
    }
    public void addAgeHed() {
        this.ageAnimal++;
    }
    boolean check() {
        if (ageAnimal > maxAge) {
            return false;
        }
        else {
            return true;
        }
    }

}
