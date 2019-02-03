/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import jampclientside.entity.ProductBean;
import java.util.ResourceBundle;
import javax.ws.rs.core.GenericType;



/**
 * Jersey REST client generated for REST resource:ProductREST [product]<br>
 * USAGE:
 * <pre>
 *        ProductRESTClient client = new ProductRESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Julen
 */
public class ProductRESTClient {

    /**
     * WebTarget attribute
     */
    private WebTarget webTarget;
    
    /**
     * Client attribute
     */
    private Client client;
    /**
     * Get URI from properties' values file.
     */
    private static final String BASE_URI = ResourceBundle.getBundle("jampclientside.rest.config")
            .getString("URI");

    /**
     * ProductRestClient
     */
    public ProductRESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("product");
    }

    /**
     * This method is for delete product
     * 
     * @param idProduct the id of poduct we want to delete
     * @throws ClientErrorException throws this exceptions if something is wrong.
     */
    public void deleteProduct(Integer idProduct) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("idProducto/{0}", new Object[]{idProduct})).request().delete();
    }

    /**
     * This method is for update product
     * 
     * @param requestEntity request entity
     * @throws ClientErrorException throws this exceptions if something is wrong.
     */
    public void updateProduct(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     * This method is for create product
     * 
     * @param requestEntity request entity
     * @throws ClientErrorException throws this exceptions if something is wrong.
     */
    public void createProduct(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }
    
    /**
     * This method is for find prodcut by id and by txoko
     * 
     * @param <T> generic type
     * @param responseType response type
     * @param idProduct the id of the product
     * @param idTxoko the id of the txoko
     * @return the product with id and txoko
     * @throws ClientErrorException throws this exceptions if something is wrong.
     */
    public <T> T findProductByIdByTxoko(Class<T> responseType, String idProduct, String idTxoko) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("idProduct/{0}/txoko/{1}", new Object[]{idProduct, Integer.parseInt(idTxoko)}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * This method is for find product by name
     * 
     * @param <T> GenericType
     * @param responseType responseType
     * @param name the name of the product
     * @param idTxoko the id of the txoko
     * @return the product by name
     * @throws ClientErrorException throws this exceptions if something is wrong.
     */
    public <T> T findProductByName(GenericType<T> responseType, String name, String idTxoko) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("name/{0}/idTxoko/{1}", new Object[]{name, Integer.parseInt(idTxoko)}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * This method return all products
     * 
     * @param <T> genericType
     * @param responseType responseType
     * @return responseType
     * @throws ClientErrorException throws this exceptions if something is wrong.
     */
    public <T> T findAllProducts(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
    /**
     * This methd is for find allproducts by one txoko
     * 
     * @param <T> generic Type
     * @param responseType responsetype
     * @param idTxoko the id of the txoko
     * @return all products of the txoko
     * @throws ClientErrorException throws this exceptions if something is wrong.
     */
    public <T> T findAllProductsByTxoko(GenericType<T> responseType, String idTxoko) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("txoko/{0}", new Object[]{Integer.parseInt(idTxoko)}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * This method find products by id
     * 
     * @param responseType responsetype
     * @param idProduct the id of the product
     * @return product found by id
     */
    public ProductBean findProductById(Class<ProductBean> responseType, String idProduct) {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("idProducto/{0}", new Object[]{idProduct}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
    /**
     * This method is to close rest
     */
    public void close() {
        client.close();
    }

}
