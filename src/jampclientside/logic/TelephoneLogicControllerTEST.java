/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.logic;

import jampclientside.entity.TelephoneBean;
import jampclientside.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author odoo
 */
public class TelephoneLogicControllerTEST implements TelephoneLogic {
      private ArrayList<TelephoneBean> telephones;
      public TelephoneLogicControllerTEST(){
        telephones=new ArrayList();
        //Create 25 TelephoneBean fake data objects.
        for(int i=0;i<25;i++)
            telephones.add(new TelephoneBean("Telefono"+i,"Telefono de Prueba"+i, i));
    
    }

    @Override
    public void deleteTelephone(TelephoneBean phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTelephone(TelephoneBean phone){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createTelephone(TelephoneBean phone){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TelephoneBean> findAllTelephone() {
        return telephones;
    }

    @Override
    public List<TelephoneBean> findTelephoneByTown(String poblacion) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TelephoneBean> findTelephoneByName(String name) throws BusinessLogicException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean startConnection() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
