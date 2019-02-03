  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.entity;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;

/**
 * Data transfer Object used in UI and client side for represernt Telephone Bean
 * It is also used as data model for a TableView in the UI.
 * 
 * @author Julen
 */
public class TelephoneBean implements Serializable{
   /**
    * 
    */
    private SimpleStringProperty idTelephone;
   
    /**
    * 
    */
    private SimpleStringProperty name;
    /**
     * 
     */
    private SimpleStringProperty telephone;
    
    /**
     * 
     */
    private SimpleStringProperty description;
    
    /**
     * 
     */
    private SimpleStringProperty town;

    /**
     * Emprty Constructor
     */
    public TelephoneBean(){
        this.idTelephone = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.telephone = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.town = new SimpleStringProperty();
     }
    
    /**
     * Public Constructor
     * 
     * @param name name of the telephone
     * @param description descriptionn of the telephone
     * @param telephone telephone of the telephone
     * @param town town of the telephone
     */
    public TelephoneBean(String name,
                    String description,
                    String telephone,
                    String town){
        this.name=new SimpleStringProperty(name);
        this.description=new SimpleStringProperty(description);
        this.telephone=new SimpleStringProperty(telephone);
        this.town = new SimpleStringProperty(town);
    }

    public TelephoneBean(String string, String string0, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Getter of the id 
     * 
     * @return the id
     */
    public String getId() {
        return this.idTelephone.get();
    }

    /**
     * Setter for set Id
     * 
     * @param idTelephone the id to set
     */
    public void setId(String idTelephone) {
        this.idTelephone.set(idTelephone);
    }

    /**
     * Getter of the name
     * 
     * @return the nombre
     */
    public String getName() {
        return this.name.get();
    }

    /**
     * Setter of the name
     * 
     * @param nombre the nombre to set
     */
    public void setName(String nombre) {
        this.name.set(nombre);
    }

    /**
     * Getter of the name
     * 
     * @return the telephon
     */
    public String getTelephone() {
        return this.telephone.get();
    }

    /**
     * Setter for telephone
     * 
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    /**
     * Getter for description
     * 
     * @return the description
     */
    public String getDescription() {
        return this.description.get();
    }
    
    /**
     * Setter to descrption
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description.set(description);
    }
    
    /**
     * Getter for town
     * 
     * @return the town
     */
    public String getTown() {
        return this.town.get();
    }

    /**
     * Setter for the town
     * 
     * @param town the town to set
     */
    public void setTown(String town) {
        this.town.set(town);
    }

    /**
     * This method is for compare entity attributes
     * 
     * @param object the objet we want to compare
     * @return boolean 
     */
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelephoneBean)) {
            return false;
        }
        TelephoneBean other = (TelephoneBean) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        if ((this.getName() == null && other.getName() != null) || (this.getName() != null && !this.getName().equals(other.getName()))) {
            return false;
        }
        if ((this.getDescription()== null && other.getDescription()!= null) || (this.getDescription() != null && !this.getDescription().equals(other.getDescription()))) {
            return false;
        }
        if ((this.getTelephone()== null && other.getTelephone()!= null) || (this.getTelephone() != null && !this.getTelephone().equals(other.getTelephone()))) {
            return false;
        }
        if ((this.getTown()== null && other.getTown()!= null) || (this.getTown() != null && !this.getTown().equals(other.getTown()))) {
            return false;
        }

        return true;
    }

}
