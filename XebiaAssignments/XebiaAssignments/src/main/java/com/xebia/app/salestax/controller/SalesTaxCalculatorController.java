package com.xebia.app.salestax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.app.salestax.dto.ProductsDTO;
import com.xebia.app.salestax.dto.ReceiptDataDTO;
import com.xebia.app.salestax.service.SalesTaxCalculatorService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sumit Agrawal
 */

@RestController
@RequestMapping("/api")
@Slf4j
public class SalesTaxCalculatorController {

	
	private SalesTaxCalculatorService salesTaxCalculatorService;
	public SalesTaxCalculatorController(SalesTaxCalculatorService salesTaxCalculatorService2) {
		this.salesTaxCalculatorService = salesTaxCalculatorService2;
	}


	/**
	 * Api Returns the Data for receipt
	 * 
	 * @param productsList
	 * @return
	 */
	@PostMapping("/calculate/tax")
	public ReceiptDataDTO calculateSalesTax(@RequestBody List<ProductsDTO> productsList) {
		log.debug("Entered in SalesTaxCalculatorController calculateSalesTax");
		return salesTaxCalculatorService.calculateTaxData(productsList);
	}
}
