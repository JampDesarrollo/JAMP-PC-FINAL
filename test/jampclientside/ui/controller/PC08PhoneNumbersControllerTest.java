/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.ui.controller;

import jampclientside.UiApplicationUser;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

/**
 * Test for PC08PhoneNumbersController Controller
 * 
 * @author Julen
 */
public class PC08PhoneNumbersControllerTest extends ApplicationTest {
     
    /**
     * Method start the application test
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        new UiApplicationUser().start(stage);//llamo a la aplicacion que me abre la ventana
    }

    /**
     * Test for initialStage
     */
    @Test
    public void testA_initialStage() {

        //write("julen");
        //clickOn("#pfContraseña");
        //write("815a76e046");

        write("testLogin");
        clickOn("#pfContraseña");
        write("6f724558dc");
        verifyThat("#userPane", isVisible());
        clickOn("#btnInicio");
        clickOn("#telefonos");
        clickOn("#btnPhones");
        
        verifyThat("#menuBar", isVisible());
        verifyThat("#menuMenu", isVisible());
        verifyThat("#menuEvent", isVisible());
        verifyThat("#menuExpense", isVisible());
        verifyThat("#menuProduct", isVisible());
        verifyThat("#menuUser", isVisible());
        verifyThat("#menuTelephon", isVisible());
        verifyThat("#txtSearchTel", isDisabled());
        verifyThat("#btnSearchTel", isDisabled());
        verifyThat("#delTelephone", isDisabled());
        verifyThat("#tbTelephone", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolNumber", isVisible());
        verifyThat("#tbcolTown", isVisible());
        verifyThat("#lblLogin", hasText("Login: ander"));
        verifyThat("#lblFullName", hasText("Nombre Completo: ander olivas"));
        verifyThat("#lblEmail", hasText("Email: anderolivas@gmail.com"));
        
        clickOn("#cbSearchTel");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        verifyThat("#tbTelephone", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolNumber", isVisible());
        verifyThat("#tbcolTown", isVisible());
        verifyThat("#addTelephone", isDisabled());
        verifyThat("#btnSearchTel", isDisabled());
        verifyThat("#txtSearchTel", isDisabled());
        
        clickOn("#cbSearchTel");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        verifyThat("#tbTelephone", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolNumber", isVisible());
        verifyThat("#tbcolTown", isVisible());
        verifyThat("#addTelephone", isDisabled());
        verifyThat("#btnSearchTel", isEnabled());
        verifyThat("#txtSearchTel", isEnabled());
        verifyThat("#labelError", isInvisible());
                
        clickOn("#cbSearchTel");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        verifyThat("#tbTelephone", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolNumber", isVisible());
        verifyThat("#tbcolTown", isVisible());
        verifyThat("#addTelephone", isDisabled());
        verifyThat("#btnSearchTel", isEnabled());
        verifyThat("#txtSearchTel", isEnabled());
        verifyThat("#labelError", isInvisible());
    }
    
    /**
     * Test Method to the Log Out menu item with close selection
     */
    @Test
    public void testB_logOut() {
        clickOn("#menuMenu");
        clickOn("#menuLogOut");
        clickOn("#cancelButton");
        verifyThat("#btnLogOut2", isVisible());
        clickOn("#menuMenu");
        clickOn("#menuLogOut");
        clickOn("#okButton");
        verifyThat("#userPane", isVisible());
    }
    
    /**
     * Test of initial state of login view before open PrincipalView.
     */
    @Test
    public void testC_secondLogin() {
        //write("julen");
        //clickOn("#pfContraseña");
        //write("815a76e046");
        write("testLogin");
        clickOn("#pfContraseña");
        write("6f724558dc");
        clickOn("#btnInicio");
        
        verifyThat("#userPane", isVisible());
        
        clickOn("#telefonos");
        clickOn("#btnPhones");
    }
    
    /**
     * Test of menu to go to event
     */
    @Test
    public void testD_goToEventPane() {
        clickOn("#menuEvent");
        clickOn("#idMenuEvent");
        verifyThat("#principalPaneEvent", isVisible());
        clickOn("#menuTelefonos");
        clickOn("#idMenuTel");
        verifyThat("#telephonPane", isVisible());
    }
    
    /**
     * Test of menu to go to expense
     */
    @Test
    public void testE_goToExpensePane() {
        clickOn("#menuExpense");
        clickOn("#idMenuExpense");
        verifyThat("#principalPaneExpense", isVisible());
        clickOn("#btnPhones");
        clickOn("#idMenuTel");
        verifyThat("#telephonPane", isVisible());
    }

    /**
     * Test of menu to go to telephone
     */
    @Test
    public void testF_goToProductPane() {
        clickOn("#menuProduct");
        clickOn("#idMenuProduct");
        verifyThat("#productPane", isVisible());
        clickOn("#menuTelephone");
        clickOn("#idMenuTelephone");
        verifyThat("#telephonePane", isVisible());
    }
    
     /**
     * Test of menu to go to clientFTP
     */
    @Test
    public void testG_goToClientFTPPane() {
        clickOn("#menuFtp");
        clickOn("#idMenuFtp");
        verifyThat("#ftpPane", isVisible());
        clickOn("#btnOut");
    }
    /**
     * Test of menu to go to clientFTP
     */
    @Test
    public void testH_deleteProduct() {
        Node row = lookup(".table-row-cell").nth(2).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn("#delTelephone");
        clickOn("Cancelar");
        clickOn("Aceptar");
        //clickOn("#delProduct");
        //clickOn("Aceptar");
}
    
 
   /**
     * Test to bottom_right Button for close session
     */
    @Test
    public void testZ_btnLogOut2() {
        clickOn("#btnLogOut2");
        clickOn("#cancelButton");
        verifyThat("#btnLogOut2", isVisible());
        clickOn("#btnLogOut2");
        clickOn("#okButton");
       // verifyThat("#loginPane", isVisible());
    }

}
