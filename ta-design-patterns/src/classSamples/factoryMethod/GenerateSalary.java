package classSamples.factoryMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateSalary {

    public static void main(String[] args) throws IOException {
        GenerateSalaryFactory generateSalaryFactory = new GenerateSalaryFactory();
        System.out.println("Enter type of employee:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String employeeType = br.readLine();
        Salary s = generateSalaryFactory.getEmployeeType(employeeType);
        s.setDailyRate();

        System.out.println("Enter number of days for salary:");
        int days = Integer.parseInt(br.readLine());
        double employeeSalary = s.calculateMonthlySalary(days);
        System.out.println("Employee Salary is: "+ employeeSalary);
    }
}

class GenerateSalaryFactory {
    public Salary getEmployeeType(String employeeType) {
        if ( employeeType == null) {
            return null;
        } else if (employeeType.equalsIgnoreCase("Employee")) {
            return new EmployeeSalary();
        } else if (employeeType.equalsIgnoreCase("LEAD")) {
            return new LeadSalary();
        } else if (employeeType.equalsIgnoreCase("MANAGER")) {
            return new ManagerSalary();
        } else {
            return null;
        }
    }
}


abstract class Salary {
    protected double dailyRate;
    protected abstract void setDailyRate();

    public double calculateMonthlySalary(int days) {
        return days * dailyRate;
    }
}

class EmployeeSalary extends Salary {
    @Override
    protected void setDailyRate() {
        dailyRate = 300.0d;
    }
}

class LeadSalary extends Salary {
    @Override
    protected void setDailyRate() {
        dailyRate = 500.0d;
    }
}

class ManagerSalary extends Salary {
    @Override
    protected void setDailyRate() {
        dailyRate = 700.0d;
    }
}