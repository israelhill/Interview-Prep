import java.util.Iterator;
public class MyStack<Item> implements Iterable<Item> {

  private Node first;
  private int N;
  
 //************************
  private class Node {
    Item item;
    Node next;
  }
 //************************
  
  public boolean isEmpty() {
    return first == null;
  }
  
  public int size() {
    return N;
  }
  
  public void push(Item item) {
  Node oldFirst = first;
  first = new Node();
  first.item = item;
  first.next = oldFirst;
  N++;
  }
  
  public Item pop() {
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new MyIterator();
  }

  //**************************************************
  private class MyIterator implements Iterator<Item>{
    private Node pointer = first;
    
    public boolean hasNext() {
      return pointer != null;
    }
    
    public void remove(){}
    
    public Item next() {
    Item item = pointer.item;
    pointer = pointer.next;
    return item;
    } 
  }
//********************************************************  
  
  public static void main(String[] args) { 
// Create a stack and push/pop strings as directed on StdIn. 
    MyStack<Integer> s = new MyStack<Integer>(); 
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
  }
  
}