package com.mpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpe.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
