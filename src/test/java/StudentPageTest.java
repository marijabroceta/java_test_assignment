import com.alasdoo.developercourseassignment.pageobjects.AddStudentPage;
import com.alasdoo.developercourseassignment.pageobjects.StudentPage;
import com.alasdoo.developercourseassignment.pageobjects.UpdateStudentPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentPageTest extends FunctionalTest{

    @Test
    public void getStudents(){
        driver.get("http://localhost:3000/student");

        StudentPage studentPage = new StudentPage(driver);
        assertTrue(studentPage.isInitialized());

        studentPage.clickOnStudentToOpenUpdateForm();

        AddStudentPage addStudentPage = studentPage.clickOnAddBtnToOpenAddForm();
        assertTrue(addStudentPage.isInitialized());

        studentPage.clickNextPage();

        assertEquals("Student", studentPage.confirmationHeader());
    }

    @Test
    public void addStudent(){
        driver.get("http://localhost:3000/student/new");
        AddStudentPage addStudentPage = new AddStudentPage(driver);
        assertTrue(addStudentPage.isInitialized());

        addStudentPage.enterName("John", "Doe");
        addStudentPage.enterAccountInfo("john_doe", "john.doe@email.com", 1596);

        addStudentPage.clickToSaveStudent();
    }


}
