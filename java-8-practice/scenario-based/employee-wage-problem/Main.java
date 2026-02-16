import java.util.*;
//Interface
interface IEmpWageBuilder {
    void addCompany(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours);
    void computeEmployeeWage();
    int getTotalWage(String companyName);
    ArrayList<Integer> getDailyWages(String companyName);
}

// Company Class
class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private int totalMonthlyWage;
    private ArrayList<Integer> dailyWages;

    CompanyEmpWage(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>();
        this.totalMonthlyWage = 0;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getMaxWorkingDays() {
        return maxWorkingDays;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    public int getTotalMonthlyWage() {
        return totalMonthlyWage;
    }

    public ArrayList<Integer> getDailyWages() {
        return dailyWages;
    }

    public void addDailyWage(int dailyWage) {
        dailyWages.add(dailyWage);
        totalMonthlyWage += dailyWage;
    }
}

//Builder Class
class EmpWageBuilder implements IEmpWageBuilder {

    private ArrayList<CompanyEmpWage> companyList;
    private HashMap<String, CompanyEmpWage> companyMap;

    private static final int FULL_TIME_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;

    EmpWageBuilder() {
        companyList = new ArrayList<>();
        companyMap = new HashMap<>();
    }

    // Add Company
    public void addCompany(String companyName,int wagePerHour,int maxWorkingDays,int maxWorkingHours) {

        CompanyEmpWage company = new CompanyEmpWage(
                companyName,
                wagePerHour,
                maxWorkingDays,
                maxWorkingHours);

        companyList.add(company);
        companyMap.put(companyName, company);
    }

    // Compute Wage for All Companies
    public void computeEmployeeWage() {

        for (CompanyEmpWage company : companyList) {

            int totalWorkingDays = 0;
            int totalWorkingHours = 0;

            Random random = new Random();

            while (totalWorkingDays < company.getMaxWorkingDays() && totalWorkingHours < company.getMaxWorkingHours()) {

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

                int dailyWage = workingHours * company.getWagePerHour();
                company.addDailyWage(dailyWage);
            }

            System.out.println("Company: " + company.getCompanyName());
            System.out.println("Daily Wages: " + company.getDailyWages());
            System.out.println("Total Monthly Wage: INR "
                    + company.getTotalMonthlyWage());
            System.out.println("---------------------------------------");
        }
    }

    // Get Total Wage by Company Name
    public int getTotalWage(String companyName) {

        CompanyEmpWage company = companyMap.get(companyName);

        if (company != null) {
            return company.getTotalMonthlyWage();
        }

        System.out.println("Company Not Found!");
        return -1;
    }

    // Get Daily Wages by Company Name
    public ArrayList<Integer> getDailyWages(String companyName) {

        CompanyEmpWage company = companyMap.get(companyName);

        if (company != null) {
            return company.getDailyWages();
        }

        System.out.println("Company Not Found!");
        return new ArrayList<>();
    }
}

//Main Class
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome To Employee Wage Computation Program\n");

        IEmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 110);
        builder.addCompany("Wipro", 18, 20, 90);

        builder.computeEmployeeWage();

        System.out.println("\nTCS Daily Wages: "
                + builder.getDailyWages("TCS"));

        System.out.println("TCS Total Wage: INR "
                + builder.getTotalWage("TCS"));
    }
}
