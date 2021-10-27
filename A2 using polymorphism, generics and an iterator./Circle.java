/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    File Name: Circle.java

    The use of the void draw method was inspired by the following reference, This will be the same for all shape classes
    
    https://www.tutorialspoint.com/design_pattern/factory_pattern.htm#:~:
    text=Factory%20pattern%20is%20one%20of%20the%20most%20used%20design%20patterns%20in%20Java.
    &text=In%20Factory%20pattern%2C%20we%20create,object%20using%20a%20common%20interface.
*/


import java.lang.Math;
public class Circle extends PlanarShape 
{

    //Private variables
    private Point points[];
    private Point centre;
    private double radius;
    private int n = 1;
    
    //Default constructor
    public Circle() 
    {
        
        //Assigning points to a new point
        points = new Point[n];
        //Creating centre as a new point
        centre = new Point();
        //Creating a radius variable
        radius = radius;   
    }
    
    //Paramertised constructors
    public Circle(double newRadius) 
    {
        //Assigning points to a new point
        points = new Point[n];
        //Assigning centre to a new point
        this.centre = new Point();
        //Assigning radius to a newRadius
        this.radius = newRadius;
    }
 
    //add points into the array
    public void addPoint(double x, double y)
    {
        //The centre point has new x and y point
        centre = new Point(x, y);
        //Assigning the points to the array
        points[0] = centre;
    }
    
    //calculates the area of a circle
    public double calculateArea()
    {
        //Area is PI*radius*radius
        double area = Math.PI*radius*radius;
        //Return Area
        return area;       
    }

    //Calcs origin distance 
    public double originDistance()
    {
        //Create double distance
        double distance;
        //Distance is the result of the get point distance from the centre - radius 
        distance = centre.getPointDistance();
        distance = distance - radius;
        //Return the distance
        return distance;
    }
      
    //Print the array method
    public String toString() 
    {
        //Create a string out
        String out = "CIRC=[";
        //Assign array to string
        out +=  points[0]; 
        //Assign the radius the string with required formatting
        out += String.format("%3.2f", radius);
        //Assign the format the string with required formatting
        out += String.format("]: %5.2f", calculateArea());
        //Retrun the string
        return out;
    }

    @Override
    public void draw() 
    {
        System.out.println("Inside circle::draw() method");
    }
} 









