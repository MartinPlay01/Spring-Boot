package com.geekshirt.orderservice.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Class that represents an item included in the order")
public class LineItem {

    @ApiModelProperty(notes = "UPC(Universal Product Code), Len 12 digits", example = "234565635789", required = true, position = 0)
    private String upc;

    @ApiModelProperty(notes = "Quantity", example = "5", required = true, position = 1)
    private int quantity;

    @ApiModelProperty(notes = "Price", example = "10.00", required = true, position = 2)
    private double price;

}
