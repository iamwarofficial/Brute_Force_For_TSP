import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    final static boolean VERBOSE_FLAG = false;
    private static ArrayList<City> initialRoute = new ArrayList<City>(Arrays.asList(
            new City("Boston", 42.3601, -71.0589),
            new City("San Francisco", 37.7749, -122.4194),
            new City("New York", 40.7128, -74.0059),
            new City("Houston", 29.7604, -95.3698),
            new City("Denver", 39.7392, -104.9903),
            new City("Los Angeles", 34.0522, -118.2437),
            new City("Chicago", 41.8781, -87.6298),
            new City("Austin", 30.2672, -97.7431)
            //new City("Dallas", 32.7767, -96.7970),
            //new City("Seattle", 47.6062, -122.3321)
            //new City("Sydney", -33.8675, 151.2070),
            //new City("Tokyo", 35.6895, 139.6917),
            //new City("Cape Town", -33.9249, 18.4241)
    ));

    public static void main(String[] args) {
        Driver driver = new Driver();
        Instant startInstant = Instant.now();
        BruteForce bruteForce = new BruteForce();
        Route currentRoute = new Route(initialRoute);
        if (VERBOSE_FLAG) driver.printHeading("Route", " Distance (in miles)  |  Shortest Distance  |  Permutation #");
        else System.out.println("permutations in progress ...");
        driver.printResult(bruteForce, bruteForce.permuteCities(0, currentRoute, new Route(currentRoute)));
        driver.printDuration(startInstant);
    }
    public void printDuration(Instant startInstant) {
        Duration permutationDuration = Duration.between(startInstant, Instant.now());
        long minutes = permutationDuration.toMinutes();
        long seconds = permutationDuration.getSeconds();
        if (seconds > 59) {
            long tempSeconds = seconds - 60*minutes;
            long tempMilliSeconds = permutationDuration.toMillis() - seconds*1000;
            System.out.println("Duration: " + minutes + " minutes "+tempSeconds+" seconds "+
                    +tempMilliSeconds+" milliseconds "+"("+permutationDuration+")");
        }
        else if (seconds > 0) {
            long tempMilliSeconds = permutationDuration.toMillis() - seconds*1000;
            System.out.println("Duration: " + seconds+ " seconds "+tempMilliSeconds+" milliseconds "+ "("+permutationDuration+")");
        }
        else System.out.println("Duration: " + permutationDuration.toMillis()+ " milliseconds ("+permutationDuration+")");
    }
    public void printResult(BruteForce bruteForce, ArrayList<Route> shortestRoutes) {
        if (VERBOSE_FLAG) System.out.println("");
        printHeading("Shortest Route", "Distance (in miles)");
        shortestRoutes.stream().forEach(x -> System.out.println(x + " | " + bruteForce.getTotalDistance(x)));
    }
    public void printHeading(String headingColumn1, String remainingHeadingColumns) {
        int cityNamesLength = 0;
        for (int x = 0; x < initialRoute.size(); x++) cityNamesLength += initialRoute.get(x).getName().length();
        int arrayLength = cityNamesLength + initialRoute.size()*2;
        int partialLength = (arrayLength - headingColumn1.length())/2;
        for (int x=0; x < partialLength; x++) System.out.print(" ");
        System.out.print(headingColumn1);
        for (int x=0; x < partialLength; x++) System.out.print(" ");
        if ((arrayLength % 2) == 0) System.out.print(" ");
        System.out.println(" | "+ remainingHeadingColumns);
        cityNamesLength += remainingHeadingColumns.length() + 3;
        for (int x=0; x < cityNamesLength+initialRoute.size()*2; x++) System.out.print("-");
        System.out.println("");
    }
}
