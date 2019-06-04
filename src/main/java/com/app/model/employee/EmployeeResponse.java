package com.app.model.employee;

import io.swagger.annotations.*;

import java.util.*;
import com.app.model.response.*;

public class EmployeeResponse extends PageResponse {
	@ApiModelProperty(required = true, value = "")
	private List<Employee> items;

	public List<Employee> getItems() {
		return items;
	}

	public void setItems(List<Employee> items) {
		this.items = items;
	}

}
