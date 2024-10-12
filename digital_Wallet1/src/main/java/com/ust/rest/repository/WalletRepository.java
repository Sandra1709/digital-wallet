package com.ust.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.rest.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet ,Long>{
	 Wallet findByName(String name);
	

}
