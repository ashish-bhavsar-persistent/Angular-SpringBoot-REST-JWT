package com.app.model.order;

import java.util.List;

import com.app.model.response.PageResponse;

import io.swagger.annotations.ApiModelProperty;


public class OrderResponse extends PageResponse {
  @ApiModelProperty(required = true, value = "")
  private List<Order> items;
}
