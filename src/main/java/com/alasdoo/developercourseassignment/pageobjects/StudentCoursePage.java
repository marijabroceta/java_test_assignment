package com.alasdoo.developercourseassignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudentCoursePage extends PageObject{

    @FindBy(xpath = ".//div[@data-field='courseName']/parent::*")
    private List<WebElement> courses;

    @FindBy(css = "div[aria-label='Course name']")
    private WebElement title;

    @FindBy(xpath = "//*[@id='root']/div/main/div[2]/div[2]/div/button")
    private WebElement close;

    public StudentCoursePage(WebDriver driver) {
        super(driver);
    }

    public void isInitialized(){
        title.isDisplayed();
    }

    /**
     * Iterate through list of WebElements and click on every element to open update form for courses.
     */
    public void clickOnCourseToOpenUpdateForm(){
        for (int i = 1; i < courses.size(); i++) {
            WebElement course = courses.get(i);
            course.click();
        }

        close.click();
    }
}
