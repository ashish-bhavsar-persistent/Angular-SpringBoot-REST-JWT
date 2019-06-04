package com.app.model.order;

import io.swagger.annotations.*;

import java.util.*;
import com.app.model.response.*;

public class OrderInfoResponse extends PageResponse {
	@ApiModelProperty(required = true, value = "")
	private List<OrderInfo> items;

	public List<OrderInfo> getItems() {
		return items;
	}

	public void setItems(List<OrderInfo> items) {
		this.items = items;
	}

}
