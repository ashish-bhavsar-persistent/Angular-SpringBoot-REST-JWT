//This is a common http response model for providing data series

package com.app.model.response;

import java.util.*;
import io.swagger.annotations.*;
import com.app.model.data.*;

public class SingleDataSeriseResponse extends OperationResponse {
	private List<SingleSerise> items;

	public List<SingleSerise> getItems() {
		return items;
	}

	public void setItems(List<SingleSerise> items) {
		this.items = items;
	}

}
