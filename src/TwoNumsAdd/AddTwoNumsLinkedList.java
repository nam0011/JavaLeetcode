package TwoNumsAdd;


import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class AddTwoNumsLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0); // create a new list to return the combined number
        ListNode currentNode = l3; //set the current node to the new list
        int carry = 0, sum; //set int values for the current rollover and sum of numbers
        while(l1!=null || l2!=null){ // if either of the lists are not empty continue working
            sum = 0; //set sum = 0
            if(l1!=null){ //if the current node of list one is not equal to zero
                sum += l1.val;//add that number to the sum
                l1 = l1.next; // move to the next index of the list
            }
            if(l2!=null){ //if the current node of list two is not equal to zero
                sum += l2.val; //add that number to the sum
                l2 = l2.next; // move to the next index of the list
            }
            sum += carry;
            carry = sum / 10;
            ListNode remainder = new ListNode(sum % 10);
            currentNode.next = remainder;
            currentNode = currentNode.next;
        }
        if(carry!=0){
            ListNode zeroRemainder = new ListNode(carry);
            currentNode.next = zeroRemainder;
        }
        return l3.next;
    }

    ListNode head;  //private Node type which will be used to create the head of a new list
    public void addNodeToList(ListNode node){
        if (head == null){  //if the list is currently empty
            head = node;    //the first node added will become the head
        }
        else{ //if the list is not empty
            ListNode temp = head;   //a temporary node should point at the head of the list
            while (temp.next != null){  //if a node exists in succession
                temp = temp.next;   //move the temporary pointer to that node
            }
            //once broken from loop and at end of list
            temp.next = node;   //the incoming node is appended to the end of the list
        }
    }

    //method to print a list in its entirety
    void printList(){
        ListNode temp = head; //set a temporary node to the head of the list

        //iterate through the list until there is no next node
        while(temp != null){
            System.out.print(temp.val + " "); //print the current node
            temp = temp.next; //move to the next node
        }

        System.out.println(); //print an empty line
    }
    public static void main(String[] Args) {
        AddTwoNumsLinkedList llist1 = new AddTwoNumsLinkedList();
        AddTwoNumsLinkedList llist2 = new AddTwoNumsLinkedList();
        AddTwoNumsLinkedList llist3 = new AddTwoNumsLinkedList();

        // Node head1 = new Node(5);
        llist1.addNodeToList(new ListNode(5));
        llist1.addNodeToList(new ListNode(7));
        llist1.addNodeToList(new ListNode(3));

        // Node head2 = new Node(2);
        llist2.addNodeToList(new ListNode(2));
        llist2.addNodeToList(new ListNode(3));
        llist2.addNodeToList(new ListNode(7));

        llist1.printList();
        llist2.printList();

        llist3.head = new AddTwoNumsLinkedList().addTwoNumbers(llist1.head, llist2.head);

        llist3.printList();
    }

}
