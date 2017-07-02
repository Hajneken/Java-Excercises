package cz.cvut.fel.pjv;

/**
 * Implementation of the {@link Queue} backed by fixed size array.
 */
public class CircularArrayQueue implements Queue {
    int head;
    int rear;
    int counter = 0;
    String[] array;
    
    /**
     * Creates the queue with capacity set to the value of 5.
     */
    public CircularArrayQueue() { // defaultni konstruktor
        array = new String[5];   // deklarace pole delky 5
        head = 0; // zacina jako nula
        rear = 0; // zacina jako nula
        
        
    }
    /**
     * Creates the queue with given {@code capacity}. The capacity represents maximal number of elements that the
     * queue is able to store.
     * @param capacity of the queue
     */
    public CircularArrayQueue(int capacity) {
       array = new String[capacity];  
        head = 0; // zacina jako nula
        rear = 0; // zacina jako nula
    }

    @Override
    public int size() {
        return (counter);
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean isFull() {
        return counter == array.length;
    }
    
    @Override
    public boolean enqueue(String obj) {
      if (!isFull() && obj != null){
      array[rear] = obj;
      rear = (rear+1) % array.length;
      counter++;
      return true;
      }  
      return false;
    }

    @Override
    public String dequeue() {
        if(!isEmpty()){
        String var = array[head];
        head = (head + 1) % array.length;
        counter--;
        return var;
        }
        return null;    
        
    }

    @Override
    public void printAllElements() {
        for (int i = 0; i < counter; i++) {
            System.out.println((head + i) % array.length);             
        }
        
    }
}
