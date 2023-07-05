package Workshop.WS4;

public class Student {
    private String name;
    private String studentId;
    private String birthDate;
    private String address;
    private String major;
    private double gpa;

    public Student(String name, String studentId, String birthDate, String address, String major, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.birthDate = birthDate;
        this.address = address;
        this.major = major;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void printAllAttributes() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Student Id: " + this.studentId);
        System.out.println("Student Birthdate: " + this.birthDate);
        System.out.println("Student Address: " + this.address);
        System.out.println("Student Major: " + this.major);
        System.out.println("Student GPA: " + this.gpa);
    }
}
