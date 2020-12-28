package com.alasdoo.developercourseassignment.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudentPage extends PageObject{

    @FindBy(tagName = "h6")
    private WebElement header;

    @FindBy(className = "MuiDataGrid-row")
    private List<WebElement> students;

    @FindBy(css = "button[aria-label='add']")
    private WebElement addStudent;

    @FindBy(css = "button[aria-label='Next page']")
    private WebElement nextPage;

    public StudentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(){
        return header.isDisplayed();
    }

    public String confirmationHeader(){
        return header.getText();
    }

    public UpdateStudentPage clickOnStudentToOpenUpdateForm(){
        for (WebElement student: students) {
            System.out.println("Student: " + student.getText());
            student.click();
            //return new UpdateStudentPage(driver);
        }
        return new UpdateStudentPage(driver);
    }

    public void clickNextPage(){
        System.out.println("Next Page");
        nextPage.click();
        clickOnStudentToOpenUpdateForm();
    }

    public AddStudentPage clickOnAddBtnToOpenAddForm(){
        System.out.println("Open Add Form");
        addStudent.click();
        return new AddStudentPage(driver);
    }
}
