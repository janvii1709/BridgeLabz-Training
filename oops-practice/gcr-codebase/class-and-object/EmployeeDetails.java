class EmployeeDetails {
    String Name;
    int Id;
    double Salary;
    void Display() {
        System.out.println("Employee Name: " + Name);
        System.out.println("Employee id: " + Id);
        System.out.println("Employee Salary: " + Salary);
    }
    public static void main(String[] args) {
        EmployeeDetails e = new EmployeeDetails();
        e.Name = "Rohan";
        e.Id = 1;
        e.Salary = 500000;
        e.Display();
    }
}