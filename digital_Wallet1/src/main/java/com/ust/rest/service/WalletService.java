package com.ust.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.Wallet;
import com.ust.rest.repository.WalletRepository;

@Service
public class WalletService {
 @Autowired
  private WalletRepository  repo;
 public Wallet addProduct(Wallet prod)
 {
	 return repo.save(prod);
 }
 public List<Wallet> getAllWallets() {
     return repo.findAll();
 }
 public Wallet getWalletById(long id) {
     Optional<Wallet> wallet = repo.findById(id);
     return wallet.orElse(null);
 }
 public Wallet getWalletByName(String name) {
     return repo.findByName(name);
 }
 public void removeProductById(long id) {
    repo.deleteById(id);
 }


}
