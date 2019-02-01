/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.ui.controller;

import jampclientside.UiApplication;
import jampclientside.UiApplicationUser;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isInvisible;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 * Test class for the expense controller
 *
 * @author Paula
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PC04ExpenseControllerIT extends ApplicationTest {

    public void start(Stage stage) throws Exception {
        new UiApplicationUser().start(stage);//llamo a la aplicacion que me abre la ventana
    }

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
     * Go to expense window
     */
    @Test
    public void test1_goToExpense() {

        clickOn("#gastos");
        clickOn("#btnExpenses");
        verifyThat("#principalPaneExpense", isVisible());
    }

    /**
     * init stage
     */
    @Test
    public void test2_InitStage() {

        verifyThat("#btnSeeAll", isEnabled());
        verifyThat("#btnSeeMonth", isEnabled());
        verifyThat("#btnLogOut2", isEnabled());
        verifyThat("#colDate", isVisible());
        verifyThat("#colUser", isVisible());
        verifyThat("#colType", isVisible());
        verifyThat("#colDescription", isVisible());
        verifyThat("#colPrice", isVisible());
    }

    /**
     * click on see all
     */
    @Test
    public void test3_clickOnBtnSeeAll() {
        clickOn("#btnSeeAll");
    }

    /**
     * click on see month
     */
    @Test
    public void test4_clickOnBtnSeeMonth() {
        clickOn("#btnSeeMonth");
    }

    /**
     * go to product
     */
    @Test
    public void test5_goToProductWindow() {
        clickOn("#btnProducts");
        clickOn("#idMenuProductos");
        verifyThat("#productPane", isVisible());
        clickOn("#menuExpense");
        clickOn("#idMenuExpense");
        verifyThat("#principalPaneExpense", isVisible());
    }

    /**
     * go to user
     */
    @Test
    public void test6_goToUserWindow() {
        clickOn("#btnUsers");
        clickOn("#idMenuUsuarios");
        verifyThat("#userPane", isVisible());
        clickOn("#gastos");
        clickOn("#btnExpenses");
        verifyThat("#principalPaneExpense", isVisible());

    }

    /**
     * go to phones
     */
    @Test
    @Ignore
    public void test7_goToPhonesWindow() {
        clickOn("#btnPhones");
        clickOn("#idMenuTel");
        verifyThat("#telephonPane", isVisible());
        clickOn("#menuExpense");
        clickOn("#idMenuExpense");
        verifyThat("#principalPaneExpense", isVisible());

    }

    /**
     * go to ftp
     */
    @Test
    public void test8_goToClientFTPWindow() {
        clickOn("#menuFTP");
        clickOn("#idMenuFTP");
        verifyThat("#ftpPane", isVisible());
        clickOn("#btnOut");
        verifyThat("#principalPaneExpense", isVisible());

    }

    /**
     * Go to event window
     */
    @Test
    public void test9_goToEvent() {
        clickOn("#btnEvents");
        clickOn("#idMenuEventos");
        verifyThat("#principalPaneEvent", isVisible());
        clickOn("#menuGastos");
        clickOn("#idMenuGastos");
        verifyThat("#principalPaneExpense", isVisible());

    }

    /**
     * log out
     */
    @Test
    public void testa_LogOut() {
        clickOn("#menu");
        clickOn("#btnLogOut");
        clickOn("Cancelar");

        clickOn("#menu");
        clickOn("#btnLogOut");
        clickOn("Aceptar");
    }

}
