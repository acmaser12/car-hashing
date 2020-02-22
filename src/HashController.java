import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

public class HashController {

    private String[] makers = new String[]{"Renault", "Peugeot", "Opel", "Saab", "Aston Martin", "Porsche"};
    private String[] types = new String[]{"Bus", "Truck", "Sedan", "Coupe", "Convertible", "SUV"};
    private String[] firstNames = new String[]{"Jeremy", "James", "Richard", "Adam", "Tanner", "Rutledge"};
    private String[] lastNames = new String[]{"Clarkson", "May", "Hammond", "Ferrara", "Foust", "Wood"};
    private String[] states = new String[]{"MN", "TX", "FL", "MT", "AZ", "WI"};

    public static void main(String[] args) {
        HashController program = new HashController();
        program.start();
    }

    private void start() {
        MyHashtable<CarInfo> table = new MyHashtable<>(100);
        for (int i = 0; i < 100; i++) {
            CarInfo car = generateCar();
            table.add(car);
        }
        Iterator<CarInfo> iterator = table.iterator();
        for (int j = 0; j < table.size(); j++) {
            System.out.println("Bucket " + j + ": ");
            System.out.println("\t" + iterator.next().);
        }
    }

    private CarInfo generateCar() {
        Random random = new Random();

        // randomly generate each CarInfo param
        String make = makers[random.nextInt(makers.length)];
        String type = types[random.nextInt(types.length)];
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String state = states[random.nextInt(states.length)];

        // get license plate
        StringBuilder plateBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            String alphanumerics = "abcdefghijklmnopqrstuvwxyz0123456789";
            plateBuilder.append(alphanumerics.charAt(random.nextInt(alphanumerics.length())));
        }
        String plate = plateBuilder.toString().toUpperCase();

        return new CarInfo(make, type, firstName + " " + lastName, state, plate);
    }
}
