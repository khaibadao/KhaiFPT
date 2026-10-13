/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workshop2;

public class Tester {
    static public void main(String[] args){
        Car c = new Car();
        c.pressStartButton();
        c.pressAcceleratorButton();
        c.output();
        
        Car c2 = new Car("Red", 200, false, true);
        c2.pressAcceleratorButton(); 
        c2.setColour("black"); 
        System.out.println("Colour of c2:" + c2.getColour()); 
        c2.output(); 
        
    }
}


