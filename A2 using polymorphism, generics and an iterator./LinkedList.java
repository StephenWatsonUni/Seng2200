
/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    File Name: LinkedList.java
*/
import java.util.Iterator;
public class LinkedList<T extends PlanarShape> implements Iterable<T> 
{
    //Declare private variables
    //Generic sentinel node
    private Node<T> sentinel;
    //List length
    private int length;

    //Private linkedList iterator class
    /*These methods were based of lecture slides,
    https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html,
    
    https://www.geeksforgeeks.org/iterators-in-java/,
    */
    private class LinkedListIterator implements Iterator<T>
    {
        //Declare private variables
        //Generic current node
        private Node<T> current;

        //default constructor for iterator 
        public LinkedListIterator() 
        {
            //Assigning sentinel with the current and assigning the length
            length = length;    
            current = sentinel;
        }

        //Has next method to loop through the lists collections
        //Move to the next node if it is not the sentinel.
        @Override
        public boolean hasNext() 
        {
            return (current.getNext() != sentinel); 
        }

        //Returns the next element in the iteration and will throw 
        //NoSuchElementException if no more elements to get
        public T next() 
        {

            //If the list length is not equal to length
            if(length != length)
            {
               
               System.out.print("Cannot mutate in context of iterator");
            }
            //Move to next node
            current = current.getNext();
            //Return that nodes data
            return current.getData();
        }
    }
    
     //return the Interator
    @Override
    public Iterator<T> iterator() 
    {
        return new LinkedListIterator();
    }

    //Default constrcutor for sentinel, node location and pointers 
    //modified for generics
    public LinkedList()
    {
        //Creating a new Sentinel 
        sentinel = new Node<T>(null);
        //Setting pointers to itself
        sentinel.setNext(sentinel);
        sentinel.setPrevious(sentinel);
        //Setting list length to 0
        length = 0;
    }

   //Append method modified for generics
    public void append(T newData) 
    {
        //if the list is empty
        if(length == 0)
        {
            //Call the node constructor 
            Node<T> newNode = new Node<T>(newData);
            //Assiging new Node to sentienl
            sentinel = newNode;
            //Setting previous pointer to sentinels
            newNode.setPrevious(sentinel);
            //Setting next pointer to sentinels
            newNode.setNext(sentinel);
            //Setting the sentinels next to the newNodes
            sentinel.setNext(newNode);
            //Setting the sentinels previous to the newNodes
            sentinel.setPrevious(newNode);
        }
        else
        {
            //Call the node constructor making a temp newNode  
            Node<T> newNode = new Node<T>(newData);
            //Setting the newNodes next pointer to sentinels next pointer
            newNode.setNext(sentinel.getNext());
            //Setting newNodes previous to sentinels
            newNode.setPrevious(sentinel);
            //Getting newNodes next and setting its previous to the newNodes
            newNode.getNext().setPrevious(newNode);
            //Setting sentinels next to the newNode
            sentinel.setNext(newNode);
       //Incerease the length of the list
        }
        length++;
    }

   //Prepend method modified for generics.
   public void prepend(T newData) 
   {
        //if the list is empty
        if(length == 0)
        {
            //Call the node constructor making a temp newNode  
            Node<T> newNode = new Node<T>(newData);
            //Assiging new Node to sentienl
            sentinel = newNode;
            //Setting previous pointer to sentinels
            newNode.setPrevious(sentinel);
            //Setting next pointer to sentinels
            newNode.setNext(sentinel);
            //Setting the sentinels next to the newNodes
            sentinel.setNext(newNode);
            //Setting the sentinels previous to the newNodes
            sentinel.setPrevious(newNode);
        }
        else
        {
            //Call the node constructor making a temp newNode  
            Node<T> newNode = new Node<T>(newData);
            //Setting the newNodes next pointer to sentinels next pointer
            newNode.setNext(sentinel.getNext());
            //Setting newNodes previous to sentinels
            newNode.setPrevious(sentinel);
            //Getting newNodes next and setting its previous to the newNodes
            newNode.getNext().setPrevious(newNode);
            //Setting sentinels next to the newNode
            sentinel.setNext(newNode);
            //Assigning the sentiens previous to the sentinel
            sentinel = sentinel.getPrevious();
        }
       //Incerease the length of the list
       length++;
    }

    //Remove node method modified for generics
    public T removeNode() 
    {
        Node<T> current = sentinel.getNext();       
        //If no nodes in the list
        if (length == 0) 
        {
            //Print out the list is empty
            System.out.println("Current list is empty");
        }
        else
        {
            //Make the newNode the sentienl
            Node<T> newNode = sentinel;
            //Assign the first node in the list previous to last node 
            sentinel.getNext().setPrevious(sentinel.getPrevious());
            //Assign the last node in the lists next pointer to first nodes next 
            sentinel.getPrevious().setNext(sentinel.getNext());
            //Assign the current node to the sentienl
            sentinel = current;
            //Decrease list length
            length--;
            //Return newNode data
            return newNode.getData();
        }
        //Return current data
        return current.getData();
    }

    //Insert order method modified for generics
    public void insertInOrder(T newData)
    {

        //Declaring required nodes new node and the current
        Node<T> newNode = new Node<T>(newData);        
        Node<T> current = sentinel.getNext();
        //If the current node is not the sentinel
        if(current != sentinel)
        {
            //If the current data compared to newNodes data returns not equal
            if(current.getData().compareTo(newNode.getData()) == 0)
            {
                //Move to the next node
                current = current.getNext();
            }
        }
        //Set the newNodes previous to the currents get previous
        newNode.setPrevious(current.getPrevious());
        //Set the current nodes get previous to the newNodes next
        current.getPrevious().setNext(newNode);
        //Set the currents previous to the new node
        current.setPrevious(newNode);
        //Set the newNodes net to the current
        newNode.setNext(current);
        //incrementing counter
        length++;
    }

    
    //accessor methods
    //Return the list length modified for generics
    public int getLength()
    {
        //If the current is the sentinel
        Node<T> current = sentinel;
        //initalise a int count to 0.
        int count = 0;
        //While the current is not null
        while(current != null) 
        {
            //Increase the count
            count++;
            //Move to the next node
            current = current.getNext();
        }
        return count;
        //return the count.
    }
    //Return the sentinel
    public T getSentinel() 
    {
        //Retrun sentienl data
        return sentinel.getData();
    }
    
    //Method to print the list as a string
    public String toString()
    {
        //Create a empty String 
        String out = "";
        //If no nodes are in the list 
        if(length == 0)
        {
            //Print the list is empty
            System.out.println("List is empty");
        }
        //create a new iterator object
        Iterator<T> iterator = iterator();
        //While their is another element in the list
        while(iterator.hasNext()) 
        {
            //Output the elements
            out += iterator.next().toString() + "\n";
        }
        //return the string
        return out;
    }
}