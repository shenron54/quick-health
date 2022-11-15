package Flow;

import java.util.ArrayList;
import java.util.Scanner;

import Logistics.Hospital;
import Logistics.Location;
import Logistics.Time;
import Logistics.User;
import Reservations.Reservation;
import ServicesFactory.Service;

public class ReservationHandler {
        public static void newReservation(Hospital hos, Scanner sc, User u) throws CloneNotSupportedException {
            System.out.println("Please select the location");
            hos.printLocations();
            int locationIndex = sc.nextInt();
            Location selectedLoc = Hospital.getLocByIndex(locationIndex);

            System.out.println("Please select the services");
            // Print out the services
            hos.printServices();
            int serviceIndex = sc.nextInt();
            Service s = Hospital.getServiceByIndex(serviceIndex);
            System.out.println("Please select the available time slots");
            // Will print the available time slots and ask the user to select from it (will
            // be different for differnt locations)
            if (s.getName().equals("CheckUp")) {
            System.out.println(selectedLoc);
                selectedLoc.getDocAvailability();
            }

            else {
                selectedLoc.getAvailableIntervals();
            }
            String time = sc.next();

            Time selectedTime = new Time(Integer.parseInt(time.substring(0, 2)),
                    Integer.parseInt(time.substring(3)));

            System.out.println("Here are the details for your reservation:");
            System.out.println("Location: " + selectedLoc);
            System.out.println("Service selected: " + s);
            System.out.println("Time slot: " + selectedTime);
            System.out.println("Press y/n:");
            String answer = sc.next();
            if (answer.equals("y")) {
                Reservation res = new Reservation(u, selectedLoc, s, selectedTime);
                u.addReservation(res);
                selectedLoc.addReservationLoc(res);
                System.out.println("Reservation successful");
            }

        }

        public static void cancelReservation(Hospital hos, Scanner sc, User u) throws CloneNotSupportedException{
            ArrayList<Reservation> r;
            r = u.getReservations();
            if (r != null) {
                System.out.println("These are your existing reservation");
                int count = 1;
                for (Reservation reservation : r) {
                    System.out.println(count + ". " + reservation);
                }

                System.out.println("Enter the Reservation id to be deleted. ");
                int id = sc.nextInt();

                Reservation rn = u.getReservationById(id);
                Location selectedLoc = rn.getLocation();
                selectedLoc.deleteReservationById(id);
                u.deleteReservationById(id);
                System.out.println("Deletion successful");
            }
        } 

        public static void enquireReservation(Hospital hos, Scanner sc, User u) throws CloneNotSupportedException{
            ArrayList<Reservation> r;
            r = u.getReservations();
            if (r != null) {
                System.out.println("These are your existing reservation");
                int count = 1;
                for (Reservation reservation : r) {
                    System.out.println(count + ". " + reservation);
                }
            }
        }
}
