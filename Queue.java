public class Queue<Item> {
  private Node first;
  private Node last;
  private int N;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void enqueue(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;

    if(isEmpty()) {
      first = last;
    }
    else {
      oldLast.next = last;
    }
    N++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    if(isEmpty()) {
      last = null;
    }
    N--;
    return item;
  }

  //*********************
  private class Node {
    Item item;
    Node next;
  }
  //*********************

  public static void main(String[] args) {
    Queue<Integer> q = new Queue<Integer>();
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    q.enqueue(8);
    System.out.println("Queue size: " + q.size());
    
    while(!q.isEmpty()) {
      int current = q.dequeue();
      System.out.println("Dequeued: " + current);
    }
  }
}
