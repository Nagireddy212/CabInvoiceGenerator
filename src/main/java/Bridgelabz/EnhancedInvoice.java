package Bridgelabz;

public class EnhancedInvoice {
    public int numberOfRides;
    public double totalFare;
    public double averageFarePerRide;

    public EnhancedInvoice(Ride[] cabRides) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        boolean areCabRidesReceived = cabRides == null ;
        this.numberOfRides = areCabRidesReceived ? 0 : cabRides.length;
        this.totalFare = areCabRidesReceived ? 0 : invoiceGenerator.calculateFare(cabRides);
        this.averageFarePerRide = areCabRidesReceived ? 0 : this.totalFare/this.numberOfRides;
    }

    public EnhancedInvoice(Ride cabRide) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        this.numberOfRides = 1;
        this.totalFare = invoiceGenerator.calculateFare(cabRide);
        this.averageFarePerRide = this.totalFare;
    }

    public EnhancedInvoice(String userID) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        RideRepository rideRepository = new RideRepository();
        for (RideRepository rideRepoIterator : RideRepository.allRideRepositories) {
            if (rideRepoIterator.getUserName().equals(userID)){
                rideRepository = rideRepoIterator;
            }
        }
        this.numberOfRides = rideRepository.getAllRides().length;
        this.totalFare = invoiceGenerator.calculateFare(rideRepository.getAllRides());
        this.averageFarePerRide = this.totalFare / this.numberOfRides;
    }
}