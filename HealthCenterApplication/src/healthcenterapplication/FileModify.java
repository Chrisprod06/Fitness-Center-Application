package healthcenterapplication;

import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;

public class FileModify {

    private Formatter output;
    HealthCenterCustomer clientNew = new HealthCenterCustomer();
    HealthCenterCustomer clientOld = new HealthCenterCustomer();

    Diet dietOld = new Diet();
    Diet dietNew = new Diet();

    Exercise workoutOld = new Exercise();
    Exercise workoutNew = new Exercise();

    public void setClient(HealthCenterCustomer cl) {
        clientNew = cl;

    }

    public void setDiet(Diet d) {
        dietNew = d;
    }

    public void setWorkout(Exercise w) {
        workoutNew = w;
    }

    // Modify client record file clients file
    public void ModifyClientRecord(int clientID) {
        //Create a new file and old file
        String originalFile = "clients.txt";
        String temp = "temp.txt";

        File oldFile = new File(originalFile);
        File newFile = new File(temp);

        try {
            //Might change for output.format later if it works
            FileWriter fw = new FileWriter(temp, true);
            Scanner in = new Scanner(new File(originalFile));
            output = new Formatter(fw);

            while (in.hasNext()) {

                clientOld.setCustomerID(in.nextInt());
                clientOld.setCustomerFirstName(in.next());
                clientOld.setCustomerLastName(in.next());
                clientOld.setGender(in.next());
                clientOld.setCustomerAge(in.nextInt());
                clientOld.setCivilID(in.nextInt());
                clientOld.setTelephone(in.nextInt());
                clientOld.setDietPlan(in.next());
                clientOld.setWorkoutPlan(in.next());
                clientOld.setFee(in.nextInt());

                //if clientNew variables equal to their default value it means the users doesnt want to change the value
                //so give the clienNew value the clientOld value else 
                //if it is not the default value it means the var must be changed to the new value
                if (clientOld.getCustomerID() == clientID) {
                    if (clientNew.getCustomerID() == 0) {
                        clientNew.setCustomerID(clientOld.getCustomerID());
                    }

                    if (clientNew.getCustomerFirstName().equals("first name")) {
                        clientNew.setCustomerFirstName(clientOld.getCustomerFirstName());
                    }

                    if (clientNew.getCustomerLastName().equals("last name")) {
                        clientNew.setCustomerLastName(clientOld.getCustomerLastName());
                    }

                    if (clientNew.getGender().equals("gender")) {
                        clientNew.setGender(clientOld.getGender());
                    }

                    if (clientNew.getCustomerAge() == 0) {
                        clientNew.setCustomerAge(clientOld.getCustomerAge());
                    }

                    if (clientNew.getCivilID() == 0) {
                        clientNew.setCivilID(clientOld.getCivilID());
                    }

                    if (clientNew.getTelephone() == 0) {
                        clientNew.setTelephone(clientOld.getTelephone());
                    }

                    if (clientNew.getDietPlan().equals("no diet plan")) {
                        clientNew.setDietPlan(clientOld.getDietPlan());
                    }

                    if (clientNew.getWorkoutPlan().equals("no workout plan")) {
                        clientNew.setWorkoutPlan(clientOld.getWorkoutPlan());
                    }

                    if (clientNew.getFee() == 0) {
                        clientNew.setFee(clientOld.getFee());
                    }

                    output.format(clientNew.getCustomerID() + " " + clientNew.getCustomerFirstName() + " " + clientNew.getCustomerLastName()
                            + " " + clientNew.getGender() + " " + clientNew.getCustomerAge() + " " + clientNew.getCivilID() + " " + clientNew.getTelephone()
                            + " " + clientNew.getDietPlan() + " " + clientNew.getWorkoutPlan() + " " + clientNew.getFee() + "\n");

                } else {
                    output.format(clientOld.getCustomerID() + " " + clientOld.getCustomerFirstName() + " " + clientOld.getCustomerLastName()
                            + " " + clientOld.getGender() + " " + clientOld.getCustomerAge() + " " + clientOld.getCivilID() + " " + clientOld.getTelephone()
                            + " " + clientOld.getDietPlan() + " " + clientOld.getWorkoutPlan() + " " + clientOld.getFee() + "\n");
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

    //Modify a diet 
    public void ModifyDietFile(String name, String day, int num) {

        //Create a new file and old file
        String originalFile = name + ".txt";
        String temp = "temp.txt";

        File oldFile = new File(originalFile);
        File newFile = new File(temp);

        try {
            //Might change for output.format later if it works
            FileWriter fw = new FileWriter(temp, true);
            Scanner in = new Scanner(new File(originalFile));
            output = new Formatter(fw);

            while (in.hasNext()) {

                dietOld.setDay(in.next());
                dietOld.setNumOfMeal(in.nextInt());
                dietOld.setMealName(in.next());
                dietOld.setDrink(in.next());
                dietOld.setCal(in.nextInt());

                //if dietNew variables equal to their default value it means the users doesnt want to change the value
                //so give the clienNew value the dietOld value else 
                //if it is not the default value it means the var must be changed to the new value
                if (dietOld.getDay().equals(day) && dietOld.getNumOfMeal() == num) {

                    if (dietNew.getDay().equals("day")) {
                        dietNew.setDay(dietOld.getDay());
                    }

                    if (dietNew.getNumOfMeal() == 0) {
                        dietNew.setNumOfMeal(dietOld.getNumOfMeal());
                    }

                    if (dietNew.getMealName().equals("meal")) {
                        dietNew.setMealName(dietOld.getMealName());
                    }

                    if (dietNew.getDrink().equals("drink")) {
                        dietNew.setDrink(dietOld.getDrink());
                    }

                    if (dietNew.getCal() == 0) {
                        dietNew.setCal(dietOld.getCal());
                    }

                    output.format(dietNew.getDay() + " " + dietNew.getNumOfMeal() + " " + dietNew.getMealName() + " " + dietNew.getDrink() + " " + dietNew.getCal() + "\n");

                } else {
                    output.format(dietOld.getDay() + " " + dietOld.getNumOfMeal() + " " + dietOld.getMealName() + " " + dietOld.getDrink() + " " + dietOld.getCal() + "\n");

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

    //Modify a workout
    public void ModifyWorkoutFile(String name, String day, int num) {
        //Create a new file and old file
        String originalFile = name + ".txt";
        String temp = "temp.txt";

        File oldFile = new File(originalFile);
        File newFile = new File(temp);

        try {
            //Might change for output.format later if it works
            FileWriter fw = new FileWriter(temp, true);
            Scanner in = new Scanner(new File(originalFile));
            output = new Formatter(fw);

            while (in.hasNext()) {

                workoutOld.setDay(in.next());
                workoutOld.setNumberOfEx(in.nextInt());
                workoutOld.setTypeOfEx(in.next());
                workoutOld.setReps(in.nextInt());
                workoutOld.setSets(in.nextInt());
                workoutOld.setTime(in.nextDouble());

                //if dietNew variables equal to their default value it means the users doesnt want to change the value
                //so give the clienNew value the dietOld value else 
                //if it is not the default value it means the var must be changed to the new value
                if (workoutOld.getDay().equals(day) && workoutOld.getNumOfEx() == num) {

                    if (workoutNew.getDay().equals("day")) {
                        workoutNew.setDay(dietOld.getDay());
                    }

                    if (workoutNew.getNumOfEx() == 0) {
                        workoutNew.setNumberOfEx(workoutOld.getNumOfEx());
                    }

                    if (workoutNew.getTypeOfEx().equals("ex")) {
                        workoutNew.setTypeOfEx(workoutOld.getTypeOfEx());
                    }

                    if (workoutNew.getReps() == 0) {
                        workoutNew.setReps(workoutOld.getReps());
                    }

                    if (workoutNew.getSets() == 0) {
                        workoutNew.setSets(workoutOld.getSets());
                    }

                    if (workoutNew.getTime() == 0.0) {
                        workoutNew.setTime(workoutOld.getTime());
                    }

                    output.format(workoutNew.getDay() + " " + workoutNew.getNumOfEx() + " " + workoutNew.getTypeOfEx() + " " + workoutNew.getReps() + " " + workoutNew.getSets() + " " + workoutNew.getTime() + "\n");

                } else {
                    output.format(workoutOld.getDay() + " " + workoutOld.getNumOfEx() + " " + workoutOld.getTypeOfEx() + " " + workoutOld.getReps() + " " + workoutOld.getSets() + " " + workoutOld.getTime() + "\n");

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
}
