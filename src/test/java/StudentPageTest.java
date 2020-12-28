import com.alasdoo.developercourseassignment.pageobjects.AddStudentPage;
import com.alasdoo.developercourseassignment.pageobjects.StudentPage;
import com.alasdoo.developercourseassignment.pageobjects.UpdateStudentPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentPageTest extends FunctionalTest{

    @Test
    public void getStudents(){
        driver.get("http://localhost:3000/student");

        StudentPage studentPage = new StudentPage(driver);
        assertTrue(studentPage.isInitialized());

        UpdateStudentPage updateStudentPage = studentPage.clickOnStudentToOpenUpdateForm();
        assertTrue(updateStudentPage.isInitialized());

        studentPage.clickNextPage();

        AddStudentPage addStudentPage = studentPage.clickOnAddBtnToOpenAddForm();
        assertTrue(addStudentPage.isInitialized());

        assertEquals("Student", studentPage.confirmationHeader());
    }
}
