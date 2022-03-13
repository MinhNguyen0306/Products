/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Connect.LoadDB;
import java.util.List;
import model.Product;

public class productService {
    private LoadDB loadPro;
    
    public productService(){
            loadPro = new LoadDB(); 
    }
    
    public List<Product> getAll(){
            return loadPro.getAll();
    }
    
    public void addProduct(Product p){
        loadPro.addProduct(p);
    }
}
