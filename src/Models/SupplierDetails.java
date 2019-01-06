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
public class SupplierDetails {
     private String  supplierId;
     private String supplierName;
     private String businessPlaceAddress;
     private Date addedDate;
     private int telephoneNo;
     private String mailAddress;
     
     public SupplierDetails(){}
     
     public SupplierDetails(String  supplierId,String supplierName,String businessPlaceAddress,int telephoneNo,
             Date addedDate,String mailAddress) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.businessPlaceAddress = businessPlaceAddress;
        this.telephoneNo = telephoneNo;
        this.addedDate = addedDate;
        this.mailAddress = mailAddress;
        
    }

    /**
     * @return the supplierId
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the businessPlaceAddress
     */
    public String getBusinessPlaceAddress() {
        return businessPlaceAddress;
    }

    /**
     * @param businessPlaceAddress the businessPlaceAddress to set
     */
    public void setBusinessPlaceAddress(String businessPlaceAddress) {
        this.businessPlaceAddress = businessPlaceAddress;
    }

    /**
     * @return the addedDate
     */
    public Date getAddedDate() {
        return addedDate;
    }

    /**
     * @param addedDate the addedDate to set
     */
    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * @return the telephoneNo
     */
    public int getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * @param telephoneNo the telephoneNo to set
     */
    public void setTelephoneNo(int telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * @return the mailAddress
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * @param mailAddress the mailAddress to set
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    
}
