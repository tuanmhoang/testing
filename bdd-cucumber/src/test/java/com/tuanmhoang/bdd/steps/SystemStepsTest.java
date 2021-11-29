package com.tuanmhoang.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemStepsTest {

    private double calculatedItemPrice = 0;
    private double priceOfTheItem;
    private int quantityOfTheItem;
    private PriceCalculator priceCalculator = new PriceCalculator();

    @Given("I added to cart the items with the price is {double}")
    public void i_added_to_cart_the_items_with_the_price_is(Double price) {
        this.priceOfTheItem = price;
    }
    @Given("the quantity is {int}")
    public void the_quantity_is(Integer quantity) {
        this.quantityOfTheItem = quantity;
    }
    @Then("the price that I have to pay is {double}")
    public void the_price_that_i_have_to_pay_is(Double itemPrice) {
        double actualCalculatedPrice = priceCalculator.calculatePrice(priceOfTheItem,quantityOfTheItem);
        assertEquals(itemPrice, actualCalculatedPrice);

    }
}
