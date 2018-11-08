package ru.stegnin.javaArchitectureHW.HW2;

public class MainClass {
    public static void main(String[] args) {
        Lion african = new AfricanLion();
        african.roar();
        Lion asian = new AsianLion();
        asian.roar();
        Hunter hunter = new Hunter();
        hunter.hunt(african);
        hunter.hunt(asian);
        WildDog wildDog = new WildDog();
        WildDogAdapter adapter = new WildDogAdapter(wildDog);
        hunter.hunt(adapter);
    }
}
