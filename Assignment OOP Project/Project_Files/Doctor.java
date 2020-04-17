package hospitalms;

class Doctor extends Person {

    private String specialist;

    Doctor() {

    }

    Doctor(String doc) {
        this.name = doc;
    }

    Doctor(String n, String sp) {
        this.name = n;
        this.specialist = sp;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    void doTreatment(Patient p) {
        System.out.println("Doing treatment to: " + p.getName() + "," + p.getAge());
    }
    
    //Abstratct Methods
    @Override
    void talk() {
        System.out.println("Hi, I'm a Doctor.");
    }

    @Override
    void healthStatus() {
        System.out.println("Doctor: I'm Well. I can Work.");
    }

    @Override
    double salary(Patient p) {
        return p.fees() * 0.4;
    }

    @Override
    void showInfo() {
        System.out.println("Doctor's name: " + this.getName());
        System.out.println("Specialized in: " + this.specialist);
    }

    void showPDInfo(Patient p, Doctor d) {
        System.out.println("\nInfo:\nPatient's Name: " + p.getName() + "\nAge: " + p.getAge() + "Y/O\nDisease: " + p.getDis());
        if (d != null) {
            System.out.println("Assigned Doctor: " + d.getName());
            System.out.println("Patient is In Treatment");
        } else {
            System.out.println("No Doctor Found. Go to another Hospital.");
        }
    }
}
