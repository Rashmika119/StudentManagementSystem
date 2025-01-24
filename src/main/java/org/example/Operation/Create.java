package org.example.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    public String addStudents(String fistname, String lastname, String address, int gradeYear, int studentID, String courses, int tuitionBalance, Connection conn) throws SQLException {
        String sql="INSERT INTO students (first_name,second_name,address,grade_year,student_ID,courses,tuition_balance)VALUES(?,?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql)){
            preparedStatement.setString(1,fistname);
            preparedStatement.setString(2,lastname);
            preparedStatement.setString(3,address);
            preparedStatement.setInt(4,gradeYear);
            preparedStatement.setInt(5,studentID);
            preparedStatement.setString(6,courses);
            preparedStatement.setInt(7,tuitionBalance);
            int res=preparedStatement.executeUpdate();
            preparedStatement.executeUpdate();

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
