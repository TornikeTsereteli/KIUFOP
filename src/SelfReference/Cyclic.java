package SelfReference;

public class Cyclic {

    private int info;
    private Cyclic ref;

    public Cyclic(){
        info = 17;
        ref = this;
    }


    public static void main(String[] args) {
        Cyclic cyclic = new Cyclic();
        System.out.println(cyclic.ref.info);
        System.out.println(cyclic.ref.ref.ref.info);
    }
}
