package justin.jalandoni.ex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItemDto {

    @JsonProperty("productName")
    private String productName = "";

    @JsonProperty("price")
    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
