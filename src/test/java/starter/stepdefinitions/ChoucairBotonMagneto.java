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

public class ChoucairBotonMagneto {

    @Before
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("visitar pagina de inicio ChoucairTesting")
    public void Choucair_Home(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.ChoucairInicio());
    }

    @Test("Navegación y busqueda de boton del portal Magneto")
    public void testChoucairBotonMagneto() throws Exception {
        driver.get("https://www.choucairtesting.com/");
        driver.findElement(By.linkText("Empleos")).click();
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.linkText("Ir al portal de empleos")).click();
        String botonBusqueda = "driver.findElement(By.xpath("//div[@id='elementor-popup-modal-11876']/div/div[2]/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/div/a/span/span")).click()";
        String botonEsperado = "//div[@id='elementor-popup-modal-11876']/div/div[2]/div/div/section/div/div/div/div/div/section/div/div/div/div/div/div/div/div/a/span/span";
        assertArrayEquals(botonEsperado, botonBusqueda);

        driver.findElement(By.linkText("Ofertas Laborales")).click();
    }

    @then("verificar ejecucion de popup y direccionamiento")
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
