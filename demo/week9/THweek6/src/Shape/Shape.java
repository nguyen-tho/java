package Shape;
public class Shape implements Comparable
{
    private String name;
    private double area;

    public Shape(String eName, double eArea){
        name = eName;
        area = eArea;  
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

    @Override
    public String toString(){
        return name + " area: "+ area;
    }

    @Override
    public int compareTo(Object o) {
        int result;
        double otherArea = (double)((Shape) o).getArea();
        if(area < otherArea) {
            result = -1;
        }
        else 
            if(area > otherArea) 
                result = 1;
            else 
                result = 0;

        return result;
    }

    public boolean equals(Object o) {
        return area == ((Shape) o).getArea();
    }
}