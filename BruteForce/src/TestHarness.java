public class TestHarness {
    //latitude.endsWith("N"))   ==> positive # (e.g. Boston ==> 42.3601 N, 71.0589 W)
    //longitude.endsWith("W"))  ==> negative # (e.g. Boston ==> 42.3601 N, 71.0589 W)
    //latitude.endsWith("S"))   ==> negative # (e.g. Sydney ==> 33.8675 S, 151.2070 E)
    //longitude.endsWith("E"))  ==> positive # (e.g. Sydney ==> 33.8675 S, 151.2070 E)
    public static void main(String[] args) {
        City city1 = new City("Boston", 42.3601, -71.0589);
        City city2 = new City("New York", 40.7128, -74.0059);
        City city3 = new City("Sydney", -33.8675, 151.2070);
        double distance1to2 = city1.measureDistance(city2);
        System.out.println("Distance from "+ city1+ " to "+ city2 + " = "+String.format("%.2f", distance1to2) +" miles");
        double distance2to3 = city2.measureDistance(city3);
        System.out.println("Distance from "+ city2+ " to "+ city3 + " = "+String.format("%.2f", distance2to3) +" miles");
        double distance3to1 = city3.measureDistance(city1);
        System.out.println("Distance from "+ city3+ " to "+ city1 + " = "+String.format("%.2f", distance3to1) +" miles");
        double totalDistance = distance1to2 + distance2to3 + distance3to1;
        System.out.println("total distance = "+ String.format("%.2f", totalDistance)+" miles");
    }
}

