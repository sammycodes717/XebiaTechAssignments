package com.xebia.app.salestax.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xebia.app.salestax.dto.ProductsDTO;
import com.xebia.app.salestax.dto.ReceiptDataDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SalesTaxCalculatorService {
	
	private final int RATE = 10;
	private final int ADDITIONAL_TAX = 5;
	
	
	
	/**
	 * Below Method will Calculate the tax for specific product based on product type
	 * @param productsList
	 * @return
	 */
	public ReceiptDataDTO calculateTaxData(List<ProductsDTO> productsList) {
		
		log.debug("Entered SalesTaxCalculatorService : calculateTaxData(productsList)");
		double salesTax = 0;
		double additionalTax = 0;
		double totalAmount = 0;
		double totalSalesTax = 0;
		ReceiptDataDTO receiptData = null;
		List<Map<String, Double>> allProducts = new ArrayList<>();
		Map<String, Double> map = null;
		// Iterating product list
		for (ProductsDTO products : productsList) {
			receiptData = new ReceiptDataDTO();
			map = new HashMap<>();

			if (products.getIsTaxApplicable() && !products.getIsImported()) {
				salesTax = (products.getAmount() * RATE) / 100;
				totalSalesTax = totalSalesTax + salesTax;
				setMapValues(map,products.getProductName(),products.getAmount()+salesTax);
			} else if (products.getIsTaxApplicable() && products.getIsImported()) {
				salesTax = (products.getAmount() * RATE) / 100;
				additionalTax = (products.getAmount() * ADDITIONAL_TAX) / 100;
				salesTax = salesTax + additionalTax;
				totalSalesTax = totalSalesTax + salesTax;
				setMapValues(map,products.getProductName(),products.getAmount()+salesTax);
			} else if (products.getIsImported() && !products.getIsTaxApplicable()) {
				additionalTax = (products.getAmount() * ADDITIONAL_TAX) / 100;
				salesTax = additionalTax;
				totalSalesTax = totalSalesTax + salesTax;
				setMapValues(map,products.getProductName(),products.getAmount()+salesTax);
			} else {
				setMapValues(map,products.getProductName(),products.getAmount());
			}

			allProducts.add(map);

			totalAmount = totalAmount + products.getAmount();
		}
		
		//Setting values to receiptDTO
		if (receiptData != null) {
			receiptData.setProduct(allProducts);
			receiptData.setSalesTax(totalSalesTax);
			receiptData.setTotal(totalAmount+totalSalesTax);
		}

		log.debug("Exiting SalesTaxCalculatorService : calculateTaxData(productsList)");

		return receiptData;
	}
	
	/**
	 * Setting Values to Map
	 * @param map
	 * @param productName
	 * @param setAmount
	 */
	public void setMapValues(Map<String, Double> map, String productName, double setAmount) {
		map.put(productName, setAmount);
	}


}
