package com.tallerconpatron.certificacion.colorlib.definition;

import com.tallerconpatron.certificacion.colorlib.common.BasePage;
import com.tallerconpatron.certificacion.colorlib.step.TaskAction;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class FormValidationDefinition extends BasePage {

    private String user;
    private String password;
    private String required;
    private String select;
    private String multipleSelect;
    private String url;
    private String email;
    private String password2;
    private String confirmPassword;
    private String minimumSize;
    private String maximumSize;
    private String number;
    private String ip;
    private String date;
    private String earlierDate;


    @Steps
    TaskAction taskAction;
    @Given("I enter with my credentials")
    public void iEnterWithMyCredentials(io.cucumber.datatable.DataTable dataTable) {
        this.user = dataTable.cell(1,0);
        this.password = dataTable.cell(1,1);
    }

    @When("I proceed with the authentication")
    public void iProceedWithTheAuthentication() {
        try{
            taskAction.openPage();
            taskAction.signIn(user,password);
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException thrown");
        }
    }

    @And("enter submenu form validations")
    public void enterSubmenuFormValidations() {
        taskAction.openMenu();
        taskAction.enter();
    }

    @And("check the title of the form on the screen")
    public void checkTheTitleOfTheFormOnTheScreen(){
        assert taskAction.checkTitle();
    }

    @And("fill all the fields")
    public void fillAllTheFields(io.cucumber.datatable.DataTable dataTable) throws Exception {
        required = dataTable.cell(1,0);
        select = dataTable.cell(1,1);
        multipleSelect = dataTable.cell(1,2);
        url = dataTable.cell(1,3);
        email = dataTable.cell(1,4);
        password2 = dataTable.cell(1,5);
        confirmPassword = dataTable.cell(1,6);
        minimumSize = dataTable.cell(1,7);
        maximumSize = dataTable.cell(1,8);
        number = dataTable.cell(1,9);
        ip = dataTable.cell(1,10);
        date = dataTable.cell(1,11);
        earlierDate = dataTable.cell(1,12);

        taskAction.fill(required, select, multipleSelect, url, email, password2, confirmPassword, minimumSize, maximumSize, number, ip, date, earlierDate );
    }

    @And("click button to validate")
    public void clickButtonToValidate() throws Exception {
        //Thread.sleep(5000);
        taskAction.send();
    }

    @Then("field required will be empty")
    public void fieldRequiredWillBeEmpty(){
        assert(taskAction.check());
    }

}
