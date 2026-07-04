import javax.swing.*;

public class PayrollDashboard {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Payroll Management System");

        JButton addEmployee = new JButton("Add Employee");
        JButton viewEmployees = new JButton("View Employees");
        JButton markAttendance = new JButton("Mark Attendance");
        JButton generatePayroll = new JButton("Generate Payroll");
        JButton viewPayroll = new JButton("View Payroll Report");

        addEmployee.setBounds(120,40,180,40);
        viewEmployees.setBounds(120,90,180,40);
        markAttendance.setBounds(120,140,180,40);
        generatePayroll.setBounds(120,190,180,40);
        viewPayroll.setBounds(120,240,180,40);

        frame.add(addEmployee);
        frame.add(viewEmployees);
        frame.add(markAttendance);
        frame.add(generatePayroll);
        frame.add(viewPayroll);

        frame.setSize(420,360);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // ADD EMPLOYEE
        addEmployee.addActionListener(e -> {

            JTextField name = new JTextField();
            JTextField dept = new JTextField();
            JTextField desig = new JTextField();
            JTextField salary = new JTextField();

            Object[] fields = {
                    "Name:", name,
                    "Department:", dept,
                    "Designation:", desig,
                    "Salary:", salary
            };

            int option = JOptionPane.showConfirmDialog(null, fields, "Add Employee", JOptionPane.OK_CANCEL_OPTION);

            if(option == JOptionPane.OK_OPTION) {

                try {

                    Employee emp = new Employee();

                    emp.name = name.getText();
                    emp.department = dept.getText();
                    emp.designation = desig.getText();
                    emp.basicSalary = Double.parseDouble(salary.getText());

                    EmployeeDAO dao = new EmployeeDAO();
                    dao.addEmployee(emp);

                    JOptionPane.showMessageDialog(frame,"Employee Added");

                } catch(Exception ex) {
                    ex.printStackTrace();
                }

            }

        });


        // VIEW EMPLOYEES
        viewEmployees.addActionListener(e -> {

            try {

                EmployeeDAO dao = new EmployeeDAO();

                dao.viewEmployees();

                JOptionPane.showMessageDialog(frame,
                        "Employee list printed in console");

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        });


        // MARK ATTENDANCE
        markAttendance.addActionListener(e -> {

            String id = JOptionPane.showInputDialog("Enter Employee ID");
            String days = JOptionPane.showInputDialog("Enter Days Present");

            try {

                Attendance att = new Attendance();

                att.empId = Integer.parseInt(id);
                att.daysPresent = Integer.parseInt(days);

                AttendanceDAO dao = new AttendanceDAO();

                dao.addAttendance(att);

                JOptionPane.showMessageDialog(frame,"Attendance Added");

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        });


        // GENERATE PAYROLL
        generatePayroll.addActionListener(e -> {

            String id = JOptionPane.showInputDialog("Enter Employee ID");

            try {

                PayrollDAO dao = new PayrollDAO();

                dao.generatePayroll(Integer.parseInt(id));

                JOptionPane.showMessageDialog(frame,"Payroll Generated");

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        });


        // VIEW PAYROLL REPORT
        viewPayroll.addActionListener(e -> {

            try {

                PayrollDAO dao = new PayrollDAO();

                dao.viewPayrollReport();

                JOptionPane.showMessageDialog(frame,
                        "Payroll report printed in console");

            } catch(Exception ex) {
                ex.printStackTrace();
            }

        });

    }

}