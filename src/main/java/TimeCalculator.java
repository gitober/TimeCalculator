public class TimeCalculator {
    public double calculateTime(double distance, double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed must be greater than zero.");
        }
        return distance / speed;
    }

    public static double kelvinToFah(double kel) {
        return Math.round((kel - 273.15) * (9.0 / 5.0) + 32);
    }

    public static void main(String[] args) {
        // Example usage of calculateTime
        TimeCalculator calculator = new TimeCalculator();
        double time = calculator.calculateTime(100, 50);
        System.out.println("Time: " + time + " hours");

        // Example usage of kelvinToFah
        double fahrenheit = kelvinToFah(300.1);
        System.out.println("300.1 Kelvin is equal to " + fahrenheit + " Fahrenheit");
    }
}
