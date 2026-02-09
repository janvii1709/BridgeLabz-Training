import java.util.*;

// Custom Exception
class InsufficientLeaveBalanceException extends Exception {
    public InsufficientLeaveBalanceException(String msg) {
        super(msg);
    }
}

// Employee Class
class Employee {
    int id;
    String name;
    int leaveBalance;

    Employee(int id, String name, int leaveBalance) {
        this.id = id;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }
}

// Leave Request Class
class LeaveRequest {
    int employeeId;
    int days;
    String status;

    LeaveRequest(int employeeId, int days) {
        this.employeeId = employeeId;
        this.days = days;
        this.status = "PENDING";
    }
}

public class EmployeeLeaveManagementSystem {

    static Map<Integer, Employee> employeeMap = new HashMap<>();
    static List<LeaveRequest> leaveRequests = new ArrayList<>();

    public static void main(String[] args) throws InsufficientLeaveBalanceException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Leave Balance: ");
            int balance = sc.nextInt();

            employeeMap.put(id, new Employee(id, name, balance));
        }

        System.out.print("\nEnter number of leave requests: ");
        int req = sc.nextInt();

        for (int i = 0; i < req; i++) {
            System.out.print("\nEnter Employee ID: ");
            int empId = sc.nextInt();

            System.out.print("Enter Leave Days: ");
            int days = sc.nextInt();

            processLeave(empId, days);
        }

        System.out.println("\n--- Leave Status ---");
        for (LeaveRequest lr : leaveRequests) {
            System.out.println("Employee ID: " + lr.employeeId +
                    " | Days: " + lr.days +
                    " | Status: " + lr.status);
        }
    }

    static void processLeave(int empId, int days) throws InsufficientLeaveBalanceException {
        Employee emp = employeeMap.get(empId);

        if (days > emp.leaveBalance)
            throw new InsufficientLeaveBalanceException("Insufficient leave balance for Employee ID: " + empId);

        emp.leaveBalance -= days;
        LeaveRequest lr = new LeaveRequest(empId, days);
        lr.status = "APPROVED";
        leaveRequests.add(lr);
    }
}
