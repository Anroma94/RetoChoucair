package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.navigation.NavigateTo;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class ChoucairCambiarBanner {

    @Before
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given ("visita a pagina de inicio ChoucairTesting")
    public void Choucair_Home(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.ChoucairInicio());
    }

    @Test ("Navegacion y busqueda de imagen del banner")
    public void testChoucairCambiarBanner() throws Exception {
        driver.get("https://www.choucairtesting.com/");
        driver.findElement(By.linkText("Empleos")).click();
        driver.findElement(By.linkText("English")).click();

        String bannerBusqueda = "driver.findElement(By.xpath(//img[contains(@src,'https://www.choucairtesting.com/wp-content/uploads/2019/07/banner.png')]")).click();
        String bannerEsperado = "//img[contains(@src,'https://www.choucairtesting.com/wp-content/uploads/2019/07/banner.png')]";
        assertArrayEquals(bannerEsperado, bannerBusqueda);
    }

    @After ("verificar imagen del banner")
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
