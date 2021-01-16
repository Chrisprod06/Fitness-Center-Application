package healthcenterapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JTextArea;

public class FilePrint {

    private Scanner in;

    HealthCenterCustomer client = new HealthCenterCustomer();
    Diet diet = new Diet();
    Exercise workout = new Exercise();

    //open file
    public void openClientsFile() {
        try {
            in = new Scanner(new File("clients.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public void readRecordsClientsFile(JTextArea textArea) {
        try {
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
                textArea.append(client.getCustomerID() + " " + client.getCustomerFirstName() + " " + client.getCustomerLastName()
                        + " " + client.getGender() + " " + client.getCustomerAge() + " " + client.getCivilID() + " " + client.getTelephone()
                        + " " + client.getDietPlan() + " " + client.getWorkoutPlan() + " " + client.getFee() + "\n");

            }

        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            in.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }

    }

    //open a diet or workout file
    public void openDietWorkoutFile(String name) {
        String filename = name + ".txt";
        try {
            in = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public void readRecordsDietFile(JTextArea textArea) {
        try {
            while (in.hasNext()) {

                diet.setDay(in.next());
                diet.setNumOfMeal(in.nextInt());
                diet.setMealName(in.next());
                diet.setDrink(in.next());
                diet.setCal(in.nextInt());
                textArea.append(diet.getDay() + " " + diet.getNumOfMeal() + " " + diet.getMealName() + " " + diet.getDrink() + " " + diet.getCal() + "\n");

            }

        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            in.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }

    }

    public void readRecordsWorkoutFile(JTextArea textArea) {
        try {
            while (in.hasNext()) {

                workout.setDay(in.next());
                workout.setNumberOfEx(in.nextInt());
                workout.setTypeOfEx(in.next());
                workout.setSets(in.nextInt());
                workout.setReps(in.nextInt());
                workout.setTime(in.nextDouble());
                textArea.append(workout.getDay() + " " + workout.getNumOfEx() + " " + workout.getTypeOfEx() + " " + workout.getSets() + " " + workout.getReps() + " " + workout.getTime() + "\n");

            }

        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            in.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }

    }

    public void closeFile() {
        if (in != null) {
            in.close();//close clients file
        }
    }
    
    public HealthCenterCustomer searchClient(int id)
    {
         try {
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
                
                if(client.getCustomerID()==id)
                    return client;

            }

        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            in.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
        
        
        return client;
    }

}
