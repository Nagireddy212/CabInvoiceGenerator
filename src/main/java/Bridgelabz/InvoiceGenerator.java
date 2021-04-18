package Bridgelabz;

public class InvoiceGenerator {

    public static final int COST_PER_KILOMETER_REGULAR = 10;
    public static final int COST_MIN_REGULAR = 5;
    public static final int COST_PER_MINUTE_REGULAR = 1;

    public static final int COST_PER_KILOMETER_PREMIUM = 15;
    public static final int COST_MIN_PREMIUM = 20;
    public static final int COST_PER_MINUTE_PREMIUM = 2;

    public double calculateFare(Ride currentRide) {
        int costPerKM = COST_PER_KILOMETER_REGULAR, costPerMin = COST_PER_MINUTE_REGULAR, costMin = COST_MIN_REGULAR;
        if(currentRide.isPremiumRide()){
            costPerKM = COST_PER_KILOMETER_PREMIUM; costPerMin = COST_PER_MINUTE_PREMIUM; costMin = COST_MIN_PREMIUM;
        }
        double currentRideFare = (currentRide.getDistance() * costPerKM + currentRide.getTime()* costPerMin);
        return currentRideFare > costMin ? currentRideFare : costMin;
    }

    public double calculateFare(Ride[] cabRides) {
        double totalFare = 0;
        for (Ride cabRide : cabRides) {
            totalFare += this.calculateFare(cabRide);
        }
        return totalFare;
    }

    public EnhancedInvoice calculateEnhancedInvoice(Ride[] cabRides) {
        return new EnhancedInvoice(cabRides);
    }

    public EnhancedInvoice calculateEnhancedInvoice(Ride cabRide) {
        return new EnhancedInvoice(cabRide);
    }

    public EnhancedInvoice calculateEnhancedInvoice(String userName) {
        return new EnhancedInvoice(userName);
    }
}