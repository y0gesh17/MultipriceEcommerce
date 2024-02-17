package com.mpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpe.exception.ProductException;
import com.mpe.modal.Product;
import com.mpe.modal.ProductSlot;
import com.mpe.request.CreateProductRequest;
import com.mpe.request.CreateSlotRequest;
import com.mpe.response.ApiResponse;
import com.mpe.service.ProductService;
import com.mpe.service.ProductSlotService;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping("/api/admin/products")

public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductSlotService productSlotService;
	
	public AdminProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Product> createProductHandler(@RequestBody CreateProductRequest req) throws ProductException{
		
		System.out.print(req.getPrice());

		Product createdProduct = productService.createProduct(req);
		
		return new ResponseEntity<Product>(createdProduct,HttpStatus.ACCEPTED);
		
	}
	@PostMapping("/p")
	public ResponseEntity<ProductSlot> createProductSlotHandler(@RequestBody CreateSlotRequest req) throws ProductException{

		

		System.out.print(req.getMaxSlotSize());
		ProductSlot createdProductSlot = null;
	//	System.out.println("HiPratik ");
	
			createdProductSlot = productSlotService.createSlot(req);
			

	
			// TODO Auto-generated catch block
			System.out.println(req.toString());
		
		return new ResponseEntity<ProductSlot>(createdProductSlot,HttpStatus.ACCEPTED);
		
		
	}
	@DeleteMapping("/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProductHandler(@PathVariable Long productId) throws ProductException{
		
		System.out.println("dlete product controller .... ");
		String msg=productService.deleteProduct(productId);
		System.out.println("dlete product controller .... msg "+msg);
		ApiResponse res=new ApiResponse(msg,true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){
		
		List<Product> products = productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@PutMapping("/{productId}/update")
	public ResponseEntity<Product> updateProductHandler(@RequestBody Product req,@PathVariable Long productId) throws ProductException{
		
		Product updatedProduct=productService.updateProduct(productId, req);
		
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
	}
	
	@PostMapping("/creates")
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] reqs) throws ProductException{
		
		for(CreateProductRequest product:reqs) {
			productService.createProduct(product);
		}
		
		ApiResponse res=new ApiResponse("products created successfully",true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}

}
