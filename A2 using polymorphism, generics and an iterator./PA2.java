/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    File Name: PA2.java

Sources used to help understand how this class works. 
https://codereview.stackexchange.com/questions/122032/instantiating-shapes-using-the-factory-design-pattern-in-java

All Sources used to help build and understand this program have been given either in the code files or the report.
*/
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.StringJoiner;
import java.io.BufferedReader;

public class PA2
{
    //Program main arguments
	public static void main(String[] args) 
	throws IOException 
	{
		//Creating a factory method object to use the factory method.
        FactoryMethod factoryMethod = new FactoryMethod();
        //Create a scanner to read in file
        Scanner inputStream = new Scanner(new File("input.txt"));
		//Create both linkedLists 
        LinkedList<PlanarShape> unorderedList = new LinkedList<PlanarShape>();			
		LinkedList<PlanarShape> orderedList = new LinkedList<PlanarShape>();																	
		try 
		{
			//While the scanner has next
            while (inputStream.hasNext()) 
			{
				//Create an empty string
                String shape = "";
				//Assign scanner input to the string
                shape = inputStream.next();
				//If the string matches to a semi circle
                if(shape.equals("S"))
                {
                    /*
                    The entire job of the main here is to create a string to store all the data, read in for semi-circle to send to the shape factory
                    As the file keeps reading in this process it will happen for every shape where the input stream equals "S" This is achieved by reading in all the 
                    doubles and casting those doubles to strings that can then be processed by factory method and have the result returned. the result is
                    assigned to a plannerShape object which can be then inserted into the new list. After all this process has occured both the lists can be printed. 
                    */ 
                    
                    //Create a string to send to the factory method for S
                    String factoryStr="S"; 
                    factoryStr = factoryStr+" ";
                    //Take in the x input
                    double x = inputStream.nextDouble();
                    //Assign x double to a string
                    String sx = String.valueOf(x);
                    //Take in the y input
                    double y = inputStream.nextDouble();
                    //Assign y doube to a string
                    String sy = String.valueOf(y);
                    //Take second x input
                    double x2 = inputStream.nextDouble();
                    //Assign x2 point to string 
                    String sx2 = String.valueOf(x2);
                    //Take second y2 input
                    double y2 = inputStream.nextDouble();
                    //Assign y2 point to string
                    String sy2 = String.valueOf(y2);
                    //Concatenate all these inputs
                    factoryStr = factoryStr.concat(sx+" "+ sy+" "+ sx2+" "+sy2);
                    //Passing the string through the factory method
                    //And assigning the result of that to a plannerShape object  
                    PlanarShape semiCircle = FactoryMethod.factoryStrMethod(factoryStr);
                    //Insert PlanarShape into list through the insert order method in linkedList class
                    orderedList.insertInOrder(semiCircle);
                    //Append the unordered list
                    unorderedList.append(semiCircle);
                }
				//If the string matches to a circle
                else if(shape.equals("C"))
                {   
                    /*
                    The entire job of the main here is to create a string to store all the data, read in for Circle to send to the shape factory
                    As the file keeps reading in this process it will happen for every shape where the input stream equals "C" This is achieved by reading in all the 
                    doubles and casting those doubles to strings that can then be processed by factory method and have the result returned. the result is
                    assigned to a plannerShape object which can be then inserted into the new list. After all this process has occured both the lists can be printed. 
                    */ 
                    
                    //Create a string to send to the factory method for C
                    String factoryStr="C";
                    factoryStr = factoryStr+" ";
                    //Take radius input
                    double radius = inputStream.nextDouble();
                    //Assign radius value to string
                    String sr = String.valueOf(radius);
                    //Take x input
                    double x = inputStream.nextDouble();
                    //Assign x value to string
                    String sx = String.valueOf(x);
                    //Take y input
                    double y = inputStream.nextDouble();
                    //Assign y value to string
                    String sy = String.valueOf(y);
                    //Concatenate all these inputs
                    factoryStr = factoryStr.concat(sr+" "+sx+" "+sy);
                    //Passing the string through the factory method
                    //And assigning the result of that to a plannerShape object  
                    PlanarShape circle = FactoryMethod.factoryStrMethod(factoryStr);
                    //Insert PlanarShape into list through the insert order method in linkedList class
                    orderedList.insertInOrder(circle);
                    //Append the unordered list
                    unorderedList.append(circle);
                }   

                //If the string matches to a circle
				else if(shape.equals("P")) 
                {
                    /*
                    The entire job of the main here is to create a string to store all the data, read in for Polygon to send to the shape factory
                    As the file keeps reading in this process it will happen for every shape where the input stream equals "P" This is achieved by reading in all the 
                    doubles and casting those doubles to strings that can then be processed by factory method and have the result returned. the result is
                    assigned to a plannerShape object which can be then inserted into the new list. After all this process has occured both the lists can be printed. 
                    */ 

                    //Create a string to send to the factory method
                    String factoryStr = "P";
                    //Creat a int n counter to take the next int 
                    int n = inputStream.nextInt();                          
                    //Assign the factory string + the int count to factoryStr
                    factoryStr = factoryStr+" "+n;
                    //Start looping through
                    for(int i = 1; i <= n; i++)
                    {
                        //Take x input
                        double x = inputStream.nextDouble();
                        //Assign x value to string
                        String sx = String.valueOf(x);
                        //Take y input
                        double y = inputStream.nextDouble();
                        //Assign y value to string
                        String sy = String.valueOf(y);
                        //Concatenate all these inputs
                        factoryStr = factoryStr.concat(" "+sx+" "+sy);
                    }
                    //Passing the string through the factory method
                    //And assigning the result of that to a plannerShape object 
                    PlanarShape poly = FactoryMethod.factoryStrMethod(factoryStr);
                    //Insert PlanarShape into list through the insert order method in linkedList class
                    orderedList.insertInOrder(poly);
                    //Append the unordered list
                    unorderedList.append(poly);
                }
			}
		}
		//inputStream reading error
		catch(Exception e) 
		{
			System.out.println("Error with the inputStream has occured");
		}
		//Close the inputstream
        inputStream.close();	
		
        //Print the list name in this case unsorted first
		System.out.println("Unsorted List:");
        //Create a iterator for our planershape objects in the list
        Iterator<PlanarShape> unorderedIterator = unorderedList.iterator();
        //While there is another collection in the list
        while(unorderedIterator.hasNext()) 
        {
            //Print out the collection
            System.out.println(unorderedIterator.next());
        }
		
        //Print the list name in this case sorted first
		System.out.println("\n" +"Sorted List:");
		//Create a iterator for our planershape objects in the list
        Iterator<PlanarShape> orderedListIterator = orderedList.iterator();
		//While there is another collection in the list
        while(orderedListIterator.hasNext()) 
        {
            //Print out the collection
            System.out.println(orderedListIterator.next());
        }
	}
}
