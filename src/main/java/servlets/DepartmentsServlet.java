package servlets;

import impl.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Set;

@WebServlet(name = "DepartmentsServlet", value = "/departments")
public class DepartmentsServlet extends AbstractServlet {


    private Set<Department> departments = new LinkedHashSet<>();





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            session = request.getSession();

            String query = "SELECT * FROM departments ORDER BY id";
            try {
                //Подсоединение к MYSQL серверу
                con = DriverManager.getConnection(url, user, password);
                stmt = con.createStatement();
                //Извлекаем данные из БД
                rs = stmt.executeQuery(query);

                departments.clear();
                while (rs.next()) {
                departments.add(new Department(rs.getInt("id"), rs.getString("name")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            finally {
                //close connection ,stmt and resultset here
                try { con.close(); } catch(SQLException se) { /*can't do anything */ }
                try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
                try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
            }


        session.setAttribute("depList", departments);
        request.getRequestDispatcher("/listOfDepartments.jsp").forward(request, response);
    }
}
