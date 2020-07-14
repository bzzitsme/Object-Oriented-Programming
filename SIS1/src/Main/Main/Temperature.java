package Main.Main;

public class Temperature {
    private double temperature;
    private char scale;

    public Temperature() {
        this.temperature = 0;
        this.scale = 'C';
    }

    public Temperature(double temperature) {
        this.temperature = temperature;
        this.scale = 'C';
    }

    public Temperature(char scale) {
        this.temperature = 0;
        this.scale = scale;
    }

    public Temperature(double temperature, char scale) {
        this.temperature = temperature;
        this.scale = scale;
    }

    /**
     * getter and setter for Temperature and Scale
     */

    private void setter(double temperature, char scale) {
        this.temperature = temperature;
        this.scale = scale;
    }

    public double getTemperature() {
        return this.temperature;
    }

    private void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public char getScale() {
        return this.scale;
    }

    private void setScale(char scale) {
        this.scale = scale;
    }

    /**
     * Methods to convert current temperature to Celcius / Fahrenheit
     */

    public double toCelcius() {
        return (this.scale == 'C' ? this.temperature : 5 * (this.temperature - 32) / 9);
    }

    public double toFahrenheit() {
        return (this.scale == 'F' ? this.temperature : 9 * (this.temperature / 5) + 32);
    }

    public static void main(String[] args) {
        Temperature data = new Temperature(12, 'C');
        System.out.println(data.getScale());
        System.out.println(data.getTemperature());
        System.out.println(data.toCelcius());
        System.out.println(data.toFahrenheit());

        data.setScale('F');
        data.setTemperature(43);

        System.out.println(data.getScale());
        System.out.println(data.getTemperature());
        System.out.println(data.toCelcius());
        System.out.println(data.toFahrenheit());
    }
}
