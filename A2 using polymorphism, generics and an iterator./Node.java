/*
	Student Number: c3339952
	Student Name: Stephen Watson
	Course: Seng 2200
	File Name: Node.java

	All the methods are same from Assignment 1.
	Only chages are they have been altered with generivces to accept all references

*/
public class Node<T>
{

    //private variables
    //Next pointer
    private Node<T> next;
    //Nodes data
    private T data;
    //Previous pointer
    private Node<T> previous;

    //constructor
    public Node() 
    {
    	data = null;
    	next = null;
    	previous = null;
    }

    //Parametised constructor for data
    public Node(T newData)
	{
		data = newData;
	}

    //Mutator methods
    //Setter for next pointer
    public void setNext(Node<T> newNext)
	{
		next = newNext;
	}

	//Setter for previous pointer
	public void setPrevious(Node<T> newPrevious)
	{
		previous = newPrevious;
	}

	//Setter for data
	public void setData(T newData)
	{
		data = newData;
	}
    
   //Accessor methods
   //Getter for data
    public T getData()
	{
		return data;
	}
	
	//Returning next pointer
	public Node<T> getNext()
	{
		return next;
	}
	
	//Returning previous pointer
	public Node<T> getPrevious()
	{
		return previous;
	}
}