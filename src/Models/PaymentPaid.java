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
public class PaymentPaid {
    private String paymentPaidId; // string, char, int int -number, string- word, char -single letter
    private Double paidAmount;
    private Double totalAmount;
    private Double discount;
    private Date paidDate;
    private String supplyId;
    
     public PaymentPaid(){}
    
    public PaymentPaid(String paymentPaidId,Double paidAmount, Double totalAmount,Double discount,
             Date paidDate,String supplyId){
    this.paymentPaidId = paymentPaidId;
        this.paidAmount = paidAmount;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.paidDate = paidDate;
        this.supplyId = supplyId;
    }

    /**
     * @return the paymentPaidId
     */
    public String getPaymentPaidId() {
        return paymentPaidId;
    }

    /**
     * @param paymentPaidId the paymentPaidId to set
     */
    public void setPaymentPaidId(String paymentPaidId) {
        this.paymentPaidId = paymentPaidId;
    }

    /**
     * @return the paidAmount
     */
    public Double getPaidAmount() {
        return paidAmount;
    }

    /**
     * @param paidAmount the paidAmount to set
     */
    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * @return the totalAmount
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the discount
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * @return the paidDate
     */
    public Date getPaidDate() {
        return paidDate;
    }

    /**
     * @param paidDate the paidDate to set
     */
    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    /**
     * @return the supplyId
     */
    public String getSupplyId() {
        return supplyId;
    }

    /**
     * @param supplyId the supplyId to set
     */
    public void setSupplyId(String supplyId) {
        this.supplyId = supplyId;
    }
}
