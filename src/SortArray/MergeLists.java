package SortArray;

import java.util.*;

//class node to build singly-linked lists
class Node {
    //private data types
    int data;
    Node next;

    //default constructor
    Node(int d){
        data = d;
        next = null;
    }
}

class MergeLists {
    Node head;  //private Node type which will be used to create the head of a new list

    //method for node to be added to the end of the linked list
    public void addNodeToList(Node node){
        if (head == null){  //if the list is currently empty
            head = node;    //the first node added will become the head
        }
        else{ //if the list is not empty
            Node temp = head;   //a temporary node should point at the head of the list
            while (temp.next != null){  //if a node exists in succession
                temp = temp.next;   //move the temporary pointer to that node
            }
            //once broken from loop and at end of list
            temp.next = node;   //the incoming node is appended to the end of the list
        }
    }

    //method to print a list in its entirety
    void printList(){
        Node temp = head; //set a temporary node to the head of the list

        //iterate through the list until there is no next node
        while(temp != null){
            System.out.print(temp.data + " "); //print the current node
            temp = temp.next; //move to the next node
        }

        System.out.println(); //print an empty line
    }

    //driver method
    public static void main(String args[]){

        MergeLists llist1 = new MergeLists();
        MergeLists llist2 = new MergeLists();

        // Node head1 = new Node(5);
        llist1.addNodeToList(new Node(5));
        llist1.addNodeToList(new Node(10));
        llist1.addNodeToList(new Node(15));

        // Node head2 = new Node(2);
        llist2.addNodeToList(new Node(2));
        llist2.addNodeToList(new Node(3));
        llist2.addNodeToList(new Node(20));

        llist1.printList();
        llist2.printList();

        llist1.head = new MergeTwoSortedLists().sortedMerge(llist1.head, llist2.head);
        llist1.printList();
    }
}

//class definition to take two presorted lists and combine them in non-descending order
class MergeTwoSortedLists{

    //method to merge lists
    //input: two linked lists
    //returns: a single sorted linked list head node
    Node sortedMerge(Node headA, Node headB){
        Node dummyNode = new Node(0);

        Node tail = dummyNode;

        while(true) {
            //check if either list ran out of elements
            // if so use the other list to fill all remaining elements
            if (headA == null) {
                tail.next = headB;
                break;
            }
            if (headB == null) {
                tail.next = headA;
                break;
            }

            //compare all data between the two lists
            if (headA.data <= headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }

            tail = tail.next; //move the tail to next element
        }
        return dummyNode.next;
    }
}
