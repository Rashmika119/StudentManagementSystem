package org.example.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public String updateEmployee(String StudentID, String attribute,Object value,Connection conn){
        String sql="UPDATE employee SET"+attribute+"=? WHERE StudentID=?";
        try(PreparedStatement preparedStatement=conn.prepareStatement(sql)){
            if(!attribute.equals("firstName") || attribute.equals("lasName") || attribute.equals("courses")){

                preparedStatement.setString(1,value.toString());
            }if(attribute.equals("gradeYear") || attribute.equals("tuitionBalance")){
                preparedStatement.setInt(1,Integer.parseInt(value.toString()));
            }
            preparedStatement.setString(2,StudentID);
            int res=preparedStatement.executeUpdate();

            if(res>0){
                return "Updated the students record of ID: "+StudentID+" Successfully!";
            }else{
                return "Update failed to the student number: "+StudentID;
            }
        }catch(SQLException e){
            return "Can't update the students record!"+e.getMessage();
        }
    }
}
