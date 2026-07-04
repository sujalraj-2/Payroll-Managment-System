import java.sql.*;

public class PayrollDAO {

    public void generatePayroll(int empId) {

    try {

        Connection con = DBConnection.getConnection();

        // get basic salary
        String empQuery = "SELECT basic_salary FROM employees WHERE emp_id=?";
        PreparedStatement pst1 = con.prepareStatement(empQuery);
        pst1.setInt(1, empId);

        ResultSet rs1 = pst1.executeQuery();

        if(rs1.next()) {

            double basic = rs1.getDouble("basic_salary");

            // get latest attendance (IMPORTANT FIX)
            String attQuery = "SELECT days_present FROM attendance WHERE emp_id=? ORDER BY id DESC LIMIT 1";

            PreparedStatement pst2 = con.prepareStatement(attQuery);
            pst2.setInt(1, empId);

            ResultSet rs2 = pst2.executeQuery();

            if(rs2.next()) {

                int days = rs2.getInt("days_present");

                double perDay = basic / 30;
                double salaryDays = perDay * days;

                double hra = basic * 0.20;
                double da = basic * 0.10;
                double deduction = basic * 0.05;

                double netSalary = salaryDays + hra + da - deduction;

                // check if payroll already exists
                String checkQuery = "SELECT * FROM payroll WHERE emp_id=?";
                PreparedStatement pst3 = con.prepareStatement(checkQuery);
                pst3.setInt(1, empId);

                ResultSet rs3 = pst3.executeQuery();

                if(rs3.next()) {

                    // UPDATE instead of insert
                    String update = "UPDATE payroll SET basic_salary=?, hra=?, da=?, deductions=?, net_salary=? WHERE emp_id=?";

                    PreparedStatement pst4 = con.prepareStatement(update);

                    pst4.setDouble(1, basic);
                    pst4.setDouble(2, hra);
                    pst4.setDouble(3, da);
                    pst4.setDouble(4, deduction);
                    pst4.setDouble(5, netSalary);
                    pst4.setInt(6, empId);

                    pst4.executeUpdate();

                    System.out.println("Payroll Updated (No Duplicate)");

                } else {

                    // INSERT
                    String insert = "INSERT INTO payroll(emp_id,basic_salary,hra,da,deductions,net_salary) VALUES(?,?,?,?,?,?)";

                    PreparedStatement pst5 = con.prepareStatement(insert);

                    pst5.setInt(1, empId);
                    pst5.setDouble(2, basic);
                    pst5.setDouble(3, hra);
                    pst5.setDouble(4, da);
                    pst5.setDouble(5, deduction);
                    pst5.setDouble(6, netSalary);

                    pst5.executeUpdate();

                    System.out.println("Payroll Inserted");

                }

            } else {
                System.out.println("No attendance found!");
            }

        }

    } catch(Exception e) {
        e.printStackTrace();
    }
}


    public void viewPayrollReport() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "SELECT e.emp_id, e.name, p.basic_salary, p.hra, p.da, p.deductions, p.net_salary " +
            "FROM employees e JOIN payroll p ON e.emp_id = p.emp_id";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("ID | Name | Basic | HRA | DA | Deduction | Net Salary");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("basic_salary") + " | " +
                        rs.getDouble("hra") + " | " +
                        rs.getDouble("da") + " | " +
                        rs.getDouble("deductions") + " | " +
                        rs.getDouble("net_salary")
                );

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}