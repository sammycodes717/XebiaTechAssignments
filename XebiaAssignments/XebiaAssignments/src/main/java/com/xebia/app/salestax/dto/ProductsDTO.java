package com.xebia.app.salestax.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductsDTO implements Serializable {
	
	/**
	 * Products DTO 
	 */
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String productName;
	private double amount;
	private Boolean isTaxApplicable;
	private Boolean isImported;

}
