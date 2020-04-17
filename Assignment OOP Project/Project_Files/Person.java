package hospitalms;

abstract class Person {

    public String name;
    public int age;
    double perdayCost;
    
    abstract void talk();
    abstract void healthStatus();
    abstract void showInfo();
    abstract double salary(Patient p);
    
    double fees(){
        return 0.0;
    }


}
