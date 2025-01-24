package org.example;

import org.example.Operation.Create;
import org.example.Operation.Delete;
import org.example.Operation.Retrieve;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        //Ask how many number of students want to add
        //create n number of new students
        int choice=0;

        while(choice==5){

        System.out.println("1.Add a student\n");
        System.out.println("2.Show all students\n");
        System.out.println("3.Delete a student\n");
        System.out.println("4.Update a student\n");
        System.out.println("5.Exit\n");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();

        Connection conn=null;
        switch (choice) {
            case 1:
                Create create = new Create();


                System.out.println("Enter student first name: ");
                String firstName = scanner.next();
                scanner.nextLine();
                System.out.println("Enter student last name: ");
                String lastName = scanner.next();
                System.out.println("Enter student grade Year: ");
                int gradeYear = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter student courses that has selected: ");
                String courses = scanner.next();
                scanner.nextLine();
                System.out.println("Enter student tuition balance: ");
                int tuitionBalance = scanner.nextInt();
                scanner.nextLine();

                create.addStudents(firstName, lastName, gradeYear, courses, tuitionBalance, conn);
                break;


            case 2:
                System.out.println("Enter the student ID that want to see the full Details");
                int studentId = scanner.nextInt();
                scanner.nextLine();

                Retrieve retrieve = new Retrieve();
                retrieve.viewStudents(studentId, conn);
                break;

            case 3:
                System.out.println("Enter the student ID that want to delete from the System");
                int studentIdIn = scanner.nextInt();
                scanner.nextLine();

                Delete delete = new Delete();
                delete.DeleteStudent(studentIdIn, conn);
                break;

            case 4:
                System.out.println("Enter the attribute you want to update: ");
                String attribute = scanner.next();
                scanner.nextLine();
                System.out.println("Enter the value of the attribute you want to update: ");
                Object value = scanner.next();
                scanner.nextLine();


        }
        }
    }
}