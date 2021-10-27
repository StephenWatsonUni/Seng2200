/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    File Name: SemiCircle.java

    The use of the void draw method was inspired by the following reference, This will be the same for all shape classes
    
    https://www.tutorialspoint.com/design_pattern/factory_pattern.htm#:~:
    text=Factory%20pattern%20is%20one%20of%20the%20most%20used%20design%20patterns%20in%20Java.
    &text=In%20Factory%20pattern%2C%20we%20create,object%20using%20a%20common%20interface.
*/

import java.lang.Math;
public class SemiCircle extends PlanarShape
{
    //Private variables
    //Int n is counter for the number of points
    private int n;
    //points array
    private Point points[];
    
    //Default constructor
    public SemiCircle()
    {
        //Creating n counter
        int n = 0;
        //Creating points array
        points = new Point[2];
        //Assigning array positions to a new point
        points[0] = new Point();
        points[1] = new Point();
    }

    public SemiCircle(double x, double y)
    {
        //Creating n counter
        int n = 0;
        //Creating points array
        points = new Point[2];
        //Assigning array positions to a new point
        points[0] = new Point();
        points[1] = new Point();
    }

    //Same addPoint method used across the entire program
    public void addPoint(double x, double y) 
    {
        //adding a new point to the array using x, y
        points[n] = new Point(x, y);
       //Increasing the n as each point is added
        n++;
    }

     //Original distance method
    public double originDistance() 
    {
        //Creating 2 distances 
        double distance1 = 0;
        double distance2 = 0;
        //Loop through both distances
        for (int i = 0; i < 2; i++) 
        {
            //If distance 1 = point distance
            distance1 = points[i].getPointDistance();
            //And distance 1 is less than distance 2
            if(distance1 < distance2)
            {
                //Assign distance 1 to distance 2
                distance2 = distance1;
            }
        }
        //Return distance 2
        return distance2;
    }
    
    //Calculating radius method
    private double calculateiRadius() 
    {
        //Radius = (x1 -x0)/2 + (y1-y0)/2 
        double radius = Math.pow((points[1].getX()- points[0].getX()), 2);
        radius = radius + Math.pow((points[1].getY()-points[0].getY()), 2);
        radius = Math.sqrt(radius);
        //Returning radius
        return radius;
    }

    public double calculateArea()
    {
        //Calculating area 
        //area = PI*(radius* radius) divided by 2
        double area = (Math.PI*(calculateiRadius()*calculateiRadius()));
        area = area/2.0;
        return area;
    }

    //ToString method
    public String toString() 
    {
        //create an empty string
        String out = "Semi=[";
        //Loop through
        for(int i = 0; i < n; i++)
        {
            //Assign the String to the aqrray
            out += points[i];
        }
        //Retrurn the string
        return out += String.format("]: %5.2f", calculateArea());
    }

    @Override
    public void draw() 
    {
        System.out.println("Inside Semi-Circle::draw() method");
    }
}

