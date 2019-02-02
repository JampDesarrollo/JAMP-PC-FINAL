/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jampclientside.logic;

import jampclientside.entity.ProductBean;
import jampclientside.exceptions.BusinessLogicException;
import jampclientside.exceptions.IdNotOkException;
import jampclientside.exceptions.NameNotOkException;
import jampclientside.exceptions.ProductExist;
import java.util.List;


/**
 * The produt interface
 *
 * @author Julen
 */
public interface ProductLogic {


    /**
     * This method is for delete product
     * 
     * @param product the product we want to delete
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public void deleteProduct(ProductBean product) throws BusinessLogicException;
    
    /**
     * This method is for update product
     * 
     * @param product the product we want to update
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public void updateProduct(ProductBean product) throws BusinessLogicException;
    
    /**
     * This method is for delete product
     * 
     * @param product the product we want to create
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public void createProduct(ProductBean product) throws BusinessLogicException;
    
    /**
     * This method is for find product by id
     * 
     * @param idProduct the id prodcut to find
     * @return the product found by id
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     * @throws IdNotOkException throws this exceptions if id is wrong.
     */
    public ProductBean findProductById(String idProduct) throws BusinessLogicException, IdNotOkException;
    
    /**
     * thi method is for find product by id and idtxoko
     * 
     * @param idProduct the product to find
     * @param idTxoko the txoko to find
     * @return the prouct foud by id and by txoko
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     * @throws IdNotOkException throws this exceptions if id is wrong.
     */
    public ProductBean findProductByIdByTxoko(String idProduct, String idTxoko) throws BusinessLogicException, IdNotOkException;
    
    /**
     * this method is for find product by name
     * 
     * @param name the name to find
     * @param idTxoko the txoko to find
     * @return the product found by name
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     * @throws NameNotOkException throws this exceptions if name is wrong.
     */
    public List<ProductBean> findProductByName(String name, String idTxoko) throws BusinessLogicException, NameNotOkException;
    
    /**
     * this method is for find all prodcuts
     * 
     * @return Lis of productBean all founds
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public List<ProductBean> findAllProducts () throws BusinessLogicException;
    
    /**
     * this method is for find all products by txoko
     * 
     * @param idTxoko the txoko to find
     * @return List of productBean found all products by txoko
     * @throws BusinessLogicException throws this exceptions if something is wrong.
     */
    public List<ProductBean> findAllProductsByTxoko(String idTxoko) throws BusinessLogicException;

    /**
     * This method is for view is product exist
     * 
     * @param id the id to find
     * @throws ProductExist throws this exceptions if product no exist.
     */
    public void isProductExist(Integer id) throws ProductExist;

   
    
}
