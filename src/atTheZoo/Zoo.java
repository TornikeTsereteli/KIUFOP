package atTheZoo;

import java.util.Arrays;

public class Zoo {

    private Vivarium[] vivaria;

    public Zoo(Vivarium[] vivaria) {
        this.vivaria = vivaria;
    }

    public int getCosts(){
        int sum = 0;
        for(Vivarium v: vivaria){
            sum+=v.getCosts();
        }
        return sum;
    }

    @Override
    public String toString(){
        String s = Arrays.toString(vivaria);
        s = "{"+s.substring(1,s.length()-1)+"}";
        return s;
    }
}
