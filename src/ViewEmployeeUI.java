import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ViewEmployeeUI {

    public ViewEmployeeUI(){

        JFrame frame = new JFrame("Employee List");

        String[] columns = {"ID","Name","Department","Designation","Salary"};
        DefaultTableModel model = new DefaultTableModel(columns,0);

        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        frame.add(pane);
        frame.setSize(600,400);
        frame.setVisible(true);

        EmployeeDAO dao = new EmployeeDAO();
        ArrayList<Employee> list = dao.getEmployees();

        for(Employee emp : list){

            Object[] row = {
                    emp.empId,
                    emp.name,
                    emp.department,
                    emp.designation,
                    emp.basicSalary
            };

            model.addRow(row);
        }

    }
}