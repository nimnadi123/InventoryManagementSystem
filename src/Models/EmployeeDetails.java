/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author user
 */
public class EmployeeDetails {
     private String  employeeId;
     private String employeeName;
     private String Department;
     private String mailAddress;
     private String userName;
     private String passWord;
     private String position;
     private String personalAddress;
     private int telephoneNo;
     private String nic;
     private String gender;
     private int age;
     private Date dateOfBirth;
     private Date hiredDate;
     

    public EmployeeDetails() {
    }

    public EmployeeDetails(String  employeeId,String employeeName,String userName,String Department,String mailAddress, String passWord,String position
    ,String personalAddress, int telephoneNo, String nic,String gender,int age, Date hiredDate,Date dateOfBirth ) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.userName = userName;
        this.Department = Department;
        this.mailAddress = mailAddress;
        this.employeeName = employeeName;
        this.passWord = passWord;
        this.position = position;
        this.personalAddress = personalAddress;
        this.telephoneNo = telephoneNo;
        this.nic = nic;
        this.gender = gender;
        this.age = age;
        this.hiredDate = hiredDate;
         this.dateOfBirth = dateOfBirth;
        
    }
    /**
     * @return the employeeId   
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the userName to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    /**
     * @return the employeeId   
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the userName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    /**
     * @return the mailAddress   
     */
    public String getmailAddress() {
        return mailAddress;
    }

    /**
     * @param mailAddress the mailAddress to set
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    
    /**
     * @return the Department   
     */
    public String getDepartment() {
        return Department;
    }

    /**
     * @param Department the Department to set
     */
    public void setDepartment(String Department) {
        this.Department = Department;
    }
    
   /**
     * @return the position   
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the userName to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
    
    /**
     * @return the personalAddress   
     */
    public String getPersonalAddress() {
        return personalAddress;
    }

    /**
     * @param personalAddress the userName to set
     */
    public void setPersonalAddress(String personalAddress) {
        this.personalAddress = personalAddress;
    }
    /**
     * @return the mailAddress   
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the mailAddress to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    /**
     * @return the nic   
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }
     /**
     * @return the age   
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    
     /**
     * @return the hiredDate   
     */
    public Date getHiredDate() {
        return hiredDate;
    }

    /**
     * @param hiredDate the hiredDate to set
     */
    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }
    
     /**
     * @return the dateOfBirth   
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the hiredDate to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassWord(){
        return passWord;
    }
    
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    
    public int getTelephoneNo(){   
      return telephoneNo;
    }
    
    public void setTelephoneNo(int TelphoneNo){
        this.telephoneNo = TelphoneNo;
    }
}

