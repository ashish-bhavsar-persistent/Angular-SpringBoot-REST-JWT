package com.app.model.product;

import java.util.List;

import com.app.model.response.PageResponse;

import io.swagger.annotations.ApiModelProperty;


public class ProductResponse extends PageResponse {
	@ApiModelProperty(required = true, value = "")
	private List<Product> items;

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

}
