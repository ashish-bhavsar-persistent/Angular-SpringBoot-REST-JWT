package com.app.model.order;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeOrderProductKey implements Serializable {
	private int orderId;
	private int productId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public CompositeOrderProductKey(int orderId, int productId) {
		this.orderId = orderId;
		this.productId = productId;
	}
}
