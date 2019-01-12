/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author user
 */
public class PurchaseAddViewDTO {
    private String purchaseId; // string, char, int int -number, string- word, char -single letter
    private Double unitValue;
    private int soldQuantity;
    private String itemId;
    private String customerId;
    private Date orderedDate;
     private String paymentReceivableId; // string, char, int int -number, string- word, char -single letter
    private Double receivableAmount;
    private String paymentId;
    private int isOutStanding;
    private Date dueDate;
    private String customerName;
    private String itemName;
    private int isHold;
    
    public PurchaseAddViewDTO(){}
    public PurchaseAddViewDTO(String purchaseId,Double unitValue,int soldQuantity,String itemId,String customerId,
             Date orderedDate,String paymentReceivableId,Double receivableAmount, String paymentId,
            int isOutStanding,Date dueDate, String customerName,String itemName, int isHold){
        this.purchaseId = purchaseId;
        this.unitValue = unitValue;
        this.soldQuantity = soldQuantity;
        this.itemId = itemId;
        this.customerId = customerId;
        this.orderedDate = orderedDate; 
        this.paymentReceivableId = paymentReceivableId;
        this.receivableAmount = receivableAmount;
       
        this.paymentId = paymentId;
        this.isOutStanding = isOutStanding;
        this.dueDate = dueDate;
        this.customerName =customerName;
        this.itemName = itemName;
        this.isHold =isHold;
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
     * @return the soldQuantity
     */
    public int getSoldQuantity() {
        return soldQuantity;
    }

    /**
     * @param soldQuantity the soldQuantity to set
     */
    public void setSoldQuantity(int soldQuantity) {
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

    /**
     * @return the paymentReceivableId
     */
    public String getPaymentReceivableId() {
        return paymentReceivableId;
    }

    /**
     * @param paymentReceivableId the paymentReceivableId to set
     */
    public void setPaymentReceivableId(String paymentReceivableId) {
        this.paymentReceivableId = paymentReceivableId;
    }

    /**
     * @return the receivableAmount
     */
    public Double getReceivableAmount() {
        return receivableAmount;
    }

    /**
     * @param receivableAmount the receivableAmount to set
     */
    public void setReceivableAmount(Double receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    /**
     * @return the paymentId
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the isOutStanding
     */
    public int getIsOutStanding() {
        return isOutStanding;
    }

    /**
     * @param isOutStanding the isOutStanding to set
     */
    public void setIsOutStanding(int isOutStanding) {
        this.isOutStanding = isOutStanding;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the isHold
     */
    public int getIsHold() {
        return isHold;
    }

    /**
     * @param isHold the isHold to set
     */
    public void setIsHold(int isHold) {
        this.isHold = isHold;
    }
    
}
