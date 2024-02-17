package com.mpe.service;

import java.util.List;

import com.mpe.exception.ProductException;
import com.mpe.modal.Product;
import com.mpe.modal.ProductSlot;
import com.mpe.request.CreateProductRequest;
import com.mpe.request.CreateSlotRequest;

public interface ProductSlotService {
	
	public ProductSlot createSlot(CreateSlotRequest req)throws ProductException ;
	
	public List<ProductSlot> findSlotById(Long id);

}
