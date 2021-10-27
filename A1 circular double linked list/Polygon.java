/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    Date: 8/3/2021 
    File Name: Polygons.java

*/

public class Polygon implements ComparePoly
{
  //Private variables and arrays
    private Point[] polygon; 
    private int pointCounter; 
    private double distance;  

	// constructor
	public Polygon(int point)
	{
		//instantiating variables and objects
		polygon = new Point[point];
		pointCounter = 0;
		distance = 0;
	}

    //ToString method used to print the array 
    public String toString()
    {
        //Printing method for printing the array to string
        //Creating a new String
        String out = "[";
        //Looping through the total points
        for(int i = 0; i < pointCounter; i++)
        {
            //Assigning the array to out string
            out += polygon[i].toString();

        }
        //Returning the out string in requireed format and calling the calculated area method
        return out+"]:" + " " +String.format("%5.2f" , calculateArea());
    }
	
    public double calculateArea()
    {   
        double area = 0;
        //Looping through the points of the polygon
        for(int i = 0; i < pointCounter-1; i++)
        {
            //Applying the Assignments given formula
            area += (polygon[i].getX() + polygon[i+1].getX()) * (polygon[i].getY() - polygon[i+1].getY());
        }
        //Multiply any negitaves by -1 to get only positive output back
        if(area < 0)
        {
            area = area*-1;
        }
        //Completing the formula by halfing it
        area = area/2;
        //Returning the area
        return area;
    }

      // adding points to the polygon
    public void addPoint(double x, double y) 
    {
        //adding a new point to the array using x, y
        polygon[pointCounter] = new Point(x, y);
       //Increasing the length as each point is added
        pointCounter++;
    }
    
    public boolean ComesBefore(Polygon o)
    {
        //assigning the area of polygon one to poly1
        double poly1 = calculateArea();
        ////assigning the area of polygon two to poly2
        double poly2 = o.calculateArea();
        //Setting percentage to measure against
        double percentage = 0.001;
        //Calculating both polys against each other
        double difference = Math.sqrt((poly1-poly2)*(poly1-poly2));
        //If poly2 is greater than poly1
        if (poly1 < poly2)
        {
            //And the differnce divided by poly1 is less than 0.001
            if (difference/poly1 < percentage)
            {
                //Poly 1 point of origin is less than poly 2 point of origin 
                //Return it true
                if(distance < o.distance)
                {
                    return true;
                } 
                //If not return it false
                else 
                {
                    return false;
                }
            }
        }
        else 
        {
            //And the differnce divided by poly2  is less than 0.001
            if(difference/poly2 < percentage)
            {
                //Poly 1 point of origin is less than poly 2 point of origin 
                //Return it true
                if(distance < o.distance)
                {
                    return true;
                } 
                else 
                //If not return it false
                {
                    return false;
                }
            }
        }
        //If poly1 area is less than poly2 area retrun true
        if(calculateArea() < o.calculateArea())
        {
            return true;
        } 
        //all other cases return false
        else 
        {
            return false;
        }
    }
}
