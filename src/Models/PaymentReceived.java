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
public class PaymentReceived {
    private String paymentReceivedId; // string, char, int int -number, string- word, char -single letter
    private Double receivedAmount;
    private Double totalAmount;
    private Double discount;
    private Date receivedDate;
    private String orderId;
    
     public PaymentReceived(){}
    
    public PaymentReceived(String paymentReceivedId,Double receivedAmount, Double totalAmount,Double discount,
             Date receivedDate,String orderId){
    this.paymentReceivedId = paymentReceivedId;
        this.receivedAmount = receivedAmount;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.receivedDate = receivedDate;
        this.orderId = orderId;
    }

    /**
     * @return the paymentReceivedId
     */
    public String getPaymentReceivedId() {
        return paymentReceivedId;
    }

    /**
     * @param paymentReceivedId the paymentReceivedId to set
     */
    public void setPaymentReceivedId(String paymentReceivedId) {
        this.paymentReceivedId = paymentReceivedId;
    }

    /**
     * @return the receivedAmount
     */
    public Double getReceivedAmount() {
        return receivedAmount;
    }

    /**
     * @param receivedAmount the receivedAmount to set
     */
    public void setReceivedAmount(Double receivedAmount) {
        this.receivedAmount = receivedAmount;
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
     * @return the receivedDate
     */
    public Date getReceivedDate() {
        return receivedDate;
    }

    /**
     * @param receivedDate the receivedDate to set
     */
    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
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

}
