package com.alasdoo.developercourseassignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddStudentPage extends PageObject{

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(name = "surname")
    private WebElement surname;

    @FindBy(name = "accountName")
    private WebElement accountName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "bankCardNumber")
    private WebElement bankCardNumber;

    @FindBy(css = "button[data-test-id='save']")
    private WebElement saveStudent;

    @FindBy(css = "button[data-test-id='delete']")
    private WebElement deleteStudent;

    public AddStudentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(){
        return name.isDisplayed();
    }

    public void enterName(String name, String surname){
        this.name.clear();
        this.name.sendKeys(name);

        this.surname.clear();
        this.surname.sendKeys(surname);
    }

    public void enterAccountInfo(String accountName, String email, Integer bankCardNumber){
        this.accountName.clear();
        this.accountName.sendKeys(accountName);

        this.email.clear();
        this.email.sendKeys(email);

        this.bankCardNumber.clear();
        this.bankCardNumber.sendKeys(Integer.toString(bankCardNumber));
    }

    public void clickToSaveStudent(){
        saveStudent.click();
    }

    public void clickToDeleteStudent(){
        deleteStudent.click();
    }
}
