import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        PayrollDAO payrollDAO = new PayrollDAO();

        while(true) {

            System.out.println("\n---- Payroll Management System ----");
            System.out.println("1 Add Employee");
            System.out.println("2 View Employees");
            System.out.println("3 Update Employee");
            System.out.println("4 Delete Employee");
            System.out.println("5 Mark Attendance");
            System.out.println("6 View Attendance");
            System.out.println("7 Generate Payroll");
            System.out.println("8 View Payroll Report");
            System.out.println("9 Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {

                Employee emp = new Employee();

                System.out.print("Enter Name: ");
                emp.name = sc.nextLine();

                System.out.print("Enter Department: ");
                emp.department = sc.nextLine();

                System.out.print("Enter Designation: ");
                emp.designation = sc.nextLine();

                System.out.print("Enter Salary: ");
                emp.basicSalary = sc.nextDouble();

                dao.addEmployee(emp);

            }

            else if(choice == 2) {

                dao.viewEmployees();

            }

            else if(choice == 3) {

                Employee emp = new Employee();

                System.out.print("Enter Employee ID: ");
                emp.empId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Name: ");
                emp.name = sc.nextLine();

                System.out.print("Enter Department: ");
                emp.department = sc.nextLine();

                System.out.print("Enter Designation: ");
                emp.designation = sc.nextLine();

                System.out.print("Enter Salary: ");
                emp.basicSalary = sc.nextDouble();

                dao.updateEmployee(emp);

            }

            else if(choice == 4) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                dao.deleteEmployee(id);

            }

            else if(choice == 5) {

                Attendance att = new Attendance();

                System.out.print("Enter Employee ID: ");
                att.empId = sc.nextInt();

                System.out.print("Enter Days Present: ");
                att.daysPresent = sc.nextInt();

                attendanceDAO.addAttendance(att);

            }

            else if(choice == 6) {

                attendanceDAO.viewAttendance();

            }

            else if(choice == 7) {

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                payrollDAO.generatePayroll(id);

            }

            else if(choice == 8) {

                payrollDAO.viewPayrollReport();

            }

            else if(choice == 9) {

                System.out.println("Exiting...");
                sc.close();
                break;

            }

        }

    }

}