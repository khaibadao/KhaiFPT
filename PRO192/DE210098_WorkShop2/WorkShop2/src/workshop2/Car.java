/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workshop2;

public class Car{
    public Car() {}
    private String Colour = "";
    private int EnginePower = 0;
    private boolean Convertible = false;
    private boolean ParkingBrake = false;
    
    Car(String Colour, int EnginePower, boolean Convertible, boolean ParkingBrake){
        this.Colour = Colour;
        this.EnginePower = EnginePower;
        this.Convertible = Convertible;
        this.ParkingBrake = ParkingBrake;
    }

    // Get Function
    public String getColour(){ return this.Colour; }
    public int getEnginePower(){ return this.EnginePower;}
    public boolean getConvertible(){ return this.Convertible;}
    public boolean getParkingBrake(){ return this.ParkingBrake;}

   // set Function

    public void setColour(String mau){ this.Colour = mau;}
    public void setEnginePower(int ks){ this.EnginePower = ks;}
    public void setConvertible(boolean status){ this.Convertible = status;}
    public void setParkingBrake(boolean status){ this.ParkingBrake = status;}

   // Setting ban đầu

    public void pressStartButton(){ System.out.println("You have pressed the start button");}
    public void pressAcceleratorButton(){ System.out.println("You have pressed the Accelerator button");}
    public void output() {
        System.out.println("Colour: " + Colour);
        System.out.println("EnginePower: " + EnginePower);
        System.out.println("Convertible: " + Convertible);
        System.out.println("ParkingBrake: " + ParkingBrake);
    }
}
