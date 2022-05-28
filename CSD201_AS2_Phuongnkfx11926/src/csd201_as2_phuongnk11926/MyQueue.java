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
public class MyQueue<T> {
    //Head node contains front node in the queue
    //Node<T> head;
    //Tail node contains last node in the queue
    //Node<T> tail;
    
    MyList<T> listQueue = new MyList<>();
    boolean isEmpty(){
        return listQueue.isEmpty();
    }
    
    public void enqueue(T value){
        listQueue.insertAtLast(value);
    }
    
       public T dequeue(){
        T value = listQueue.head.data;
        listQueue.head = listQueue.head.next;
        return value;
    }
}
