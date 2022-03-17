package exceptionhandling;

/*
Write a Java program to write 
(a) a student details into a file.
(b) fetch a student details from the file
All the possible exceptions should be handled

*/

public class Student {
    private String name, dept;
    private int registerNo;
    private char gender;

    public Student(String name, String dept, int registerNo, char gender) {
        this.name = name;
        this.dept = dept;
        this.registerNo = registerNo;
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(int registerNo) {
        this.registerNo = registerNo;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + " | " + dept + " | " + registerNo + " | " + gender;
    }
}
