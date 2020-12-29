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

    @FindBy(css = "button[data-test-id='courses']")
    private WebElement toggleCourses;

    @FindBy(css = "button[data-test-id='save']")
    private WebElement saveStudent;

    @FindBy(css = "button[data-test-id='delete']")
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

    public void enterEmail(String email){
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void clickOnToggleCourses(){
        toggleCourses.click();
        StudentCoursePage studentCoursePage = new StudentCoursePage(driver);
        studentCoursePage.isInitialized();
        studentCoursePage.clickOnCourseToOpenUpdateForm();
    }

    public void clickToSaveChanges(){
        saveStudent.click();
    }

    public void clickToDeleteStudent(){
        deleteStudent.click();
    }
}
