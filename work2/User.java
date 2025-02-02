package work2;

// User.java
public class User {
    int userID;
    String name;
    String email;

    public User(int userID, String name, String email) {
        this.userID = userID;
        this.name = name;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void checkList() {
        System.out.println("Checking borrowed books for User ID: " + userID);
    }
}