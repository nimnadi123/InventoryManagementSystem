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
public class PaymentReceivables {
    private String paymentReceivableId; // string, char, int int -number, string- word, char -single letter
    private Double receivableAmount;
    private int soldQuantity;
    private String paymentId;
    private int isOutStanding;
    private Date dueDate;
    
    public PaymentReceivables(){}
    
    public PaymentReceivables(String paymentReceivableId,Double receivableAmount, int soldQuantity,String paymentId,
            int isOutStanding,Date dueDate){
    this.paymentReceivableId = paymentReceivableId;
        this.receivableAmount = receivableAmount;
        this.soldQuantity = soldQuantity;
        this.paymentId = paymentId;
        this.isOutStanding = isOutStanding;
        this.dueDate = dueDate;
        
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
    
}
