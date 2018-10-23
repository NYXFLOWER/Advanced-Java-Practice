package Week4;

public abstract class Animal {
    public void talk() {
	    System.out.println("Animals can't talk");
    }
}

class Pig extends Animal {
    public void talk() {
        System.out.println("Grunt!");
    }
}

class Cow extends Animal {
    public void talk() {
        System.out.println("Moo!");
    }
}

class Sheep extends Animal {
    @Override
    public void talk() {
        System.out.println("Baaa!");
    }
}

class TestSheep {
    public static void main(String[] args) {
        Animal[] animals = {new Cow(), new Pig(), new Sheep()};
        for (Animal animal: animals) {
            animal.talk();
        }
    }
}