import java.sql.*;

public class AttendanceDAO {

    public void addAttendance(Attendance att) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO attendance(emp_id, days_present) VALUES (?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, att.empId);
            pst.setInt(2, att.daysPresent);

            pst.executeUpdate();

            System.out.println("Attendance Added Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void viewAttendance() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM attendance");

            System.out.println("EmpID | Days Present");

            while(rs.next()) {

                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getInt("days_present")
                );

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}