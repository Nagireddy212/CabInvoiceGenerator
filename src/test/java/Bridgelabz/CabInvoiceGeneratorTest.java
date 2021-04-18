package Bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    @Test
    public void givenDistanceAndTime_CalculateFare_ReturnTrueIfCorrectlyCalculated(){
        Ride cabRide = new Ride(10 , 5);
        InvoiceGenerator runnerObject = new InvoiceGenerator();
        double totalFare = runnerObject.calculateFare(cabRide);
        Assertions.assertEquals(105, totalFare , 0);
    }

    @Test
    public void givenMultipleRides_CalculateFare_ReturnTrueIfCorrectlyCalculated(){
        Ride cabRide1 = new Ride(10 , 5);
        Ride cabRide2 = new Ride(0.1 , 1);
        Ride cabRide3 = new Ride(2 , 3);
        Ride[] cabRides = {cabRide1,cabRide2,cabRide3};
        InvoiceGenerator runnerObject = new InvoiceGenerator();
        double totalFare = runnerObject.calculateFare(cabRides);
        Assertions.assertEquals(133, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_CalculateEnhancedInvoice_ReturnTrueIfCorrectlyCalculated(){
        Ride cabRide1 = new Ride(10 , 5);
        Ride cabRide2 = new Ride(0.1 , 1);
        Ride cabRide3 = new Ride(2 , 3);
        Ride[] cabRides = {cabRide1,cabRide2,cabRide3};
        InvoiceGenerator runnerObject = new InvoiceGenerator();
        EnhancedInvoice enhancedInvoice = runnerObject.calculateEnhancedInvoice(cabRides);
        Assertions.assertEquals(3, enhancedInvoice.numberOfRides, 0.1);
        Assertions.assertEquals(133, enhancedInvoice.totalFare, 0.1);
        Assertions.assertEquals(44.3, enhancedInvoice.averageFarePerRide, 0.1);
    }

    @Test
    public void givenOneRide_CalculateEnhancedInvoice_ReturnTrueIfCorrectlyCalculated(){
        Ride cabRide2 = new Ride(0.1 , 1);
        InvoiceGenerator runnerObject = new InvoiceGenerator();
        EnhancedInvoice enhancedInvoice = runnerObject.calculateEnhancedInvoice(cabRide2);
        Assertions.assertEquals(1, enhancedInvoice.numberOfRides, 0.1);
        Assertions.assertEquals(5, enhancedInvoice.totalFare, 0.1);
        Assertions.assertEquals(5, enhancedInvoice.averageFarePerRide, 0.1);
    }

    @Test
    public void givenUserID_CalculateEnhancedInvoice_ReturnTrueIfCorrectlyCalculated(){
        Ride cabRide1 = new Ride(10 , 5);
        Ride cabRide2 = new Ride(0.1 , 1);
        Ride cabRide3 = new Ride(2 , 3);
        Ride[] cabRidesList1 = {cabRide1,cabRide2,cabRide3};
        Ride cabRide4 = new Ride(10 , 5);
        Ride cabRide5 = new Ride(0.1 , 1);
        Ride cabRide6 = new Ride(2 , 3);
        Ride[] cabRidesList2 = {cabRide4,cabRide5,cabRide6};
        Ride cabRide7 = new Ride(4.0 , 3);
        RideRepository user1Repository = new RideRepository("User1");
        user1Repository.addRides(cabRidesList1);
        user1Repository.addRides(cabRidesList2);
        user1Repository.addRides(cabRide7);
        InvoiceGenerator runnerObject = new InvoiceGenerator();
        EnhancedInvoice enhancedInvoice = runnerObject.calculateEnhancedInvoice("User1");
        Assertions.assertEquals(7, enhancedInvoice.numberOfRides, 0);
        Assertions.assertEquals(310.4, enhancedInvoice.totalFare, 2);
        Assertions.assertEquals(44.3, enhancedInvoice.averageFarePerRide, .2);
    }

    @Test
    public void givenUserID_CalculateEnhancedInvoiceWithDifferentPremiumRideRates_ReturnTrueIfCorrectlyCalculated(){
        Ride cabRide1 = new Ride(10 , 5);
        Ride cabRide2 = new Ride(0.1 , 1, true);
        Ride cabRide3 = new Ride(2 , 3);
        Ride[] cabRidesList1 = {cabRide1,cabRide2,cabRide3};
        Ride cabRide4 = new Ride(10 , 5);
        Ride cabRide5 = new Ride(0.1 , 1);
        Ride cabRide6 = new Ride(2 , 3);
        Ride[] cabRidesList2 = {cabRide4,cabRide5,cabRide6};
        Ride cabRide7 = new Ride(4.0 , 3);
        RideRepository user1Repository = new RideRepository("User1");
        user1Repository.addRides(cabRidesList1);
        user1Repository.addRides(cabRidesList2);
        user1Repository.addRides(cabRide7);
        InvoiceGenerator runnerObject = new InvoiceGenerator();
        EnhancedInvoice enhancedInvoice = runnerObject.calculateEnhancedInvoice("User1");
        Assertions.assertEquals(7, enhancedInvoice.numberOfRides, 0);
        Assertions.assertEquals(325.4, enhancedInvoice.totalFare, 2);
        Assertions.assertEquals(46.3, enhancedInvoice.averageFarePerRide, .2);
    }
}