package com.model;

public class Admin {
    private String studentName;
    private String studentGroup;
    private String studentSection;
    private String studentPhoneNumber;
    private String fatherName;
    private String motherName;
    private String parentPhoneNumber;
    private String username;
    private String password;
    private String email;

    // Constructors
    public Admin() {
    }

    public Admin(String studentName, String studentGroup, String studentSection, String studentPhoneNumber,
                   String fatherName, String motherName, String parentPhoneNumber, String username, String password,
                   String email) {
        this.studentName = studentName;
        this.studentGroup = studentGroup;
        this.studentSection = studentSection;
        this.studentPhoneNumber = studentPhoneNumber;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.parentPhoneNumber = parentPhoneNumber;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters and setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(String studentSection) {
        this.studentSection = studentSection;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                ", studentSection='" + studentSection + '\'' +
                ", studentPhoneNumber='" + studentPhoneNumber + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", parentPhoneNumber='" + parentPhoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
