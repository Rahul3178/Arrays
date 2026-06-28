package deleted;

class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

class LinkedLi{
    Node head;


    public void reverse(){
        Node prev=null;
        Node next=null;
        Node current=head;

        while(current!=null)
        {
            next=current.next;
            current.next=prev;

            prev=current;
            current=next;
        }

        head=prev;
    }

    public void display()
    {
        Node temp=head;
        while(temp != null)
        {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }

    public void append(int data)
    {
        if (head ==null)
        {
            head= new Node(data);
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }

        temp.next=new Node(data);
    }
}
public class ReverseLinkedList {
    public static void main(String[] args) {

        LinkedLi ls= new LinkedLi();
        ls.append(2);
        ls.append(3);
        ls.append(4);
        ls.append(5);
        ls.append(7);
        ls.display();
        ls.reverse();
        ls.display();
    }
}
