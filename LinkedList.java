public class LinkedList {
  private Node head;
  private int size;

  public LinkedList() {
    head = null;
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public Node getHead() {
    return head;
  }

  //add a new node to the end of the list
  public void add(double value) {
    if(head == null) {
      head = new Node(value, null);
      size++;
    }
    else {
      Node pointer = head;
      Node temp = new Node(value, null);
      while(pointer.next != null){
        pointer = pointer.next;
      }
      pointer.next = temp;
      size++;
    }
  }

  //insert a node before the first occurence of the targetted value
  public void insertBeforeFirstInstance(LinkedList list, double target, double value) {
    Node insert = new Node(value, null);
    Node pointer;
    Node temp;

    if(list.getSize() == 0) {
      list.add(value);
    }
    else if(list.head.value == target) {
      temp = list.head;
      list.head = insert;
      insert.next = temp;
    }
    else {
      pointer = list.head.next;
      temp = list.head;
      while(pointer.next != null) {
        if(pointer.value == target) {
          insert.next = pointer;
          temp.next = insert;
          break;
        }
        pointer = pointer.next;
        temp = temp.next;
      }
    }
  }

  /**
  Recursive solution
  */
  public void reverse(Node current) {
    //check for empty list
    if(current == null) {
      return;
    }

    //BASE CASE: we are at the tail node. Set HEAD equal to this node
    if(current.next == null) {
      head = current;
      return; //since this is the base case
    }

    //recursive step
    reverse(current.next);
    current.next.next = current;
    current.next = null; //set old next pointer to null
  }

  public void print() {
    Node pointer = head;
    if(size == 0){
      System.out.println("List is empty");
    }
    else {
      while(pointer != null){
        System.out.println(pointer.value + " ");
        pointer = pointer.next;
      }
    }
  }


//*************************************************
  private class Node {
    double value;
    Node next;

    public Node(double value, Node next) {
      this.value = value;
      this.next = next;
    }

    public Node getNext() {
      return this.next;
    }

    public double getValue() {
      return this.value;
    }
  }
//*************************************************

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    for(int i = 0; i < 20; i++) {
      list.add(i);
    }
    
    list.print();
    System.out.println(" ");
    list.reverse(list.head);
    list.print();
  }
}
