public class EmployeeBonus{
    // Method to generate salary and years of service
    public static double[][] GenerateEmployeeData(int Employees) {
        double[][] Data = new double[Employees][2];

        for (int i = 0; i < Employees; i++) {
            // Generate 5-digit salary (10000 to 99999)
            Data[i][0] = 10000 + Math.random() * 90000;

            // Generate years of service (1 to 10)
            Data[i][1] = 1 + Math.random() * 10;
        }
        return Data;
    }

    // Method to calculate new salary and bonus
    public static double[][] CalculateBonus(double[][] EmployeeData) {
        int Employees = EmployeeData.length;
        double[][] Result = new double[Employees][3];

        for (int i = 0; i < Employees; i++) {
            double OldSalary = EmployeeData[i][0];
            double Years = EmployeeData[i][1];
            double Bonus;

            if (Years > 5) {
                Bonus = OldSalary * 0.05;
            } else {
                Bonus = OldSalary * 0.02;
            }

            double NewSalary = OldSalary + Bonus;

            Result[i][0] = OldSalary;
            Result[i][1] = Bonus;
            Result[i][2] = NewSalary;
        }
        return Result;
    }

    // Method to calculate totals and display result
    public static void DisplaySummary(double[][] SalaryData) {
        double TotalOldSalary = 0.0;
        double TotalBonus = 0.0;
        double TotalNewSalary = 0.0;

        System.out.println("Employee\tOld Salary\tBonus\t\tNew Salary");

        for (int i = 0; i < SalaryData.length; i++) {
            System.out.printf("%d\t\t%.2f\t%.2f\t%.2f\n",
                    i + 1,
                    SalaryData[i][0],
                    SalaryData[i][1],
                    SalaryData[i][2]);

            TotalOldSalary += SalaryData[i][0];
            TotalBonus += SalaryData[i][1];
            TotalNewSalary += SalaryData[i][2];
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL\t\t%.2f\t%.2f\t%.2f\n",
                TotalOldSalary, TotalBonus, TotalNewSalary);
    }

    public static void main(String[] args) {

        int Employees = 10;

        // Step 1: Generate employee salary and service data
        double[][] EmployeeData = GenerateEmployeeData(Employees);

        // Step 2: Calculate bonus and new salary
        double[][] SalaryData = CalculateBonus(EmployeeData);

        // Step 3: Display final summary
        DisplaySummary(SalaryData);
    }
}
