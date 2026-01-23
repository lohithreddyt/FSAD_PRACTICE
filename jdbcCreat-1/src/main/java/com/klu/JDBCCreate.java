package com.klu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCreate {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/lohith";
    String usr = "root";
    String pwd = "lohithreddy@891";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      Connection con = DriverManager.getConnection(url,usr,pwd);
      System.out.println("CONNECTION ESTABLISHED");
      String Createdep1 = "create table if not exists DEP1("+" dept_id INT PRIMARY KEY,"+" name VARCHAR(10)"+")";
      Statement st= con.createStatement();

      st.execute(Createdep1);
      System.out.println("Dept tables created.");
      
      String CreateEmp = "create table if not exists EMP("+" emp_id INT PRIMARY KEY," + "emp_name VARCHAR(50)," +"salary DOUBLE, "+"dept_id INT, "+"FOREIGN KEY(dep_id) REFERENCES dept1(dept_id))";
      st.execute(CreateEmp);
      System.out.println("EMP TABLES IS CREATED");
      String insertDeps = "INSERT INTO DEP1 (dept_id, name) VALUES (1, 'HR'), (2, 'Finance'), (3, 'Engineering') ON DUPLICATE KEY UPDATE name = VALUES(name)";
            st.executeUpdate(insertDeps);
            String insertEmps = "INSERT INTO EMP (emp_id, emp_name, salary, dept_id) VALUES (101, 'Alice', 55000.0, 1), (102, 'Bob', 72000.5, 3), (103, 'Charlie', 48000.0, 2) ON DUPLICATE KEY UPDATE emp_name = VALUES(emp_name), salary = VALUES(salary), dept_id = VALUES(dept_id)";
            st.executeUpdate(insertEmps);
            con.close();
    }catch(Exception e) {
      
    }
  }
  

}