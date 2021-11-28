# Cucumber


## Documentation
https://github.com/cucumber/cucumber-jvm/blob/main/junit-platform-engine/README.md

## Some notes

### Can I add new line character? For example
```
Hello
This is the text
with new line
as an example
```

**Refer:**
- https://stackoverflow.com/questions/15551832/newline-character-in-cucumber-jvm-parameters
- https://github.com/TheBrainFamily/cypress-cucumber-preprocessor/issues/106

**Solution:**

Add a special word like `{enter}` then replace with `\n`

## Practice scenario: feature order

### As a buyer

- I want to order some items on an ecommerce website.
- I will order items with quantities and get the total order price.
- Then I need to pay the fee for shipping.
- I also can apply discount code.
- I can get the final order number.

### As a seller

- I can view the order with items and their ordered quantities
- I can update the status of the order to canceled/shipped

