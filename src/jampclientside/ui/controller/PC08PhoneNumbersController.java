/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.ui.controller;

import jampclientside.entity.TelephoneBean;
import jampclientside.entity.UserBean;
import jampclientside.exceptions.BusinessLogicException;
import jampclientside.logic.EventLogic;
import jampclientside.logic.ExpenseLogic;
import jampclientside.logic.FTPClientLogic;
import jampclientside.logic.ILogicFactory;
import jampclientside.logic.ProductLogic;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import jampclientside.logic.TelephoneLogic;
import jampclientside.logic.UserLogic;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Julen
 */
public class PC08PhoneNumbersController{
    private TextField textField;
    
    
    /**
     * Maximum characters that can be inserted
     */
    private static final int MAX_CARACT = 255;

    /**
     * Attribute to appear the information text.
     */
    private static final Logger LOGGER = Logger.getLogger("package.class");
   
     /**
     * The Stage object associated to the Scene controlled by this controller.
     * This is an utility method reference that provides quick access inside the
     * controller to the Stage object in order to make its initialization. Note
     * that this makes Application, Controller and Stage being tightly coupled.
     */
    private Stage stage;
   
    /**
     * The TelephoneiLogic
     */
    private TelephoneLogic ilogicTelephone;
   
    /**
     * The UserBean user
     */
    private UserBean user;

    /**
     * the tooltip for id
     */
    private final Tooltip tooltipID = new Tooltip();
   
    /**
     * The tooltip for name
     */
    private final Tooltip tooltipName = new Tooltip();
    
    /**
     * Vbox pricipaPane
     */
    @FXML
    private VBox principalPane;
    
    /**
     * Menu item for expense 
     */
    @FXML
    private MenuItem idMenuExpense;
    
    /**
     * Menu item for product
     */
    @FXML
    private MenuItem idMenuProduct;
   
    /**
     * Menu item or user
     */
    @FXML
    private MenuItem idMenuUser;
    
    /**
     * Menu item for event
     */
    @FXML
    private MenuItem idMenuEvent;
    
    /**
     * Menu item for FTP
     */
    @FXML
    private MenuItem idMenuFTP;
   
    /**
     * The menu bar
     */
    @FXML
    private MenuBar menuBar;
   
    /**
     * The menu menu
     */
    @FXML
    private Menu menuMenu;
   
    /**
     * The item for log out
     */
    @FXML
    private MenuItem menuLogOut;
   
    /**
     * the menu event
     */
    @FXML
    private Menu menuEvent;
    
    /**
     * the menu for expenses
     */
    @FXML
    private Menu menuGastos;
   
    /**
     * the menu for products
     */
    @FXML
    private Menu menuProductos;
   
    /**
     * the menu for users
     */
    @FXML
    private Menu menuUsuarios;
   
    /**
     * the menu for telephones
     */
    @FXML
    private Menu menuTelefonos;
    
    /**
     * the label for date
     */
    @FXML
    private Label lblDate;
    
    /**
     * the lable for login
     */
    @FXML
    private Label lblLogin;
    
    /**
     * the label for fullName
     */
    @FXML
    private Label lblFullName;
    
    /**
     * the label for email
     */
    @FXML
    private Label lblEmail;
   
    /**
     * the label for txoko
     */
    @FXML
    private Label lblTxoko;
    
    /**
     * the text field for search
     */
    @FXML
    private TextField txtSearchTel;
    
    /**
     * thebutton for search
     */
    @FXML
    private Button btnSearchTel;
   
    /**
     * the laber for errors
     */
    @FXML
    private Label labelError;
   
    /**
     * the button for add telephones
     */
    @FXML
    private Button addTelephone;
    
    /**
     * the button for delete telephones
     */
    @FXML
    private Button delTelephone;
   
    /**
     * the button fo log out
     */
    @FXML
    private Button btnLogOut2;
   
    /**
     * the Tabe view for telephones
     */
    @FXML
    private TableView<TelephoneBean> tbTelephone;
    
    /**
     * the combo box for telephones
     */
    @FXML
    private ComboBox<String> cbSearchTel;
    
    /**
     * the table colum for name 
     */
    @FXML
    private TableColumn tbcolName;
    
    /**
     * the table column for description
     */
    @FXML
    private TableColumn tbcolDescription;
   
    /**
     * the table column for telephone number
     */
    @FXML
    private TableColumn tbcolTelephone;
    
    /**
     * the table column for town
     */
    @FXML
    private TableColumn tbcolTown;
    
    /**
     * The date picker for last access
     */
    @FXML
    private DatePicker datePicker;
   
    /**
     * The label for requiredTel
     */
    @FXML
    private Label requiredTel;

    /**
     * the obseable list for telephones data
     */
    private ObservableList<TelephoneBean> telephoneData;
    
    /**
     * the integer forclose window
     */
    private int cerrar;

    /**
     * The business logic object containing all business methods.
     */
    private TelephoneLogic iLogicTelephone;

    /**
     * Telephone object
     */
    private TelephoneBean telephone;
    
    /**
     * the List for Telephonebean data copy
     */
    private List<TelephoneBean> telephoneDatacopy = new ArrayList<>();

    /**
     * Getter of stage
     * 
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Setter stage
     * 
     * @param stage the stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Setter ilogicTelephone
     * 
     * @param iLogicTelephone iLogicTelephone
     */
    public void setILogic(TelephoneLogic iLogicTelephone) {
        this.iLogicTelephone = iLogicTelephone;
    }

    /**
     * Setter for user
     * 
     * @param user the user wo is login
     */
    public void setUser(UserBean user) {
        this.user = user;

    }

    /**
     * Initializes the controller class.
     *
     * @param root root
     * @throws java.io.IOException InputOuput exception
     */
    public void initStage(Parent root) throws IOException {
        LOGGER.info("Initializing Telephone stage.");
        //Create a scene associated to the node graph root.
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        //Associate scene to primaryStage(Window)
        stage.setScene(scene);
        //Set window properties
        stage.setTitle("Telefonos");
        //Set window's events handlers
        stage.setOnShowing(this::windowShow);
        //menu item de cerrar sesion
        menuLogOut.setOnAction(this::logOutAction);
        //boton de cerrar sesion
        btnLogOut2.setOnAction(this::logOutAction);
        //ir a la ventana de productos
        idMenuProduct.setOnAction(this::productWindow);
        //ir a la ventana de eventos
        idMenuEvent.setOnAction(this::eventWindow);
        //gastos
        idMenuExpense.setOnAction(this::expenseWindow);
        //ventana de los usuarios
        idMenuUser.setOnAction(this::usersWindow);
        //ventana de los usuarios
        idMenuFTP.setOnAction(this::FTPClientWindow);
        //boton añadir evento
        addTelephone.setOnAction(this::handleAddTelephone);
        //boton eleminar evento
        delTelephone.setOnAction(this::handleDeleteTelephone);
        //dependiendo la opcion que pulse del combo box
        cbSearchTel.setOnAction(this::comboBoxOption);
        //boton de busqueda
        btnSearchTel.setOnAction(this::searchButton);
        tbcolName.setCellFactory(TextFieldTableCell.<TelephoneBean>forTableColumn());
        tbcolName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TelephoneBean, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<TelephoneBean,String> e) {
                try {
                    ((TelephoneBean) tbTelephone.getItems().get(
                            e.getTablePosition().getRow())
                            ).setName(e.getNewValue());
                    addUpdateTelephone();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tbcolDescription.setCellFactory(TextFieldTableCell.<TelephoneBean>forTableColumn());
        tbcolDescription.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TelephoneBean, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<TelephoneBean,String> e) {
                try {
                    ((TelephoneBean) tbTelephone.getItems().get(
                            e.getTablePosition().getRow())
                            ).setDescription(e.getNewValue());
                    addUpdateTelephone();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tbcolTelephone.setCellFactory(TextFieldTableCell.<TelephoneBean>forTableColumn());
        tbcolTelephone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TelephoneBean, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<TelephoneBean,String> e) {
                try {
                    ((TelephoneBean) tbTelephone.getItems().get(
                            e.getTablePosition().getRow())
                            ).setTelephone(e.getNewValue());
                    addUpdateTelephone();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tbcolTown.setCellFactory(TextFieldTableCell.<TelephoneBean>forTableColumn());
        tbcolTown.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TelephoneBean, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<TelephoneBean,String> e) {
                try {
                    ((TelephoneBean) tbTelephone.getItems().get(
                            e.getTablePosition().getRow())
                            ).setTown(e.getNewValue());
                    addUpdateTelephone();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //las columnas van a coger el valor de los atributos
        tbTelephone.getSelectionModel().selectedItemProperty()
                .addListener(this::handleUsersTableSelectionChanged);
        tbcolDescription.setCellValueFactory(
                new PropertyValueFactory<>("description"));
        tbcolName.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        tbcolTelephone.setCellValueFactory(
                new PropertyValueFactory<>("telephone"));
        tbcolTown.setCellValueFactory(
                new PropertyValueFactory<>("town"));
        //Show primary window
        stage.show();
        stage.setOnCloseRequest((WindowEvent e) -> {
            cerrar = 1;
            e.consume();
            cerrarSesionAlert(cerrar);
            
        });
        try{
            boolean ok = iLogicTelephone.startConnection();
            
            telephoneData = FXCollections.observableArrayList(iLogicTelephone.findAllTelephone());
            if(telephoneData.isEmpty()){
                cbSearchTel.setDisable(true);
                addTelephone.setDisable(true);
                Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                dialogoAlerta.setTitle("INFORMACION");
                dialogoAlerta.setContentText("No hay telefonos en la base de datos!!!");
                dialogoAlerta.setHeaderText("Ventana Telefonos");
                dialogoAlerta.showAndWait();
            }else{
                tbTelephone.setItems(telephoneData);
                telephoneDatacopy.addAll(telephoneData);
            }
        }catch(Exception e){
                LOGGER.log(Level.SEVERE,
                        "PC08TelephoneController: Error Connection: {0}",
                        e.getMessage());
                Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
                dialogoAlerta.setTitle("ATENCION");
                dialogoAlerta.setContentText("Comprueba tu conexion a Mongo!!!");
                dialogoAlerta.setHeaderText("Ventana Telefonos");
                dialogoAlerta.showAndWait();
        }
    }

    /**
     * Initializes the window when shown.
     *
     * @param event WindowEvent event
     */
    private void windowShow(WindowEvent event) {
        try {
            LOGGER.info("Beginning Telephone window::windowShow");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            Date parsedDate = dateFormat.parse(user.getLastAccess());
            Timestamp timeStamp = new java.sql.Timestamp(parsedDate.getTime());
            
            LocalDate local = timeStamp.toLocalDateTime().toLocalDate();
            
            datePicker.setValue(local);
            datePicker.getEditor().setDisable(true);
            
            lblFullName.setText(user.getFullname());
            lblTxoko.setText(user.getTxoko().getName());
            
            cbSearchTel.getItems().removeAll(cbSearchTel.getItems());
            cbSearchTel.getItems().addAll("Todos los telefonos del catalogo", "Nombre del telefono", "Poblacion");
            cbSearchTel.getSelectionModel().selectFirst();
            labelError.setVisible(false);
            cbSearchTel.requestFocus();
            txtSearchTel.setDisable(true);
            tbTelephone.setEditable(true);
            btnSearchTel.setDisable(true);
            delTelephone.setDisable(true);
            addTelephone.setMnemonicParsing(true);
            addTelephone.setText("_Añadir Telefono");
            delTelephone.setMnemonicParsing(true);
            delTelephone.setText("_Eliminar Telefono");
            menuMenu.setMnemonicParsing(true);
            menuMenu.setText("_Menu");
            menuLogOut.setMnemonicParsing(true);
            menuLogOut.setText("_Cerrar Sesion");
            menuLogOut.setAccelerator(
                    new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
            btnLogOut2.setMnemonicParsing(true);
            btnLogOut2.setText("_Cerrar Sesion");
        } catch (ParseException ex) {
            Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method that change the selection of the table
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleUsersTableSelectionChanged(ObservableValue observable,
             Object oldValue,
             Object newValue) {
        if(newValue!=null){
            delTelephone.setDisable(false);
        }else{
            delTelephone.setDisable(true);
        }   
    }

    /**
     * Action event handler for create button. 
     * It validates new user data, send it to the business logic 
     * tier and updates telephone table view with new telephone data.
     * 
     * @param ev event for add telephone
     */
    public void handleAddTelephone(ActionEvent ev) {
        try{
        Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("CONFIRMACION");
        dialogoAlerta.setContentText("¿Estas seguro que deseas añadir un telefono?");
        dialogoAlerta.setHeaderText("Añadir un telefono");
        Optional<ButtonType> result = dialogoAlerta.showAndWait();
        Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("buttonAdd");
        Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setId("buttonCancel");

        if (result.get() == ButtonType.OK) {

            TelephoneBean event = new TelephoneBean();
            
            Platform.runLater(new Runnable() 
            { 
                @Override 
                public void run() 
                { 
                 tbTelephone.requestFocus(); 
                 tbTelephone.getSelectionModel().selectLast();
                 tbTelephone.getFocusModel().focus(0); 
                } 
            }); 

            tbTelephone.getSelectionModel().selectFirst();
            
            tbTelephone.getItems().add(event);
            tbTelephone.refresh();

        }

        }catch(Exception e){
            LOGGER.log(Level.SEVERE,
                    "PC08TelephoneController: Error adding telephone: {0}",
                    e.getMessage());
        }
    }
    
    /**
     * Action event handler for delete button. It asks user for confirmation on
     * delete, sends delete message to the business logic tier and updates user
     * table view.
     * 
     * @param ev event for delete telephone
     */
    public void handleDeleteTelephone(ActionEvent ev) {
        boolean isSelected = isSelected();
        if (isSelected) {
            TelephoneBean selectedTelephone=((TelephoneBean)tbTelephone.getSelectionModel()
                    .getSelectedItem());
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CONFIRMACION");
            dialogoAlerta.setContentText("¿Estas seguro que deseas eliminar telefono:" + selectedTelephone.getName()+"?");
            dialogoAlerta.setHeaderText("Eliminar un telefono");
            Optional<ButtonType> resultado = dialogoAlerta.showAndWait();
            Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("buttonDelete");
            Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setId("buttonNotDelete");
            if (resultado.get() == ButtonType.OK) {
                try {
                    this.iLogicTelephone.deleteTelephone(selectedTelephone);
                    
                    tbTelephone.getItems().remove(tbTelephone.getSelectionModel().getSelectedItem());
                    tbTelephone.refresh();
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {

            Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
            dialogoAlerta.setTitle("ERROR");
            dialogoAlerta.setContentText("Tienes que seleccionar una fila!!");
            dialogoAlerta.setHeaderText("Eliminar un telfono");
            dialogoAlerta.showAndWait();
        }
    }

    /**
     * This method is to go to the eventPane
     * 
     * @param ev event to go to event window
     */
    public void eventWindow(ActionEvent ev) {
        LOGGER.info("clickOn Event Menu");
        try {
            EventLogic iLogicEvent = ILogicFactory.getEventLogic();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC05EventsController.fxml"));
            Parent root = (Parent) loader.load();
            PC05EventsController controller = (PC05EventsController) loader.getController();
            controller.setILogic(iLogicEvent);
            controller.setStage(stage);
            controller.initStage(root);
            cbSearchTel.requestFocus();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }

    }

    /**
     * This method is to go to the productPane
     * 
     * @param ev evet to go to prodcut window
     */
    public void productWindow(ActionEvent ev) {
        LOGGER.info("clickOn Telephone Menu");
        try {
            ProductLogic iLogicProduct = ILogicFactory.getProductLogic();
            //instancio el xml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC07Products.fxml"));
            //lo cargo en el root que es de tipo parent
            Parent root = (Parent) loader.load();
            //obtener el controlador
            PC07ProductsController controller = (PC07ProductsController) loader.getController();
            //le mando el objeto logica al controlador 
            controller.setILogicProduct(iLogicProduct);
            controller.setUser(user);
            //a ese controlador le paso el stage
            controller.setStage(stage);
            //inizializo el stage
            controller.initStage(root);
            cbSearchTel.requestFocus();
            stage.hide();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }

    }

    /**
     * This method is to go to the expensePane
     * 
     * @param ev event to go to expense window
     */
    public void expenseWindow(ActionEvent ev) {
        LOGGER.info("clickOn Gastos Menu");
        try {
            ExpenseLogic iLogicExpense = ILogicFactory.getExpenseLogic();
            //instancio el xml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC04Expense.fxml"));
            //lo cargo en el root que es de tipo parent
            Parent root = (Parent) loader.load();
            //obtener el controlador
            PC04ExpenseController controller = (PC04ExpenseController) loader.getController();
            //le mando el objeto logica al controlador 
            controller.setILogic(iLogicExpense);
            controller.setUser(user);
            //a ese controlador le paso el stage
            controller.setStage(stage);
            //inizializo el stage
            controller.initStage(root);
            cbSearchTel.requestFocus();
            stage.hide();            
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }
    
    /**
     * This method is to go to the userPane
     * 
     * @param ev event to go to user window
     */
    public void usersWindow(ActionEvent ev) {
        LOGGER.info("clickOn User Menu");
        try {
            UserLogic iLogicUser = ILogicFactory.getUserLogic();
            //instancio el xml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC03User.fxml"));
            //lo cargo en el root que es de tipo parent
            Parent root = (Parent) loader.load();
            //obtener el controlador
            PC03UserController controller = (PC03UserController) loader.getController();
            //le mando el objeto logica al controlador 
            controller.setILogic(iLogicUser);
            controller.setUser(user);
            //a ese controlador le paso el stage
            controller.setStage(stage);
            //inizializo el stage
            controller.initStage(root);
            cbSearchTel.requestFocus();
            stage.hide();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }
    
    /**
     * This method is to go to ftp client
     * 
     * @param ev event to go to ftp client
     */
    public void FTPClientWindow(ActionEvent ev) {
        LOGGER.info("clickOn FTP Client btn");
        try {
            FTPClientLogic iLogic = ILogicFactory.getFTPClientLogic();
            //instancio el xml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/jampclientside/ui/view/PC06FTPClient.fxml"));
            //lo cargo en el root que es de tipo parent
            Parent root = (Parent) loader.load();
            //obtener el controlador
            PC06FTPClientController controller = (PC06FTPClientController) loader.getController();
            //le mando el objeto logica al controlador 
            controller.setILogic(iLogic);
            //a ese controlador le paso el stage
            controller.setStage(stage);
            //inizializo el stage
            controller.initStage(root);
            cbSearchTel.requestFocus();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accediendo a la ventana {0}", ex.getCause());
        }
    }
    
    /**
     * This method is to select the cobobox options
     * 
     * @param ev event to combobox
     */
    public void comboBoxOption(ActionEvent ev) {
        LOGGER.info("clickOn combo box");
        switch (cbSearchTel.getSelectionModel().getSelectedItem()) {
            case "Todos los telefonos del catalogo":
                try {
                    tbTelephone.setEditable(true);
                    addTelephone.setDisable(false);
                    telephoneData = FXCollections.observableArrayList(iLogicTelephone.findAllTelephone());
                    if(telephoneData == null){
                        Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
                        dialogoAlerta.setTitle("INFORMACION");
                        dialogoAlerta.setHeaderText("No hay telefonos en la lista");
                        dialogoAlerta.showAndWait();
                    }else{
                        tbTelephone.setItems(telephoneData);
                    }
                } catch (BusinessLogicException ex) {
                    Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case "Nombre del telefono":  
                addTelephone.setDisable(true);
                tbTelephone.setEditable(false);
                tbTelephone.getItems().clear();
                txtSearchTel.setText("");
                txtSearchTel.requestFocus();
                txtSearchTel.setDisable(false);
                cbSearchTel.setDisable(false);
                btnSearchTel.setDisable(false);
                tooltipName.setText("Escribe el nombre del telefono");
                txtSearchTel.setTooltip(tooltipName);
                labelError.setVisible(false);
                txtSearchTel.setStyle("-fx-border-color: -fx-box-border;");
                break;
            case "Poblacion":  
                addTelephone.setDisable(true);
                tbTelephone.setEditable(false);
                tbTelephone.getItems().clear();
                txtSearchTel.setText("");
                txtSearchTel.requestFocus();
                txtSearchTel.setDisable(false);
                cbSearchTel.setDisable(false);
                btnSearchTel.setDisable(false);
                tooltipName.setText("Escribe el nombre del telefono");
                txtSearchTel.setTooltip(tooltipName);
                labelError.setVisible(false);
                txtSearchTel.setStyle("-fx-border-color: -fx-box-border;");
                break;
            default:
                break;
        }
    }
    
    /**
     * This method is for the search button.
     * When you click on the button, first check that text field it isn't empty, 
     * if it is empty, a label error appears with a message.
     * Also check that the size does not exceed 255 characters.
     * If the conditions are ok, the method stores the telephones in a collection,
     * if the collection is empty, a dialogue with the message appears.
     * 
     * @param ev event to sarch button
     */
    public void searchButton(ActionEvent ev) {
        LOGGER.info("clickOn search button");
        //que se quite lo rojo si anteriormente habia seleccionado algo y daba error
        labelError.setVisible(false);
        txtSearchTel.setStyle("-fx-border-color: -fx-box-border;");

        if (cbSearchTel.getSelectionModel().getSelectedItem().equals("Poblacion")) {
            //miramos si el textfield esta vacio o no
            boolean tfIDEmpty = textEmptyOrNot();
            //si no esta vacio
            if (tfIDEmpty) {                    
                if(txtSearchTel.getText().trim().length() < MAX_CARACT){      
                    try {
                        String town = txtSearchTel.getText().trim();

                        telephoneData = FXCollections.observableArrayList(iLogicTelephone.findTelephoneByTown(town));
                        if(telephoneData == null){
                            Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                            dialogoAlerta.setTitle("INFORMACION");
                            dialogoAlerta.setHeaderText("No hay telefonos en la lista");
                            dialogoAlerta.showAndWait();
                        }else{
                            tbTelephone.setItems(telephoneData);
                        }
                    } catch (BusinessLogicException ex) {
                        Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    txtSearchTel.setStyle("-fx-border-color: red;");
                    labelError.setText("Se ha introducido un numero superior de caracteres al permitido");
                    labelError.setVisible(true);
                    labelError.setStyle("-fx-text-inner-color: red;");
                }
            } else {
                txtSearchTel.setStyle("-fx-border-color: red;");
                labelError.setText("Tienes que escribir la poblacion");
                labelError.setVisible(true);
                labelError.setStyle("-fx-text-inner-color: red;");
            }
        } else if (cbSearchTel.getSelectionModel().getSelectedItem().equals("Nombre del telefono")) {
            boolean tfNameEmpty = textEmptyOrNot();
            if (tfNameEmpty) {
                if(txtSearchTel.getText().trim().length() < MAX_CARACT){ 
                    try {
                        String name = txtSearchTel.getText();

                        telephoneData = FXCollections.observableArrayList(iLogicTelephone.findTelephoneByName(name));
                        if(telephoneData == null){
                            Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
                            dialogoAlerta.setTitle("INFORMACION");
                            dialogoAlerta.setHeaderText("No hay telefonos en la lista");
                            dialogoAlerta.showAndWait();
                        }else{
                            tbTelephone.setItems(telephoneData);
                        }
                    }
                    catch (BusinessLogicException ex) {
                        Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    txtSearchTel.setStyle("-fx-border-color: red;");
                    labelError.setText("Se ha introducido un numero superior de caracteres al permitido");
                    labelError.setVisible(true);
                    labelError.setStyle("-fx-text-inner-color: red;");
                }
            }
            else {
                txtSearchTel.setStyle("-fx-border-color: red;");
                labelError.setText("Tienes que escribir el nombre");
                labelError.setVisible(true);
                labelError.setStyle("-fx-text-inner-color: red;");
            }
        }
    }
    
    /** 
     * This method compares the data in the table with the data in the database 
     * to update or to create a new telephone. 
     * In a list, keep all the products that are in the database and 
     * in another list the telephones in the table.
     * First check if all the fields are informed. 
     * If yes, compare the two lists and if a telephone is repeated, 
     * keep it in a third list. 
     * If the third list contains any telephone, update the telephone, 
     * otherwise create the telephone. 
     */
    private void addUpdateTelephone() throws BusinessLogicException {
        List<TelephoneBean> telephones = tbTelephone.getItems();
        boolean modif = false;
        
        for(TelephoneBean tel: telephones){
            if(tel.getName()!=null && !tel.getName().trim().isEmpty()&& 
              tel.getDescription()!=null && !tel.getDescription().trim().isEmpty()&& 
              tel.getTown()!=null && !tel.getTown().trim().isEmpty() &&
              tel.getTelephone()!=null && !tel.getTelephone().trim().isEmpty()) 
              {             
                    
                    List telephoneEquals = telephoneDatacopy.stream().filter(t -> t.getTelephone().equals(tel.getTelephone())).collect(Collectors.toList());
                    if(telephoneEquals.isEmpty()){
                        addTelephone(tel);
                        modif = true;
                        break;
                    }else if(!telephoneEquals.get(0).equals(tel)){
                        updateTelephone(tel);
                        modif = true;
                        break;
                    }
            }
        }
        if(modif==true){
            telephoneDatacopy = iLogicTelephone.findAllTelephone();
        }
            
    }
    
    

    /**
     * This method is to add the selected telephone in the table. 
     * First ask for the confirmation, if it is positive, add the telephone 
     * and confirm it in a dialog box.
     * If it is negative, give the confirmation in a dialog and don't add it.
     * 
     * @param telephone
     * @throws BusinessLogicException 
     */
    private void addTelephone(TelephoneBean telephone) {
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CONFIRMACION");
            dialogoAlerta.setContentText("¿Estas seguro que deseas añadir el teléfono "+telephone.getName()+"?");
            dialogoAlerta.setHeaderText("Añadir un teléfono");
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
            Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("buttonAdd");
            Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setId("buttonCancel");
        
            if (result.get() == ButtonType.OK) {
                if (telephone.getName().trim().length() < MAX_CARACT && telephone.getDescription().trim().length() < MAX_CARACT &&
                        telephone.getTelephone().trim().length() < MAX_CARACT && telephone.getTown().trim().length()< MAX_CARACT) {
                    try {
                        iLogicTelephone.createTelephone(telephone);
                    } catch (BusinessLogicException ex) {
                        Logger.getLogger(PC08PhoneNumbersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    labelError.setText("Demasiados caracteres!!!");
                    labelError.setVisible(true);
                    labelError.setStyle("-fx-text-inner-color: red;");
                }
            }
    } 
    
    /**
     * This method is to update the selected telephone in the table. 
     * First ask for the confirmation, if it is positive, update the telephone 
     * and confirm it in a dialog box.
     * If it is negative, give the confirmation in a dialog and don't update it.
     * 
     * @param telephone
     * @throws BusinessLogicException 
     */
    private void updateTelephone(TelephoneBean telephone) throws BusinessLogicException {

            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("CONFIRMACION");
            dialogoAlerta.setContentText("¿Estas seguro que deseas actualizar el telefono "
                    +telephone.getName()+" "+telephone.getDescription()+"?");
            dialogoAlerta.setHeaderText("Actualizar un telefono");
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
            Button okButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setId("buttonAdd");
            Button cancelButton = (Button) dialogoAlerta.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setId("buttonCancel");
        
            if (result.get() == ButtonType.OK) {
                if (telephone.getName().trim().length() < MAX_CARACT && telephone.getDescription().trim().length() < MAX_CARACT &&
                    telephone.getTelephone().trim().length() < MAX_CARACT && telephone.getTown().trim().length()< MAX_CARACT) {
                
                    iLogicTelephone.updateTelephone(telephone);

                }else{
                    labelError.setText("Demasiados caracteres!!!");
                    labelError.setVisible(true);
                    labelError.setStyle("-fx-text-inner-color: red;");
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
        if (!this.txtSearchTel.getText().trim().equals("")) {
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
        //si es diferente a vacio
        if (!tbTelephone.getSelectionModel().getSelectedItems().isEmpty()) {
            //hay algo seleccionado
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
        LOGGER.info("Beginning Telephones::logout action");
        cerrar = 2;
        cerrarSesionAlert(cerrar);
    }
    
    /**
     * Method that show a confirm dialog to close session
     * 
     * @param cerrar Difference for close app or close session
     */
    public void cerrarSesionAlert(int cerrar){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Dialogo de confirmacion");
        alert.setContentText("Estas seguro que deseas cerrar la sesion");
        alert.setHeaderText("Cerrar Sesion");
        
        Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
        okButton.setId("okButton");
        
        Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.setId("cancelButton");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            if(cerrar == 1){
                System.exit(0);
            }else{
                stage.hide();
            }
        }
    }
    
}
