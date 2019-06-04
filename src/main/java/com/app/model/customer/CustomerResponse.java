package com.app.model.customer;

import io.swagger.annotations.*;

import java.util.*;
import com.app.model.response.*;

public class CustomerResponse extends PageResponse {
	@ApiModelProperty(required = true, value = "")
	private List<Customer> items;

	public List<Customer> getItems() {
		return items;
	}

	public void setItems(List<Customer> items) {
		this.items = items;
	}

}
