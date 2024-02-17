package com.mpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpe.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
