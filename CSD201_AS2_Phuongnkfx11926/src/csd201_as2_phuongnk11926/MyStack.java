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
public class MyStack<T> {
    //Head node contains front node in the stack
    //Node<T> head;
    MyList<T> listStack = new MyList<>();
    boolean isEmpty(){
        return listStack.isEmpty();
    } 
    public T pop(){
        T value = listStack.head.data;
        listStack.head = listStack.head.next;
        return value;
    }
    public void push(T data){
        listStack.insertAtHead(data);
    }
}
