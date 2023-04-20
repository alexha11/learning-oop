package a2_2101040197;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;

public class PC {
    @DomainConstraint (type = "String", mutable = true, optional = false, length = 20)
    private String model;
    @DomainConstraint (type = "Integer", mutable = false, optional = false, min = 1984)
    private Integer year;
    @DomainConstraint (type = "String", mutable = false, optional = false, length = 15)
    private String manufacturer;
    @DomainConstraint (type = "Set<String>", mutable = true, optional = false)
    private Set<String> components;
    //Constructor
    @DOpt(type = OptType.Constructor)
    public PC (@AttrRef("model") String model,@AttrRef("year") int year,@AttrRef("manufacturer") String manufacturer,@AttrRef("components") Set components) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.components = components;
    }
    @AttrRef("model")
    @DOpt(type = OptType.Observer)
    public String getModel() {
        return model;
    }
    @DOpt(type = OptType.Mutator)
    public void setModel(String model) {
        this.model = model;
    }
    @AttrRef("year")
    @DOpt(type = OptType.Observer)
    public int getYear() {
        return year;
    }
//    @DOpt(type = OptType.Mutator)
//    public void setyear(int year) {
//        this.year = year;
//    }

    @AttrRef("manufacturer")
    @DOpt(type = OptType.Observer)
    public String getManufacturer() {
        return manufacturer;
    }

    @AttrRef("components")
    @DOpt(type = OptType.Observer)
    public Set<String> getComponents() {
        return components;
    }

    @DOpt(type = OptType.Mutator)
    public void setComponents(Set<String> components) {
        this.components = components;
    }
    @DOpt(type = OptType.Helper)
    private boolean modelValid(String model) {
        if (model.length() > 20) {
            System.out.println("The length of model is invalid!");
            return false;
        } else{
            return true;
        }
    }
    @DOpt(type = OptType.Helper)
    private boolean manufacturerValid(String manufacturer) {
        if (manufacturer.length() > 15) {
            System.out.println("The length of manufacturer is invalid!");
            return false;
        } else{
            return true;
        }
    }
    @DOpt(type = OptType.Helper)
    private boolean yearValid(Integer year) {
        if (year < 1984) {
            System.out.println("The year is invalid!");
            return false;
        } else {
            return true;
        }
    }
    @DOpt(type = OptType.Helper)
    public boolean repOK() {
        return modelValid(model) && manufacturerValid(manufacturer ) && yearValid(year);
    }

    @Override
    @DOpt(type = OptType.Default)
    public String toString() {
        return "PC<" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", manufacturer='" + manufacturer + '\'' +
                ", Set{" + components +
                "}>";
    }
}
