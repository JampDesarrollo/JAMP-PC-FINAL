/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.ui.controller;

import jampclientside.UiApplication;
import jampclientside.UiApplicationUser;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

/**
 * class for the events controller
 *
 * @author Paula
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC05EventsControllerIT extends ApplicationTest {

    public void start(Stage stage) throws Exception {
        new UiApplicationUser().start(stage);//llamo a la aplicacion que me abre la ventana
    }

    /**
     * Initializing the application and going to user window
     *
     */
    @Test
    public void test0_initializingAplication() {

        verifyThat("#tfUsuario", isEnabled());
        verifyThat("#tfContraseña", isEnabled());
        verifyThat("#lblError", isInvisible());
        doubleClickOn("#tfUsuario");
        eraseText(20);
        doubleClickOn("#tfUsuario");
        eraseText(20);
        write("pau");
        clickOn("#pfContraseña");
        write("fcdd6828d2");
        clickOn("#btnInicio");
        verifyThat("#loginPane", isVisible());
    }

    /**
     * Go to events window
     */
    @Test
    public void test1_goToEvents() {

        clickOn("#eventos");
        clickOn("#btnEvents");
        verifyThat("#principalPaneEvent", isVisible());
    }

    /**
     * . Initializing handle WindowShowing of events
     */
    @Test
    public void test2_initStage() {

        verifyThat("#btnSearch", isEnabled());
        verifyThat("#btnSearch", (Button t) -> t.isFocused());
        verifyThat("#tfSearch", isDisabled());
        verifyThat("#tfSearch", hasText(""));
        verifyThat("#btnAddEvent", isDisabled());
        verifyThat("#btnDeleteEvent", isDisabled());
        verifyThat("#btnAsignar", isDisabled());
        verifyThat("#btnImgEvent", isDisabled());
        verifyThat("#tbcolName", isVisible());
        verifyThat("#tbcolDescription", isVisible());
        verifyThat("#tbcolDate", isVisible());
        verifyThat("#tbcolImg", isVisible());
        verifyThat("#tbcolPrice", isVisible());
        verifyThat("#labelError", isInvisible());
        verifyThat("#menuBar", isVisible());
        verifyThat("#menuMenu", isVisible());
        verifyThat("#menuFTP", isVisible());
        verifyThat("#menuEvent", isVisible());
        verifyThat("#menuGastos", isVisible());
        verifyThat("#menuProductos", isVisible());
        verifyThat("#menuUsuarios", isVisible());
        verifyThat("#menuTelefonos", isVisible());

    }

    /**
     * Click on the combobox the first option and button search. Then we are
     * going to add an event and assign it to our txoko.
     */
    @Test
    public void test3_clickOnBTNSearch() {
        clickOn("#btnSearch");
        verifyThat("#labelError", isInvisible());
        clickOn("#btnAddEvent");
        verifyThat("#addEvent", isEnabled());
        verifyThat("#btnSalir", isEnabled());
        clickOn("#btnAdd");
        verifyThat("#lblError", isVisible());
        doubleClickOn("#tfName");
        write("anyEvent");
        clickOn("#btnAdd");
        verifyThat("#lblError", isVisible());
        doubleClickOn("#tfDescription");
        write("anyEvent");
        clickOn("#btnAdd");
        verifyThat("#lblError", isVisible());
        doubleClickOn("#tfImg");
        write("anyEvent");
        clickOn("#btnAdd");
        verifyThat("#lblError", isVisible());
        doubleClickOn("#tfPrice");
        write("3");
        clickOn("#btnAdd");
        verifyThat("#lblError", isVisible());
        clickOn("#hora");
        write("17:00");
        clickOn("#btnAdd");
        verifyThat("#lblError", isVisible());
        doubleClickOn("#hora");
        eraseText(10);
        write("17:00");
        clickOn("#btnAdd");
        clickOn("Aceptar");
        clickOn("#btnSalir");
        verifyThat("#principalPaneEvent", isVisible());
        clickOn("#btnSearch");
        clickOn("#btnAsignar");
        clickOn("Aceptar");
        //look for 1st row in table view and click it
        Node row = lookup(".table-row-cell").nth(5).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
        clickOn("#btnAsignar");
    }

    /**
     * click on the second option of combobox and button search. The we are
     * going to delete an event. click on the 3 option of combobox and the
     * button search.First in the text field there is not going to be text so it
     * has to appear an error. Then we are going to put an incorrect id so in
     * the label it has to appear an error. Then we put the correct id. Click on
     * the 4 option and button search. First in the text field there is not
     * going to be text so it has to appear an error. Then we are going to put
     * an incorrect name so in the label it has to appear an error. Then we put
     * the correct name.
     */
   @Test
    public void test4_clickOnBTNSearchComboBoxOption2Option3Option4() {
       //TODOS LOS EVENTOS DE MI TXOKO
        clickOn("#cbSearch");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("#btnSearch");
        clickOn("#btnDeleteEvent");
        clickOn("Aceptar");
        Node row = lookup(".table-row-cell").nth(3).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
        clickOn("#btnDeleteEvent");
        clickOn("Cancelar");
        clickOn("#btnDeleteEvent");
        clickOn("Aceptar");
        //BUSQUEDA POR ID
        clickOn("#cbSearch");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("#btnSearch");
        verifyThat("#labelError ", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
        doubleClickOn("#tfSearch");
        write("50");
        clickOn("#btnSearch");
        //  verifyThat("#labelError ", org.testfx.matcher.control.LabeledMatchers.hasText("ID del evento incorrecto"));
        doubleClickOn("#tfSearch");
        eraseText(2);
        write("5");
        clickOn("#btnSearch");
        //BUSQUEDA POR NOMBRE
        clickOn("#cbSearch");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("#btnSearch");
        verifyThat("#labelError ", org.testfx.matcher.control.LabeledMatchers.hasText("Campo requerido"));
        doubleClickOn("#tfSearch");
        write("fiestas");
        clickOn("#btnSearch");
        // verifyThat("#labelError ", org.testfx.matcher.control.LabeledMatchers.hasText("Nombre del evento incorrecto"));
        doubleClickOn("#tfSearch");
        eraseText(10);
        write("fiestas de zamudio");
        clickOn("#btnSearch");
        verifyThat("#labelError", isInvisible());
    }

    /**
     * Go to expenses window and go back
     */
    @Test
    public void test5_goToExpensesWindow() {

        clickOn("#menuGastos");
        clickOn("#idMenuGastos");
        verifyThat("#principalPaneExpense", isVisible());
        clickOn("#btnEvents");
        clickOn("#idMenuEventos");
        verifyThat("#principalPaneEvent", isVisible());

    }

    /**
     * go to products window and go back
     */
    @Test 
    public void test6_goToProductsWindow() {

        clickOn("#menuProductos");
        clickOn("#idMenuProductos");
        verifyThat("#productPane", isVisible());
        clickOn("#menuEvent");
        clickOn("#idMenuEvent");
        verifyThat("#principalPaneEvent", isVisible());

    }

    /**
     * go to user window and go back
     */
   @Test
    public void test7_goToUserWindow() {

        clickOn("#menuUsuarios");
        clickOn("#idMenuUsuarios");
        verifyThat("#userPane", isVisible());
        clickOn("#eventos");
        clickOn("#btnEvents");
        verifyThat("#principalPaneEvent", isVisible());

    }

    /**
     * go to phones window and go back
     */
    @Test @Ignore
    public void test8_goToPhoneWindow() {

        clickOn("#menuTelefonos");
        clickOn("#idMenuTel");
        verifyThat("#telephonPane", isVisible());
        clickOn("#menuEvent");
        clickOn("#idMenuEvent");
        verifyThat("#principalPanePhones", isVisible());

    }

    /**
     * go to ftp client window with the menu item and go back
     */
    @Test
    public void test9_goToFTClientWindow() {

        clickOn("#menuFTP");
        clickOn("#idMenuFTP");
        verifyThat("#ftpPane", isVisible());
        clickOn("#btnOut");
        verifyThat("#principalPaneEvent", isVisible());

    }

    //CON EL  BOTON
    /**
     * go to the ftp client window with the button and go back
     */
   @Test
    public void testa_goToFTPClientWindowWithButton() {
        clickOn("#btnSearch");
        clickOn("#btnImgEvent");
        verifyThat("#ftpPane", isVisible());
        clickOn("#btnOut");
        verifyThat("#principalPaneEvent", isVisible());

    }

    //IR AL INFORME
    /**
     * Do the report
     */
    @Test
    @Ignore
    public void testb_informe() {
        clickOn("#btnSearch");
        clickOn("#btnInforme");
        verifyThat("#jasperviewer", isVisible());
    }

    /**
     * we click in the log out button.
     */
    //CERRAR SESION
    @Test
    public void testc_btnLogOut() {
        clickOn("#btnLogOut2");
        clickOn("#cancelButton");
        verifyThat("#principalPaneEvent", isVisible());
        clickOn("#btnLogOut2");
        clickOn("#okButton");

    }

}
