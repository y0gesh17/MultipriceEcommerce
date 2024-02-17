package com.mpe.service;

import com.mpe.exception.ProductException;
import com.mpe.modal.Product;
import com.mpe.modal.ProductSlot;
import com.mpe.repository.ProductSlotRepository;
import com.mpe.request.CreateSlotRequest;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class ProductSlotServiceImplementation implements ProductSlotService {

	
	 private ProductSlotRepository ps;
	 private ProductService pr;
	private UserService userService;
	public ProductSlotServiceImplementation(ProductSlotRepository ps,ProductService pr, UserService userService) {
		super();
		this.ps = ps;
		this.pr= pr;
		this.userService=userService;
	}

	@Override
	public ProductSlot createSlot(CreateSlotRequest req) throws ProductException {
		// TODO Auto-generated method stub
		
		System.out.println(req.getMaxSlotSize()+"Hi");
		Product p= pr.findProductById(req.getProductId());
		ProductSlot productslot =new ProductSlot();
		
		productslot.setCurrentSlotSize(req.getCurrentSlotSize());
		productslot.setIsFull(req.getIsFull());
		productslot.setSlotDiscountPercent(req.getSlotDiscountPercent());
		productslot.setMaxSlotSize(req.getMaxSlotSize());
		productslot.setPdt(p);
		
		ProductSlot savedProduct;
	
			savedProduct = ps.save(productslot);
		
		
		return savedProduct;
	}

	@Override
	public List<ProductSlot> findSlotById(Long id) {
		
		List<ProductSlot> p=ps.findByProductId(id);
		System.out.println(p.get(0).getMaxSlotSize());
	 return p;
	}

}
