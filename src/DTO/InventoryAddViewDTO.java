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
public class InventoryAddViewDTO {

    private String itemId; // string, char, int int -number, string- word, char -single letter
    private String itemName;
    private Double unitPrice;
    private int quantity;
    private String netAmount;
    private Date newInventoryDate;
    private String categoryId;
    private String categoryName;
    private String supplierId;
    private String supplierName;
    private String supplyId;

    public InventoryAddViewDTO() {
    }

    public InventoryAddViewDTO(String itemId, String itemName, Double unitPrice, int quantity, String netAmount, Date newInventoryDate,
            String categoryId, String categoryName, String supplierId, String supplierName,String supplyId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.netAmount = netAmount;
        this.newInventoryDate = newInventoryDate;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplyId =supplyId;
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
     * @return the unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
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

    /**
     * @return the netAmount
     */
    public String getNetAmount() {
        return netAmount;
    }

    /**
     * @param netAmount the netAmount to set
     */
    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    /**
     * @return the newInventoryDate
     */
    public Date getNewInventoryDate() {
        return newInventoryDate;
    }

    /**
     * @param newInventoryDate the newInventoryDate to set
     */
    public void setNewInventoryDate(Date newInventoryDate) {
        this.newInventoryDate = newInventoryDate;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
