package com.alasdoo.developercourseassignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateStudentPage extends PageObject{

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

    @FindBy(id = "courses")
    private WebElement toggleCourses;

    @FindBy(id = "save")
    private WebElement saveStudent;

    @FindBy(id = "delete")
    private WebElement deleteStudent;

    public UpdateStudentPage(WebDriver driver) {
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

    public void enterAccountInfo(String accountName, String email, String bankCardNumber){
        this.accountName.clear();
        this.accountName.sendKeys(accountName);

        this.email.clear();
        this.email.sendKeys(email);

        this.bankCardNumber.clear();
        this.bankCardNumber.sendKeys(bankCardNumber);
    }

    public void clickOnToggleCourses(){
        toggleCourses.click();
    }

    public void clickToSaveStudent(){
        saveStudent.click();
    }

    public void clickToDeleteStudent(){
        deleteStudent.click();
    }
}
