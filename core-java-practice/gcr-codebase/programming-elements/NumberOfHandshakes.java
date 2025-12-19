import java.util.*;
class NumberOfHandshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// input scanner
        int NumberOfStudents = sc.nextInt();// taking number of students as input
        int NumberOfhandshakes = (NumberOfStudents * (NumberOfStudents - 1)) / 2;// calculating number of handshakes
        System.out.println("The number of handshakes is " + NumberOfhandshakes + " for " + NumberOfStudents + " students" );
    }
    
}
