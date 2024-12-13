package AdventiunParty.adventuin;


import AdventiunParty.color.IntMath;
import AdventiunParty.color.RgbColor8Bit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AdventuinParty {

    public static Map<HatType, List<Adventuin>> groupByHatType(List<Adventuin> adventuinList){
        return adventuinList.stream()
                .distinct()
                .filter(x-> x != null)
                .collect(Collectors.groupingBy(x->x.getHat()));
    }

    public static void printLocalizedChristmasGreetings(List<Adventuin> adventuinList){
        adventuinList.stream()
                .filter(x-> x != null)
                .distinct()
                .sorted((a1,a2)-> Integer.compare(a1.getHeight(),a2.getHeight()))
                .forEach(x-> {
                    System.out.println(x.getLanguage().getLocalizedChristmasGreeting(x.getName()));
                });
    }

    public static Map<HatType,List<Adventuin>> getAdventuinsWithLongestNamesByHatType(List<Adventuin> adventuinList){
        int maxlength = adventuinList.stream()
                .max((a1,a2) -> a1.getName().compareTo(a2.getName()))
                .get()
                .getName()
                .length();
        return adventuinList.stream()
                .filter(x-> x != null && x.getName().length() == maxlength)
                .distinct()
                .collect(Collectors.groupingBy(x->x.getHat()));
    }

    public static Map<Integer,Double> getAverageColorBrightnessByHeight(List<Adventuin> adventuinList){
        Map<Integer,List<Adventuin>> map = adventuinList.stream()
                .filter(x->x!=null)
                .distinct()
                .collect(Collectors.groupingBy(x-> IntMath.round(x.getHeight())));

        Map<Integer,Double> result = new HashMap<>();

        map.forEach((height,lst)->{
            double avg = lst.stream()
                    .mapToDouble(x->{
                        RgbColor8Bit rgbColor8Bit = x.getColor().toRgbColor8Bit();
                        return (0.2126 * rgbColor8Bit.getRed() + 0.7152 * rgbColor8Bit.getGreen() + 0.0722 * rgbColor8Bit.getBlue())/255;
                    }).average().getAsDouble();
            result.put(height,avg);
        });

        return result;

    }


//    public static Map<HatType,Double> getDiffOfAvgHeightDiffsToPredecessorByHatType(List<Adventuin> adventuinList){
//
//    }







}
