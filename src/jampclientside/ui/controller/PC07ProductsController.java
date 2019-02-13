/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.ui.controller;

import jampclientside.entity.ProductBean;
import jampclientside.entity.TxokoBean;
import jampclientside.entity.UserBean;
import jampclientside.exceptions.BusinessLogicException;
import jampclientside.exceptions.IdNotOkException;
import jampclientside.exceptions.NameNotOkException;
import jampclientside.logic.EventLogic;
import jampclientside.logic.ExpenseLogic;
import jampclientside.logic.FTPClientLogic;
import jampclientside.logic.ILogicFactory;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jampclientside.logic.ProductLogic;
import jampclientside.logic.TelephoneLogic;
import jampclientside.logic.UserLogic;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.NumberStringConverter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML PC07ProductsController class
 *
 * @author Julen
 */
public class PC07ProductsController {

    /**
     * Maximum characters that can be inserted
     */
    private static final int MAX_CARACT = 50;

    /**
     * Attribute to appear the information text.
     */
    private static final Logger LOGGER = Logger.getLogger("package.class");


    /**
     * Tooltip for id
     */
    private final Tooltip tooltipID = new Tooltip();

    /**
     * Tooltip for the name
     */
    private final Tooltip tooltipName = new Tooltip();

    /**
     * Menu item of expense
     */
    @FXML
    private MenuItem idMenuExpense;

    /**
     * Menu item of events
     */
    @FXML
    private MenuItem idMenuEvent;

    /**
     * Menu item of users
     */
    @FXML
    private MenuItem idMenuUser;

    /**
     * Menu item of phones
     */
    @FXML
    private MenuItem idMenuTelephon;

    /**
     * the menu item client ftp
     */
    @FXML
    private MenuItem idMenuFTP;

    /**
     * The menu bar
     */
    @FXML
    private MenuBar menuBar;

    /**
     * The menu "menu"
     */
    @FXML
    private Menu menuMenu;

    /**
     * The menu item for log out
     */
    @FXML
    private MenuItem menuLogOut;

    /**
     * the menu event
     */
    @FXML
    private Menu menuEvent;

    /**
     * the menu expense
     */
    @FXML
    private Menu menuExpense;

    /**
     * the menu product
     */
    @FXML
    private Menu menuProduct;

    /**
     * the menu user
     */
    @FXML
    private Menu menuUser;

    /**
     * the menu telephone
     */
    @FXML
    private Menu menuTelephon;

    /**
     * the product pane
     */
    @FXML
    private VBox productPane;

    /**
     * labe for date
     */
    @FXML
    private Label lblDate;

    /**
     * label for login
     */
    @FXML
    private Label lblLogin;

    /**
     * label for full name
     */
    @FXML
    private Label lblFullName;

    /**
     * label for email
     */
    @FXML
    private Label lblEmail;

    /**
     * label for txoko
     */
    @FXML
    private Label lblTxoko;

    /**
     * the combo box search
     */
    @FXML
    private ComboBox<String> cbSearch;

    /**
     * the textfield for search
     */
    @FXML
    private TextField txtSearch;

    /**
     * the button search
     */
    @FXML
    private Button btnSearch;

    /**
     * the label error
     */
    @FXML
    private Label labelError;

    /**
     * the button for add product
     */
    @FXML
    private Button addProduct;

    /**
     * the button for delete product
     */
    @FXML
    private Button delProduct;

    /**
     * the button for asign product
     */
    @FXML
    private Button asignProduct;

    /**
     * the button for unasign product
     */
    @FXML
    private Button unasignProduct;

    /**
     * the button for printproduct report
     */
    @FXML
    private Button btnReport;

    /**
     * th button for log out
     */
    @FXML
    private Button btnLogOut;

    /**
     * th button for log out
     */
    @FXML
    private Button btnLogOut2;

    /**
     * thetable view for products
     */
    @FXML
    private TableView<ProductBean> tbProducts;

    /**
     * the table column fo name
     */
    @FXML
    private TableColumn tbcolName;

    /**
     * The table column for description
     */
    @FXML
    private TableColumn tbcolDescription;

    /**
     * The table column for price
     */
    @FXML
    private TableColumn tbcolPrice;

    /**
     * the table column for stock
     */
    @FXML
    private TableColumn tbcolStock;
    
    /**
     * The date picker for last access
     */
    @FXML
    private DatePicker datePicker;

    /**
     * the observable list for product data
     */
    private ObservableList<ProductBean> productData;

    /**
     * the list of products to copy the data
     */
    private List<ProductBean> productDatacopy = new ArrayList<>();
    
    /**
     * Integer to close the window
     */
    private int cerrar;

    /**
     * The PorductLogic 
     */
    private ProductLogic iLogicProduct;

    /**
     * the userbean user
     */
    private UserBean user;

    /**
     * The Stage object associated to the Scene controlled by this controller.
     * This is an utility method reference that provides quick access inside the
     * controller to the Stage object in order to make its initialization. Note
     * that this makes Application, Controller and Stage being tightly coupled.
     */
    protected Stage stage;

    /**
     * Gets the Stage object related to this controller.
     *
     * @return The Stage object initialized by this controller.
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Sets the Stage object related to this controller.
     *
     * @param stage The Stage object to be initialized.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Set logic for this view controller
     *
     * @param iLogicProduct iogicProduct
     */
    public void setILogicProduct(ProductLogic iLogicProduct) {
        this.iLogicProduct = iLogicProduct;
    }

    /**
     * Set the user received in Login view for this view.
     *
     * @param user Userbean user
     */
    public void setUser(UserBean user) {
        this.user = user;
    }

    /**
     * User bean txoko
     */
    TxokoBean txoko;
    
    /**
     * Initializes the controller class.
     *
     * @param root root
     */
    public void initStage(Parent root) {
        try {
        LOGGER.info("Initializing Product Window.");
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Productos");
        stage.setOnShowing(this::windowShow);
        menuLogOut.setOnAction(this::logOutAction);
        btnLogOut2.setOnAction(this::logOutAction);
        idMenuEvent.setOnAction(this::eventWindow);
        idMenuExpense.setOnAction(this::expenseWindow);
        idMenuTelephon.setOnAction(this::telephoneWindow);
        idMenuUser.setOnAction(this::usersWindow);
        idMenuFTP.setOnAction(this::ftpClientWindow);
        addProduct.setOnAction(this::handleAddProduct);
        delProduct.setOnAction(this::handleDeleteProduct);
        asignProduct.setOnAction(this::handleAsignProduct);
        unasignProduct.setOnAction(this::handleUnasignProduct);
        btnReport.setOnAction(this::handlePrintAction);
        cbSearch.setOnAction(this::comboBoxOption);
        btnSearch.setOnAction(this::searchButton);
        tbProducts.getSelectionModel().selectedItemProperty()
                .addListener(this::handleUsersTableSelectionChanged);

     /*   Callback<TableColumn<ProductBean, String>, TableCell<ProductBean, String>> cellNameFactory
                = (TableColumn<ProductBean, String> p) -> new EditingCell();
        tbcolName.setCellFactory(cellNameFactory);*/
        tbcolName.setCellFactory(TextFieldTableCell.<ProductBean>forTableColumn());
        tbcolName.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        tbcolName.setOnEditCommit(new EventHandler<CellEditEvent<ProductBean, String>>() {
            @Override
            public void handle(CellEditEvent<ProductBean, String> e) {
                try {
                    ((ProductBean) tbProducts.getItems().get(
                            e.getTablePosition().getRow())).setName(e.getNewValue());
                    addUpdateProduct();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

       /* Callback<TableColumn<ProductBean, String>, TableCell<ProductBean, String>> cellDescriptionFactory
                = (TableColumn<ProductBean, String> p) -> new EditingCell();
        tbcolDescription.setCellFactory(cellDescriptionFactory);*/
        tbcolDescription.setCellFactory(TextFieldTableCell.<ProductBean>forTableColumn());
        tbcolDescription.setCellValueFactory(
                new PropertyValueFactory<>("description"));
        tbcolDescription.setOnEditCommit(new EventHandler<CellEditEvent<ProductBean, String>>() {
            @Override
            public void handle(CellEditEvent<ProductBean, String> e) {
                try {
                    ((ProductBean) tbProducts.getItems().get(
                            e.getTablePosition().getRow())).setDescription(e.getNewValue());
                    addUpdateProduct();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        /*Callback<TableColumn<ProductBean, String>, TableCell<ProductBean, String>> cellPriceFactory
                = (TableColumn<ProductBean, String> p) -> new EditingCell();
        tbcolPrice.setCellFactory(cellPriceFactory);*/
        tbcolPrice.setCellFactory(TextFieldTableCell.<ProductBean>forTableColumn());
        tbcolPrice.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        //tbcolPrice.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        tbcolPrice.setOnEditCommit(new EventHandler<CellEditEvent<ProductBean, String>>() {
            @Override
            public void handle(CellEditEvent<ProductBean, String> e) {
                try {
                    ((ProductBean) tbProducts.getItems().get(
                            e.getTablePosition().getRow())).setPrice(e.getNewValue());
                            addUpdateProduct();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

      /*  Callback<TableColumn<ProductBean, String>, TableCell<ProductBean, String>> cellStockFactory
                = (TableColumn<ProductBean, String> p) -> new EditingCell();
        tbcolStock.setCellFactory(cellStockFactory);*/
        tbcolStock.setCellFactory(TextFieldTableCell.<ProductBean>forTableColumn());
        tbcolStock.setCellValueFactory(
                new PropertyValueFactory<>("stock"));
        tbcolStock.setOnEditCommit(new EventHandler<CellEditEvent<ProductBean, String>>() {
            @Override
            public void handle(CellEditEvent<ProductBean, String> e) {
                try {
                    ((ProductBean) tbProducts.getItems().get(
                            e.getTablePosition().getRow())).setStock(e.getNewValue());
                    addUpdateProduct();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        stage.show();
        stage.setOnCloseRequest((WindowEvent e) -> {
            int cerrar = 1;
            e.consume();
            cerrarSesionAlert(cerrar);
        });
        
        

          productData = FXCollections.observableArrayList(iLogicProduct.findAllProducts());
            if(productData.isEmpty()){
                Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                dialogoAlerta.setTitle("INFORMACION");
                dialogoAlerta.setContentText("No hay ningun Producto");
                dialogoAlerta.setHeaderText("Productos Txoko");
                dialogoAlerta.showAndWait();
            }else{
                tbProducts.setItems(productData);
                productDatacopy.addAll(productData);
            }
        } catch (BusinessLogicException ex) {
            Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the window when shown.
     *
     * @param event WindowEvent event
     */
    private void windowShow(WindowEvent event){

        try {
            LOGGER.info("Beginning Product Window::windowShow");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            Date parsedDate = dateFormat.parse(user.getLastAccess());
            Timestamp timeStamp = new java.sql.Timestamp(parsedDate.getTime());
            
            LocalDate local = timeStamp.toLocalDateTime().toLocalDate();

            datePicker.setValue(local);
            datePicker.setDisable(true);
            
            lblFullName.setText(user.getFullname());
            lblTxoko.setText(user.getTxoko().getName());
            
            cbSearch.getItems().removeAll(cbSearch.getItems());
            cbSearch.getItems().addAll("Todos los productos del catalogo", "Todos los productos de mi txoko");
            cbSearch.getSelectionModel().selectFirst();
            labelError.setVisible(false);
            cbSearch.requestFocus();
            txtSearch.setDisable(true);
            btnSearch.setDisable(true);
            delProduct.setDisable(true);
            asignProduct.setDisable(true);
            unasignProduct.setDisable(true);
            addProduct.setMnemonicParsing(true);
            addProduct.setText("_Añadir Producto");
            delProduct.setMnemonicParsing(true);
            delProduct.setText("_Eliminar Producto");
            menuMenu.setMnemonicParsing(true);
            menuMenu.setText("_Menu");
            menuLogOut.setMnemonicParsing(true);
            menuLogOut.setText("_Cerrar Sesion");
            menuLogOut.setAccelerator(
                    new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
            idMenuEvent.setMnemonicParsing(true);
            idMenuEvent.setText("Ir a la ventana de E_ventos");
            idMenuEvent.setAccelerator(
                    new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
            
            btnLogOut2.setMnemonicParsing(true);
            btnLogOut2.setText("_Cerrar Sesion");
            
            txoko = user.getTxoko();
        } catch (ParseException ex) {
            Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Method that change the selection of the table
     *
     * @param observable
     * @param oldValue
     * @param newValue
     */
    private void handleUsersTableSelectionChanged(ObservableValue observable,
            Object oldValue,
            Object newValue) {
        if (newValue != null) {
            delProduct.setDisable(false);
        } else {
            delProduct.setDisable(true);
        }
    }

    /**
     * Action event handler for create button. It validates new user data, send
     * it to the business logic tier and updates product table view with new
     * product data.
     *
     * @param event The ActionEvent object for the event.
     */
    private void handleAddProduct(ActionEvent event) {
        try {
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CONFIRMACION");
            dialogoAlerta.setContentText("¿Estas seguro que deseas añadir un producto?");
            dialogoAlerta.setHeaderText("Añadir un producto");
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
            Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("buttonAdd");
            Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setId("buttonCancel");

            if (result.get() == ButtonType.OK) {

                tbProducts.setEditable(true);
                ProductBean product = new ProductBean();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        tbProducts.requestFocus();
                        tbProducts.getSelectionModel().selectLast();
                        tbProducts.getFocusModel().focus(0);
                    }
                });

                tbProducts.getItems().add(product);
                tbProducts.refresh();

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,
                    "PC07ProductsController: Error adding product: {0}",
                    e.getMessage());
        }
    }

    /**
     * This method assigns a product to txoko. First check that the product
     * already exists in the txoko. If the product already exists, notify
     * through a dialogue. If it does not exist, give the option to add it or
     * not through another confirmation dialog.
     *
     * @param event
     */
    private void handleAsignProduct(ActionEvent event) {
        try {
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            boolean esta = false;
            List productequals = new ArrayList<>();
            ProductBean selectedProduct = tbProducts.getSelectionModel().getSelectedItem();
            List<ProductBean> selectedProduct2 = new ArrayList<>();
            selectedProduct2.add(selectedProduct);
            String idTxoko = user.getTxoko().getIdTxoko().toString();
            List<ProductBean> productos = iLogicProduct.findAllProductsByTxoko(idTxoko);
            List<TxokoBean> txokos = new ArrayList<>();
            txokos.add(txoko);
            selectedProduct.setTxokos(txokos);

            for (ProductBean product : productos) {
                productequals = selectedProduct2.stream().filter(p -> p.getIdProduct().equals(product.getIdProduct())).collect(Collectors.toList());
                if (!productequals.isEmpty()) {
                    dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                    dialogoAlerta.setTitle("ERROR");
                    dialogoAlerta.setContentText("El producto ya existe en el Txoko!!");
                    dialogoAlerta.setHeaderText("Añadir un producto al txoko");
                    dialogoAlerta.showAndWait();
                    esta = true;
                    break;
                }
            }
            if (!esta) {

                dialogoAlerta.setTitle("CONFIRMACION");
                dialogoAlerta.setContentText("¿Estas seguro que deseas añadir el producto al txoko?");
                dialogoAlerta.setHeaderText("Añadir un producto al txoko");
                Optional<ButtonType> result = dialogoAlerta.showAndWait();
                Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
                okButton.setId("buttonAdd");
                Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
                cancelButton.setId("buttonCancel");

                if (result.get() == ButtonType.OK) {

                    this.iLogicProduct.updateProduct(selectedProduct);

                    tbProducts.refresh();

                } 
            }
        } catch (BusinessLogicException e) {
            LOGGER.log(Level.SEVERE,
                    "PC07ProductsController: Error adding product: {0}",
                    e.getMessage());
        }
    }

    /**
     * Action event handler for unasign button. It asks user for confirmation on
     * unasign product from Txoko
     *
     * @param event
     */
    private void handleUnasignProduct(ActionEvent event) {
        try {
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CONFIRMACION");
            dialogoAlerta.setContentText("¿Estas seguro que deseas quitar el producto del txoko?");
            dialogoAlerta.setHeaderText("Quitar un producto del txoko");
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
            Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("buttonAdd");
            Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setId("buttonCancel");

            ProductBean selectedProduct = ((ProductBean) tbProducts.getSelectionModel().getSelectedItem());

            if (result.get() == ButtonType.OK) {
                
                List<TxokoBean> txoko = new ArrayList<>();
                TxokoBean aux = new TxokoBean();
                String idTxoko = user.getTxoko().getIdTxoko().toString();
                aux.setIdTxoko(Integer.parseInt(idTxoko));
                txoko.remove(aux);
                selectedProduct.setTxokos(txoko);

                this.iLogicProduct.updateProduct(selectedProduct);

                tbProducts.getItems().remove(tbProducts.getSelectionModel().getSelectedItem());
                tbProducts.refresh();
            } 
        } catch (BusinessLogicException e) {
            LOGGER.log(Level.SEVERE,
                    "PC07ProductsController: Error adding product: {0}",
                    e.getMessage());
        }
    }

    /**
     * Action event handler for delete button. It asks user for confirmation on
     * delete, sends delete message to the business logic tier and updates user
     * table view.
     *
     * @param ev The ActionEvent object for the event.
     */
    private void handleDeleteProduct(ActionEvent ev) {
        boolean isSelected = isSelected();
        try {
            if (isSelected) {

                Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoAlerta.setTitle("CONFIRMACION");
                dialogoAlerta.setContentText("¿Estas seguro que deseas eliminar un producto?");
                dialogoAlerta.setHeaderText("Eliminar un producto");
                Optional<ButtonType> resultado = dialogoAlerta.showAndWait();
                Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
                okButton.setId("buttonDelete");
                Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
                cancelButton.setId("buttonNotDelete");
                if (resultado.get() == ButtonType.OK) {
                    ProductBean selectedProduct = ((ProductBean) tbProducts.getSelectionModel()
                            .getSelectedItem());
                    this.iLogicProduct.deleteProduct(selectedProduct);
                    tbProducts.getItems().remove(tbProducts.getSelectionModel().getSelectedItem());
                    tbProducts.refresh();
                } 

            } else {

                Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
                dialogoAlerta.setTitle("ERROR");
                dialogoAlerta.setContentText("Tienes que seleccionar una fila!!");
                dialogoAlerta.setHeaderText("Eliminar un producto");
                dialogoAlerta.showAndWait();
            }
        } catch (BusinessLogicException e) {
            LOGGER.log(Level.SEVERE,
                    "PC07ProductsController: Error deleting user: {0}",
                    e.getMessage());
        }
    }

    /**
     * This method is to go to the eventPane
     *
     * @param ev event
     */
    public void eventWindow(ActionEvent ev) {
        LOGGER.info("clickOn Products Menu");
        try {
            EventLogic iLogicEvent = ILogicFactory.getEventLogic();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC05Events.fxml"));
            Parent root = (Parent) loader.load();
            PC05EventsController controller = (PC05EventsController) loader.getController();
            controller.setILogic(iLogicEvent);
            controller.setStage(stage);
            controller.setUser(user);
            controller.initStage(root);
            cbSearch.requestFocus();
            stage.hide();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }

    /**
     * This method is to go to the telephonePane
     *
     * @param ev event
     */
    public void telephoneWindow(ActionEvent ev) {
        LOGGER.info("clickOn Telephone Menu");
        try {
            TelephoneLogic iLogicTelephone = ILogicFactory.getTelephoneLogic();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC08PhoneNumbers.fxml"));
            Parent root = (Parent) loader.load();
            PC08PhoneNumbersController controller = (PC08PhoneNumbersController) loader.getController();
            controller.setILogic(iLogicTelephone);
            controller.setStage(stage);
            controller.setUser(user);
            controller.initStage(root);
            cbSearch.requestFocus();
            stage.hide();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }

    /**
     * This method is to go to the expensePane
     *
     * @param ev event
     */
    public void expenseWindow(ActionEvent ev) {
        LOGGER.info("clickOn Gastos Menu");
        try {
            ExpenseLogic iLogicExpense = ILogicFactory.getExpenseLogic();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC04Expense.fxml"));
            Parent root = (Parent) loader.load();
            PC04ExpenseController controller = (PC04ExpenseController) loader.getController();
            controller.setILogic(iLogicExpense);
            controller.setStage(stage);
            controller.setUser(user);
            controller.initStage(root);
            cbSearch.requestFocus();
            stage.hide();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }

    /**
     * This method is to go to the userPane .
     *
     * @param ev event
     */
    public void usersWindow(ActionEvent ev) {
        LOGGER.info("clickOn User Menu");
        try {
            UserLogic iLogicUser = ILogicFactory.getUserLogic();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC03User.fxml"));
            Parent root = (Parent) loader.load();
            PC03UserController controller = (PC03UserController) loader.getController();
            controller.setILogic(iLogicUser);
            controller.setUser(user);
            controller.setStage(stage);
            controller.initStage(root);
            cbSearch.requestFocus();
            stage.hide();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }

    /**
     * This method is to go to the ftpWindow
     *
     * @param ev event
     */
    public void ftpClientWindow(ActionEvent ev) {
        LOGGER.info("clickOn FTP Client btn");
        try {
            FTPClientLogic iLogic = ILogicFactory.getFTPClientLogic();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC06FTPClient.fxml"));
            Parent root = (Parent) loader.load();
            PC06FTPClientController controller = (PC06FTPClientController) loader.getController();
            controller.setILogic(iLogic);
            controller.setStage(stage);
            controller.initStage(root);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }

    /**
     * This metho change the options when clicked in the combo box
     * 
     * @param ev event
     */
    public void comboBoxOption(ActionEvent ev) {
        LOGGER.info("clickOn combo box");
        switch (cbSearch.getSelectionModel().getSelectedItem()) {
            case "Todos los productos de mi txoko":
                try {
                    String idTxoko = user.getTxoko().getIdTxoko().toString();
                    productDatacopy = iLogicProduct.findAllProductsByTxoko(idTxoko);
                    labelError.setVisible(false);
                    tbProducts.setEditable(true);
                    asignProduct.setDisable(true);
                    unasignProduct.setDisable(false);
                    addProduct.setDisable(true);
                    btnSearch.setDisable(true);
                    txtSearch.setDisable(true);
                    productData = FXCollections.observableArrayList(iLogicProduct.findAllProductsByTxoko(idTxoko));
                    if (productData == null) {
                        Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                        dialogoAlerta.setTitle("INFORMACION");
                        dialogoAlerta.setHeaderText("No hay productos en la lista");
                        dialogoAlerta.showAndWait();
                    } else {
                        tbProducts.setItems(productData);
                    }
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Todos los productos del catalogo":
                try {
                    productDatacopy = iLogicProduct.findAllProducts();
                    labelError.setVisible(false);
                    tbProducts.setEditable(true);
                    asignProduct.setDisable(false);
                    unasignProduct.setDisable(true);
                    addProduct.setDisable(false);
                    btnSearch.setDisable(true);
                    txtSearch.setDisable(true);
                    productData = FXCollections.observableArrayList(iLogicProduct.findAllProducts());
                    if (productData == null) {
                        Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                        dialogoAlerta.setTitle("INFORMACION");
                        dialogoAlerta.setHeaderText("No hay productos en la lista");
                        dialogoAlerta.showAndWait();
                    } else {
                        tbProducts.setItems(productData);
                    }
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
    }

    /**
     * This method is for the search button. When you click on the button, first
     * check that text field it isn't empty, if it is empty, a label error
     * appears with a message. Also check that the size does not exceed 255
     * characters. If the conditions are ok, the method stores the telephones in
     * a collection, if the collection is empty, a dialogue with the message
     * appears.
     *
     * @param ev event
     */
    public void searchButton(ActionEvent ev) {
        txtSearch.setDisable(false);
        LOGGER.info("clickOn search button");
        labelError.setVisible(false);
        txtSearch.setStyle("-fx-border-color: -fx-box-border;");
        if (cbSearch.getSelectionModel().getSelectedItem().equals("Id del producto")) {
            productData = null;
            boolean tfIDEmpty = textEmptyOrNot();
            if (tfIDEmpty) {
                if (txtSearch.getText().trim().length() < MAX_CARACT) {
                    try {
                        String idProduct = txtSearch.getText();
                        productData = FXCollections.observableArrayList(iLogicProduct.findProductById(idProduct));
                        if (productData.isEmpty()) {
                            Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                            dialogoAlerta.setTitle("INFORMACION");
                            dialogoAlerta.setHeaderText("No hay productos en la lista");
                            dialogoAlerta.showAndWait();
                        } else {
                            tbProducts.setItems(productData);
                        }
                    } catch (BusinessLogicException ex) {
                        Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IdNotOkException e) {
                        LOGGER.log(Level.SEVERE,
                            " Error reading event BY ID: {0}",
                            e.getMessage());
                        labelError.setText("Id del produco incorrecto");
                        labelError.setVisible(true);
                        labelError.setStyle("-fx-text-inner-color: red;");
                    }
                } else {
                    txtSearch.setStyle("-fx-border-color: red;");
                    labelError.setText("Demasiados Caracteres!!!");
                    labelError.setVisible(true);
                    labelError.setStyle("-fx-text-inner-color: red;");
                }
            } else {
                txtSearch.setStyle("-fx-border-color: red;");
                labelError.setText("Tienes que escribir el id de un producto");
                labelError.setVisible(true);
                labelError.setStyle("-fx-text-inner-color: red;");
            }
        } else if (cbSearch.getSelectionModel().getSelectedItem().equals("Nombre del producto")) {
            productData = null;
            boolean tfNameEmpty = textEmptyOrNot();
            if (tfNameEmpty) {
                if (txtSearch.getText().trim().length() < MAX_CARACT) {
                    try {
                        String nameProduct = txtSearch.getText().trim();
                        String idTxoko = user.getTxoko().getIdTxoko().toString();
                        productData = FXCollections.observableArrayList(iLogicProduct.findProductByName(nameProduct, idTxoko));
                        if (productData.isEmpty()) {
                            Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                            dialogoAlerta.setTitle("INFORMACION");
                            dialogoAlerta.setHeaderText("No hay productos en la lista");
                            dialogoAlerta.showAndWait();
                        } else {
                            tbProducts.setItems(productData);
                        }
                    } catch (BusinessLogicException ex) {
                        Logger.getLogger(PC07ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NameNotOkException e) {
                        LOGGER.log(Level.SEVERE,
                                " Error reading event BY NAME: {0}",
                                e.getMessage());            
                        labelError.setText("Nombre del producto incorrecto");
                        labelError.setVisible(true);
                        labelError.setStyle("-fx-text-inner-color: red;");
                    }
                } else {
                    txtSearch.setStyle("-fx-border-color: red;");
                    labelError.setText("Demasiados Caracteres!!!");
                    labelError.setVisible(true);
                    labelError.setStyle("-fx-text-inner-color: red;");
                }
            } else {
                txtSearch.setStyle("-fx-border-color: red;");
                labelError.setText("Tienes que escribir el nombre del producto");
                labelError.setVisible(true);
                labelError.setStyle("-fx-text-inner-color: red;");
            }
        }
    }

    /**
     * This method compares the data in the table with the data in the database
     * to update or to create a new product. In a list, keep all the products
     * that are in the database and in another list the products in the table.
     * First check if all the fields are informed. If yes, compare the two lists
     * and if a product is repeated, keep it in a third list. If the third list
     * contains any product, update the product, otherwise create the product.
     *
     */
    private void addUpdateProduct() throws BusinessLogicException {
        labelError.setVisible(false);
        List<ProductBean> productos = tbProducts.getItems();
        boolean modif = false;
        String idTxoko = user.getTxoko().getIdTxoko().toString();

        for (ProductBean product : productos) {
            if (product.getName() != null && !product.getName().trim().isEmpty()
                    && product.getDescription() != null && !product.getDescription().trim().isEmpty()
                    && product.getPrice() != null && !product.getPrice().trim().isEmpty()
                    && product.getStock() != null && !product.getStock().trim().isEmpty()) {
                List productequals = productDatacopy.stream().filter(p -> p.getIdProduct().equals(product.getIdProduct())).collect(Collectors.toList());
                if (productequals.isEmpty()) {
                    addProduct(product);
                    modif = true;
                    break;
                } else if (!productequals.get(0).equals(product)) {
                    updateProduct(product);
                    modif = true;
                    break;
                }
            }
        }
        if(modif==true){
            switch(cbSearch.getSelectionModel().getSelectedItem()){
                case "Todos los productos de mi txoko":
                    productDatacopy = iLogicProduct.findAllProductsByTxoko(idTxoko);
                    break;
                case "Todos los productos del catalogo":
                    productDatacopy = iLogicProduct.findAllProducts();
                    break;
                default:
                    productDatacopy = iLogicProduct.findAllProducts();
                    break;
            }
            
        }
    }
    /**
     * This method is to add the selected product in the table. First ask for
     * the confirmation, if it is positive, add the product and confirm it in a
     * dialog box. If it is negative, give the confirmation in a dialog and
     * don't add it.
     *
     * @param product
     * @throws BusinessLogicException
     */
    private void addProduct(ProductBean product) throws BusinessLogicException {

        Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("CONFIRMACION");
        dialogoAlerta.setContentText("¿Estas seguro que deseas añadir el producto " + product.getName() + " " + product.getDescription() + "?");
        dialogoAlerta.setHeaderText("Añadir un producto");
        Optional<ButtonType> result = dialogoAlerta.showAndWait();
        Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("buttonAdd");
        Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setId("buttonCancel");

        if (result.get() == ButtonType.OK) {
            if (product.getName().trim().length() < MAX_CARACT && product.getDescription().trim().length() < MAX_CARACT &&
                    product.getPrice().trim().length() < MAX_CARACT && product.getStock().trim().length() < MAX_CARACT) {
                
                iLogicProduct.createProduct(product);

            }else{
                labelError.setText("Demasiados Caracteres!!!");
                labelError.setVisible(true);
                labelError.setStyle("-fx-text-inner-color: red;");
            }
        } 
    }

    /**
     * This method is to update the selected product in the table. First ask for
     * the confirmation, if it is positive, update the product and confirm it in
     * a dialog box. If it is negative, give the confirmation in a dialog and
     * don't update it.
     *
     * @param product
     * @throws BusinessLogicException
     */
    private void updateProduct(ProductBean product) throws BusinessLogicException {

        Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("CONFIRMACION");
        dialogoAlerta.setContentText("¿Estas seguro que deseas actualizar al producto " + product.getName() + " " + product.getDescription() + "?");
        dialogoAlerta.setHeaderText("Actualizar un producto");
        Optional<ButtonType> result = dialogoAlerta.showAndWait();
        Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("buttonAdd");
        Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setId("buttonCancel");

        if (result.get() == ButtonType.OK) {
            if (product.getName().trim().length() < MAX_CARACT && product.getDescription().trim().length() < MAX_CARACT &&
                    product.getPrice().trim().length() < MAX_CARACT && product.getStock().trim().length() < MAX_CARACT) {
                iLogicProduct.updateProduct(product);
            }else{
                labelError.setText("Demasiados caracteres!!!");
                labelError.setVisible(true);
                labelError.setStyle("-fx-text-inner-color: red;");
            }
        }else{
            tbProducts.refresh();
        }
    }

    /**
     * This method prints a report with the data of the products in the table.
     *
     * @param event
     */
    @FXML
    private void handlePrintAction(ActionEvent event) {
        Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("CONFIRMACION");
        dialogoAlerta.setContentText("¿Estas seguro que deseas imprimir la lista de productos?");
        dialogoAlerta.setHeaderText("Imprimir Reporte");
        Optional<ButtonType> resultado = dialogoAlerta.showAndWait();
        Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("buttonDelete");
        Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setId("buttonNotDelete");
        
        if (resultado.get() == ButtonType.OK) {
            try {
                JasperReport report
                        = JasperCompileManager.compileReport(getClass()
                                .getResourceAsStream("/jampclientside/ui/report/products.jrxml"));
                //Data for the report: a collection of UserBean passed as a JRDataSource 
                //implementation 
                JRBeanCollectionDataSource dataItems
                        = new JRBeanCollectionDataSource((Collection<ProductBean>) this.tbProducts.getItems());
                //Map of parameter to be passed to the report
                Map<String, Object> parameters = new HashMap<>();
                //Fill report with data
                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataItems);
                //Create and show the report window. The second parameter false value makes 
                //report window not to close app.
                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setVisible(true);
                // jasperViewer.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            } catch (JRException ex) {
                    dialogoAlerta = new Alert(Alert.AlertType.ERROR);
                    dialogoAlerta.setTitle("ERROR");
                    dialogoAlerta.setContentText("No se ha podido imprimir el informe!!");
                    dialogoAlerta.setHeaderText("Imprimir Informe");
                    dialogoAlerta.showAndWait();
                LOGGER.log(Level.SEVERE,
                        "PC07ProductsController: Error printing report: {0}",
                        ex.getMessage());
            }
        } 
    }

    /**
     * This method checks if the field is empty
     *
     * @return boolean, is empty, return true, if not, return false
     */
    private boolean textEmptyOrNot() {
        boolean empty = false;
        //si no esta vacio
        if (!this.txtSearch.getText().trim().equals("")) {
            empty = true;
        }
        return empty;
    }

    /**
     * This method checks if the row of the table is selected
     *
     * @return boolean is selected return true, is not selected return false
     */
    private boolean isSelected() {
        boolean isSelected = false;
        if (!tbProducts.getSelectionModel().getSelectedItems().isEmpty()) {
            isSelected = true;
        }
        return isSelected;
    }

    /**
     * Close current view and open Login view method.
     *
     * @param event Action Event
     */
    public void logOutAction(ActionEvent event) {
        LOGGER.info("Beginning Productos::logout action");
        cerrar = 2;
        cerrarSesionAlert(cerrar);
    }

    /**
     * Method that show a confirm dialog to close session
     *
     * @param cerrar Difference for close app or close session
     */
    public void cerrarSesionAlert(int cerrar) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Dialogo de confirmacion");
        alert.setContentText("Estas seguro que deseas cerrar la sesion");
        alert.setHeaderText("Cerrar Sesion");

        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("okButton");

        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setId("cancelButton");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (cerrar == 1) {
                System.exit(0);
            } else {
                stage.hide();
            }
        }
    }
/*
    public class EditingCell extends TableCell<ProductBean, String> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.focusedProperty().addListener(
                    (ObservableValue<? extends Boolean> arg0,
                            Boolean arg1, Boolean arg2) -> {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                    });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
*/


}
