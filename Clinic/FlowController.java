import java.util.Scanner;

import Flow.ReservationHandler;
import Logistics.Hospital;
import Logistics.User;

public class FlowController {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner sc = new Scanner(System.in);

        Hospital hos = Hospital.getinstance();
       

        String userChoice = "run";

        while (!userChoice.equals("exit")) {

            System.out.println("Welcome to the Online Clinic Reservation Reservation Services");

            System.out.println("Are you an existing user? Press y/n");
            String exsistingUser = sc.next();
            User u;
            String HKID;

            if (exsistingUser.equals("y")) {
                System.out.println("Enter your HKID:");
                HKID = sc.next();
                u = hos.findUserByHKID(HKID);
            }

            else {
                System.out.println("Please enter your name: ");
                String name = sc.next();
                System.out.println("Enter your HKID:");
                HKID = sc.next();
                u = new User(HKID, name);
                hos.addUser(u);
            }

            System.out.println("Please select one of the options below: ");
            System.out.println("Type 'new' to make a new reservation.");
            System.out.println("Type 'cancel' to cancel an existing reservation.");
            System.out.println("Type 'enquire' to enquire about your existing reservation.");
            String serviceRequested = sc.next();

            if (serviceRequested.equals("new")) {
                ReservationHandler.newReservation(hos, sc, u);
            }

            else if (serviceRequested.equals("cancel")) {
               
                ReservationHandler.cancelReservation(hos, sc, u);

            }

            else if (serviceRequested.equals("enquire")) {
                
                ReservationHandler.enquireReservation(hos, sc, u);
            }
            System.out.println("Select one of the given options:");
            System.out.println("Type 'run' to use the reservation portal again.");
            System.out.println("Type 'exit' to end the application.");
            userChoice = sc.next();
        }
    }
}
