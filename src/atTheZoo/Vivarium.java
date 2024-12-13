package atTheZoo;

import java.util.Arrays;

public class Vivarium {

    private int area;
    private int constructedYear;

    private Animal[] inhabitants;

    public Vivarium(int area, int constructedYear, Animal[] inhabitants) {
        this.area = area;
        this.constructedYear = constructedYear;
        this.inhabitants = inhabitants;
    }

    public int getCosts(){
        int sum = 0;
        for(Animal animal: inhabitants){
            sum+= animal.getFoodCosts();
        }
        return sum + 900 + area * 100 + area * (2024 - constructedYear)*5;
    }

    @Override
    public String toString(){
        return "[area: " + area + ", constructionYear: " + constructedYear +
                ", animals: " + Arrays.toString(inhabitants).substring(1);
    }
}
