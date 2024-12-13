package Interfaces;

public class Animal {
    protected int age;
    public Animal(int age){
        this.age = age;
    }

    public void birthday(){
        age++;
    }
}
