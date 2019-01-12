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
public class CustomerPaymentReturned {

    private String paymentReturnedId; // string, char, int int -number, string- word, char -single letter
    private Double returnedAmount;
    private Date returnedDate;
    private String orderId;
    private int PaymentReceived;
    private int PaymentReceivable;
    private int returnedQuantity;

    public CustomerPaymentReturned() {
    }

    public CustomerPaymentReturned(String paymentReturnedId, Double returnedAmount,
        Date returnedDate, String orderId, int PaymentReceived,int PaymentReceivable,int returnedQuantity) {
        this.paymentReturnedId = paymentReturnedId;

        this.returnedAmount = returnedAmount;

        this.returnedDate = returnedDate;
        this.orderId = orderId;
        this.PaymentReceived=PaymentReceived;
        this.PaymentReceivable=PaymentReceivable;
        this.PaymentReceivable=PaymentReceivable;
        this.returnedQuantity =returnedQuantity;
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
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the PaymentReceived
     */
    public int getPaymentReceived() {
        return PaymentReceived;
    }

    /**
     * @param PaymentReceived the PaymentReceived to set
     */
    public void setPaymentReceived(int PaymentReceived) {
        this.PaymentReceived = PaymentReceived;
    }

    /**
     * @return the PaymentReceivable
     */
    public int getPaymentReceivable() {
        return PaymentReceivable;
    }

    /**
     * @param PaymentReceivable the PaymentReceivable to set
     */
    public void setPaymentReceivable(int PaymentReceivable) {
        this.PaymentReceivable = PaymentReceivable;
    }

    /**
     * @return the returnedQuantity
     */
    public int getReturnedQuantity() {
        return returnedQuantity;
    }

    /**
     * @param returnedQuantity the returnedQuantity to set
     */
    public void setReturnedQuantity(int returnedQuantity) {
        this.returnedQuantity = returnedQuantity;
    }

}
