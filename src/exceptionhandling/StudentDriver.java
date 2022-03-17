package exceptionhandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*

Write a Java program to write (a) a student details into a file.
(b) fetch a student details from the file
All the possible exceptions should be handled

*/
public class StudentDriver {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void printMenu(){
        for(int i = 0; i < 40; i++)
            System.out.print("-");
        System.out.println();
        System.out.println("1. Add student");
        System.out.println("2. Print student details");
        System.out.println("3. Exit\n");
        
    }
    
    public static void main(String[] args) {
        while(true){
            printMenu();
            int option = getOption();
            String fileName = "studentDetails.txt";
            switch(option){
                case 1:
                    addStudentToFile(fileName, getStudentDetails());
                    break;
                case 2:
                    fetchDetailsFromFile(fileName);
                    break;
                case 3:
                    System.out.println("Bye!");
            }
            if(option == 3)
                break;
        }
        
    }
    
    
    public static Student getStudentDetails() {
        StudentBuilder sb = new StudentBuilder();
        while(true){
            try{
                System.out.print("Enter student name: ");
                sb.setName(sc.nextLine());
                break;
            }catch(InvalidNameException e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                System.out.print("Enter department: ");
                sb.setDept(sc.nextLine());
                break;
            }catch(InvalidDeptException e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                System.out.print("Enter Reg number: ");
                sb.setRegisterNo(sc.nextLine());
                break;
            }catch(InvalidRegisterNumberException e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                System.out.print("Enter gender: ");
                sb.setGender(sc.nextLine());
                break;
            }catch(InvalidGenderException e){
                System.out.println(e);
            }
        }
        return sb.getStudent();
    }
    
    public static void addStudentToFile(String fileName, Student stud){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            bw.write(stud.toString() + "\n");
            System.out.println(stud.toString() + " added to file");
        }catch(IOException e){
            System.out.println(e);
        }finally{
            try {
                bw.close();
            } catch (IOException e) {}
            catch(Exception e){}
        }
    }
    
    public static void fetchDetailsFromFile(String fileName){
        System.out.println("\nDetails in the given file: \n");
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null)
                System.out.println(line);
        }catch(IOException e){
            System.out.println(e);
        }finally{
            try{
                br.close();
            }catch(IOException e){
            }catch(Exception e){}
        }
    }

    public static int getOption(){
        while(true){
            try{
                System.out.print("Enter option: ");
                int op = Integer.parseInt(sc.nextLine());
                if(op > 3)
                    throw new InputMismatchException("Option must be 1 or 2 or 3");
                return op;
            }catch(NumberFormatException | InputMismatchException e){
                System.out.println(e);
            }
        }
    }
}
