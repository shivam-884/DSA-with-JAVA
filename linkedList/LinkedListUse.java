package linkedList;

import java.net.Inet4Address;
import java.util.Scanner;

class DoubleNode{
    Node<Integer> head;
    Node<Integer> tail;

    DoubleNode(){

    }

    DoubleNode(Node<Integer> head, Node<Integer> tail){
        this.head = head;
        this.tail = tail;
    }
}

public class LinkedListUse {

    public static Node<Integer> createLinkedList(){
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);

        n1.next = n2;
//        System.out.println("n1 " + n1 + " data " + n1.data + " next " + n1.next);
        n2.next = n3;
//        System.out.println("n2 " + n2 + " data " + n2.data + " next " + n2.next);
        n3.next = n4;
//        System.out.println("n3 " + n3 + " data " + n3.data + " next " + n3.next);
        n4.next = null;
//        System.out.println("n4 " + n4 + " data " + n4.data + " next " + n4.next);

        return n1;

    }

     public static void print(Node<Integer> head){
//         System.out.println("Print " + head);
         Node<Integer> temp = head;
         while(temp != null){
             System.out.print(temp.data + " ");
             temp = temp.next;
         }
         System.out.println();
     }

     public static void increment(Node<Integer> head){
         Node<Integer> temp = head;
         while(temp != null){
             temp.data++;
             temp = temp.next;
         }
     }

     public static void printIthNode(Node<Integer> head, int i){
         Node<Integer> temp = head;
         int count = 0;
         while(temp != null && count < i){
             temp = temp.next;
             count++;
         }
         if(temp != null){
             System.out.println(temp.data);
         }else {
             return;
         }
     }

     public static int lengthOfLL(Node<Integer> head){
         Node<Integer> temp = head;
         int count = 0;
         while(temp != null){
             count++;
             temp = temp.next;
         }
         return count;
     }

     public static Node<Integer> takeInput(){
         Scanner s = new Scanner(System.in);
         int data = s.nextInt();
         Node<Integer> head = null;
         Node<Integer> tail = null;

         // O(n^2) time complexity

//         while (data != -1){
//             Node<Integer> currentNode = new Node<Integer>(data);
//             if(head == null){
//                 // Make this node as head node
//                 head = currentNode;
//             } else{
//                Node<Integer> tail = head;
//                while (tail.next != null){
//                    tail = tail.next;
//                }
//                // Now tail will refer to last node
//                 // Connect current node after last node
//                 tail.next = currentNode;
//             }
//             data = s.nextInt();
//         }



         // O(n) time complexity

         while (data != -1){
             Node<Integer> currentNode =new  Node<Integer>(data);
             if(head == null){
                 head = currentNode;
                 tail = currentNode;
             }else{
                 tail.next = currentNode;
                 tail = currentNode;
             }
             data = s.nextInt();
         }
         return head;
     }

     public static Node<Integer> insertNode(Node<Integer> head, int pos, int element){
        Node<Integer> newNode = new Node<Integer>(element);
        int count = 0;
        if(pos == 0){
            newNode.next = head;
            return newNode;
        }else {
        Node<Integer> temp = head;
            while (temp != null && count < pos - 1) {
                count++;
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return head;
     }

     // RECURSIVELY INSERT
    public static Node<Integer> insertRecursive(Node<Integer> head, int pos, int data){
        if(head == null && pos > 0){
            return head;
        }else if(pos == 0){
            Node<Integer> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            return head;
        }else{
            Node<Integer> temp = insertRecursive(head.next, pos-1, data);
            head.next = temp;
            return head;
        }
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int pos){
        int count = 0;

        if(pos == 0 && head != null){
            head = head.next;
        }else{
        Node<Integer> temp = head;
        while(temp != null && count < pos-1){
            count++;
            temp = temp.next;
        }
        if(temp != null && temp.next != null){
            temp.next = temp.next.next;
        }
        }
        return head;
     }

     // DELETE RECURSIVELY
    public static Node<Integer> deleteRecursive(Node<Integer> head, int pos){
        if(head == null){
            return head;
        }else if(pos == 0){
            head = head.next;
            return head;
        }else{
            head.next = deleteRecursive(head.next, pos-1);
            return head;
        }
    }

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        //Your code goes here

        Node<Integer> temp = head;
        Node<Integer> temp1 = head;

        if(temp == null){
            return temp;
        }else{
            while(temp != null && temp.next != null){
                if(temp.data != temp.next.data){
                    temp = temp.next;
                    temp1.next = temp;
                    temp1 = temp1.next;
                }else{
                    temp = temp.next;
                }
            }
            temp1.next = null;
            return head;
        }

    }


    // RECURSIVELY O(N^2)
  public static Node<Integer> printReverseRec(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }else{
            Node<Integer> newNode = printReverseRec(head.next);
            Node<Integer> tail = newNode;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = head;
            head.next = null;

           return newNode;

        }
    }

    public static DoubleNode printBetterRevRec(Node<Integer> head){
        DoubleNode ans;
        if(head == null || head.next == null){
            ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        DoubleNode smallAns = printBetterRevRec(head.next);
        smallAns.tail.next = head;
        head.next = null;

        ans = new DoubleNode();

        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }

    public static Node<Integer> printReverse(Node<Integer> head){
       Node<Integer> prev = null;
       Node<Integer> current = head;
       Node<Integer> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
         head = prev;
        return head;
    }

    public static Node<Integer> printRevRecBest(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> smallHead = printRevRecBest(head.next);
        Node<Integer> reversedTail = head.next;
        reversedTail.next = head;
        head.next = null;
        return smallHead;
    }

    public static boolean isPalindrome(Node<Integer> head){
        int length = lengthOfLL(head);
        Node<Integer> temp = head;
        if(temp == null || length == 1){
            return true;
        }else{
            int count = 0;
            while (temp != null && count<length/2){
                count++;
                temp = temp.next;
            }
            Node<Integer> newNode = printReverse(temp);
            count = 0;
            boolean check = false;
            while (count < length/2){
                count++;
                if(head.data == newNode.data){
                    head = head.next;
                    newNode = newNode.next;
                    check = true;
                }else{
                    check = false;
                    break;
                }
            }
            return check;
        }
    }

    public static Node<Integer> midPointOfLL(Node<Integer> head){
        Node<Integer> fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> mergeSortedLL(Node<Integer> head1, Node<Integer> head2){
        Node<Integer> t1 = head1;
        Node<Integer> t2 = head2;
        Node<Integer> head = null;


        if(t1 == null){
            return t2;
        }else if(t2 == null){
            return t1;
        }else if(t1.data <= t2.data){
            head = t1;
            t1 = t1.next;
        }else{
            head = t2;
            t2 = t2.next;
        }

        Node<Integer> temp = head;

        while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                temp.next = t1;
                t1 = t1.next;
                temp = temp.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
                temp = temp.next;
            }
        }

        if(t1 != null){
            temp.next = t1;
        }

        if(t2 != null){
           temp.next = t2;
        }

        return head;
    }

    public static Node<Integer> mergeSortLL(Node<Integer> head){
        Node<Integer> part1head = null;
        Node<Integer> part2head = null;

        if(head == null || head.next == null){
            return head;
        }
        part1head = head;

        // Finding mid of LL
        Node<Integer> fast = head, temp = head;
        while(fast.next != null && fast.next.next != null) {
            temp = temp.next;
            fast = fast.next.next;
        }

        part2head = temp.next;
        temp.next = null;

        part1head = mergeSortLL(part1head);
        part2head = mergeSortLL(part2head);
        return mergeSortedLL(part1head, part2head);

    }

    public static void main(String[] args) {

//        Node<Integer> head = createLinkedList();
//        System.out.println("Main " + head);
//        increment(head);
//        print(head);
//        System.out.println(lengthOfLL(head));

//        Node<Integer> head = takeInput();
//        print(head);
//        printIthNode(head, 2);


//        Node<Integer> n1 = new Node<>(10);
//        System.out.println(n1);
//        System.out.println(n1.data);
//        System.out.println(n1.next);

//        Node<Integer> head = createLinkedList();
//        print(head);
//        head = insertNode(head, 5,25);
//        print(head);

//        Node<Integer> head = takeInput();
//        print(head);
//        head = deleteNode(head, 5);
//        print(head);


//        Node<Integer> head = takeInput();
//        print(head);
//        head = removeDuplicates(head);
//        print(head);

//        Node<Integer> head = takeInput();
//        print(head);
//        head = printReverse(head);
//        print(head);

//        Node<Integer> head = takeInput();
//        print(head);
//        head = printReverseRec(head);
//        print(head);

//        Node<Integer> head = takeInput();
//        print(head);
//        DoubleNode ans = printBetterRevRec(head);
//        print(ans.head);

//        Node<Integer> head = takeInput();
//        print(head);
//        head = printRevRecBest(head);
//        print(head);


//        Node<Integer> head = takeInput();
//        print(head);
//        System.out.println(isPalindrome(head));


//        Node<Integer> head = takeInput();
//        print(head);
//        head = insertRecursive(head, 0, 20);
//        print(head);

//        Node<Integer> head = takeInput();
//        print(head);
//        Node<Integer> midNode = midPointOfLL(head);
//        System.out.println(midNode.data);

//        Node<Integer> head1 = takeInput();
//        Node<Integer> head2 = takeInput();
//        print(head1);
//        print(head2);
//
//        Node<Integer> head = mergeSortedLL(head1, head2);
//        print(head);


        Node<Integer> head = takeInput();
        print(head);
       Node<Integer> newHead = mergeSortLL(head);
        print(newHead);
    }
}
