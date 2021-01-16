package healthcenterapplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class FileDelete {

    HealthCenterCustomer client = new HealthCenterCustomer();
    private Formatter output;

    // delete client record file clients file
    public void deleteClientRecord(int clientID) {
        //Create a new file and old file
        String originalFile = "clients.txt";
        String temp = "temp.txt";

        File oldFile = new File(originalFile);
        File newFile = new File(temp);

        try {
            //Might change for output.format later if it works
            FileWriter fw = new FileWriter(temp, true); 
            Scanner in = new Scanner(new File(originalFile));
            output= new Formatter(fw);

            while (in.hasNext()) {
                client.setCustomerID(in.nextInt());
                client.setCustomerFirstName(in.next());
                client.setCustomerLastName(in.next());
                client.setGender(in.next());
                client.setCustomerAge(in.nextInt());
                client.setCivilID(in.nextInt());
                client.setTelephone(in.nextInt());
                client.setDietPlan(in.next());
                client.setWorkoutPlan(in.next());
                client.setFee(in.nextInt());

                if (client.getCustomerID() != clientID) {
                    output.format(client.getCustomerID() + " " + client.getCustomerFirstName() + " " + client.getCustomerLastName()
                            + " " + client.getGender() + " " + client.getCustomerAge() + " " + client.getCivilID() + " " + client.getTelephone()
                            + " " + client.getDietPlan() + " " + client.getWorkoutPlan() + " " + client.getFee() + "\n");

                }
            }
            in.close();
            output.close();
            oldFile.delete();
            File dump = new File(originalFile);
            newFile.renameTo(dump);
        } catch (Exception e) {
            System.out.println("Error in creating/opening the file");
        }
    }

    //delete a workout plan or diet
    public void deleteFile(String Name) {
        String fileName = Name + ".txt";

        File file = new File(fileName);

        try {
            file.delete();
        } catch (Exception e) {
            System.err.println("Could not delete file");
        }
    }
}
