package com.app.model.session;

import com.app.model.response.OperationResponse;

import io.swagger.annotations.ApiModelProperty;

public class SessionResponse extends OperationResponse {
	@ApiModelProperty(required = true, value = "")
	private SessionItem item;

	public SessionItem getItem() {
		return item;
	}

	public void setItem(SessionItem item) {
		this.item = item;
	}

}
