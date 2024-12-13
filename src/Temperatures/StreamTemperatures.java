package Temperatures;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTemperatures extends Temperatures {
    public StreamTemperatures(String filepath) {
        super(filepath);
    }

    public long size() {
        return stream().count();
    }

    public List<LocalDate> dates() {
        return stream().map(x -> x.getDate()).distinct().sorted().toList();
    }

    public Set<String> cities() {
        return stream().map(x->x.getCity()).collect(Collectors.toSet());
    }

    public Set<String> countries() {
        return stream().map(x->x.getCountry()).collect(Collectors.toSet());
    }


    // A 17
    // A 12
    // B 33
    // A -> [17,12] , B -> [33]
    public Map<String, List<Double>> temperaturesByCountry() {
        Map<String,List<Temperature>> map = stream().collect(Collectors.groupingBy(x->x.getCountry()));
        Map<String,List<Double>> result = new HashMap<>();
        for(String key: map.keySet()){
            List<Double> temps = map.get(key).stream().map(x->x.getTemperature()).toList();
            result.put(key,temps);
        }
        return result;
    }

    @Override
    public String coldestCountryAbs() {
         return stream().min((t1,t2)-> Double.compare(t1.getTemperature(), t2.getTemperature())).get().getCountry();
    }

    @Override
    public String hottestCountryAbs() {
        return stream().max((t1,t2)-> Double.compare(t1.getTemperature(), t2.getTemperature())).get().getCountry();
    }

    @Override
    public Map<String, Double> countriesAvgTemperature() {
        Map<String,List<Double>> countryToTemperatures = temperaturesByCountry();
        Map<String,Double>  countryToAvgTemp = new HashMap<>();
        for(String country: countryToTemperatures.keySet()){
            double avg = countryToTemperatures.get(country).stream().mapToDouble(x->x).average().getAsDouble();
            countryToAvgTemp.put(country, avg);
        }
        return countryToAvgTemp;
    }

    public Map<String, Double> avgTemperatureDeltaPerYearPerCountry() {
        Set<String> countries = countries();
        Map<String,Double> result = new HashMap<>();
        for(String country: countries){
            Map<Integer,Double> avgByYear = avgByYearly(country);

            List<Integer> years = avgByYear.keySet().stream().sorted().toList();
            List<Double> avgs = new LinkedList<>();

            for(int i = 0; i < years.size() - 1; i++){
                double avgNextYear = avgByYear.get(years.get(i+1));
                double avgYear = avgByYear.get(years.get(i));
                avgs.add(avgNextYear - avgYear);
            }

            double avg = avgs.stream().mapToDouble(x->x).average().getAsDouble();

            result.put(country,avg);
        }

        return result;
    }

    private Map<Integer,Double> avgByYearly(String countryName){
        Map<Integer,List<Temperature>> map = stream()
                .filter(x-> x.getCountry().equals(countryName))
                .collect(Collectors.groupingBy(x->x.getDate().getYear()));
        Map<Integer,Double> avgByYear = new HashMap<>();
        map.forEach((x,list)->{
            avgByYear.put(x,list.stream().mapToDouble(t->t.getTemperature()).average().getAsDouble());
        });
        return avgByYear;
    }







    public static void main(final String[] args) {
        String filepath = "temperaturesEurope1963Till2013ByCity.csv";
        StreamTemperatures temperatures = new StreamTemperatures(filepath);

        temperatures.printSummary();
        final Map<String, Double> values = temperatures
                .avgTemperatureDeltaPerYearPerCountry();

        print("Averaged yearly temperature delta per country:",
                Arrays.toString(values.entrySet().toArray()));

        String English = "English";

        Planet planet = Planet.Earth;
        Planet planet1 = Planet.Jupiter;

        System.out.println(planet == planet1);


    }



    public enum Planet{
        Mars,
        Earth,

        Jupiter,
    }


}
