package com.mpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpe.exception.ProductException;
import com.mpe.modal.Product;
import com.mpe.modal.ProductSlot;
import com.mpe.request.CreateSlotRequest;
import com.mpe.service.ProductService;
import com.mpe.service.ProductSlotService;
import com.mpe.user.domain.ProductSubCategory;

@RestController


@RequestMapping("/api")

public class UserProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductSlotService productSlotService;
	
	public UserProductController(ProductService productService) {
		this.productService=productService;
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findProductByCategoryHandler() {

	 // System.out.print("HiPratik");
		
		List<Product> res= productService.getAllProducts();
		
		System.out.println("complete products");
		return new ResponseEntity<List<Product>>(res,HttpStatus.ACCEPTED);
		
	}
//	@PostMapping("/productslot")
//	public ResponseEntity<ProductSlot> createProductSlotHandler(CreateSlotRequest req){
//
//		ProductSlot createdProductSlot = null;
//		System.out.println("HiPratik ");
//		try {
//			createdProductSlot = productSlotService.createSlot(req);
//			
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(req.toString());
//		}
//		return new ResponseEntity<ProductSlot>(createdProductSlot,HttpStatus.ACCEPTED);
//		
//		
//	}
//	
	@GetMapping("/productslot/{productId}")
	public ResponseEntity<List<ProductSlot>> findProductSlotByCategoryHandler(@PathVariable Long productId){

		
		 //System.out.println(productId);
		
		List<ProductSlot> res= productSlotService.findSlotById(productId);
		
		System.out.println("complete productsSlot");
		return new ResponseEntity<List<ProductSlot>>(res,HttpStatus.ACCEPTED);
		
	}
	

	
	@GetMapping("/products/id/{productId}")
	public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId) throws ProductException{
		
		Product product=productService.findProductById(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}

	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProductHandler(@RequestParam String q){
		
		List<Product> products=productService.searchProduct(q);
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
}
