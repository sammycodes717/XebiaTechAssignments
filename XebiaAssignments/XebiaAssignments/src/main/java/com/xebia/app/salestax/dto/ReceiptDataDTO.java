package com.xebia.app.salestax.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ReceiptDataDTO {
	
	List<Map<String,Double>> product;
	private double salesTax;
	private double total;
	

}
