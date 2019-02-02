/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.logic;


import jampclientside.entity.TelephoneBean;
import jampclientside.exceptions.BusinessLogicException;
import static jampclientside.logic.TelephoneLogicController.collection;
import static jampclientside.logic.TelephoneLogicController.mongoDB;
import static jampclientside.logic.TelephoneLogicController.mongoclient;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;


/**
 *
 * Class that implements the logic
 * interface.
 *
 * @author Julen
 */
public class TelephoneLogicController implements TelephoneLogic {

    private static final String MONGOCLIENT = ResourceBundle.
            getBundle("jampclientside.logic.config").getString("MONGOCLIENT");
    private static final String MONGODB = ResourceBundle.
            getBundle("jampclientside.logic.config").getString("MONGODB");
    private static final String COLLECTION = ResourceBundle.
            getBundle("jampclientside.logic.config").getString("COLLECTION");
    /**
     * 
     */
    public static MongoClient mongoclient;
    
    /**
     * 
     */
    public static MongoDatabase mongoDB;
    
    /**
     * 
     */
    public static MongoCollection<Document> collection;


    /**
     * Attribute to appear the information text.
     */
    private static final Logger LOGGER
            = Logger.getLogger("jamp.pc.logic.IlogicImplementationTelephone");

    /**
     *
     */
    @Override
    public void startConnection(){

            mongoclient = MongoClients.create(MONGOCLIENT);
            mongoDB = mongoclient.getDatabase(MONGODB);
            collection = mongoDB.getCollection(COLLECTION);

    }
    /**
     * This method is for delete telephones.
     * 
     * @param phone the phone to delete
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    @Override
    public void deleteTelephone(TelephoneBean phone) throws BusinessLogicException {
        collection.deleteOne(Filters.eq("telephone",phone.getTelephone()));
    }

    /**
     * This method is for update telephones.
     * 
     * @param phone the phne to update
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    @Override
    public void updateTelephone(TelephoneBean phone) throws BusinessLogicException {
        Document documentToSet = new Document();
        
        documentToSet.put("name", phone.getName());
        documentToSet.put("description", phone.getDescription());
        documentToSet.put("telephone", phone.getTelephone());
        documentToSet.put("town", phone.getTown());
         
        Document set =  new Document("$set", documentToSet);
        collection.updateOne(new Document("idTelephone",phone.getId()), set);
          
    }

    /**
     * This method is for create tellephones
     * 
     * @param phone the phone to create
     * @throws BusinessLogicException throws this exceptions if something is wrong. 
     */
    @Override
    public void createTelephone(TelephoneBean phone) throws BusinessLogicException {
        Document document = new Document();
        
        document.put("name", phone.getName());
        document.put("description", phone.getDescription());
        document.put("telephone", phone.getTelephone());
        document.put("town", phone.getTown());
        
        collection.insertOne(document);
    }

    /**
     * This method is for find all telephones.
     * 
     * @return Collection of telephones 
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    @Override
    public List<TelephoneBean> findAllTelephone() throws BusinessLogicException {
        FindIterable<Document> fi;
        MongoCursor<Document> cursor;
        Document itera;
        fi = collection.find();
        cursor = fi.iterator();
        List<TelephoneBean> telephones = new ArrayList<>();
            try {
                if (!cursor.hasNext()) {
                    System.out.println("No se ha encontrado el telefono");
                }
                int i = 0;
                while (cursor.hasNext()) {
                    itera = cursor.next();
                    TelephoneBean telephone= new TelephoneBean();
                    telephone.setId(itera.getString("id"));
                    telephone.setName(itera.getString("name"));
                    telephone.setDescription(itera.getString("description"));
                    telephone.setTown(itera.getString("town"));
                    telephone.setTelephone(itera.getString("telephone"));

                    
                    telephones.add(telephone);
                    
                }
            } finally {
                cursor.close();
            }
        
        return telephones;
    }

    /**
     * This method is for find telephones by Id.
     * 
     * @param idTelephone the id of telephone
     * @return a telephone
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    @Override
    public TelephoneBean findTelephoneById(Integer idTelephone) throws BusinessLogicException {
        FindIterable<Document> fi;
        MongoCursor<Document> cursor;
        fi = collection.find();
        cursor = fi.iterator();
        TelephoneBean telephone = new TelephoneBean();
            try {
                if (!cursor.hasNext()) {
                    System.out.println("No se ha encontrado el telefono");
                }
                int i = 0;
                while (cursor.hasNext()) {
                    //telephones.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        
        return telephone;
    }

    /**
     * This method is for find telephones by name.
     * 
     * @param name the name of the telephone
     * @return Collecion of telephones
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    @Override
    public List<TelephoneBean> findTelephoneByName(String name) throws BusinessLogicException {
        FindIterable<Document> fi;
        MongoCursor<Document> cursor;
        Document itera;
        fi = collection.find();
        cursor = fi.iterator();
        List<TelephoneBean> telephones = new ArrayList<>();
            try {
                if (!cursor.hasNext()) {
                    System.out.println("No se ha encontrado el telefono");
                }
                int i = 0;
                while (cursor.hasNext()) {
                    //telephones.add(cursor.next());
                }
            } finally {
                cursor.close();
            }
        
        return telephones;
    }
}