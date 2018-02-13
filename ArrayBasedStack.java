import java.util.*;

public class ArrayBasedStack<E> implements StackInterface<E> {
   private E data[];
   private int topOfStack;
   private final int INITIAL_CAPACITY = 5;
   private boolean initialized;
   
   public ArrayBasedStack (int capacity){
      if (capacity <= 0){
         throw new IllegalArgumentException("Capacity must be greater than 0");
      }else{
         E[] tempData = (E[])new Object[capacity];
         data = tempData;
         initialized = true;
      }
      topOfStack = -1;
   }
   public ArrayBasedStack (){
      this(INITIAL_CAPACITY);
   }
   private void doubleSize(){
      data = Arrays.copyOf(data, data.length * 2);
   }
   private void expandArray(){
      data = Arrays.copyOf(data, data.length * 2);
   }
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(E newEntry){
      if(topOfStack == INITIAL_CAPACITY){
         expandArray();
      }
      else{
         data[topOfStack++] = newEntry;
      }
   }
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public E pop(){
      if(isEmpty()){
         throw new EmptyStackException();
      }
      else{
         E element = data[topOfStack];
         data[topOfStack] = null;
      }
      return data[--topOfStack];
   }
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public E peek(){
      if(isEmpty()){
         throw new EmptyStackException();
      }
      else{
         return data[topOfStack];
      }
   }
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty(){
      if (topOfStack < 0){
         return true;
      }
      else{
         return false;
      }
   }
  
   /** Removes all entries from this stack. */
   public void clear(){
      if(!isEmpty()){
         for(int i =0; i < data.length; i ++){
            pop();
         }
      }
      else{
         throw new EmptyStackException();
      }
   }

}