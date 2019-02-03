 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.entity;


import java.io.Serializable;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Data Transfer Object used in UI and client side for representing User entity.
 * It is also used as data model for a TableView in the UI.
 * 
 * @author Julen
 */
@XmlRootElement (name = "product")
public class ProductBean implements Serializable{

    /**
     * 
     */
    private SimpleIntegerProperty idProduct;   
   
    /**
     * 
     */
    private SimpleStringProperty stock;
    
    /**
     * 
     */
    private SimpleStringProperty name;    
   
    /**
    * 
    */
    private SimpleStringProperty price; 
    
    /**
     * 
     */
    private SimpleStringProperty description;
    
    /**
     * 
     */
    private List<TxokoBean> txokos;
    
    public ProductBean(){
     this.idProduct = new SimpleIntegerProperty();
     this.name = new SimpleStringProperty ();
     this.description = new SimpleStringProperty();
     this.price = new SimpleStringProperty();
     this.stock = new SimpleStringProperty();
     this.txokos = txokos;

     }
    
        public ProductBean(String name,
                    String description,
                    String stock,
                    String price,
                    String venta){
        this.name=new SimpleStringProperty(name);
        this.description=new SimpleStringProperty(description);
        this.stock=new SimpleStringProperty(stock);
        this.price = new SimpleStringProperty(price);
    }

    /**
     * Getter of the id
     * 
     * @return the idProduct
     */
    public Integer getIdProduct() {
        return this.idProduct.get();
    }
    /**
     * Setter for set idProduct
     * 
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(Integer idProduct) {
        this.idProduct.set(idProduct);
    }

    /**
     * Getter of the stock
     * 
     * @return the stock
     */
    public String getStock() {
        return this.stock.get();
    }

    /**
     * Setter of the stock
     * 
     * @param stock the stock to set
     */
    public void setStock(String stock) {
        this.stock.set(stock);
    }

    /**
     * Getter of the name
     * 
     * @return the name
     */
    public String getName() {
        return this.name.get();
    }

    /**
     * Setter for set Name
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * Getter ofthe price
     * 
     * @return the price
     */
    public String getPrice() {
        return this.price.get();
    }

    /**
     * Setter for set the price
     * 
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price.set(price);
    }

    /**
     * Getter of the Description
     * 
     * @return the description
     */
    public String getDescription() {
        return this.description.get();
    }

    /**
     * Setter for set the Description
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description.set(description);
    }    

    /**
     * Getter of the Txokos
     * 
     * @return the txokos
     */
    public List<TxokoBean> getTxokos() {
        return txokos;
    }

    /**
     * Setter for set the txokos
     * 
     * @param txokos the txokos to set
     */
    public void setTxokos(List<TxokoBean> txokos) {
        this.txokos = txokos;
    }

    /**
     * This method is for compare entity attributes
     * 
     * @param object th bject we want to compare
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductBean)) {
            return false;
        }
        ProductBean other = (ProductBean) object;
        if ((this.getIdProduct() == null && other.getIdProduct() != null) || (this.getIdProduct() != null && !this.getIdProduct().equals(other.getIdProduct()))) {
            return false;
        }
        if ((this.getName() == null && other.getName() != null) || (this.getName() != null && !this.getName().equals(other.getName()))) {
            return false;
        }
        if ((this.getDescription()== null && other.getDescription()!= null) || (this.getDescription() != null && !this.getDescription().equals(other.getDescription()))) {
            return false;
        }
        if ((this.getStock() == null && other.getStock() != null) || (this.getStock() != null && !this.getStock().equals(other.getStock()))) {
            return false;
        }
        if ((this.getPrice() == null && other.getPrice() != null) || (this.getPrice() != null && !this.getPrice().equals(other.getPrice()))) {
            return false;
        }
        return true;
    }
}
