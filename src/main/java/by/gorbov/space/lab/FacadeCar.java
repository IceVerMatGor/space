package by.gorbov.space.lab;

public class FacadeCar {
    Car car = new Car();


    void start(){
       car.ignition();
       car.startEngine();
    }

    void stop(){

        car.stopEngine();
    }





}
