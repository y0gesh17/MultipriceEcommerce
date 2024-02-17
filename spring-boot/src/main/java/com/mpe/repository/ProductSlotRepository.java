package com.mpe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mpe.modal.Product;
import com.mpe.modal.ProductSlot;

public interface ProductSlotRepository extends JpaRepository<ProductSlot, Long> {
	
	
	@Query("SELECT p From ProductSlot p Where p.pdt.id= :id")
	public List<ProductSlot> findByProductId(@Param("id") Long id);

}
