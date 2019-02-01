/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.ui.controller;

import jampclientside.UiApplication;
import jampclientside.UiApplicationProduct;
import jampclientside.UiApplicationUser;
import jampclientside.logic.ProductLogic;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

/**
 * Test class for PC07Products Controller
 * 
 * @author Julen
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC07ProductsControllerTest extends ApplicationTest {
    
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

    @Test 
    public void testA_initialStage() {

        write("ander");
        clickOn("#pfContraseña");
        write("4463a7e7a1");
        clickOn("#btnInicio");
        
        verifyThat("#userPane", isVisible());
        
        clickOn("#productos");
        clickOn("#btnProducts");
        
        verifyThat("#menuBar", isVisible());
        verifyThat("#menuMenu", isVisible());
        verifyThat("#menuEvent", isVisible());
        verifyThat("#menuExpense", isVisible());
        verifyThat("#menuProduct", isVisible());
        verifyThat("#menuUser", isVisible());
        verifyThat("#menuTelephon", isVisible());
        verifyThat("#txtSearch", isDisabled());
        //verifyThat("#tbProducts", isEditable());
        verifyThat("#btnSearch", isDisabled());
        verifyThat("#delProduct", isDisabled());
        verifyThat("#asignProduct", isDisabled());
        verifyThat("#unasignProduct", isDisabled());
        verifyThat("#tbProducts", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolPrice", isVisible());
        verifyThat("#tbcolStock", isVisible());
        verifyThat("#lblLogin", hasText("Login: ander"));
        verifyThat("#lblFullName", hasText("Nombre Completo: ander olivas"));
        verifyThat("#lblEmail", hasText("Email: anderolivas@gmail.com"));
        
        clickOn("#cbSearch");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        verifyThat("#tbProducts", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolPrice", isVisible());
        verifyThat("#tbcolStock", isVisible());
        verifyThat("#asignProduct", isDisabled());
        verifyThat("#unasignProduct", isEnabled());
        verifyThat("#addProduct", isDisabled());
        verifyThat("#btnSearch", isDisabled());
        verifyThat("#txtSearch", isDisabled());
        
        clickOn("#cbSearch");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        verifyThat("#tbProducts", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolPrice", isVisible());
        verifyThat("#tbcolStock", isVisible());
        verifyThat("#asignProduct", isEnabled());
        verifyThat("#unasignProduct", isDisabled());
        verifyThat("#addProduct", isDisabled());
        verifyThat("#btnSearch", isEnabled());
        verifyThat("#txtSearch", isEnabled());
       // verifyThat("#txtSearch", hasText(""));
        verifyThat("#labelError", isInvisible());
                
        clickOn("#cbSearch");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        verifyThat("#tbProducts", isVisible());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolPrice", isVisible());
        verifyThat("#tbcolStock", isVisible());
        verifyThat("#asignProduct", isEnabled());
        verifyThat("#unasignProduct", isDisabled());
        verifyThat("#addProduct", isDisabled());
        verifyThat("#btnSearch", isEnabled());
        verifyThat("#txtSearch", isEnabled());
       // verifyThat("#txtSearch", hasText(""));
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
        //verifyThat("#loginPane", isVisible());
    }
    
    /**
     * Test of initial state of login view before open PrincipalView.
     */
    @Test 
    public void testC_secondLogin() {

        write("ander");
        clickOn("#pfContraseña");
        write("4463a7e7a1");
        clickOn("#btnInicio");
        verifyThat("#userPane", isVisible());
        clickOn("#productos");
        clickOn("#btnProducts");
    }
    
    /**
     * Test of menu to go to event
     */
    @Test 
    public void testD_goToEventPane() {
        clickOn("#menuEvent");
        clickOn("#idMenuEvent");
        verifyThat("#principalPaneEvent", isVisible());
        clickOn("#menuProductos");
        clickOn("#idMenuProductos");
        verifyThat("#productPane", isVisible());
    }
    
    /**
     * Test of menu to go to expense
     */
    @Test 
    public void testF_goToExpensePane() {
        clickOn("#menuExpense");
        clickOn("#idMenuExpense");
        verifyThat("#principalPaneExpense", isVisible());
        clickOn("#btnProducts");
        clickOn("#idMenuProductos");
        verifyThat("#productPane", isVisible());
    }
    
    /**
     * Test of menu to go to telephone
     */
    @Test
    public void testH_goToTelephonePane() {
        clickOn("#menuTelephon");
        clickOn("#idMenuTelephon");
        verifyThat("#telephonPane", isVisible());
        clickOn("#menuProduct");
        clickOn("#idMenuProduct");
        verifyThat("#productPane", isVisible());
    }
    
     /**
     * Test of menu to go to clientFTP
     */
    @Test @Ignore
    public void testI_goToClientFTPPane() {
        clickOn("#menuFtp");
        clickOn("#idMenuFtp");
        verifyThat("#ftpPane", isVisible());
        clickOn("#btnOut");
    }

    /**
     * Test of add Button
     */
    @Test
    public void testJ_addProduct() {
        clickOn("#addProduct");
        clickOn("Cancelar");
        /*clickOn("#addProduct");
        clickOn("Aceptar");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
        clickOn("#addProduct");
        clickOn("Cancelar");
        clickOn("#addProduct");
        clickOn("Aceptar");*/
    }   
    
    /**
     * Test of asign Button
     */
    @Test
    public void testK_asignProduct() {
        clickOn("#cbSearch");
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("#btnSearch");
        verifyThat("#labelError ", hasText("Tienes que escribir el id de un producto"));
        clickOn("#txtSearch");
        write("28");
        clickOn("#btnSearch");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
        clickOn("#asignProduct");
        clickOn("Aceptar");
        clickOn("Aceptar");
        clickOn("#asignProduct");
        clickOn("Aceptar");
    } 
    
    /**
     * Test of unasign Button
     */
    @Test
    public void testL_unasignProduct() {
        clickOn("#cbSearch");
        type(KeyCode.UP);
        type(KeyCode.ENTER);
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
        clickOn("#unasignProduct");
        clickOn("Cancelar");
        clickOn("Aceptar");
        clickOn("#unasignProduct");
        clickOn("Aceptar");
        clickOn("Aceptar");
    } 
    
    /**
     * Test of deleteButton
     */
    @Test
    public void testN_deleteProduct() {
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
        clickOn("#delProduct");
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
        clickOn("Cancelar");
        verifyThat("#btnLogOut2", isVisible());
        clickOn("#btnLogOut2");
        clickOn("Aceptar");
        verifyThat("#loginPane", isVisible());
    }
}