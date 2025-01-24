package org.example.OTPHandler;

import java.util.Random;

public class GenerateStudentId {



    public static int generateStudentID(int start, int end){
        if(start>end){
            throw new IllegalArgumentException("start cannot be greater than the end");

        }else{
            Random random=new Random();
            return random.nextInt(end-start+1)+start;

        }
    }

    public static int generateStudentIdAccordingToYear(int gradeYear){
        int start=100;
        int end=900;
        int stdIdAfterConsiderYear = 0;
        if(gradeYear==1){
            int stdIdBeforeConsiderYear=generateStudentID(start,end);
            stdIdAfterConsiderYear=1000+stdIdBeforeConsiderYear;

        }
        else if(gradeYear==2){
            int stdIdBeforeConsiderYear=generateStudentID(start,end);
            stdIdAfterConsiderYear=2000+stdIdBeforeConsiderYear;

        }
        else if(gradeYear==3){
            int stdIdBeforeConsiderYear=generateStudentID(start,end);
            stdIdAfterConsiderYear=3000+stdIdBeforeConsiderYear;

        }
        else if(gradeYear==4){
            int stdIdBeforeConsiderYear=generateStudentID(start,end);
            stdIdAfterConsiderYear=4000+stdIdBeforeConsiderYear;
        }
        return stdIdAfterConsiderYear;
    }

}
