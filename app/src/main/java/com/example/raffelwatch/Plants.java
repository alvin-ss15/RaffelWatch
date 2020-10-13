package com.example.raffelwatch;

public class Plants {
    String timestamp;
    int xp;
    double temperature, humidity, pH, luminance;

    public Plants() {

    }

    public Plants(int xp, String timestamp, double temperature, double humidity, double pH, double luminance) {
        this.xp = xp;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pH = pH;
        this.luminance = luminance;
    }

    public Plants(int xp) {

    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humid) {
        this.humidity = humidity;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public double getLuminance() {
        return luminance;
    }

    public void setLuminance(double luminance) {
        this.luminance = luminance;
    }
}
