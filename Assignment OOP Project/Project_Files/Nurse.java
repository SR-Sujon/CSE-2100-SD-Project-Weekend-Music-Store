package hospitalms;

class Nurse extends Person {

    Nurse() {

    }

    Nurse(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void talk() {
        System.out.println("Hi, I'm a Nurse.");
    }

    void NurseTakingCare(Patient p) {
        System.out.println(""+this.name+ " is Taking Care of Patient: " + p.getName() + "," + p.getAge() + "\n");
    }

    //Abstract Methods
    @Override
    void healthStatus() {
        System.out.println("Nurse: I'm fine. I can Work.");
    }

    @Override
    double salary(Patient p) {
        return (0.2 * p.fees());
    }

    @Override
    void showInfo() {
        System.out.println("Nurse's name: " + this.getName());
    }

    void showPNInfo(Patient p, Nurse n) {
        System.out.println("\nPatients name: " + p.getName() + "\nAge: " + p.getAge() + "\nDisease: " + p.getDis());
        System.out.println("Assigned Nurse: " + n.getName());
    }
}
