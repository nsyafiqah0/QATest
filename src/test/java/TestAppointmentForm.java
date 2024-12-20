import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.junit.jupiter.api.DisplayName;
import java.time.Duration;

public class TestAppointmentForm {

    private WebDriver driver;
    private TestParameter parameter;
    private AppointmentForm appform;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\piqah\\IdeaProjects\\QATESTKVD\\src\\test\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        parameter = new TestParameter();
        driver.get(parameter.getDemoUrl());
        appform = new AppointmentForm(driver);
    }

    @Test(priority = 1)
    @DisplayName("Fill the form")
    public void testSuccessfulLogin() {
        appform.setAppoinmentName(parameter.getAppointmentName());
        appform.setAppointmentNumber(parameter.getAppointmentNumber());
        appform.setAppointmentEmail(parameter.getAppointmentEmail());
        appform.setAppointmentState(parameter.getAppointmentState());
        appform.setAppointmentStore(parameter.getAppointmentStore());
        //appform.setAppointmentStoreAddress(parameter.getAppointmentStoreAddress());
        appform.setAgreedToSubmitData(true);
        appform.setRecaptcha(true);

        appform.execute();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
