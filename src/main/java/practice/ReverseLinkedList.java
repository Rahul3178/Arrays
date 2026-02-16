package practice;

class Node{

    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;

    }

}

class LinkedList{

    Node head;

    // function to reverse the linked list
    public void reverse()
    {
        Node prev=null;
        Node current=head;
        Node next=null;

        while (current!= null)
        {
           next= current.next; // store next node
            current.next=prev; // reverse the link


            // move pointer one step forward
            prev=current;
            current=next;
        }
        head=prev; // update the head to the first new node
    }


    public  void print()
    {
        Node temp=head;

        while (temp!=null)
        {
            System.out.println(temp.data+"");
            temp=temp.next;
        }
        System.out.println();
    }


    // function to append a new node
    public void append(int data)
    {
        if (head == null)
        {
            head= new Node(data);
            return;
        }

        Node temp=head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }

        temp.next=new Node(data);
    }

}

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.append(1);
        ls.append(2);
        ls.append(3);
        ls.append(4);

        ls.reverse();
        ls.print();
    }
}
