class Reservation {
    Room room;
    String customerName;
    int numberOfNights;
    double totalPrice;

    // Constructor for reservation
    Reservation(Room room, String customerName, int numberOfNights) {
        this.room = room;
        this.customerName = customerName;
        this.numberOfNights = numberOfNights;
        this.totalPrice = room.price * numberOfNights;
        room.isAvailable = false; // Mark the room as booked
    }

    // Display reservation details
    public void displayBookingDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Room Number: " + room.roomNo);
        System.out.println("Room Type: " + room.roomType);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Total Price: $" + totalPrice);
    }
}