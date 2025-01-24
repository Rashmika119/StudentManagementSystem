package org.example.Operation;

import org.example.OTPHandler.GenerateStudentId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    public String addStudents(String fistname, String lastname, int gradeYear, String courses, int tuitionBalance, Connection conn) throws SQLException {


        String sql="INSERT INTO students (first_name,second_name,grade_year,student_ID,courses,tuition_balance)VALUES(?,?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql)){

            int studentID = GenerateStudentId.generateStudentIdAccordingToYear(gradeYear);

            preparedStatement.setString(1,fistname);
            preparedStatement.setString(2,lastname);
            preparedStatement.setInt(3,gradeYear);
            preparedStatement.setInt(4,studentID);
            preparedStatement.setString(5,courses);
            preparedStatement.setInt(6,tuitionBalance);

            int res=preparedStatement.executeUpdate();

            if(res>0){
                return "Successfully added the student record of student id:"+studentID;
            }else{
                return "Failed to add the student record of student id:"+studentID;
            }
        }
        catch(SQLException e){
            return "Registering student is unsuccessfull! Reason "+e.getMessage();
        }

    }
}
