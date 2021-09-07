package com.list;

public class DoubleLinkedList {
    private Node head;
    private int size;
    private Node tail;



    public DoubleLinkedList(){
        this.head = null;
        this.size = 0;
        this.tail = null;
    }
    public boolean isEmpty(){
        if (this.head == null || this.tail == null){
            return true;
        }else {
            return false;
        }
    }
    public int size(){
        return this.size;
    }
    public void insertFirst(Object data){
        Node newNode = new Node(data); //crea nodo
        this.head.previous = newNode;
        newNode.next = this.head;// al siguiete le guarda el primero
        newNode.previous = null;
        this.head = newNode; // se guarda en la cabeza actual
        this.size++;
    }
    public Node deleteFirst(){
        if (this.head != null){
            Node temp = this.head;
            this.head = this.head.next;
            this.head.previous = null;
            this.size--;
            return temp;

        }else {
            return null;
        }
    }
    public void displayList(){
        Node current = this.head;
        while (current != null){
            System.out.println(current.getData());
            current = current.next;
        }
    }
    public Node find (Object searchValue){
        Node current = this.head;
        while (current!= null){
            if (current.getData().equals(searchValue)){
                return current;
            }else {
                current = current.getNext();
            }
        }
        return null; //no encontró el valor
    }
    public Node delete(Object searchValue){
        Node current = this.head;
        while (current != null){
            if (current.getData().equals(searchValue)){
                Node temp = current; // borro nodo
                current = current.next; // lo sustituyo por el nodo sig
                current.previous = temp.previous; //actualizo que el prev será el previ del nodo borrado
                temp.previous.next = current; // el nodo anterior al borrado le dijo que siguiente es el nuevo nodo

            }else{
                current = current.getNext();
            }

        }
        return null;
    }


}
