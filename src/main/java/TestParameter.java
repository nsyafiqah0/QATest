import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestParameter {

    private final Properties properties;

    public TestParameter() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDemoUrl() {
        return properties.getProperty("demo.url");
    }
    public String getAppointmentName() {
        return properties.getProperty("appointment.name");
    }
    public String getAppointmentNumber() {
        return properties.getProperty("appointment.phonenumber");
    }
    public String getAppointmentEmail() { return properties.getProperty("appointment.email"); }
    public String getAppointmentState() { return properties.getProperty("appointment.state"); }
    public String getAppointmentStore() { return properties.getProperty("appointment.store"); }

}
