package com.ust.rest.controller;


import java.util.List;
//import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ust.rest.model.Wallet;
import com.ust.rest.service.WalletService;

@RestController
@RequestMapping("/wallet/api")//root of the resource/controller

public class WalletController {
	@Autowired
	private WalletService service;
	Logger logger =Logger.getLogger("WalletController.class");
	
	
	@GetMapping(value="/wallet/{id}")
	public ResponseEntity <Wallet>getById(@PathVariable long id)
	{
		Wallet wallet = service.getWalletById(id);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(null);
        }
		

		
		//return null;
	}
		
	@GetMapping(value="/walet/{name}")
	public ResponseEntity <Wallet>getByName(@PathVariable String name)
	{
		Wallet wallet = service.getWalletByName(name);
        if (wallet != null) {
		return ResponseEntity.ok(wallet);
       } else {
           return ResponseEntity.notFound().build();
       }
		
		//return null;
		}
@GetMapping(value="/walletsinfo",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity <List<Wallet>> displayWallets()
{
	 List<Wallet> wallets = service.getAllWallets();
     return ResponseEntity.ok(wallets);
}
@PostMapping(value="/addData")
public  ResponseEntity<Wallet> addProduct(@RequestBody Wallet prod)
{
	 logger.info("Entered PostMethod"+prod);
     Wallet savedproduct = service.addProduct(prod); 
     logger.info("Persisted product"+savedproduct);
	return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(savedproduct);
	}
@PutMapping(value="/modify")
public  ResponseEntity<Wallet> updateProduct(@RequestBody Wallet prod)
{

	
	         return null;
}
@DeleteMapping(value="/delete/{id}")
public void  removeProduct(@PathVariable long id)
{
	service.removeProductById(id);
    
		
}

}