package com.tuanmhoang.bdd.steps;

import com.tuanmhoang.bdd.services.PriceCalculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyerStepsTest {

    private double shippingFee;

    private double discountPrice;

    private double finalPrice = 0;

    private PriceCalculator priceCalculator = new PriceCalculator();

    @Given("I add to cart the items like this")
    public void i_add_to_cart_the_items_like_this(io.cucumber.datatable.DataTable dataTable) {
        final List<List<String>> inputData = dataTable.asLists();
        int rows = inputData.size();
        for (int i = 1; i < rows; i++) {
            List<String> rowData = inputData.get(i);
            finalPrice = finalPrice + priceCalculator.calculatePrice(
                Double.parseDouble(rowData.get(1)),
                Integer.parseInt(rowData.get(2))
            );
        }
    }

    @Given("the shipping fee is {double}")
    public void the_shipping_fee_is(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    @Given("with the discount code I can reduce the price is {double}")
    public void with_the_discount_code_i_can_reduce_the_price_is(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @When("I go to the last step")
    public void i_go_to_the_last_step() {
        System.out.println("Calculating the money for the last step.");
        finalPrice = priceCalculator.calculateFinalPrice(finalPrice, shippingFee, discountPrice);
    }

    @Then("the final price should be {double}")
    public void the_final_price_should_be(Double expectedFinalPrice) {
        assertEquals(expectedFinalPrice, finalPrice);
    }
}
