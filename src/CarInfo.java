/*
    written by: Adam Maser
    CSC 450 week 6 project
    CarInfo.java
    Class for CarInfo objects. Overrides toString() and hashCode() methods.
 */


public class CarInfo {

    private String make;
    private String type;
    private String owner;
    private String licenseState;
    private String licensePlate;

    CarInfo(String make, String type, String owner, String licenseState, String licensePlate) {
        this.make = make;
        this.type = type;
        this.owner = owner;
        this.licenseState = licenseState;
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car is: " + this.owner + " - " + this.licensePlate + " " + this.licenseState +
                " " + this.make + " " + this.type;
    }

    @Override
    public int hashCode() {
        return this.licensePlate.hashCode() + this.licenseState.hashCode() + this.owner.hashCode();
    }
}
