/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    Date: 3/3/2021
    File Name: MyPolygons.java (LinkedList class)

*/
public class MyPolygons //implements ComparePoly
{
    //private variables
    //current Node pointed to
    private Node current;
    //LinkedList sentinel
    private Node sentinel;
    //List length
    private int length;

    //Default constrcutor for sentinel, node location and pointers 
    public MyPolygons()
    {
        //Creating a new Sentinel
        sentinel = new Node(null);
        //Setting pointers to itself
        sentinel.setNext(sentinel);
        sentinel.setPrevious(sentinel);
        //Assigning current node as the sentinel
        current = sentinel;
        //Setting list length to 0
        length = 0;
    }

     //@veride method to print the list as a string
    public String toString()
    {
        //creat a string
        String list = "";

        //loop through the nodes
        for (int i = 0; i < length; i++)
        {
            // assign current node data to string and assign to list
            list += current.getData().toString() + "\n";
            //Move to next node
            current = current.getNext();
        }
        // return string
        return list;
    }

   //Prepend method
   public void prepend(Polygon newData) 
   {
        //if the list is empty
        if(length == 0)
        {
            //Call the node constructor making a temp newNode  
            Node newNode = new Node(newData);
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
            Node newNode = new Node(newData);
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
            //Assigning the sentinel to the current
            current = sentinel;
        }
       //Incerease the length of the list
       length++;
    }

   public void append(Polygon newData) 
   {
        //if the list is empty
        if(length == 0)
        {
            //Call the node constructor 
            Node newNode = new Node(newData);
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
            Node newNode = new Node(newData);
            //Setting the newNodes next pointer to sentinels next pointer
            newNode.setNext(sentinel.getNext());
            //Setting newNodes previous to sentinels
            newNode.setPrevious(sentinel);
            //Getting newNodes next and setting its previous to the newNodes
            newNode.getNext().setPrevious(newNode);
            //Setting sentinels next to the newNode
            sentinel.setNext(newNode);
            //Assigning the sentinel to the current
            current = sentinel;
        }
       //Incerease the length of the list
       length++;
    }

     //Insert before current item
    public void insert(Polygon newData)
    {   
        //If the list length is zero
        if(length == 0)
        {
            
            //Call the append method to populated the list 
            append(newData);
            //Assignb sentinel to current
            current = sentinel;
        }   
        else
        {                                     
            //Create a new temp newNode
            Node newNode = new Node(newData);
            //Set the next point to current
            newNode.setNext(current);
            //Set newNode current to currents previous
            newNode.setPrevious(current.getPrevious());
            //Setting currents previosu and setting to newNode 
            current.getPrevious().setNext(newNode);
            //Setting current previous to newNode
            current.setPrevious(newNode);
            //Increasing the length of the list
            length++;
        }
    }
    //Assigning current next Node to current Node
    public void stepNext()
    {
        current = current.getNext();
    }

    //Resetting the linked list
    public void reset()
    {
        current = sentinel;
       
    }

    public void takeAndRemove()
    {       
        //Assigning the next node after the sentinel to current
        current = sentinel.getNext();
        //If the list is empty
        if (length == 0)
        {                       
           //Print out nothing in the lkist to remove
            System.out.println("Nothing in the list to remove");
        }
        //If the list has atleast 1 node with data
        else if(length == 1)
        {                  
            //Remove that node
            sentinel = null;
        }
        else
        {
            //Make a temporary node and assign it to sentinel
            Node newNode = sentinel;
            //Setting the sentinels previous node pointer to sentinels next node.    
            sentinel.getPrevious().setNext(sentinel.getNext());
            //Setting the sentinels next nodes previous to sentinels previous 
            sentinel.getNext().setPrevious(sentinel.getPrevious());
            //Assign the current node to be the new sentienl
            sentinel = current;
            //get the temporary nodes data
            newNode.getData();
            //Decrease the length of the list
            length--;
        }
        //Get the current nodes data
        current.getData();
    }

   public MyPolygons insertSort()
    {  
     //Create a linkedList
        MyPolygons linkedList = new MyPolygons();
        linkedList.reset();
        //loop through unsorted list
        for(int unsortedList = 0; unsortedList < length; unsortedList++)
        {
            //Reset the list
            linkedList.reset();
            //If the linkedList is empty
            if(linkedList.getLength() == 0)
            {                                                   
                //add to the linkedlist
                linkedList.append(sentinel.getData());
            }
            else
            {
                //Move to next node 
                linkedList.stepNext();
                //iterate through current list
                for (int i = 1; i < linkedList.getLength(); i++)
                {
                    //call the comes before method to compare data
                    if(current.getData().ComesBefore(linkedList.getCurrent()))
                    {                
                        break;
                    }
                    else
                    {
                        //iterate to next node
                        linkedList.stepNext();
                    }
                }
                //call the insert method to add to the list
                linkedList.insert(current.getData());
            }
            //move to next node
            stepNext();
        }
        //return new list
        return linkedList;
    }

    // accessor methods
    //Returns the currents data  
    public Polygon getCurrent()
    {
        //Retrun currents data
        return current.getData();
    }

    //Return the length
    public int getLength()
    {
        //Return list Length
        return length;
    }
}

    /*
     *********TESTING METHODS used to check linked list during program build***************
    

    //Checking if the list is empty
    public void isEmpty()
    {
        //If the list is empty
        if(length == 0)
        {
            //Print out list is empty
            System.out.println("Current list is empty");
        }
        else
        {   //Print out how many nodes in the list
            System.out.println(length);
        }
    }
    

    //Begining of the get location method
    public int get(int x)
    {
        //return the node in position x of the LinkedList
        return x;
    }
    
    //Returning the length of the of the linklist in testeding stage
    public int getLength()
    {
        //Creating int for a loop through
        int i = 0;
        //Assigning the sentinel to the current Node
        current = sentinel;
        //While the first node in the list is not null
        while(current.getNext().getData() != null)
        {
            //Increase the count
            i++;
            //Move to next node
            current = current.getNext();
        }
        //Assignt sentinel to current
        current = sentinel;
        //Return count
        return i;
    }
    
    //ToString method for the linklist during testing
    public String toString()
    {
        String out = "[";
        current = sentinel;
        do
        {
            current = current.getNext();
            out += current.getData();
            if(current.getNext().getData() != null)
            { 
                out += ", "; 
            }

        }
        while(current.getNext().getData() != null);
        current = sentinel;
        return out+"]";
    }
    
    End of testing methods section and file
    */




