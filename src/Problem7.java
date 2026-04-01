class InvalidSalaryException extends Exception{
    InvalidSalaryException(String message){
        super(message);
    }
}
abstract class Employee{
    String name;
    String id;
    abstract double calculateMonthlySalary() throws InvalidSalaryException;
    double printPaySlip(){
        try {
            double result = calculateMonthlySalary();
            System.out.println("Monthly Salary: "+result);
            return result;
        } catch (InvalidSalaryException e) {
            System.out.println("error: "+e.getMessage());
            return 0;
        }
    }
}

class FullTimeEmployee extends Employee{
    double annualSalary;

    FullTimeEmployee(double annualSalary){
        super();
        this.annualSalary = annualSalary;
    }

    @Override
    double calculateMonthlySalary() throws InvalidSalaryException {
        if(annualSalary<=0)throw new InvalidSalaryException("Annual salary is not positive.");
        return annualSalary/12d;
    }
}

class PartTimeEmployee extends Employee{
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(double hourlyRate, int hoursWorked){
        super();
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateMonthlySalary() throws InvalidSalaryException {
        if(this.hoursWorked<= 0) throw new InvalidSalaryException("Hours worked is not positive.");
        if(this.hourlyRate<= 0) throw new InvalidSalaryException("Hourly Rate is not positive.");
        return hourlyRate*hoursWorked;
    }
}

class CommissionEmployee extends Employee{
    double baseSalary;
    double salesAmount;
    double commissionRate;

    CommissionEmployee(double baseSalary, double salesAmount, double commissionRate){
        this.baseSalary = baseSalary;
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }
    @Override
    double calculateMonthlySalary() throws InvalidSalaryException {
        if(commissionRate<0 || commissionRate>1) throw new InvalidSalaryException("Invalid Commission Rate");
        return 0;
    }
}