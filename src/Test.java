import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;

public class Test {

    public static void main(String[] args) {
        //Задание 1
        HashMap<String, String> slovar = new HashMap<>();
        slovar.put("Перов", "Егор");
        slovar.put("Ольгов", "Дмитрий");
        slovar.put("Яковлев", "Михаил");
        HashMap<String, String> copy1 = new HashMap<>(slovar);
        HashMap<String, String> copy2 = new HashMap<>(slovar);
        for (Map.Entry<String, String> hash : copy1.entrySet()) {
            String name = hash.getValue();
            for (Map.Entry<String, String> map : copy2.entrySet()) {
                if (map.getValue().equals(name) && !map.equals(hash)) {
                    slovar.remove(map.getKey());
                    break;
                }
            }
        }
        System.out.println(slovar);
        //Задание 2
        HashMap<String, ArrayList<String>> hash = new HashMap<>();
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Moscow", "Russia"));
        cities.add(new City("Seattle", "USA"));
        cities.add(new City("Los-Angeles", "USA"));
        for (City c : cities) {
            if (!hash.containsKey(c.getCountry())) {
                ArrayList<String> array = new ArrayList<>();
                hash.put(c.getCountry(), array);
            }
            hash.get(c.getCountry()).add(c.getCity());
        }
        System.out.println(hash);
    }
}

class City{
    public String city;
    public String country;

    public City(String city, String country){
        this.city=city;
        this.country=country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}