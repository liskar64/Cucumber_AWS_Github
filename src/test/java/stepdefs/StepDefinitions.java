package stepdefs;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private WebDriver driver;

    @Dado("^que me conecte a la aplicacion$")

    public void que_me_conecte_a_la_aplicacion() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        //capabilities.setCapability("deviceName","Xperia M2");
        //capabilities.setCapability("platformVersion","5.1.1");
        capabilities.setCapability("deviceName","EmuladorMaxam26");
        //capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("browser_Name","Android");
        //capabilities.setCapability("app","src/apk/MAXAM Mobile Blast.apk");
        //capabilities.setCapability("app","C:Maxam_Cucumber_AWS/src/apk/app-debug_2.apk");
        capabilities.setCapability("appPackage", "com.maxam.maxammobileblast");
       // capabilities.setCapability("appActivity", "com.maxam.maxammobileblast.MainActivity");
        try{
            //driver = new AndroidDriver(new URL(appiumServiceUrl), capabilities);
             //driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Cuando("^pulso boton de aceptar popup$")

    public void pulso_boton_de_aceptar_popup(){
        driver.findElement(By.id("btAceptar")).click();
    }

    @Entonces("^entraremos en la aplicacion$")

    public void entraremos_en_la_aplicacion() {
        Assert.assertTrue(isElementPresent(By.id("toolbar_title")));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        driver.quit();
    }

    @Cuando("^navego hasta el menu de ajustes y pulso en castellano$")
    public void navego_hasta_el_menu_de_ajustes() {

        driver.findElement(By.id("btAceptar")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        driver.findElement(By.id("imageView15")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        driver.findElement(By.id("clSettings")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        driver.findElement(By.id("rbCastellano")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    @Entonces("^veremos la palabra idioma en la pantalla$")
    public void veremos_la_palabra_idioma_en_la_pantalla()  {

        Assert.assertEquals(driver.findElement(By.id("tvIdioma")).getText(),"Idioma");

        driver.quit();

    }

    @Cuando("^navego hasta el menu de conversion y convierto (\\d+) mm a cm$")
    public void navego_hasta_el_menu_de_conversion_y_convierto_mm_a_cm(String arg1) {

        //boton de popup

        driver.findElement(By.id("btAceptar")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }


        //herramientas

        driver.findElement(By.id("imageView15")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //conversor de unidades

        List<WebElement> elems = driver.findElements(By.id("listTitle"));
        elems.get(0).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //longitud

        List<WebElement> elems2 = driver.findElements(By.id("imageView"));
        elems2.get(0).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }


        // Cambio unidades

        List<WebElement> elems3 = driver.findElements(By.id("textView2"));

        elems3.get(1).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // Cambio a cm

        List<WebElement> elems4 = driver.findElements(By.id("textView2"));

        elems3.get(1).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //Clico en valor

        driver.findElement(By.id("tvDe")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //escribo 10

        driver.findElement(By.id("bt1")).click();
        driver.findElement(By.id("bt0")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        //pulso done

        driver.findElement(By.id("btCambiar")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

    }
        // assert final

    @Entonces("^el resultado sera (\\d+)$")
    public void el_resultado_sera(String arg1)  {

        Assert.assertEquals(arg1,driver.findElement(By.id("tvA")).getText());

        driver.quit();

    }


    public boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
}
