package SortingLists;

import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class SortingLinkedLists {

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

    private ListNode partition(ListNode head){
        ListNode fast = head.next, slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }
    private ListNode merge(ListNode a, ListNode b){
        ListNode c = null;
        if(a.val <= b.val) c = a;
        else{
            c = b;
            b = a;
            a = c;
        }
        while(a.next != null){
            if(a.next.val > b.val){
                ListNode temp = a.next;
                a.next = b;
                b = temp;
            }
            a = a.next;
        }
        a.next = b;
        return c;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode second = partition(head);
        head = sortList(head);
        second = sortList(second);
        return merge(head, second);
    }

    public static void main(String[] args) {
        SortingLinkedLists list1 = new SortingLinkedLists();

        int max = 10;
        int min = 1;
        int range = max - min + 1;

        for(int i = 0; i < 10; i++){
            int rand = (int)(Math.random() * range) + min;
            list1.addNodeToList(new ListNode(rand));
        }

        list1.sortList(list1.head);
        list1.printList();
    }
}
