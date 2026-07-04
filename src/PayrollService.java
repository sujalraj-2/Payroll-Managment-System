public class PayrollService {

    public double calculateNetSalary(double basicSalary) {

        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        double deduction = basicSalary * 0.05;

        return basicSalary + hra + da - deduction;
    }

}