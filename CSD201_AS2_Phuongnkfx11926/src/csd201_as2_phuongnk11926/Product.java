/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuongnk11926;

import java.io.Serializable;
import java.util.Scanner;
/**
 *
 * @author Phuong Nguyen
 */
//lớp phải implement interface Serializable để ghi đối tượng vào file
public class Product implements Serializable{
    
    //Constructor method to initialize a product
    String code;
    String title;
    Integer quantity;
    double price;
    
    Scanner sc = new Scanner(System.in);
    
    public Product(){
    
    }
    
    public Product(String code, String title, Integer quantity, double price){
        this.code = code;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String toString(){
        return(code + "  |  " + title + "  |  " + quantity + "  |  " + price);
      
    }
}
