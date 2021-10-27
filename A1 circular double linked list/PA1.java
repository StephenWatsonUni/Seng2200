/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200b
    Date: 13/3/2021
    File Name: PA1.java 

*/

import java.util.*;
import java.io.*;
public class PA1 
{

    public static void main(String args[])
    {
        //create new linkedList 
        MyPolygons polygonList = new MyPolygons();
        try 
        {
            //Creating a file scanner to take the input
            Scanner inputStream = new Scanner(new File(args[0]));
            //Using a do while loop so I can see it run atleast once
            do
            {
                //Create a string
                String list = "";
                //Assigning the input to the string
                list = inputStream.next();
                //Reading the input 
                int count = inputStream.nextInt();
                //scanner reads "P"
                if(list.equals("P")) 
                { 
                    //Create a new polygon 
                    Polygon data = new Polygon(count);
                    //creating an array of points to be stored
                    Point[] points = new Point[count];
                    //create int variables
                    int newPoint = 0;
                    int j = 1;
                    while (j <= count) 
                    {
                        //declare x double and creating it based off the input
                        double x = inputStream.nextDouble();
                        //declare y double and creating it based off the input
                        double y = inputStream.nextDouble();
                        //creating new point to be stored
                        points[newPoint] = new Point(x, y);
                        //adding points
                        data.addPoint(x, y);
                        j++;
                    }
                    //Add polygon
                    polygonList.append(data);
                }
                else
                {
                    break;
                }
            }
            while(inputStream.hasNext());
            inputStream.close();
        }
        catch(Exception e)
        {
            //Exception code for if there is a problem reading from file
            System.out.println("Error has occured");
        }
        // print unsorted list
        System.out.println("Unsorted list:");
        System.out.println(polygonList.toString());
        //creating a new sortedList and assiging the unsorted polygon list after the sort method has been called
        MyPolygons sortedPolygons = polygonList.insertSort();
        // print sorted list
        System.out.println("Sorted List:");
        System.out.println(sortedPolygons.toString());
    }
}
