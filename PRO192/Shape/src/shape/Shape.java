package shape;

public abstract class Shape {
    protected String color;
    Shape(){}
    Shape(String color){
        this.color = color;
    }
    
    public abstract double getArea();
    public abstract double getPer();
    public abstract void draw();
}
