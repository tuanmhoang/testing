package com.tuanmhoang.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellerStepsTest {

    private Map<Integer, String> orderData;

    @Given("I update the status of the order like this")
    public void i_update_the_status_of_the_order_like_this(io.cucumber.datatable.DataTable dataTable) {
        orderData = parseDataFromDataTable(dataTable);
    }

    private Map<Integer, String> parseDataFromDataTable(DataTable dataTable) {
        Map<Integer, String> parsedInputData = new HashMap<>();
        final List<List<String>> listData = dataTable.asLists();
        for (int i = 1; i < listData.size(); i++) {
            List<String> rowData = listData.get(i);
            parsedInputData.put(Integer.parseInt(rowData.get(0)), rowData.get(1));
        }
        return parsedInputData;
    }

    @Given("I update the status of the first id is {int} to {string}")
    public void i_update_the_status_of_the_first_id_is_to(Integer id, String status) {
        orderData.put(id, status);
    }

    @Given("I update the status of the second id is {int} to {string}")
    public void i_update_the_status_of_the_second_id_is_to(Integer id, String status) {
        orderData.put(id, status);
    }

    @When("I check the order status again")
    public void i_check_the_order_status_again() {
        System.out.println("Checking status again...");
    }

    @Then("the status should be like this")
    public void the_status_should_be_like_this(io.cucumber.datatable.DataTable dataTable) {
        final List<List<String>> listData = dataTable.asLists();
        for (int i = 1; i < listData.size(); i++) {
            final List<String> rowData = listData.get(i);
            final String expected = orderData.get(Integer.parseInt(rowData.get(0)));
            final String actual = rowData.get(1);
            assertEquals(expected, actual);
        }
    }
}
