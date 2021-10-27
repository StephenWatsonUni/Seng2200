/*
	Student Number: c3339952
	Student Name: Stephen Watson
	Course: Seng 2200
	File Name: FactoryMethod.java

	Sources used to help build and understand this class

	Source 1:
	https://www.tutorialspoint.com/design_pattern/factory_pattern.htm#:~:text=Factory
	%20pattern%20is%20one%20of%20the%20most%20used%20design%20patterns%20in%20
	Java.&text=In%20Factory%20pattern%2C%20we%20create,object%20using%20a%20common
	%20interface.

	Source 2:
	https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm

	Source 3:
	https://codereview.stackexchange.com/questions/122032/instantiating-shapes-using-the-factory-design-pattern-in-java

    Source 4:
    https://www.javatpoint.com/factory-method-design-pattern
*/

import java.util.Scanner;
public class FactoryMethod 
{
	//Factory method
	public static PlanarShape factoryStrMethod(String confirmShape)
    {
        //Create a Scanner to read the input
        Scanner inputStream = new Scanner(confirmShape);
        //Create a planershape and set to null
        PlanarShape shape = null;
        //While the scanner reads next line
        while(inputStream.hasNext())
        { 
            //Assigning the scanner read to the string
            confirmShape = inputStream.next();
            //Creating a switch for the 3 different shapes we could have
            switch(confirmShape)
            {
                //if the Scanner reads a semi circle
                case "S":
                {
                    //If the string equals Semi circle
                    if(confirmShape.equals("S"))
                    {
                        //Assing x value to 0 before the input comes
                        double x = 0;
                        //Assing y value to 0 before the input comes
                        double y = 0;
                        //Create the new circle object with paramertised constructor
                        PlanarShape semiCircle = new SemiCircle(x,y);
                        //Take in the x value
                        x = inputStream.nextDouble();
                        //Take in the y value
                        y = inputStream.nextDouble();
						//Add the points
						semiCircle.addPoint(x, y);
						//Return shape
						return semiCircle;
                    }
                    break;
                }  
                //if the Scanner reads a circle
                case "C":
                {
                    //If the string is circle
                    if(confirmShape.equals("C"))
                    {
                         
                        //Assing radius value to 0 before the input comes
                        double newRadius = 0;
                        //Assing x value to 0 before the input comes
                        double x = 0;
                        //Assing y value to 0 before the input comes
                        double y = 0;
                        //Take in the radius value
                        newRadius = inputStream.nextDouble();
                        //Take in the x value
                        x = inputStream.nextDouble();
                        //Take in the y value
                        y = inputStream.nextDouble();
                         //Create a new  circle via paramertised constructor
                        PlanarShape circle = new Circle(newRadius);
                        //Add the points to circle
                        circle.addPoint(x, y);
                        //Return the shape
                        return circle;
                    }
                    break;
                }
                
                case "P":
                {
                    if(confirmShape.equals("P"))
                    {
                       int n = 0;
                        //Set x to 0   
                        double x = 0;
                        //Set y to 0
                        double y = 0; 
                        //int assign inputstream to count
                        n = inputStream.nextInt();
                        //Create a new poly object 
                        PlanarShape poly = new Polygon(n);               
                        //creating array for the  new points to be stored
                        Point[] points = new Point[n];                                          
                        //Loop through
                        for (int i = 0; i < n; i++)
                        {
                            //Take in the x value
                            x = inputStream.nextDouble();
                            //Take in the y value
                            y = inputStream.nextDouble();
                           //Create new points
                           points[0] = new Point(x, y);
                           //add in the points
                           poly.addPoint(x, y); 
                        }
                        return poly;
                    }
                    break;       
                }
            }
        }
        //Returning the chosen shape type
        return shape;
    }
}