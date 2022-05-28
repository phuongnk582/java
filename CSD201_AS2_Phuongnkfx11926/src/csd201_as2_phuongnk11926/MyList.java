/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_as2_phuongnk11926;
import java.util.Collection;

/**
 *
 * @author Phuong Nguyen
 */
// <T> : khái niệm generic trong Java, định nghĩa kiểu dữ liệu của ArrayList
//Node với MyList là xây dựng khung, nên dùng kiểu dữ liệu T, vào operator mới gọi kiểu Product thay cho T

public class MyList<T> {
    Node<T> head;
    Node<T> tail;

    public MyList() {
        head = tail = null;
    }
    
    public MyList(Node head, Node tail){
    
    }
    
    //xóa tất cả phần tử trong link list
    void clear(){
        head = tail = null;
    }
    
    //hàm kiểm tra chuỗi rỗng hay không
    boolean isEmpty(){
        return(head == null);
    }
    
    //trả về độ dài của linkList
    public int length(){
        int length = 0;
        Node current = this.head;
        while(current !=null){
            length ++;
            current = current.getNextNode();
        }
        return length;
    }
    
    //Thêm phần tử vào đầu danh sách
    public void insertAtHead(T data){
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }
    
    //Thêm phần tử vào cuối danh sách
    public void insertAtLast(T data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = tail=newNode;
            return;
        }
            tail.next = newNode;
            tail=newNode;
        
    }

    //hàm đổi chỗ 2 phần tử 
    public void swap(Node<Product> firstNode, Node<Product> secondNode) {

    }
}
