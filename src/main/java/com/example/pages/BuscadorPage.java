package com.example.pages;

import com.example.utils.Utilidades;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BuscadorPage extends BasePage {

    By inputBuscador = By.name("q");
    By textoResultados = By.name("q");
    By textoNoResultados= By.name("q");

    public BuscadorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Abrir buscador. Url {0}")
    public BuscadorPage gotoBuscador(String url)  {
        driver.get(url);
        Utilidades.waitInMs(5000);
        return new BuscadorPage(driver);
    }

    @Step("Buscar el texto {0}")
    public BuscadorPage searchText(String texto) {
        Utilidades.waitInMs(5000);
        writeText(inputBuscador, texto + "\n");
        Utilidades.waitInMs(5000);
        return this;
    }

    @Step("Comprobar resultado correcto")
    public BuscadorPage comprobarResultadoCorrecto() {
        Utilidades.waitInMs(5000);
        Assert.assertEquals(getElement(textoResultados).isDisplayed(), true);
        return this;
    }

    @Step("Comprobar resultado incorrecto")
    public BuscadorPage comprobarResultadoIncorrecto() {
        Utilidades.waitInMs(5000);
        Assert.assertEquals(readText(textoNoResultados), "Texto no coincidente");
        return this;
    }

}
