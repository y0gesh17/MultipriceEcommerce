package com.mpe.request;

import com.mpe.modal.Product;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CreateSlotRequest {

	
    private int maxSlotSize;
    private Boolean isFull;
    private int currentSlotSize;
    private int slotDiscountPercent;
    private Long productId;
	public int getMaxSlotSize() {
		return maxSlotSize;
	}
	public void setMaxSlotSize(int maxSlotSize) {
		this.maxSlotSize = maxSlotSize;
	}
	public Boolean getIsFull() {
		return isFull;
	}
	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}
	public int getCurrentSlotSize() {
		return currentSlotSize;
	}
	public void setCurrentSlotSize(int currentSlotSize) {
		this.currentSlotSize = currentSlotSize;
	}
	public int getSlotDiscountPercent() {
		return slotDiscountPercent;
	}
	public void setSlotDiscountPercent(int slotDiscountPercent) {
		this.slotDiscountPercent = slotDiscountPercent;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
