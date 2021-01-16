package healthcenterapplication;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class FileCreate {

    private Formatter output;// object used for output text to file
    HealthCenterCustomer client = new HealthCenterCustomer();
    Diet diet = new Diet();
    Exercise workout = new Exercise();

    //Get client object to pass data to file
    public void setClient(HealthCenterCustomer cl) {
        client = cl;
    }

    //Get diet object to pass data to file
    public void setDiet(Diet d) {
        diet = d;
    }

    //Get workout object to pass data to file
    public void setWorkout(Exercise w) {
        workout = w;
    }

    //enable user to open file
    public void openClientsFile() {
        try {
            FileWriter f = new FileWriter("clients.txt", true);
            output = new Formatter(f);
        } catch (IOException e) {
            System.out.println("Error in creating/opening the file");
            System.exit(1);
        } catch (SecurityException securityException) {
            System.out.println("You do not have write access to this file.");
            System.exit(1);
        }

    }//End of openClientFile

    //Add client to file
    public void addRecordsClientsFile() {

        try {
            output.format(client.getCustomerID() + " " + client.getCustomerFirstName() + " " + client.getCustomerLastName()
                    + " " + client.getGender() + " " + client.getCustomerAge() + " " + client.getCivilID() + " " + client.getTelephone()
                    + " " + client.getDietPlan() + " " + client.getWorkoutPlan() + " " + client.getFee() + "\n");

        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error writing to file.");
            
        }

    }//end AddRecordsClientsFile

    // close file
    public void closeClientsFile() {
        if (output != null) {
            output.close();
        }
    } // end method closeFile

    //enable user to open file
    public void openDietsFile() {
        try {
            String name = diet.getDietName();
            String fileName = name + ".txt";
            FileWriter f = new FileWriter(fileName, true);
            output = new Formatter(f);
        } catch (IOException e) {
            System.out.println("Error in creating/opening the file");
            System.exit(1);
        } catch (SecurityException securityException) {
            System.out.println("You do not have write access to this file.");
            System.exit(1);
        }

    }//End of openDietsFile

    //add diet to file
    public void addRecordsDietsFile() {
        try {
            output.format(diet.getDay() + " " + diet.getNumOfMeal() + " " + diet.getMealName() + " " + diet.getDrink() + " " + diet.getCal() + "\n");

        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error writing to file.");
            
        }

    }//end AddRecordsDietsFile
    // close file

    public void closeDietsFile() {
        if (output != null) {
            output.close();
        }
    } // end method closeFile

    //enable user to open file
    public void openExFile() {
        try {
            String name = workout.getNameOfWP();
            String fileName = name + ".txt";
            FileWriter f = new FileWriter(fileName, true);
            output = new Formatter(f);
        } catch (IOException e) {
            System.out.println("Error in creating/opening the file");
            System.exit(1);
        } catch (SecurityException securityException) {
            System.out.println("You do not have write access to this file.");
            System.exit(1);
        }

    }//End of openExFile

    //add workout to file
    public void addRecordsExFile() {
        try {
            output.format(workout.getDay() + " " + workout.getNumOfEx() + " " + workout.getTypeOfEx()
                    + " " + workout.getSets() + " " + workout.getReps() + " " + workout.getTime() + "\n");

        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error writing to file.");
           
        }

    }//end AddRecordsClientsFile
    // close file

    public void closeExFile() {
        if (output != null) {
            output.close();
        }
    } // end method closeFile
}
