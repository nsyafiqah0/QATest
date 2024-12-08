import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppointmentForm {

    private final WebDriver driver;

    public AppointmentForm(WebDriver driver) {
        this.driver = driver;
    }

    public void setAppoinmentName(String name) {
        WebElement appointmentnameField = driver.findElement(By.id("name"));
        appointmentnameField.clear();
        appointmentnameField.sendKeys(name);
    }

    public void setAppointmentNumber(String phonenumber) {
        WebElement phonenumberField = driver.findElement(By.id("mobileNumber"));
        phonenumberField.clear();
        phonenumberField.sendKeys(phonenumber);
    }

    public void setAppointmentEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setAppointmentState(String state) {
        WebElement stateDropdownTrigger = driver.findElement(By.xpath("//label[contains(text(), 'State')]//following-sibling::span//span[@class='e-input-group-icon e-ddl-icon e-search-icon']"));

        stateDropdownTrigger.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("StateId_hidden")));

        WebElement stateDropdown = driver.findElement(By.id("StateId"));
        Select stateSelect = new Select(stateDropdown);

        stateSelect.selectByVisibleText(state);
    }

    public void setAppointmentStore(String store) {
        WebElement storeDropdownTrigger = driver.findElement(By.xpath("//label[contains(text(), 'Store')]//following-sibling::span//input[@class='e-input-group e-control-wrapper e-input e-ddl e-lib e-keyboard']"));

        storeDropdownTrigger.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BranchId_hidden")));

        WebElement storeDropdown = driver.findElement(By.id("BranchId"));
        Select storeSelect = new Select(storeDropdown);

        storeSelect.selectByVisibleText(store);
    }

    public void setAgreedToSubmitData(boolean isChecked) {
        WebElement checkbox = driver.findElement(By.id("AgreedToSubmitData"));

        //check the box
        if (isChecked && !checkbox.isSelected()) {
            checkbox.click();
        }
        //uncheck the box
        else if (!isChecked && checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void setRecaptcha(boolean isChecked) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement recaptchaCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recaptcha-anchor")));

        wait.until(ExpectedConditions.elementToBeClickable(recaptchaCheckbox));

        if (isChecked && !recaptchaCheckbox.getAttribute("aria-checked").equals("true")) {
            recaptchaCheckbox.click();
        }
    }

    public void execute() {
        WebElement confirmButton = driver.findElement(By.id("SaveAppointment"));
        confirmButton.click();
    }

}
