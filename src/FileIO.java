import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

       public ArrayList<Customer> readCustomerData(String path) {
        ArrayList<Customer> customers = new ArrayList<>();
        //instantier File
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //Skip header
            while (scan.hasNextLine()) {
                String s = scan.nextLine();// Hele linjen vil stå i én string   ==>  "Egon, 200"
                String[] row = s.split(",");// s splittes to strings ==>  "Egon", "200"
                String name = row[0];      // ==> "Egon"
                int balance = Integer.parseInt(row[1].trim()); // Konverterer string til int "200" ==> 200
                Customer c = new Customer(name, balance); //bruger de indlæste værdier til at konstruere et kundeobjekt (instansiering)customers.add(c);
                // placerer objektet i listen med kunder
                customers.add(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return customers;
    }

    public void saveCustomerData(ArrayList<Customer> customers){
     try

    {
        FileWriter writer = new FileWriter("src/customer.txt");
        writer.write("Name,Balance" + "\n");
        for (Customer c : customers) {
            String textTosave = c.name + "," + c.balance;
            writer.write(textTosave + "\n");//Egon,5200
        }
        writer.close();
    } catch(
            IOException e)
    {
        System.out.println("noget gik galt ved skrivning til fil");
    }
}
}