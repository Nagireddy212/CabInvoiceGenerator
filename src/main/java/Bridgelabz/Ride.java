package Bridgelabz;

public class Ride {
    private double distance;
    private int time;
    private final boolean premiumRide;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.premiumRide = false;
    }

    public Ride(double distance, int time, boolean premium) {
        this.distance = distance;
        this.time = time;
        this.premiumRide = premium;
    }

    public boolean isPremiumRide() {
        return premiumRide;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}