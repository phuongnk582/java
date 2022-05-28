/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuongnk11926;

/**
 *
 * @author Phuong Nguyen
 */
public class Node<Product> {
    Product data;
    Node<Product> next;
    
    public Node(Product p, Node next){
        this.data = p;
        this.next = next;
    }
    
    //dùng khi chỉ cần 1 tham số là đối tượng product. phần tử cuối sẽ có next bằng null để dừng vòng lặp.
    public Node(Product p){
        this(p, null); 
    }
    
    public Product getInfo(){
        return this.data;
    }
    
    public Node getNextNode(){
        return this.next;
    }
    
    public void setData(Product p){
        this.data = p;
    }
    
    public void setNextNode(Node nextNode){
        this.next = nextNode;
    }
    
    @Override 
    public String toString(){
        return "  |  " + this.data;
    }
}
