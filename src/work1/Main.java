package work1;
//Animal 클래스를 상속 받는 work.Dog, work.Cat, work.Human 클래스를 만들고 각 메서드를 1개 이상 만들어 보세요.
//
//조건
// work.Animal 클래스는 1개 이상의 속성과 행동을 자식에게 물려 주어야 합니다.
// 자식은 부모에게 물려 받은 행동을 오버라이딩해야 합니다.

class Animal {
    int age;
    String name;
    String gender;
    String species;
    public void Myself() {
        System.out.println("I am a "+ species);
        System.out.println("my name is "+ name);
        System.out.println("my gender is "+ gender);
        System.out.println("my age is "+ age);
    }

    public void bow() {
        System.out.println("boww");
    }
    public void hand() {
        System.out.println("hand");
    }
}

class Dog extends Animal{
    String breed; //견종
    String color;

    Dog(int age,String species, String name,String gender,String breed,String color){
        super.age=age;
        super.name=name;
        super.species=species;
        super.gender=gender;
        this.breed=breed;
        this.color=color;
    }

    @Override
    public void Myself() {
        super.Myself();
        System.out.println("I am a "+ breed);
        System.out.println("my color is "+ color);
    }
    // bow와 hand의 내용을 작성하지 않아도 부모 클래스에서 상속 받아 사용할 수 있다
}

class Cat extends Animal{
    String breed; //종
    String color;

    Cat(int age,String name,String species,String gender,String breed,String color){
        super.age=age;
        super.name=name;
        super.species=species;
        super.gender=gender;
        this.breed=breed;
        this.color=color;
    }

    @Override
    public void Myself() {
        super.Myself();
        System.out.println("I am a "+ breed);
        System.out.println("my color is "+ color);
    }

    @Override
    public void hand() {
        System.out.println("No!!!!!!!");
    }
    @Override
    public void bow() {
        System.out.println("mewwwo");
    }
}

class Human extends Animal{
    String country;
    String hairColor;
    Human(int age,String name,String species,String gender,String country,String hairColor){
        super.age=age;
        super.name=name;
        super.species=species;
        super.gender=gender;
        this.country=country;
        this.hairColor=hairColor;
    }

    @Override
    public void Myself() {
        super.Myself();
        System.out.println("my country is "+ country);
        System.out.println("my hair color is "+ hairColor);
    }

    @Override
    public void hand() {
        System.out.println("hello~");
    }
    @Override
    public void bow() {
        System.out.println("Let's shake hand~");
    }
}


public class Main{
    public static void main(String[] args) {
        Dog dog=new Dog(1,"Dog","John","Male","beagle","brown");
        dog.Myself();
        dog.bow();
        dog.hand();
        System.out.println();

        Cat cat = new Cat(1,"Amy","Cat","Female","persian","silver");
        cat.Myself();
        cat.bow();
        cat.hand();
        System.out.println();

        Human human = new Human(25,"Nick","Human","Male","Canada","Yellow");
        human.Myself();
        human.bow();
        human.hand();
        System.out.println();

    }
}
