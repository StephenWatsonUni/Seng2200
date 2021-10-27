/*
	Student Number: c3339952
	Student Name: Stephen Watson
	Course: Seng 2200
	Date: 1/3/2021
	File Name: Node.java

*/
public class Node
{
	//private variables
	//Object data
	private Polygon data;
	//Next pointer
	private Node next;
	//Previous pointer
	private Node previous;
	//Int Location
	private int location;	
 
	//Parametised constructor
	public Node(Polygon newData)
	{
		data = newData;
		next = null;
		previous = null;
	}

	//Mutator methods
	//Setter for data
	public void setData(Polygon newData)
	{
		data = newData;
	}
	//Setter for next pointer
	public void setNext(Node newNext)
	{
		next = newNext;
	}
	//Setter for previous pointer
	public void setPrevious(Node newPrevious)
	{
		previous = newPrevious;
	}
	//Setter for int location
	public void setLocation(int newLocation)
	{
		location = location;
	}
	//Accessor methods
	//Returning data
	public Polygon getData()
	{
		return data;
	}
	//Returning next pointer
	public Node getNext()
	{
		return next;
	}
	//Returning previous pointer
	public Node getPrevious()
	{
		return previous;
	}
	//Returning location
	public int getLocation()
	{
		return location;
	}
}