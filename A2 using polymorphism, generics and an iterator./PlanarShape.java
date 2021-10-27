
/*
    Student Number: c3339952
    Student Name: Stephen Watson
    Course: Seng 2200
    File Name: PlanarShape.java
*/
public abstract class PlanarShape implements Comparable<PlanarShape>
{
    private double distance;
    private double poly1;
    private double poly2;
    private double percentage;
    private double difference;

    //Required abstract methods
    public abstract double originDistance();
    public abstract double calculateArea();
    public abstract void addPoint(double x, double y); 
    public abstract String toString();
    public abstract void draw();
   
    //Exact same CompareTo method used in Polygon.java file from Assignment 1
    public int compareTo(PlanarShape o)
    {
        
  
        //assigning the area of polygon one to poly1
        poly1 = calculateArea();
        ////assigning the area of polygon two to poly2
        poly2 = o.calculateArea();
        //Setting percentage to measure against
        percentage = 0.001;
        //Calculating both polys against each other
        difference = Math.sqrt((poly1-poly2)*(poly1-poly2));
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
                    return 1;
                } 
                //If not return it false
                else 
                {
                    return -1;
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
                    return -1;
                } 
                else 
                //If not return it false
                {
                    return 1;
                }
            }
        }
        //If poly1 area is less than poly2 area retrun true
        if(calculateArea() < o.calculateArea())
        {
            return 0;
        } 
        //all other cases return false
        else 
        {
            return -1;
        }
    } 
}
     