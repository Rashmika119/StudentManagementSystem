package org.example.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public String DeleteStudent(String StudentID, Connection conn){
        String sql="DELETE FROM students WHERE student_id=?";
        try(PreparedStatement preparedStatement=conn.prepareStatement(sql)){
            preparedStatement.setInt(1, Integer.parseInt(StudentID));
            int rows=preparedStatement.executeUpdate();
            if(rows>0){
                return "Successfully deleted the record of student with the employee ID: "+StudentID;
            }else{
                return "Failed to delete the record of student with the employee ID: "+StudentID;
            }
        } catch (SQLException e) {
            return"Deleting student with the ID: "+StudentID+" is unsuccessful";
        }
    }
}
