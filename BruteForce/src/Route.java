import java.util.ArrayList;
import java.util.Arrays;

public class Route {
    private ArrayList<City> cities = new ArrayList<City>();
    public Route(ArrayList<City> initialRoute) { setCities(initialRoute);}
    public Route(Route route) { route.cities.stream().forEach(x -> cities.add(x));}
    public ArrayList<City> getCities() { return cities; }
    public void setCities(ArrayList<City> cities) { this.cities = cities; }
    public String toString() { return Arrays.toString(cities.toArray()); }
}
