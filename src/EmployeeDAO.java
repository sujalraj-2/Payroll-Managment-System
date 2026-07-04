import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO employees(name,department,designation,basic_salary) VALUES(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, emp.name);
            pst.setString(2, emp.department);
            pst.setString(3, emp.designation);
            pst.setDouble(4, emp.basicSalary);

            pst.executeUpdate();

            System.out.println("Employee Added Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void viewEmployees() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            System.out.println("ID | Name | Department | Designation | Salary");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("department") + " | " +
                        rs.getString("designation") + " | " +
                        rs.getDouble("basic_salary")
                );

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void updateEmployee(Employee emp) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "UPDATE employees SET name=?,department=?,designation=?,basic_salary=? WHERE emp_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, emp.name);
            pst.setString(2, emp.department);
            pst.setString(3, emp.designation);
            pst.setDouble(4, emp.basicSalary);
            pst.setInt(5, emp.empId);

            pst.executeUpdate();

            System.out.println("Employee Updated Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteEmployee(int empId) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM employees WHERE emp_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, empId);

            pst.executeUpdate();

            System.out.println("Employee Deleted Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    // NEW METHOD FOR GUI
    public ArrayList<Employee> getEmployees(){

        ArrayList<Employee> list = new ArrayList<>();

        try{

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employees";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){

                Employee emp = new Employee();

                emp.empId = rs.getInt("emp_id");
                emp.name = rs.getString("name");
                emp.department = rs.getString("department");
                emp.designation = rs.getString("designation");
                emp.basicSalary = rs.getDouble("basic_salary");

                list.add(emp);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

}