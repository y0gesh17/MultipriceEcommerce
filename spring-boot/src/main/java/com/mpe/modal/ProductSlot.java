package com.mpe.modal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProductSlot {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long slotId;

    @Column(name = "maxSlotSize")
    private int maxSlotSize;
    
    @Column(name = "isFull")
    private Boolean isFull;
    

	@Column(name = "currentSlotSize")
    private int currentSlotSize;
    
    @Column(name = "slotDiscountPercent")
    private int slotDiscountPercent;
    
   
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Product pdt;
    
    
    




	public Long getSlotId() {
		return slotId;
	}



	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}



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



	public Product getPdt() {
		return pdt;
	}



	public void setPdt(Product pdt) {
		this.pdt = pdt;
	}



	public ProductSlot(Long slotId, int maxSlotSize, Boolean isFull, int currentSlotSize, int slotDiscountPercent,
			Product product) {
		super();
		this.slotId = slotId;
		maxSlotSize = maxSlotSize;
		isFull = isFull;
		currentSlotSize = currentSlotSize;
		slotDiscountPercent = slotDiscountPercent;
		pdt= product;
	}



	public ProductSlot() {
		super();
		// TODO Auto-generated constructor stub
	}



    


}
