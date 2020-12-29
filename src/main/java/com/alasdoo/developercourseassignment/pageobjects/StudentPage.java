package com.alasdoo.developercourseassignment.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class StudentPage extends PageObject{

    @FindBy(tagName = "h6")
    private WebElement header;

    @FindBy(xpath = ".//div[@data-field='id']/..")
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

    /**
     * Iterate through list of WebElements and click on every element to open update form,
     * check if form is open, edit every student and
     * click to toggle courses.
     */
    public void clickOnStudentToOpenUpdateForm(){
        for (int i = 1; i < students.size(); i++) {
            WebElement student = students.get(i);

            student.click();

            UpdateStudentPage updateStudentPage = new UpdateStudentPage(driver);
            updateStudentPage.isInitialized();

            String id = student.findElement(By.xpath(".//div[@data-field='id']")).getText();
            updateStudentPage.enterName("Nick" + id, "Name" + id);
            updateStudentPage.enterEmail(id + "nick.name@email.com");

            updateStudentPage.clickToSaveChanges();

            updateStudentPage.clickOnToggleCourses();
        }

    }

    public void clickNextPage(){
        nextPage.click();
        clickOnStudentToOpenUpdateForm();
    }

    public AddStudentPage clickOnAddBtnToOpenAddForm(){
        addStudent.click();
        return new AddStudentPage(driver);
    }
}
