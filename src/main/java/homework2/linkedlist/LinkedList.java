package homework2.linkedlist;

import homework2.classes.Main;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class LinkedList<T> {
    private static Logger logger = LogManager.getLogger(LinkedList.class);

    private Node head;

    class Node {
        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }
    }

    public void add(T element) {
        Node node = new Node(element);
        if (this.head == null) {
            this.head = node;
        } else {
            Node iterator = this.head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = node;
        }
    }

    public void print() {
        Node iterator = head;
        while (iterator != null) {
            logger.info(iterator.value + " ");
            iterator = iterator.next;
        }
    }

    public void delete(T element){
        Node iterator=head;
        int found=0;
        // to check if first valor is value
        if(iterator.value==element){
            found=1;
            head=head.next;
        }
        // to check other than first value
        else{
            Node iterator2=head;
            while(iterator!=null){
                if(iterator.value==element){
                    found=1;
                    break;
                }
                iterator2=iterator;
                iterator=iterator.next;
            }
            if(found==1){
                iterator2.next=iterator.next;
            }
        }
        if(found==0){
            logger.info("element not found in linked list");
        }
    }

    public int getCount(){
        if(head==null){
            return 0;
        }
        Node iterator = head;
        int count = 0;

        while(iterator!=null){
            count++;
            iterator=iterator.next;
        }
        return count;

    }

    /*

    public T get(T value){

    }



     */

}










