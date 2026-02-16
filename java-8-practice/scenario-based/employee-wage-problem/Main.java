import java.util.*;

interface IEmpWageBuilder {

    void addCompany(String companyName,
                    int wagePerHour,
                    int maxWorkingDays,
                    int maxWorkingHours);

    void computeEmployeeWage();

    int getTotalWage(String companyName);

    ArrayList<Integer> getDailyWages(String companyName);
}

//Company Class
class CompanyEmpWage {

    private String companyName;
    int wagePerHour;
    int maxWorkingDays;
    int maxWorkingHours;
    private int totalMonthlyWage;

    private ArrayList<Integer> dailyWages;

    CompanyEmpWage(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getTotalMonthlyWage() {
        return totalMonthlyWage;
    }

    public void addDailyWage(int dailyWage) {
        dailyWages.add(dailyWage);
        totalMonthlyWage += dailyWage;
    }

    public ArrayList<Integer> getDailyWages() {
        return dailyWages;
    }
}

//Builder Class
class EmpWageBuilder implements IEmpWageBuilder {

    private ArrayList<CompanyEmpWage> companyList;

    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;

    EmpWageBuilder() {
        companyList = new ArrayList<>();
    }

    public void addCompany(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {
        companyList.add(new CompanyEmpWage(
                companyName,
                wagePerHour,
                maxWorkingDays,
                maxWorkingHours));
    }

    public void computeEmployeeWage() {

        for (CompanyEmpWage company : companyList) {

            int totalWorkingDays = 0;
            int totalWorkingHours = 0;

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

                int dailyWage = workingHours * company.wagePerHour;

                company.addDailyWage(dailyWage);
            }

            System.out.println("Company: " + company.getCompanyName());
            System.out.println("Daily Wages: " + company.getDailyWages());
            System.out.println("Total Monthly Wage: INR " +
                    company.getTotalMonthlyWage());
            System.out.println("-------------------------------------");
        }
    }

    public int getTotalWage(String companyName) {

        for (CompanyEmpWage company : companyList) {
            if (company.getCompanyName().equals(companyName)) {
                return company.getTotalMonthlyWage();
            }
        }
        return -1;
    }

    public ArrayList<Integer> getDailyWages(String companyName) {

        for (CompanyEmpWage company : companyList) {
            if (company.getCompanyName().equals(companyName)) {
                return company.getDailyWages();
            }
        }
        return null;
    }
}
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome To Employee Wage Computation Program\n");

        IEmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 110);

        builder.computeEmployeeWage();

        System.out.println("TCS Daily Wages: " +
                builder.getDailyWages("TCS"));

        System.out.println("TCS Total Wage: INR " +
                builder.getTotalWage("TCS"));
    }
}
