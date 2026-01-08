import java.util.ArrayList;
import java.util.Scanner;

class SocialMediaConnection {

    // User class representing each user node in singly linked list
    private class User {
        int userID;
        String name;
        int age;
        ArrayList<Integer> friends; // List of friend IDs
        User next;

        User(int userID, String name, int age) {
            this.userID = userID;
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
            this.next = null;
        }
    }

    private User head; // Head of the linked list
    private int userCount = 0; // Auto-increment ID

    // Add a new user
    public void addUser(String name, int age) {
        User newUser = new User(++userCount, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User added: " + name + " (ID: " + newUser.userID + ")");
    }

    // Find user by ID
    private User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Find user by name
    private User findUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection
    public void addFriend(int user1ID, int user2ID) {
        User u1 = findUserByID(user1ID);
        User u2 = findUserByID(user2ID);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        if (!u1.friends.contains(user2ID)) u1.friends.add(user2ID);
        if (!u2.friends.contains(user1ID)) u2.friends.add(user1ID);

        System.out.println(u1.name + " and " + u2.name + " are now friends.");
    }

    // Remove a friend connection
    public void removeFriend(int user1ID, int user2ID) {
        User u1 = findUserByID(user1ID);
        User u2 = findUserByID(user2ID);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        u1.friends.remove(Integer.valueOf(user2ID));
        u2.friends.remove(Integer.valueOf(user1ID));

        System.out.println("Friend connection removed between " + u1.name + " and " + u2.name);
    }

    // Display all friends of a user
    public void displayFriends(int userID) {
        User u = findUserByID(userID);
        if (u == null) {
            System.out.println("User not found!");
            return;
        }

        if (u.friends.isEmpty()) {
            System.out.println(u.name + " has no friends.");
            return;
        }

        System.out.print(u.name + "'s friends: ");
        for (int friendID : u.friends) {
            User f = findUserByID(friendID);
            if (f != null) System.out.print(f.name + " ");
        }
        System.out.println();
    }

    // Find mutual friends between two users
    public void mutualFriends(int user1ID, int user2ID) {
        User u1 = findUserByID(user1ID);
        User u2 = findUserByID(user2ID);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        ArrayList<Integer> mutual = new ArrayList<>();
        for (int f1 : u1.friends) {
            if (u2.friends.contains(f1)) mutual.add(f1);
        }

        if (mutual.isEmpty()) {
            System.out.println(u1.name + " and " + u2.name + " have no mutual friends.");
        } else {
            System.out.print("Mutual friends of " + u1.name + " and " + u2.name + ": ");
            for (int id : mutual) {
                User f = findUserByID(id);
                if (f != null) System.out.print(f.name + " ");
            }
            System.out.println();
        }
    }

    // Count number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Search user by ID or name
    public void searchUser(String query) {
        User u = null;
        try {
            int id = Integer.parseInt(query);
            u = findUserByID(id);
        } catch (NumberFormatException e) {
            u = findUserByName(query);
        }

        if (u != null) {
            System.out.println("User found: ID=" + u.userID + ", Name=" + u.name + ", Age=" + u.age);
        } else {
            System.out.println("User not found!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMediaConnection sm = new SocialMediaConnection();

        System.out.println("=== Social Media Friend Connection System ===");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend");
            System.out.println("3. Remove Friend");
            System.out.println("4. Display Friends");
            System.out.println("5. Mutual Friends");
            System.out.println("6. Count Friends");
            System.out.println("7. Search User");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sm.addUser(name, age);
                    break;
                case 2:
                    System.out.print("Enter User1 ID: ");
                    int u1 = sc.nextInt();
                    System.out.print("Enter User2 ID: ");
                    int u2 = sc.nextInt();
                    sm.addFriend(u1, u2);
                    break;
                case 3:
                    System.out.print("Enter User1 ID: ");
                    u1 = sc.nextInt();
                    System.out.print("Enter User2 ID: ");
                    u2 = sc.nextInt();
                    sm.removeFriend(u1, u2);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sm.displayFriends(uid);
                    break;
                case 5:
                    System.out.print("Enter User1 ID: ");
                    u1 = sc.nextInt();
                    System.out.print("Enter User2 ID: ");
                    u2 = sc.nextInt();
                    sm.mutualFriends(u1, u2);
                    break;
                case 6:
                    sm.countFriends();
                    break;
                case 7:
                    System.out.print("Enter User ID or Name: ");
                    String query = sc.nextLine();
                    sm.searchUser(query);
                    break;
                case 8:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
