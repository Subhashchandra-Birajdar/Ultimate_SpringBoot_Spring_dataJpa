package com.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @JsonProperty("c-name")
    private String customerName;
    private String productName;
    private long quantity;
//getter,setter,toString

}
