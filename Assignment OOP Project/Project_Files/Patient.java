package hospitalms;

public class Patient extends Person {

    private String disease;
    private int workday;

    Patient() {

    }

    Patient(String n) {
        this.name = n;
    }

    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Patient(String dis, String pat, int age) {
        this.disease = dis; //Calls Superclass Constructor
        this.name = pat;
        this.age = age;
    }

    public String getDis() {
        return disease;
    }

    public void setDis(String dis) {
        this.disease = dis;
    }

    public void setWorkday(int workday) {
        this.workday = workday;
    }

    public int getWorkday() {
        return workday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    void healthStatus() {
        System.out.println("Patient: \"I'm sick. I need treatment.\"");
    }

    public String showDis() {
        return this.disease;
    }

    //Abstract Methods
    @Override
    public double fees() {
        return this.workday * this.perdayCost;
    }

    @Override
    void talk() {
        System.out.println("Hi, I'm a patient.");
    }

    @Override
    void showInfo() {
        System.out.println("Patient's name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Disease: " + this.disease);
    }

    @Override
    double salary(Patient p) {
        System.out.println("Fees: ");
        return this.fees();
    }

    void showPDNInfo(Patient p, Doctor d, Nurse n) {
        System.out.println("\nInfo:\nPatient's Name: " + p.getName() + "\nAge: " + p.getAge() + "Y/O\nDisease: " + p.getDis());
        if (d != null) {
            System.out.println("Assigned Doctor: " + d.getName());
            System.out.println("Assigned Nurse: " + n.getName());
            System.out.println("Fees: " + p.fees());
            System.out.println("Doctor's Salary: " + d.salary(p));
            System.out.println("Nurse's Salary: " + n.salary(p));
            System.out.println("Tests & Medicines: " + p.fees() * 0.4);

        } else {
            System.out.println("No Doctor Found. Go to another Hospital.");
        }
    }

}
