package ManagementProgram;

public class Employee {
    private String employeeID;
    private String name;
    private String birthdate;
    private String role;
    private String sex;
    private String passwaord;

    public Employee(String employeeID, String name, String birthdate, String role, String sex, String passwaord) {
        this.employeeID = employeeID;
        this.name = name;
        this.birthdate = birthdate;
        this.role = role;
        this.sex = sex;
        this.passwaord = passwaord;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPasswaord() {
        return passwaord;
    }

    public void setPasswaord(String passwaord) {
        this.passwaord = passwaord;
    }

    public void display() {
        System.out.println(this.employeeID + "\t" + this.name + "\t" + this.birthdate + "\t" +
                this.role + "\t" + this.sex);
    }
}
