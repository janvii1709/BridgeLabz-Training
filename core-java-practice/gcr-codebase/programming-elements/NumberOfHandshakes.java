import java.util.*;
class NumberOfHandshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int NumberOfStudents = sc.nextInt();
        int NumberOfhandshakes = (NumberOfStudents * (NumberOfStudents - 1)) / 2;
        System.out.println("The number of handshakes is " + NumberOfhandshakes + " for " + NumberOfStudents + " students" );
    }
    
}
