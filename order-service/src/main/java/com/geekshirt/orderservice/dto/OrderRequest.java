package com.geekshirt.orderservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@ApiModel(description = "Class representing an order to processed")
public class OrderRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Account ID", example = "9898768976", required = true)
    private String accountId;

    @ApiModelProperty(notes = "Items included in the order", required = true, position = 2)
    private List<LineItem> items;
}
