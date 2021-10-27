/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    Date: 5/3/2021
    File Name: Point.java

*/
//Importing the math library
import java.lang.Math;

public class Point
{
	//Private variables
	//X coordinate
	double x;
	//Y coordinate
	double y;
	//Distance
	double pointDistance;

	//paramertised constructor
	public Point(double newX, double newY) 
	{
		//Setting x, y and distance 
		x = newX;
		y = newY;
		pointDistance = 0.0;
	}

	//Mutator methods	
	//Setting x point
	public void setX(double newX)
	{
		x = newX;
	}
	//Setting y point
	public void setY(double newY)
	{
		y = newY;
	}
	
	//Accessor methods
	//getting x point
	public double getX()
	{
		return x;
	}
	//getting y point
	public double getY()
	{
		return y;
	}
	
	//Getting the distance
	public double getPointDistance() 
	{
		double pointDistance = 0;
		pointDistance = Math.sqrt((x*x) + (y*y));
		return pointDistance;
	}

	//ToString method printing oiut in the format required 
    public String toString()
    {
        //declaring a string points
        String points = "";
        //Print x with with the required format
        String newX = String.format("%3.2f", x);
        //Print y with the required format
        String newY = String.format("%3.2f", y);
        //Concatinating the string
        points = "("+newX + "," + newY +")";
        //Returning the string
        return points;
    }
}