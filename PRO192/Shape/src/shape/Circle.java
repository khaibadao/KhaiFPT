package shape;

public class Circle extends Shape{
    private double r;
    final double pi = 3.14;
    
    Circle(double r, String color){
        super(color);
        this.r = r;
    }
    
    @Override
    public double getArea(){
        return r*r*3.14;
    }
    
    @Override
    public double getPer(){
        return 2*r*pi;
    }
    
    @Override
    public String toString(){
        return "Circle{color=" + color + ", area=" + getArea() + "}";
    }
    
    @Override
    public void draw(){
        System.out.println("Day la hinh tron!");
    }
} 
