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
public class CustomerDetails {

    private String customerId; // string, char, int int -number, string- word, char -single letter
    private String customerName;
    private String customerNic;
    private String customerBusinessPlace;
    private String customerRegNo;
    private String customerPersonalAddress;
    private String customerEmail;
    private int customerTelephoneNo;
    private Date customerAddedDate;

    public CustomerDetails() { // constructor - object hadaddi initiate wenne.
    }

    public CustomerDetails(String customerId, String customerName, String customerNic, String customerBusinessPlace, String customerRegNo, String customerPersonalAddress,
            String customerEmail, int customerTelephoneNo, Date customerAddedDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNic = customerNic;
        this.customerBusinessPlace = customerBusinessPlace;
        this.customerRegNo = customerRegNo;
        this.customerPersonalAddress = customerPersonalAddress;
        this.customerEmail = customerEmail;
        this.customerTelephoneNo = customerTelephoneNo;
        this.customerAddedDate = customerAddedDate;

    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerNic
     */
    public String getCustomerNic() {
        return customerNic;
    }

    /**
     * @param customerNic the customerNic to set
     */
    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    /**
     * @return the customerBusinessPlace
     */
    public String getCustomerBusinessPlace() {
        return customerBusinessPlace;
    }

    /**
     * @param customerBusinessPlace the customerBusinessPlace to set
     */
    public void setCustomerBusinessPlace(String customerBusinessPlace) {
        this.customerBusinessPlace = customerBusinessPlace;
    }

    /**
     * @return the customerRegNo
     */
    public String getCustomerRegNo() {
        return customerRegNo;
    }

    /**
     * @param customerRegNo the customerRegNo to set
     */
    public void setCustomerRegNo(String customerRegNo) {
        this.customerRegNo = customerRegNo;
    }

    /**
     * @return the customerPersonalAddress
     */
    public String getCustomerPersonalAddress() {
        return customerPersonalAddress;
    }

    /**
     * @param customerPersonalAddress the customerPersonalAddress to set
     */
    public void setCustomerPersonalAddress(String customerPersonalAddress) {
        this.customerPersonalAddress = customerPersonalAddress;
    }

    /**
     * @return the customerEmail
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * @param customerEmail the customerEmail to set
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * @return the customerTelephoneNo
     */
    public int getCustomerTelephoneNo() {
        return customerTelephoneNo;
    }

    /**
     * @param customerTelephoneNo the customerTelephoneNo to set
     */
    public void setCustomerTelephoneNo(int customerTelephoneNo) {
        this.customerTelephoneNo = customerTelephoneNo;
    }

    /**
     * @return the customerAddedDate
     */
    public Date getCustomerAddedDate() {
        return customerAddedDate;
    }

    /**
     * @param customerAddedDate the customerAddedDate to set
     */
    public void setCustomerAddedDate(Date customerAddedDate) {
        this.customerAddedDate = customerAddedDate;
    }

}
