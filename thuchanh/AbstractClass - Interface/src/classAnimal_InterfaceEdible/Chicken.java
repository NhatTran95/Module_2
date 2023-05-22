package classAnimal_InterfaceEdible;

public class Chicken extends Animal implements Edible{
    public String makeSound(){
        return "Chicken keu: o o o";
    }

    @Override
    public String howtoEat() {
        return "cach an ga: luoc cham muoi tieu";
    }
}
