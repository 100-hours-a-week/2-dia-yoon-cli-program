package work2;

// Reservation.java
import java.util.Date;

public class Reservation {
    private int reservationID;
    private int userID;
    private int itemID;
    private Date reservationDate;

    public Reservation(int reservationID, int userID, int itemID, Date reservationDate) {
        this.reservationID = reservationID;
        this.userID = userID;
        this.itemID = itemID;
        this.reservationDate = reservationDate;
    }

    public void checkStatus() {
        System.out.println("Checking reservation status for Book ID: " + itemID);
    }

    public void reserve(int bookID) {
        System.out.println("Book reserved: " + bookID);
    }

    public void cancelReservation(int bookID) {
        System.out.println("Reservation canceled for Book ID: " + bookID);
    }
}