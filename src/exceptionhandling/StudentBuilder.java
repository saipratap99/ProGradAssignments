package exceptionhandling;

public class StudentBuilder {
    private String name, dept;
    private int registerNo;
    private char gender;

    public StudentBuilder setName(String name) throws InvalidNameException{
        if(!name.matches("[a-zA-Z]+[ ]{0,1}[a-zA-Z]*"))
            throw new InvalidNameException("Invalid Name. Name must contain alphabets and spaces only");
        
        this.name = name;
        return this;
    }
    
    public StudentBuilder setDept(String dept) throws InvalidDeptException{
        if(!dept.equalsIgnoreCase("CSE") && !dept.equalsIgnoreCase("ECE")
            && !dept.equalsIgnoreCase("EEE") && !dept.equalsIgnoreCase("MECH"))
            throw new InvalidDeptException("Invalid dept name. Dept must be any one out of these [CSE, ECE, EEE, MECH]");
        
        this.dept = dept.toUpperCase();
        return this;
    }

    public StudentBuilder setRegisterNo(String registerNo) throws InvalidRegisterNumberException{
        if(!registerNo.matches("[3-6]{1}[0-9]{3}"))
            throw new InvalidRegisterNumberException("Invalid reg no. It must start with 3-6 and length must be 4");
        
        this.registerNo = Integer.parseInt(registerNo);
        return this;
    }

    public StudentBuilder setGender(String gender) throws InvalidGenderException{
        if(!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"))
            throw new InvalidGenderException("Invalid Gender. Gender must be M or F");
        
        this.gender = gender.toUpperCase().charAt(0);
        return this;
    }
    
    public Student getStudent(){
        return new Student(name, dept, registerNo, gender);
    }
    
}
