package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomerPage {

    private final WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[ng-class='btnClass1']")
    private WebElement addCustomerButton;

    @FindBy(css = "[placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(css = "[ng-model='lName']")
    private WebElement lastNameField;

    @FindBy(css = "[placeholder='Post Code']")
    private WebElement postCodeField;

    @FindBy(className = "btn-default")
    private WebElement addSubmitButton;

    @FindBy(css = "[ng-class='btnClass3']")
    private WebElement searchCustomerButton;

    @FindBy(css = "[placeholder='Search Customer']")
    private WebElement searchCustomerField;

    @FindBy(css = "[class='ng-binding']")
    private WebElement firstTableElement;

    @FindAll(@FindBy(css = "tbody td"))
    private List<WebElement> tableLines;

    @FindBy(css = "td a")
    private WebElement sortNamesButton;

    @Step("Нажали кнопку создания клиента")
    public CustomerPage clickAddCustomerMenu() {
        addCustomerButton.click();
        return this;
    }

    @Step("Вставить {firstName} в поле ввода имени")
    public CustomerPage inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Вставить {lastName} в поле ввода фамилии")
    public CustomerPage inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Вставить {postCode} в поле ввода почтового индекса")
    public CustomerPage inputPostCode(String postCode) {
        postCodeField.sendKeys(postCode);
        return this;
    }

    @Step("Создать клиента")
    public CustomerPage clickSubmitButton() {
        addSubmitButton.click();
        return this;
    }

    @Step("Переход во вкладку поиска клиента")
    public CustomerPage clickSearchCustomerButton() {
        searchCustomerButton.click();
        return this;
    }

    @Step("Вставить {firstName} в поле поиска клиента")
    public CustomerPage inputSearchCustomerField(String firstName) {
        searchCustomerField.sendKeys(firstName);
        return this;
    }

    @Step("Нажать кнопку сортировки")
    public CustomerPage clickSortNamesButton() {
        sortNamesButton.click();
        return this;
    }

    public String getFirstNameText() {
        return firstTableElement.getText();
    }

    public List<String> getNamesFromTable() {
        List<String> namesFromTable = new ArrayList<>();
        for (int i = 0; i < tableLines.size(); i++) {
            if (i % 5 == 0) {
                namesFromTable.add(tableLines.get(i).getText());
            }
        }
        return namesFromTable;
    }


}

