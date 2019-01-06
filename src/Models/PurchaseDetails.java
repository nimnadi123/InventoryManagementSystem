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
public class PurchaseDetails {
     private String purchaseId; // string, char, int int -number, string- word, char -single letter
    private Double unitValue;
    private int soldQuantity;
    private String itemId;
    private String customerId;
    private Date orderedDate;
    
    
    public PurchaseDetails(){}
    
     public PurchaseDetails(String purchaseId,Double unitValue,int soldQuantity,String itemId,String customerId,
             Date orderedDate)
     {
         this.purchaseId = purchaseId;
        this.unitValue = unitValue;
        this.soldQuantity = soldQuantity;
        this.itemId = itemId;
        this.customerId = customerId;
        this.orderedDate = orderedDate; 
     }

    /**
     * @return the purchaseId
     */
    public String getPurchaseId() {
        return purchaseId;
    }

    /**
     * @param purchaseId the purchaseId to set
     */
    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * @return the unitValue
     */
    public Double getUnitValue() {
        return unitValue;
    }

    /**
     * @param unitValue the unitValue to set
     */
    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return soldQuantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
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
     * @return the orderedDate
     */
    public Date getOrderedDate() {
        return orderedDate;
    }

    /**
     * @param orderedDate the orderedDate to set
     */
    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }
        

    
}
