package com.tallerconpatron.certificacion.colorlib.step;

import com.tallerconpatron.certificacion.colorlib.common.BasePage;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaFormulario;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaLogin;
import com.tallerconpatron.certificacion.colorlib.pageobject.PaginaMenu;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import javax.swing.JOptionPane;

public class TaskAction extends BasePage {

    private PaginaLogin paginaLogin;
    private PaginaMenu paginaMenu;
    private PaginaFormulario paginaFormulario;

    @Step
    public void openPage(){
        openApp();
    }

    @Step
    public void signIn(String strUsername, String strPassword){
        sendKey(strUsername);
        sendKeyPassword(strPassword);
        paginaLogin.btnSingIn.waitUntilClickable().click();
    }

    @Step


    public void sendKey(String strUsername){
        paginaLogin.user.click();
        paginaLogin.user.clear();
        paginaLogin.user.sendKeys(strUsername);
    }

    public void sendKeyPassword(String strPassword){
        paginaLogin.password.click();
        paginaLogin.password.clear();
        paginaLogin.password.sendKeys(strPassword);
    }

    @Step

    public void openMenu(){
        paginaMenu.menu.waitUntilClickable().click();
    }

    public void enter(){
        paginaMenu.button.waitUntilClickable().click();
    }

    @Step

    public void fill(String req, String sel, String mult, String url, String email, String pass, String pass2, String min, String max, String number, String ip, String date, String earl){
        paginaFormulario.required.clear();
        paginaFormulario.url.clear();
        paginaFormulario.email.clear();
        paginaFormulario.password.clear();
        paginaFormulario.confirmPassword.clear();
        paginaFormulario.minimumSize.clear();
        paginaFormulario.maximumSize.clear();
        paginaFormulario.number.clear();
        paginaFormulario.ip.clear();
        paginaFormulario.date.clear();
        paginaFormulario.dateEarlier.clear();

        paginaFormulario.required.sendKeys(req);
        paginaFormulario.select.selectByValue(sel);
        paginaFormulario.multipleSelect.selectByValue(mult);
        paginaFormulario.url.sendKeys(url);
        paginaFormulario.email.sendKeys(email);
        paginaFormulario.password.sendKeys(pass);
        paginaFormulario.confirmPassword.sendKeys(pass2);
        paginaFormulario.minimumSize.sendKeys(min);
        paginaFormulario.maximumSize.sendKeys(max);
        paginaFormulario.number.sendKeys(number);
        paginaFormulario.ip.sendKeys(ip);
        paginaFormulario.date.sendKeys(date);
        paginaFormulario.dateEarlier.sendKeys(earl);
    }

    public void send(){
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        paginaFormulario.validation.waitUntilClickable().click();

    }

    public boolean check(){
        return paginaFormulario.required.getText().equals("");
    }

    public boolean checkTitle(){
        return paginaFormulario.getDriver().getTitle().equals("Form Validation");
    }
}
