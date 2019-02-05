package servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public abstract class AbstractServlet extends HttpServlet {
    protected static final String url = "jdbc:mysql://localhost:3306/departaments";
    protected static final String user = "root";
    protected static final String password = "1234";
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;



    DataSource ds;
    HttpSession session;
    String clickedButton;




}
