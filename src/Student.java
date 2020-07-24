public class Student {
    String firstName;
    String lastName;
    double grade;
    String department;

    public Student(String firstName, String lastName, double grade, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.department = department;

    }
    
    public String toString() {
        return firstName + " " + lastName + " " + grade + " " + department;
    }
    //Setters
    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setGrade(double grade){
        this.grade = grade;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    
    //Getters
    public String getName(){
        return firstName + " " + lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public double getGrade(){
        return this.grade;
    }
    public String getDepartment(){
        return this.department;
    }
}

