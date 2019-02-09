/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.logic;

import jampclientside.entity.TelephoneBean;
import jampclientside.exceptions.BusinessLogicException;
import java.util.List;


/**
 * The telephone interface
 *
 * @author Julen
 */
public interface TelephoneLogic {

    /**
     * This method is for delete telephone
     * 
     * @param phone the phone we want to delete
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public void deleteTelephone(TelephoneBean phone) throws BusinessLogicException;
    
    /**
     * This method is to update telephone
     * 
     * @param phone the phonne we want to update
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public void updateTelephone(TelephoneBean phone) throws BusinessLogicException;
    
    /**
     * This method is to create a telephone
     * 
     * @param phone the telephone we want to create
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public void createTelephone(TelephoneBean phone) throws BusinessLogicException;
    
    /**
     * This method to find all telephones
     * 
     * @return List of TelephoneBean with all telephones founds
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public List<TelephoneBean> findAllTelephone()throws BusinessLogicException;
    
    /**
     * This method is for find tlephone by id
     * 
     * @param idTelephone the telephone we want to find
     * @return TelephoneBean found
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public List<TelephoneBean> findTelephoneByTown(String poblacion)throws BusinessLogicException;
    
    /**
     * This method finnd telephones by name
     * 
     * @param name the name of telephone we want to found
     * @return List of telephoneBean with the name
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public List<TelephoneBean> findTelephoneByName(String name)throws BusinessLogicException;
    
    public boolean startConnection() throws Exception;
    

    
}
