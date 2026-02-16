import java.util.*;

// Interface
interface IEmpWageBuilder {
    void addCompany(String companyName,
                    int wagePerHour,
                    int maxWorkingDays,
                    int maxWorkingHours);

    void computeEmployeeWage();

    int getTotalWage(String companyName);
}

// ===== Company Class =====
class CompanyEmpWage {

    String companyName;
    int wagePerHour;
    int maxWorkingDays;
    int maxWorkingHours;
    int totalMonthlyWage;

    CompanyEmpWage(String companyName,
                   int wagePerHour,
                   int maxWorkingDays,
                   int maxWorkingHours) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.totalMonthlyWage = 0;
    }

    void setTotalMonthlyWage(int totalMonthlyWage) {
        this.totalMonthlyWage = totalMonthlyWage;
    }
}

// ===== Builder Class Implementing Interface =====
class EmpWageBuilder implements IEmpWageBuilder {

    private ArrayList<CompanyEmpWage> companyList;

    private final int FULL_TIME_HOURS = 8;
    private final int PART_TIME_HOURS = 4;

    EmpWageBuilder() {
        companyList = new ArrayList<>();
    }

    // Add Company
    public void addCompany(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {

        companyList.add(new CompanyEmpWage(
                companyName,
                wagePerHour,
                maxWorkingDays,
                maxWorkingHours));
    }

    // Compute Wage for All Companies
    public void computeEmployeeWage() {

        for (CompanyEmpWage company : companyList) {

            int totalWorkingDays = 0;
            int totalWorkingHours = 0;
            int totalWage = 0;

            Random random = new Random();

            while (totalWorkingDays < company.maxWorkingDays && totalWorkingHours < company.maxWorkingHours) {

                totalWorkingDays++;

                int empCheck = random.nextInt(3);
                int workingHours = 0;

                switch (empCheck) {
                    case 1:
                        workingHours = PART_TIME_HOURS;
                        break;
                    case 2:
                        workingHours = FULL_TIME_HOURS;
                        break;
                    default:
                        workingHours = 0;
                }

                totalWorkingHours += workingHours;
                totalWage += workingHours * company.wagePerHour;
            }

            company.setTotalMonthlyWage(totalWage);

            System.out.println("Company: " + company.companyName);
            System.out.println("Total Monthly Wage: INR " + totalWage);
            System.out.println("------------------------------------");
        }
    }

    // Get Wage by Company Name
    public int getTotalWage(String companyName) {

        for (CompanyEmpWage company : companyList) {
            if (company.companyName.equals(companyName)) {
                return company.totalMonthlyWage;
            }
        }
        return -1;
    }
}
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome To Employee Wage Computation Program\n");

        IEmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 110);
        builder.addCompany("Wipro", 18, 20, 90);

        builder.computeEmployeeWage();

        System.out.println("TCS Total Wage: INR " +
                builder.getTotalWage("TCS"));
    }
}
