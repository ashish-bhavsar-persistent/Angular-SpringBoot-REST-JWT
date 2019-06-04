package com.app.model.user;

import com.app.model.response.OperationResponse;

public class UserResponse extends OperationResponse {
	private User data = new User();

	public User getData() {
		return data;
	}

	public void setData(User data) {
		this.data = data;
	}

}
