package Bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;

public class RideRepository {
    public static ArrayList<RideRepository> allRideRepositories = new ArrayList<>();
    private String userName;
    private ArrayList<Ride> allRides;

    public RideRepository() {
    }

    public RideRepository(String userName) {
        this.userName = userName;
        this.allRides = new ArrayList<>();
        allRideRepositories.add(this);
    }

    public String getUserName() {
        return userName;
    }

    public Ride[] getAllRides() {
        Ride[] rideArray = new Ride[allRides.size()];
        this.allRides.toArray(rideArray);
        return rideArray;
    }

    public void addRides(Ride[] cabRidesList) {
        this.allRides.addAll(Arrays.asList(cabRidesList));
    }

    public void addRides(Ride cabRide) {
        this.allRides.add(cabRide);
    }
}
