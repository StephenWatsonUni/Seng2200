/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    File Name: Polygon.java

    The use of the void draw method was inspired by the following reference, This will be the same for all shape classes
    
    https://www.tutorialspoint.com/design_pattern/factory_pattern.htm#:~:
    text=Factory%20pattern%20is%20one%20of%20the%20most%20used%20design%20patterns%20in%20Java.
    &text=In%20Factory%20pattern%2C%20we%20create,object%20using%20a%20common%20interface.
*/
public class Polygon extends PlanarShape
{
  //Private variables and array
    private Point points[];
    private int n;
    private double distance;  

	//default constructor
    public Polygon()
    {
        //Creating point array
        points = new Point[n];
        //Creating number counter
        n = 0;
        //creating distance  variable
        distance = 0;   
    }
   
    //Paramertised constructor
	public Polygon(int newN)
	{
        //Creating points array
		this.points = new Point[newN];
		//Creating an int counter
        this.n = 0;
		// creating distance
        this.distance = 0;
    }
    
    //adding points to the polygon
    public void addPoint(double x, double y) 
    {
        //adding a new point to the array using x, y
        points[n] = new Point(x, y);
       //Increasing the length as each point is added
        n++;
    }

    //Calculate area function
    public double calculateArea()
    {   
        //Creating are variablee
        double area = 0;
        //Looping through the points of the polygon
        for(int i = 0; i < n-1; i++)
        {
            //Applying area formula
            area += (points[i].getX() + points[i+1].getX()) * (points[i].getY() - points[i+1].getY());
        }
        //Returning area
        return (0.5 * Math.abs(area));
    }
    
    //Calculate distance from origin
    public double originDistance() 
    {
        //Creating distance variables
        double distance1 = 0;
        double distance2 = 0;
        //Looping through the points
        for (int i = 0; i < n; i++) 
        {
            distance1 = points[i].getPointDistance();
            if (distance1 < distance2)
            {
                distance2 = distance1;
            }
        }
        return distance2;
    }

     //ToString method used to print the array 
    public String toString()
    {
        //Printing method for printing the array to string
        //Creating a new String
        String out = "Poly=[";
        //Looping through the total points
        for(int i = 0; i < n; i++)
        {
            //Assigning the array to out string
            out += points[i].toString();

        }
        //Returning the out string in requireed format and calling the calculated area method
        return out+"]:" + " " +String.format("%5.2f" , calculateArea());
    }

    @Override
    public void draw() 
    {
        System.out.println("Inside Polygon::draw() method");
    }   
}
