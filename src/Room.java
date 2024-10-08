public class Room {
    int roomNo;
    String roomType;
    boolean isAvailable;
    double price;

    Room(int roomNo, String roomType, Boolean isAvailable, double price) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    void displayRoomDetails(){
        System.out.println("Room No: " + roomNo);
        System.out.println("Room Type: " + roomType);
        System.out.println("Available: " + isAvailable);
        System.out.println("Price: " + price);
    }
}
