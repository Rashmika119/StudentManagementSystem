package org.example.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrieve {
    public String viewStudents(String id, Connection conn) {
        String sql="select * from students where student_id=?";
        StringBuilder result=new StringBuilder();
        try(PreparedStatement preparedStatement=conn.prepareStatement(sql)){
            preparedStatement.setString(1, id);
            ResultSet res=preparedStatement.executeQuery();
            if(res.next()){
                String first_name=res.getString("first_name");
                String last_name=res.getString("last_ anme");
                int gradeYear=res.getInt("grade_year");
                int student_id=res.getInt("student_id");
                String courses=res.getString("course");
                int tuition_balance=res.getInt("tuition_balance");
                 return String.format("student ID: %d\nStudent First name: %s\nLast_name: %s\nGrade Year: %d\nCourses: %s\nTuition Balance: %d",student_id,first_name,last_name,gradeYear,courses,tuition_balance);
            }
            else{
                return "Employee records are empty";
            }
        }catch(SQLException e){
            return "Retrieving employee is unsuccessful! Reason: "+e.getMessage();

        }
    }

}
