package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;

import java.util.Comparator;
import java.util.List;

public class CustomersTest extends BaseTest {

    @Test
    public void createCustomerTest() {
        String firstName = "Test";
        String lastName = "Test";
        String postCode = "Test";

        new CustomerPage(driver).clickAddCustomerMenu()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputPostCode(postCode)
                .clickSubmitButton();
        Assert.assertTrue(driver.switchTo().alert().getText()
                .contains("Customer added successfully with customer id :"));

    }

    @Test
    public void customerSearchTest() {
        String firstName = "Neville";
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.clickSearchCustomerButton()
                .inputSearchCustomerField(firstName);
        Assert.assertEquals(customerPage.getFirstNameText(), firstName);

    }

    @Test
    public void sortCustomerTest() {
        CustomerPage customerPage = new CustomerPage(driver);
        List<String> unsortedNames = customerPage.clickSearchCustomerButton()
                .getNamesFromTable();
        unsortedNames.sort(Comparator.reverseOrder());
        List<String> sortedNames = customerPage.clickSortNamesButton()
                .getNamesFromTable();
        Assert.assertEquals(sortedNames, unsortedNames);
    }
}

