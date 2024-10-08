import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the hotel rooms
        rooms.add(new Room(101, "Single",true,1000));
        rooms.add(new Room(102, "Double", true, 1500));
        rooms.add(new Room(103, "Suite", true, 2500));
        rooms.add(new Room(104, "Single", true, 1500));
        rooms.add(new Room(105, "Double", true, 3000));

        while (true) {
            System.out.println("\n*** Hotel Reservation System ***");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Search for available rooms
    public static void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                room.displayRoomDetails();
                System.out.println("------------------------");
            }
        }
    }

    // Make a reservation
    public static void makeReservation() {
        System.out.print("\nEnter room number to book: ");
        int roomNumber = scanner.nextInt();
        Room selectedRoom = null;

        // Search for the selected room
        for (Room room : rooms) {
            if (room.roomNo == roomNumber && room.isAvailable) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            scanner.nextLine(); // Clear the newline buffer
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter number of nights: ");
            int numberOfNights = scanner.nextInt();

            // Simulated payment process
            System.out.println("Processing payment for $" + (selectedRoom.price * numberOfNights));
            System.out.println("Payment successful!");

            // Create a reservation
            Reservation newReservation = new Reservation(selectedRoom, customerName, numberOfNights);
            reservations.add(newReservation);
            System.out.println("Reservation successful!");

        } else {
            System.out.println("Room is either unavailable or does not exist.");
        }
    }

    // View booking details
    public static void viewBookingDetails() {
        System.out.print("\nEnter customer name to view booking details: ");
        scanner.nextLine(); // Clear the newline buffer
        String customerName = scanner.nextLine();

        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.customerName.equalsIgnoreCase(customerName)) {
                reservation.displayBookingDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No reservation found for " + customerName);
        }
    }
}
