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
public class SupplierPaymentReturned {
    private String paymentReturnedId; // string, char, int int -number, string- word, char -single letter
    private Double returnedAmount;
    private Date returnedDate;
    private String supplyId;
     private int PaymentPaid;
    private int PaymentPayable;
    private int quantity;

    public SupplierPaymentReturned() {
    }

    public SupplierPaymentReturned(String paymentReturnedId, Double returnedAmount,
            Date returnedDate, String supplyId, int PaymentPaid,int PaymentPayable,int quantity) {
        this.paymentReturnedId = paymentReturnedId;

        this.returnedAmount = returnedAmount;

        this.returnedDate = returnedDate;
        this.supplyId = supplyId;
        this.PaymentPaid = PaymentPaid;
        this.PaymentPayable = PaymentPayable;
        this.quantity = quantity;
    }

    /**
     * @return the paymentReturnedId
     */
    public String getPaymentReturnedId() {
        return paymentReturnedId;
    }

    /**
     * @param paymentReturnedId the paymentReturnedId to set
     */
    public void setPaymentReturnedId(String paymentReturnedId) {
        this.paymentReturnedId = paymentReturnedId;
    }

    /**
     * @return the returnedAmount
     */
    public Double getReturnedAmount() {
        return returnedAmount;
    }

    /**
     * @param returnedAmount the returnedAmount to set
     */
    public void setReturnedAmount(Double returnedAmount) {
        this.returnedAmount = returnedAmount;
    }

    /**
     * @return the returnedDate
     */
    public Date getReturnedDate() {
        return returnedDate;
    }

    /**
     * @param returnedDate the returnedDate to set
     */
    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
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

    /**
     * @return the PaymentPaid
     */
    public int getPaymentPaid() {
        return PaymentPaid;
    }

    /**
     * @param PaymentPaid the PaymentPaid to set
     */
    public void setPaymentPaid(int PaymentPaid) {
        this.PaymentPaid = PaymentPaid;
    }

    /**
     * @return the PaymentPayable
     */
    public int getPaymentPayable() {
        return PaymentPayable;
    }

    /**
     * @param PaymentPayable the PaymentPayable to set
     */
    public void setPaymentPayable(int PaymentPayable) {
        this.PaymentPayable = PaymentPayable;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
