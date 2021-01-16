package healthcenterapplication;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ApplicationFrame extends JFrame {
    //Variables 

    String activities[] = {" ", "Client Management", "Diets", "Workouts"};
    String genders[] = {"", "Male", "Female"};
    String days[] = {" ", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    //Characteristics Declaration
    private JButton btnSelect, btnLogin, btnRegister, btnDeleteC, btnAddDiet, btnDeleteD, btnAddWPlan, btnDeleteWP, btnViewClients, btnViewDiet, btnViewWorkout, btnModifyC, btnModifyD, btnModifyW, btnSearchC;
    private JButton btnCreateDiet, btnDeleteDiet, btnModifyDiet, btnCreateWPlan, btnDeleteWPlan, btnModifyWPlan, btnAddClient, btnDeleteClient, btnModifyClient, btnShowClients, btnShowDiet, btnShowWorkout, btnSearchClient;//Buttons Management
    private JButton btnBack1, btnBack2, btnBack3, btnBack4, btnBack5, btnBack6, btnBack7, btnBack8, btnBack9, btnBack10, btnBack11, btnBack12, btnBack13, btnBack14, btnBack15, btnBack16;//Back buttons used throughout the program
    private JComboBox cboSelect, cboGender, cboDietDay, cboWPDay, cboMGender, cboMDietDay, cboMWPDay;//cbo main,add client,create diet,create WPlan
    private JLabel lblUsername, lblPassword;//labels login
    private JLabel lblFirstname, lblLastname, lblCustomerID, lblAge, lblDietPlan, lblWorkoutPlan, lblTelephone, lblCivilID, lblEnterID, lblFee, lblGender;//labels add client,delete client
    private JTextField txtFirstname, txtLastname, txtCustomerID, txtAge, txtDietPlan, txtWorkoutPlan, txtTelephone, txtCivilID, txtID, txtFee;//txtboxes add client,delete client
    private JLabel lblDietName, lblDietDay, lblNumOfMeal, lblMealName, lblDrink, lblCal, lblEnterDietName;//labels of create diet,delete diet
    private JTextField txtDietName, txtNumOfMeal, txtMealName, txtDrink, txtCal, txtEnterDietName;//txtboxes of create diet,delete diet
    private JLabel lblNameOfWP, lblWPDay, lblNumOfEx, lblTypeOfEx, lblSets, lblReps, lblTime, lblEnterWPlanName;//labels of create WPlan,deleteWPlan
    private JTextField txtNameOfWP, txtNumOfEx, txtTypeOfEx, txtSets, txtReps, txtTime, txtWPlanName;//textboxes of create WPlan,delete WPlan
    private JTextField txtUsername;// txt login
    private JPasswordField txtPassword;//txt login
    private JTextField txtDiet, txtWorkout;//txt show diet and workout
    private JLabel lblDiet, lblWorkout;//lbl show diet and workout
    private JPanel panelClient, panelDiet, panelWorkout, panelLogin, panelCont, panelMain, panelAddClient, panelModifyClient, panelDeleteClient, panelSearchClient;//panels that the program uses
    private JPanel panelCreateDiet, panelModifyDiet, panelDeleteDiet, panelCreateWPlan, panelDeleteWPlan, panelModifyWPlan, panelShowClients, panelShowDiet, panelShowWorkout, subPanel1, subPanel2, subPanel3;//panels that the program uses
    private JTextArea textAreaClients, textAreaDiet, textAreaWorkout;
    private JScrollPane scrollPaneClients, scrollPaneDiet, scrollPaneWorkout;
    private JLabel lblMFirstname, lblMLastname, lblMCustomerID, lblMAge, lblMDietPlan, lblMWorkoutPlan, lblMTelephone, lblMCivilID, lblMFee, lblMGender;//labels modify client
    private JTextField txtMFirstname, txtMLastname, txtMCustomerID, txtMAge, txtMDietPlan, txtMWorkoutPlan, txtMTelephone, txtMCivilID, txtMFee;//txtboxes modify client
    private JLabel lblMDietName, lblMDietDay, lblMNumOfMeal, lblMMealName, lblMDrink, lblMCal;//labels of modify diet
    private JTextField txtMDietName, txtMNumOfMeal, txtMMealName, txtMDrink, txtMCal;//txtboxes of modify diet
    private JLabel lblMNameOfWP, lblMWPDay, lblMNumOfEx, lblMTypeOfEx, lblMSets, lblMReps, lblMTime;//labels of modify WPlan
    private JTextField txtMNameOfWP, txtMNumOfEx, txtMTypeOfEx, txtMSets, txtMReps, txtMTime;//textboxes of modify
    private JLabel lblCusFirstname, lblCusLastname, lblCusID, lblCusCivID, lblCusAge, lblCusFee, lblCusGender, lblCusDietPlan, lblCusWorkoutPlan, lblCusTelephone, lblID; //labels  search client
    private JTextField txtCusID;//textbox search client
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem itemAbout;

    GridBagConstraints gbc = new GridBagConstraints();//used to position components to panels

    public ApplicationFrame() {

        super("Health Center");
        //Variables used in constructor

        //help menu bar
        menuBar = new JMenuBar();
        helpMenu = new JMenu("Help");
        itemAbout = new JMenuItem("About...");

        menuBar.add(helpMenu);
        helpMenu.add(itemAbout);

        super.setJMenuBar(menuBar);
        //Create GUI components and add them to the panels
        CardLayout cardLayout = new CardLayout();

        //Create panels
        panelCont = new JPanel();//Container panel which contains all other panels
        panelLogin = new JPanel();
        panelMain = new JPanel();
        panelClient = new JPanel();
        panelDiet = new JPanel();
        panelWorkout = new JPanel();
        panelAddClient = new JPanel();
        panelModifyClient = new JPanel();
        panelDeleteClient = new JPanel();
        panelCreateDiet = new JPanel();
        panelDeleteDiet = new JPanel();
        panelModifyDiet = new JPanel();
        panelCreateWPlan = new JPanel();
        panelDeleteWPlan = new JPanel();
        panelModifyWPlan = new JPanel();
        panelSearchClient = new JPanel();
        panelShowClients = new JPanel();
        panelShowDiet = new JPanel();
        panelShowWorkout = new JPanel();
        subPanel1 = new JPanel();
        subPanel2 = new JPanel();
        subPanel3 = new JPanel();

        panelCont.setLayout(cardLayout);

        //Login panel
        gbc.insets = new Insets(5, 5, 5, 5);// used to have spaces between the components
        lblUsername = new JLabel("UserName: ");
        lblPassword = new JLabel("Password: ");
        txtUsername = new JTextField(10);
        txtPassword = new JPasswordField(10);
        btnLogin = new JButton("Login");

        panelLogin.setLayout(new GridBagLayout());
        setPosition(0, 1);
        panelLogin.add(lblUsername, gbc);
        setPosition(1, 1);
        panelLogin.add(txtUsername, gbc);
        setPosition(0, 2);
        panelLogin.add(lblPassword, gbc);
        setPosition(1, 2);
        panelLogin.add(txtPassword, gbc);
        setPosition(0, 3);
        panelLogin.add(btnLogin, gbc);

        //Main panel
        cboSelect = new JComboBox(activities);
        btnSelect = new JButton("Select");

        panelMain.setLayout(new GridBagLayout());
        setPosition(0, 0);
        panelMain.add(cboSelect, gbc);
        setPosition(1, 0);
        panelMain.add(btnSelect, gbc);

        //Panel Client
        btnAddClient = new JButton("  Add Client  ");
        btnDeleteClient = new JButton("Delete Client");
        btnModifyClient = new JButton("Modify Client");
        btnShowClients = new JButton("Show Clients");
        btnSearchClient = new JButton("Search Client");
        btnBack1 = new JButton("Back");

        panelClient.setLayout(new GridBagLayout());
        setPosition(0, 0);
        panelClient.add(btnAddClient, gbc);
        setPosition(0, 1);
        panelClient.add(btnDeleteClient, gbc);
        setPosition(0, 2);
        panelClient.add(btnModifyClient, gbc);
        setPosition(0, 3);
        panelClient.add(btnShowClients, gbc);
        setPosition(0, 4);
        panelClient.add(btnSearchClient, gbc);
        setPosition(0, 5);
        panelClient.add(btnBack1, gbc);

        //Panel Diets
        btnCreateDiet = new JButton("Create Diet");
        btnDeleteDiet = new JButton("Delete Diet");
        btnModifyDiet = new JButton("Modify Diet");
        btnShowDiet = new JButton("Show Diet");
        btnBack2 = new JButton("Back");

        panelDiet.setLayout(new GridBagLayout());
        setPosition(0, 0);
        panelDiet.add(btnCreateDiet, gbc);
        setPosition(0, 1);
        panelDiet.add(btnDeleteDiet, gbc);
        setPosition(0, 2);
        panelDiet.add(btnModifyDiet, gbc);
        setPosition(0, 3);
        panelDiet.add(btnShowDiet, gbc);
        setPosition(0, 4);
        panelDiet.add(btnBack2, gbc);

        //Panel Workouts
        btnCreateWPlan = new JButton("Create Workout");
        btnDeleteWPlan = new JButton("Delete Workout");
        btnModifyWPlan = new JButton("Modify Workout");
        btnShowWorkout = new JButton("Show Workout");
        btnBack3 = new JButton("Back");

        panelWorkout.setLayout(new GridBagLayout());
        setPosition(0, 0);
        panelWorkout.add(btnCreateWPlan, gbc);
        setPosition(0, 1);
        panelWorkout.add(btnDeleteWPlan, gbc);
        setPosition(0, 2);
        panelWorkout.add(btnModifyWPlan, gbc);
        setPosition(0, 3);
        panelWorkout.add(btnShowWorkout, gbc);
        setPosition(0, 4);
        panelWorkout.add(btnBack3, gbc);

        //Panel add client
        lblFirstname = new JLabel("Firstname: ");
        lblLastname = new JLabel("Lastname: ");
        lblCivilID = new JLabel("Civil ID:");
        lblCustomerID = new JLabel("Customer ID: ");
        lblTelephone = new JLabel("Telephone: ");
        lblAge = new JLabel("Age: ");
        lblDietPlan = new JLabel("Diet Plan: ");
        lblWorkoutPlan = new JLabel("Workout Plan: ");
        lblFee = new JLabel("Fee: ");
        lblGender = new JLabel("Gender: ");

        txtFirstname = new JTextField(10);
        txtLastname = new JTextField(10);
        txtCivilID = new JTextField(10);
        txtCustomerID = new JTextField(10);
        txtTelephone = new JTextField(10);
        txtAge = new JTextField(10);
        txtDietPlan = new JTextField(10);
        txtWorkoutPlan = new JTextField(10);
        txtFee = new JTextField(10);

        cboGender = new JComboBox(genders);
        btnRegister = new JButton("Register");
        btnBack4 = new JButton("Back");

        panelAddClient.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelAddClient.add(lblFirstname, gbc);
        setPosition(0, 1);
        panelAddClient.add(lblLastname, gbc);
        setPosition(0, 2);
        panelAddClient.add(lblGender, gbc);
        setPosition(0, 3);
        panelAddClient.add(lblCivilID, gbc);
        setPosition(0, 4);
        panelAddClient.add(lblCustomerID, gbc);
        setPosition(0, 5);
        panelAddClient.add(lblTelephone, gbc);
        setPosition(0, 6);
        panelAddClient.add(lblAge, gbc);
        setPosition(0, 7);
        panelAddClient.add(lblDietPlan, gbc);
        setPosition(0, 8);
        panelAddClient.add(lblWorkoutPlan, gbc);
        setPosition(0, 9);
        panelAddClient.add(lblFee, gbc);
        setPosition(0, 10);
        panelAddClient.add(btnRegister, gbc);

        setPosition(1, 0);
        panelAddClient.add(txtFirstname, gbc);
        setPosition(1, 1);
        panelAddClient.add(txtLastname, gbc);
        setPosition(1, 2);
        panelAddClient.add(cboGender, gbc);
        setPosition(1, 3);
        panelAddClient.add(txtCivilID, gbc);
        setPosition(1, 4);
        panelAddClient.add(txtCustomerID, gbc);
        setPosition(1, 5);
        panelAddClient.add(txtTelephone, gbc);
        setPosition(1, 6);
        panelAddClient.add(txtAge, gbc);
        setPosition(1, 7);
        panelAddClient.add(txtDietPlan, gbc);
        setPosition(1, 8);
        panelAddClient.add(txtWorkoutPlan, gbc);
        setPosition(1, 9);
        panelAddClient.add(txtFee, gbc);
        setPosition(1, 10);
        panelAddClient.add(btnBack4, gbc);

        //Panel delete client
        lblEnterID = new JLabel("Enter ID: ");

        txtID = new JTextField(5);

        btnDeleteC = new JButton("Delete");
        btnBack5 = new JButton("Back");

        panelDeleteClient.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelDeleteClient.add(lblEnterID, gbc);
        setPosition(0, 1);
        panelDeleteClient.add(btnDeleteC, gbc);
        setPosition(1, 0);
        panelDeleteClient.add(txtID, gbc);
        setPosition(1, 1);
        panelDeleteClient.add(btnBack5, gbc);

        //Panel modify client
        lblMFirstname = new JLabel("Firstname: ");
        lblMLastname = new JLabel("Lastname: ");
        lblMCivilID = new JLabel("Civil ID:");
        lblMCustomerID = new JLabel("Customer ID: ");
        lblMTelephone = new JLabel("Telephone: ");
        lblMAge = new JLabel("Age: ");
        lblMDietPlan = new JLabel("Diet Plan: ");
        lblMWorkoutPlan = new JLabel("Workout Plan: ");
        lblMFee = new JLabel("Fee: ");
        lblMGender = new JLabel("Gender: ");

        txtMFirstname = new JTextField(10);
        txtMLastname = new JTextField(10);
        txtMCivilID = new JTextField(10);
        txtMCustomerID = new JTextField(10);
        txtMTelephone = new JTextField(10);
        txtMAge = new JTextField(10);
        txtMDietPlan = new JTextField(10);
        txtMWorkoutPlan = new JTextField(10);
        txtMFee = new JTextField(10);

        cboMGender = new JComboBox(genders);
        btnModifyC = new JButton("Modify");
        btnBack13 = new JButton("Back");

        panelModifyClient.setLayout(new GridBagLayout());

        setPosition(0, 1);
        panelModifyClient.add(lblMFirstname, gbc);
        setPosition(0, 2);
        panelModifyClient.add(lblMLastname, gbc);
        setPosition(0, 3);
        panelModifyClient.add(lblMGender, gbc);
        setPosition(0, 4);
        panelModifyClient.add(lblMCivilID, gbc);
        setPosition(0, 5);
        panelModifyClient.add(lblMCustomerID, gbc);
        setPosition(0, 6);
        panelModifyClient.add(lblMTelephone, gbc);
        setPosition(0, 7);
        panelModifyClient.add(lblMAge, gbc);
        setPosition(0, 8);
        panelModifyClient.add(lblMDietPlan, gbc);
        setPosition(0, 9);
        panelModifyClient.add(lblMWorkoutPlan, gbc);
        setPosition(0, 10);
        panelModifyClient.add(lblMFee, gbc);
        setPosition(0, 11);
        panelModifyClient.add(btnModifyC, gbc);

        setPosition(1, 1);
        panelModifyClient.add(txtMFirstname, gbc);
        setPosition(1, 2);
        panelModifyClient.add(txtMLastname, gbc);
        setPosition(1, 3);
        panelModifyClient.add(cboMGender, gbc);
        setPosition(1, 4);
        panelModifyClient.add(txtMCivilID, gbc);
        setPosition(1, 5);
        panelModifyClient.add(txtMCustomerID, gbc);
        setPosition(1, 6);
        panelModifyClient.add(txtMTelephone, gbc);
        setPosition(1, 7);
        panelModifyClient.add(txtMAge, gbc);
        setPosition(1, 8);
        panelModifyClient.add(txtMDietPlan, gbc);
        setPosition(1, 9);
        panelModifyClient.add(txtMWorkoutPlan, gbc);
        setPosition(1, 10);
        panelModifyClient.add(txtMFee, gbc);
        setPosition(1, 11);
        panelModifyClient.add(btnBack13, gbc);

        //Panel create diet
        lblDietName = new JLabel("Diet name: ");
        lblDietDay = new JLabel("Day: ");
        lblNumOfMeal = new JLabel("Number of meal: ");
        lblMealName = new JLabel("Meal name: ");
        lblDrink = new JLabel("Drink name: ");
        lblCal = new JLabel("Calories: ");

        txtDietName = new JTextField(10);
        txtNumOfMeal = new JTextField(10);
        txtMealName = new JTextField(10);
        txtDrink = new JTextField(10);
        txtCal = new JTextField(10);

        cboDietDay = new JComboBox(days);

        btnAddDiet = new JButton("Add Meal");
        btnBack6 = new JButton("Back");

        panelCreateDiet.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelCreateDiet.add(lblDietName, gbc);
        setPosition(0, 1);
        panelCreateDiet.add(lblDietDay, gbc);
        setPosition(0, 2);
        panelCreateDiet.add(lblNumOfMeal, gbc);
        setPosition(0, 3);
        panelCreateDiet.add(lblMealName, gbc);
        setPosition(0, 4);
        panelCreateDiet.add(lblDrink, gbc);
        setPosition(0, 5);
        panelCreateDiet.add(lblCal, gbc);
        setPosition(0, 6);
        panelCreateDiet.add(btnAddDiet, gbc);

        setPosition(1, 0);
        panelCreateDiet.add(txtDietName, gbc);
        setPosition(1, 1);
        panelCreateDiet.add(cboDietDay, gbc);
        setPosition(1, 2);
        panelCreateDiet.add(txtNumOfMeal, gbc);
        setPosition(1, 3);
        panelCreateDiet.add(txtMealName, gbc);
        setPosition(1, 4);
        panelCreateDiet.add(txtDrink, gbc);
        setPosition(1, 5);
        panelCreateDiet.add(txtCal, gbc);
        setPosition(1, 6);
        panelCreateDiet.add(btnBack6, gbc);

        //Panel delete diet
        lblEnterDietName = new JLabel("Enter diet name: ");

        txtEnterDietName = new JTextField(10);

        btnDeleteD = new JButton("Delete");
        btnBack7 = new JButton("Back");

        panelDeleteDiet.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelDeleteDiet.add(lblEnterDietName, gbc);
        setPosition(0, 1);
        panelDeleteDiet.add(btnDeleteD, gbc);
        setPosition(1, 0);
        panelDeleteDiet.add(txtEnterDietName, gbc);
        setPosition(1, 1);
        panelDeleteDiet.add(btnBack7, gbc);

        //panel modify diet
        lblMDietName = new JLabel("Diet name: ");
        lblMDietDay = new JLabel("Day: ");
        lblMNumOfMeal = new JLabel("Number of meal: ");
        lblMMealName = new JLabel("Meal name: ");
        lblMDrink = new JLabel("Drink name: ");
        lblMCal = new JLabel("Calories: ");

        txtMDietName = new JTextField(10);
        txtMNumOfMeal = new JTextField(10);
        txtMMealName = new JTextField(10);
        txtMDrink = new JTextField(10);
        txtMCal = new JTextField(10);

        cboMDietDay = new JComboBox(days);

        btnModifyD = new JButton("Modify Meal");
        btnBack14 = new JButton("Back");

        panelModifyDiet.setLayout(new GridBagLayout());

        setPosition(0, 1);
        panelModifyDiet.add(lblMDietName, gbc);
        setPosition(0, 2);
        panelModifyDiet.add(lblMDietDay, gbc);
        setPosition(0, 3);
        panelModifyDiet.add(lblMNumOfMeal, gbc);
        setPosition(0, 4);
        panelModifyDiet.add(lblMMealName, gbc);
        setPosition(0, 5);
        panelModifyDiet.add(lblMDrink, gbc);
        setPosition(0, 6);
        panelModifyDiet.add(lblMCal, gbc);
        setPosition(0, 7);
        panelModifyDiet.add(btnModifyD, gbc);

        setPosition(1, 1);
        panelModifyDiet.add(txtMDietName, gbc);
        setPosition(1, 2);
        panelModifyDiet.add(cboMDietDay, gbc);
        setPosition(1, 3);
        panelModifyDiet.add(txtMNumOfMeal, gbc);
        setPosition(1, 4);
        panelModifyDiet.add(txtMMealName, gbc);
        setPosition(1, 5);
        panelModifyDiet.add(txtMDrink, gbc);
        setPosition(1, 6);
        panelModifyDiet.add(txtMCal, gbc);
        setPosition(1, 7);
        panelModifyDiet.add(btnBack14, gbc);

        //panel create workout plan
        lblNameOfWP = new JLabel("Name of workout plan: ");
        lblWPDay = new JLabel("Day: ");
        lblNumOfEx = new JLabel("Number of Exercise: ");
        lblTypeOfEx = new JLabel("Type of Exercise: ");
        lblSets = new JLabel("Sets: ");
        lblReps = new JLabel("Reps: ");
        lblTime = new JLabel("Time(m): ");

        txtNameOfWP = new JTextField(10);
        txtNumOfEx = new JTextField(10);
        txtTypeOfEx = new JTextField(10);
        txtSets = new JTextField(10);
        txtReps = new JTextField(10);
        txtTime = new JTextField(10);

        cboWPDay = new JComboBox(days);

        btnAddWPlan = new JButton("Add Exercise");
        btnBack8 = new JButton("Back");

        panelCreateWPlan.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelCreateWPlan.add(lblNameOfWP, gbc);
        setPosition(0, 1);
        panelCreateWPlan.add(lblWPDay, gbc);
        setPosition(0, 2);
        panelCreateWPlan.add(lblNumOfEx, gbc);
        setPosition(0, 3);
        panelCreateWPlan.add(lblTypeOfEx, gbc);
        setPosition(0, 4);
        panelCreateWPlan.add(lblSets, gbc);
        setPosition(0, 5);
        panelCreateWPlan.add(lblReps, gbc);
        setPosition(0, 6);
        panelCreateWPlan.add(lblTime, gbc);
        setPosition(0, 7);
        panelCreateWPlan.add(btnAddWPlan, gbc);

        setPosition(1, 0);
        panelCreateWPlan.add(txtNameOfWP, gbc);
        setPosition(1, 1);
        panelCreateWPlan.add(cboWPDay, gbc);
        setPosition(1, 2);
        panelCreateWPlan.add(txtNumOfEx, gbc);
        setPosition(1, 3);
        panelCreateWPlan.add(txtTypeOfEx, gbc);
        setPosition(1, 4);
        panelCreateWPlan.add(txtSets, gbc);
        setPosition(1, 5);
        panelCreateWPlan.add(txtReps, gbc);
        setPosition(1, 6);
        panelCreateWPlan.add(txtTime, gbc);
        setPosition(1, 7);
        panelCreateWPlan.add(btnBack8, gbc);

        //panel modify workout plan
        lblMNameOfWP = new JLabel("Name of workout plan: ");
        lblMWPDay = new JLabel("Day: ");
        lblMNumOfEx = new JLabel("Number of Exercise: ");
        lblMTypeOfEx = new JLabel("Type of Exercise: ");
        lblMSets = new JLabel("Sets: ");
        lblMReps = new JLabel("Reps: ");
        lblMTime = new JLabel("Time(m): ");

        txtMNameOfWP = new JTextField(10);
        txtMNumOfEx = new JTextField(10);
        txtMTypeOfEx = new JTextField(10);
        txtMSets = new JTextField(10);
        txtMReps = new JTextField(10);
        txtMTime = new JTextField(10);

        cboMWPDay = new JComboBox(days);

        btnModifyW = new JButton("Modify Exercise");
        btnBack15 = new JButton("Back");
        panelModifyWPlan.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelModifyWPlan.add(lblMNameOfWP, gbc);
        setPosition(0, 1);
        panelModifyWPlan.add(lblMWPDay, gbc);
        setPosition(0, 2);
        panelModifyWPlan.add(lblMNumOfEx, gbc);
        setPosition(0, 3);
        panelModifyWPlan.add(lblMTypeOfEx, gbc);
        setPosition(0, 4);
        panelModifyWPlan.add(lblMSets, gbc);
        setPosition(0, 5);
        panelModifyWPlan.add(lblMReps, gbc);
        setPosition(0, 6);
        panelModifyWPlan.add(lblMTime, gbc);
        setPosition(0, 7);
        panelModifyWPlan.add(btnModifyW, gbc);

        setPosition(1, 0);
        panelModifyWPlan.add(txtMNameOfWP, gbc);
        setPosition(1, 1);
        panelModifyWPlan.add(cboMWPDay, gbc);
        setPosition(1, 2);
        panelModifyWPlan.add(txtMNumOfEx, gbc);
        setPosition(1, 3);
        panelModifyWPlan.add(txtMTypeOfEx, gbc);
        setPosition(1, 4);
        panelModifyWPlan.add(txtMSets, gbc);
        setPosition(1, 5);
        panelModifyWPlan.add(txtMReps, gbc);
        setPosition(1, 6);
        panelModifyWPlan.add(txtMTime, gbc);
        setPosition(1, 7);
        panelModifyWPlan.add(btnBack15, gbc);

        //panel delete workout plan
        lblEnterWPlanName = new JLabel("Enter workout plan name: ");

        txtWPlanName = new JTextField(10);

        btnDeleteWP = new JButton("Delete");
        btnBack9 = new JButton("Back");

        panelDeleteWPlan.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelDeleteWPlan.add(lblEnterWPlanName, gbc);
        setPosition(0, 1);
        panelDeleteWPlan.add(btnDeleteWP, gbc);
        setPosition(1, 0);
        panelDeleteWPlan.add(txtWPlanName, gbc);
        setPosition(1, 1);
        panelDeleteWPlan.add(btnBack9, gbc);

        //panel view clients data
        textAreaClients = new JTextArea();

        scrollPaneClients = new JScrollPane(textAreaClients);

        btnViewClients = new JButton("View Clients");
        btnBack10 = new JButton("Back");

        panelShowClients.setLayout(new BorderLayout());

        panelShowClients.add(scrollPaneClients, BorderLayout.CENTER);

        subPanel1.add(btnViewClients);
        subPanel1.add(btnBack10);
        panelShowClients.add(subPanel1, BorderLayout.SOUTH);

        //panel view diet
        lblDiet = new JLabel("Enter diet name: ");
        txtDiet = new JTextField(10);

        textAreaDiet = new JTextArea();

        scrollPaneDiet = new JScrollPane(textAreaDiet);

        btnViewDiet = new JButton("View Diet");
        btnBack11 = new JButton("Back");

        panelShowDiet.setLayout(new BorderLayout());

        panelShowDiet.add(scrollPaneDiet, BorderLayout.CENTER);

        subPanel2.add(lblDiet);
        subPanel2.add(txtDiet);
        subPanel2.add(btnViewDiet);
        subPanel2.add(btnBack11);
        panelShowDiet.add(subPanel2, BorderLayout.SOUTH);

        //panel view workout
        lblWorkout = new JLabel("Enter workout name: ");
        txtWorkout = new JTextField(10);
        textAreaWorkout = new JTextArea();

        scrollPaneWorkout = new JScrollPane(textAreaWorkout);

        btnViewWorkout = new JButton("View Workout");
        btnBack12 = new JButton("Back");

        panelShowWorkout.setLayout(new BorderLayout());

        panelShowWorkout.add(scrollPaneWorkout, BorderLayout.CENTER);

        subPanel3.add(lblWorkout);
        subPanel3.add(txtWorkout);
        subPanel3.add(btnViewWorkout);
        subPanel3.add(btnBack12);
        panelShowWorkout.add(subPanel3, BorderLayout.SOUTH);

        //panel search client
        lblCusFirstname = new JLabel("Firstname: ");
        lblCusLastname = new JLabel("Lastname: ");
        lblCusCivID = new JLabel("Civil ID:");
        lblCusID = new JLabel("Customer ID: ");
        lblCusTelephone = new JLabel("Telephone: ");
        lblCusAge = new JLabel("Age: ");
        lblCusDietPlan = new JLabel("Diet Plan: ");
        lblCusWorkoutPlan = new JLabel("Workout Plan: ");
        lblCusFee = new JLabel("Fee: ");
        lblCusGender = new JLabel("Gender: ");
        lblID = new JLabel("Enter customer ID: ");

        txtCusID = new JTextField(5);

        btnSearchC = new JButton("Search Client");
        btnBack16 = new JButton("Back");

        panelSearchClient.setLayout(new GridBagLayout());

        setPosition(0, 0);
        panelSearchClient.add(lblCusFirstname, gbc);
        setPosition(0, 1);
        panelSearchClient.add(lblCusLastname, gbc);
        setPosition(0, 2);
        panelSearchClient.add(lblCusGender, gbc);
        setPosition(0, 3);
        panelSearchClient.add(lblCusCivID, gbc);
        setPosition(0, 4);
        panelSearchClient.add(lblCusID, gbc);
        setPosition(0, 5);
        panelSearchClient.add(lblCusTelephone, gbc);
        setPosition(0, 6);
        panelSearchClient.add(lblCusAge, gbc);
        setPosition(0, 7);
        panelSearchClient.add(lblCusDietPlan, gbc);
        setPosition(0, 8);
        panelSearchClient.add(lblCusWorkoutPlan, gbc);
        setPosition(0, 9);
        panelSearchClient.add(lblCusFee, gbc);
        setPosition(0, 10);
        panelSearchClient.add(lblID, gbc);
        setPosition(0, 11);
        panelSearchClient.add(btnSearchC, gbc);
        setPosition(1, 10);
        panelSearchClient.add(txtCusID, gbc);
        setPosition(1, 11);
        panelSearchClient.add(btnBack16, gbc);

        //Add panels to container panels with identifiers
        panelCont.add(panelLogin, "1");
        panelCont.add(panelMain, "2");
        panelCont.add(panelClient, "3");
        panelCont.add(panelDiet, "4");
        panelCont.add(panelWorkout, "5");
        panelCont.add(panelAddClient, "6");
        panelCont.add(panelDeleteClient, "7");
        panelCont.add(panelModifyClient, "8");
        panelCont.add(panelCreateDiet, "9");
        panelCont.add(panelModifyDiet, "10");
        panelCont.add(panelDeleteDiet, "11");
        panelCont.add(panelCreateWPlan, "12");
        panelCont.add(panelDeleteWPlan, "13");
        panelCont.add(panelModifyWPlan, "14");
        panelCont.add(panelSearchClient, "15");
        panelCont.add(panelShowClients, "16");
        panelCont.add(panelShowDiet, "17");
        panelCont.add(panelShowWorkout, "18");
        cardLayout.show(panelCont, "1");//Show main panel when program starts

        //Assign handlers
        Handler handler = new Handler(cardLayout);

        btnLogin.addActionListener(handler);
        btnSelect.addActionListener(handler);
        btnBack1.addActionListener(handler);
        btnBack2.addActionListener(handler);
        btnBack3.addActionListener(handler);
        btnBack4.addActionListener(handler);
        btnBack5.addActionListener(handler);
        btnBack6.addActionListener(handler);
        btnBack7.addActionListener(handler);
        btnBack8.addActionListener(handler);
        btnBack9.addActionListener(handler);
        btnBack10.addActionListener(handler);
        btnBack11.addActionListener(handler);
        btnBack12.addActionListener(handler);
        btnBack13.addActionListener(handler);
        btnBack14.addActionListener(handler);
        btnBack15.addActionListener(handler);
        btnBack16.addActionListener(handler);
        cboSelect.addItemListener(handler);
        btnRegister.addActionListener(handler);
        btnAddClient.addActionListener(handler);
        btnDeleteClient.addActionListener(handler);
        btnModifyClient.addActionListener(handler);
        btnCreateDiet.addActionListener(handler);
        btnDeleteDiet.addActionListener(handler);
        btnModifyDiet.addActionListener(handler);
        btnCreateWPlan.addActionListener(handler);
        btnDeleteWPlan.addActionListener(handler);
        btnModifyWPlan.addActionListener(handler);
        btnDeleteC.addActionListener(handler);
        btnAddDiet.addActionListener(handler);
        btnDeleteD.addActionListener(handler);
        btnAddWPlan.addActionListener(handler);
        btnDeleteWP.addActionListener(handler);
        btnShowClients.addActionListener(handler);
        btnShowDiet.addActionListener(handler);
        btnShowWorkout.addActionListener(handler);
        btnViewClients.addActionListener(handler);
        btnViewDiet.addActionListener(handler);
        btnViewWorkout.addActionListener(handler);
        btnModifyC.addActionListener(handler);
        btnModifyD.addActionListener(handler);
        btnModifyW.addActionListener(handler);
        btnSearchClient.addActionListener(handler);
        btnSearchC.addActionListener(handler);
        itemAbout.addActionListener(handler);

    }

    public JPanel getPanelCont() {
        return panelCont;
    }

    public void setPosition(int x, int y)//used to set the posistion of the components
    {
        gbc.gridx = x;
        gbc.gridy = y;
    }

    private class Handler implements ActionListener, ItemListener {

        String activity = "no activity";
        String userName = "admin";
        String password = "1234";
        CardLayout cardLayout = new CardLayout();
        FileCreate fileCreate = new FileCreate();
        FileDelete fileDelete = new FileDelete();
        FilePrint filePrint = new FilePrint();
        FileModify fileModify = new FileModify();
        int panel = 1;

        HealthCenterCustomer client = new HealthCenterCustomer();
        Diet diet = new Diet();
        Exercise workout = new Exercise();

        public Handler(CardLayout cl)//import cardlayout object from above
        {
            cardLayout = cl;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnLogin)//Check if credentials are correct then login,else display error message
            {
                if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login Successfull!", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                    cardLayout.show(panelCont, "2");
                    panel = 2;

                } else {
                    JOptionPane.showMessageDialog(null, "Login failed,try again.", "Health Center", JOptionPane.ERROR_MESSAGE);
                }

            }

            if (e.getSource() == btnBack1 || e.getSource() == btnBack2 || e.getSource() == btnBack3)//Go back to main panel
            {
                cardLayout.show(panelCont, "2");
                panel = 2;

            }

            if (e.getSource() == btnBack4)//Go back to client panel
            {
                clearContentAddClient();
                cardLayout.show(panelCont, "3");
                panel = 3;
            }

            if (e.getSource() == btnBack5)//Go back to client panel
            {
                txtID.setText("");
                cardLayout.show(panelCont, "3");
                panel = 3;
            }

            if (e.getSource() == btnBack6)//Go back to diet panel
            {
                clearContentCreateDiet();
                cardLayout.show(panelCont, "4");
                panel = 3;

            }
            if (e.getSource() == btnBack7)//Go back to diet panel
            {
                txtEnterDietName.setText("");
                cardLayout.show(panelCont, "4");
                panel = 3;
            }

            if (e.getSource() == btnBack8)//Go back to workout panel
            {
                clearContentCreateWPlan();
                cardLayout.show(panelCont, "5");
                panel = 3;
            }

            if (e.getSource() == btnBack9)//go back to workout panel
            {
                txtWPlanName.setText("");
                cardLayout.show(panelCont, "5");
                panel = 3;
            }

            if (e.getSource() == btnBack10)//go back to client panel
            {
                cardLayout.show(panelCont, "3");
                textAreaClients.setText("");
                panel = 3;
            }

            if (e.getSource() == btnBack11)//go back to diet panel
            {
                cardLayout.show(panelCont, "4");
                textAreaDiet.setText("");
                panel = 3;
            }

            if (e.getSource() == btnBack12)//go back to workout panel
            {

                cardLayout.show(panelCont, "5");
                textAreaWorkout.setText("");
                panel = 3;

            }

            if (e.getSource() == btnBack13)//go back to client panel
            {

                cardLayout.show(panelCont, "3");
                panel = 3;

            }

            if (e.getSource() == btnBack14)//go back to diet panel
            {

                cardLayout.show(panelCont, "4");
                txtDiet.setText("");
                panel = 3;
            }

            if (e.getSource() == btnBack15)//go back to workout panel
            {
                cardLayout.show(panelCont, "5");
                txtWorkout.setText("");
                panel = 3;
            }

            if (e.getSource() == btnBack16)//go back to client panel
            {
                cardLayout.show(panelCont, "3");
                clearContentSearchClient();
                panel = 3;
            }

            if (e.getSource() == btnSelect)//Depending which item is selected the correct panel will show
            {
                if (activity.equals("Client Management")) {
                    cardLayout.show(panelCont, "3");
                } else if (activity.equals("Diets")) {
                    cardLayout.show(panelCont, "4");
                } else if (activity.equals("Workouts")) {
                    cardLayout.show(panelCont, "5");
                }
                panel = 3;

            }

            if (e.getSource() == btnAddClient)//show panel  add client
            {

                cardLayout.show(panelCont, "6");
                panel = 5;
            }

            if (e.getSource() == btnDeleteClient)//show panel delete client
            {
                cardLayout.show(panelCont, "7");
                panel = 6;
            }

            if (e.getSource() == btnModifyClient)//show panel modify client
            {
                cardLayout.show(panelCont, "8");
                panel = 7;
            }

            if (e.getSource() == btnShowClients)//show panel show clients
            {
                cardLayout.show(panelCont, "16");
                panel = 15;

            }
            if (e.getSource() == btnSearchClient)// show panel search client
            {
                cardLayout.show(panelCont, "15");
                panel = 14;
            }

            if (e.getSource() == btnCreateDiet)//show panel create diet
            {
                cardLayout.show(panelCont, "9");
                panel = 8;
            }
            if (e.getSource() == btnDeleteDiet)//show panel delete diet
            {
                cardLayout.show(panelCont, "11");
                panel = 10;
            }
            if (e.getSource() == btnModifyDiet)//show panel modify diet
            {
                cardLayout.show(panelCont, "10");
                panel = 9;
            }

            if (e.getSource() == btnShowDiet)//show panel show diet
            {
                cardLayout.show(panelCont, "17");
                panel = 16;
            }
            if (e.getSource() == btnCreateWPlan)//show panel create wplan
            {
                cardLayout.show(panelCont, "12");
                panel = 11;
            }

            if (e.getSource() == btnDeleteWPlan)//show panel delete wplan
            {
                cardLayout.show(panelCont, "13");
                panel = 12;

            }

            if (e.getSource() == btnModifyWPlan)//show panel modify wplan
            {
                cardLayout.show(panelCont, "14");
                panel = 13;
            }

            if (e.getSource() == btnShowWorkout)//show panel show workout
            {
                cardLayout.show(panelCont, "18");
                panel = 17;
            }

            if (e.getSource() == btnRegister)//register client to file
            {

                //Pass data to HealthCenterCustomer class for data handling
                //exception numbers
                client.setCustomerFirstName(txtFirstname.getText());
                client.setCustomerLastName(txtLastname.getText());
                client.setCustomerID(Integer.parseInt(txtCustomerID.getText()));
                client.setCivilID(Integer.parseInt(txtCivilID.getText()));
                client.setCustomerAge(Integer.parseInt(txtAge.getText()));
                client.setDietPlan(txtDietPlan.getText());
                client.setWorkoutPlan(txtWorkoutPlan.getText());
                client.setFee(Integer.parseInt(txtFee.getText()));
                client.setTelephone(Integer.parseInt(txtTelephone.getText()));
                client.setGender(cboGender.getSelectedItem().toString());
                fileCreate.setClient(client);

                //open file,write to file and close file
                fileCreate.openClientsFile();
                fileCreate.addRecordsClientsFile();
                fileCreate.closeClientsFile();

                JOptionPane.showMessageDialog(null, "Client added successfully!", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                clearContentAddClient();

            }

            if (e.getSource() == btnDeleteC)//delete client from file
            {
                //exception id should be number
                fileDelete.deleteClientRecord(Integer.parseInt(txtID.getText()));

                JOptionPane.showMessageDialog(null, "Client deleted successfully", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                txtID.setText("");

            }

            if (e.getSource() == btnAddDiet)//create diet file
            {

                //Pass data to Diet class for data handling
                //exception number
                diet.setDietName(txtDietName.getText());
                diet.setDay(cboDietDay.getSelectedItem().toString());
                diet.setNumOfMeal(Integer.parseInt(txtNumOfMeal.getText()));
                diet.setMealName(txtMealName.getText());
                diet.setDrink(txtDrink.getText());
                diet.setCal(Integer.parseInt(txtCal.getText()));
                fileCreate.setDiet(diet);

                //open file,write to file and close file
                fileCreate.openDietsFile();
                fileCreate.addRecordsDietsFile();
                fileCreate.closeDietsFile();

                JOptionPane.showMessageDialog(null, "Meal added successfully!", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                clearContentCreateDiet();

            }

            if (e.getSource() == btnDeleteD)//delete diet file
            {
                
                fileDelete.deleteFile(txtEnterDietName.getText());
                JOptionPane.showMessageDialog(null, "Diet deleted successfully", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                txtEnterDietName.setText("");
            }

            if (e.getSource() == btnAddWPlan)//create WPlan file
            {

                //Pass data to Diet class for data handling
                workout.setNameOfWP(txtNameOfWP.getText());
                workout.setDay(cboWPDay.getSelectedItem().toString());
                workout.setNumberOfEx(Integer.parseInt(txtNumOfEx.getText()));
                workout.setTypeOfEx(txtTypeOfEx.getText());
                workout.setSets(Integer.parseInt(txtSets.getText()));
                workout.setReps(Integer.parseInt(txtReps.getText()));
                workout.setTime(Double.parseDouble(txtTime.getText()));
                fileCreate.setWorkout(workout);

                //open file,write to file and close file
                fileCreate.openExFile();
                fileCreate.addRecordsExFile();
                fileCreate.closeExFile();

                JOptionPane.showMessageDialog(null, "Exercise added successfully!", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                clearContentCreateWPlan();
            }

            if (e.getSource() == btnDeleteWP)//delete workout file
            {
                fileDelete.deleteFile(txtWPlanName.getText());
                JOptionPane.showMessageDialog(null, "Workout plan deleted successfully!", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                txtWPlanName.setText("");
            }

            if (e.getSource() == btnViewClients) {
                //open file,read and append to textArea,close it
                filePrint.openClientsFile();
                filePrint.readRecordsClientsFile(textAreaClients);
                filePrint.closeFile();
            }

            if (e.getSource() == btnSearchC)//search client
            {
                filePrint.openClientsFile();
                client = filePrint.searchClient(Integer.parseInt(txtCusID.getText()));
                filePrint.closeFile();
                System.out.println(client.getCivilID());
                if (client.getCustomerID() == Integer.parseInt(txtCusID.getText())) {
                    System.out.println(client.getCivilID());
                    lblCusFirstname.setText("Firstname: " + client.getCustomerFirstName());
                    lblCusLastname.setText("Lastname: " + client.getCustomerLastName());
                    lblCusCivID.setText("Civil ID: " + client.getCivilID());
                    lblCusID.setText("Customer ID: " + client.getCustomerID());
                    lblCusTelephone.setText("Telephone: " + client.getTelephone());
                    lblCusAge.setText("Age: " + client.getCustomerAge());
                    lblCusDietPlan.setText("Diet Plan: " + client.getDietPlan());
                    lblCusWorkoutPlan.setText("Workout Plan: " + client.getWorkoutPlan());
                    lblCusFee.setText("Fee: " + client.getFee());
                    lblCusGender.setText("Gender: " + client.getGender());

                } else {
                    JOptionPane.showMessageDialog(null, "No client with this ID number.", "Health Center", JOptionPane.INFORMATION_MESSAGE);

                }

            }

            if (e.getSource() == btnViewDiet) {
                //open file,read and append to textArea,close it
                filePrint.openDietWorkoutFile(txtDiet.getText());
                filePrint.readRecordsDietFile(textAreaDiet);
                filePrint.closeFile();
            }

            if (e.getSource() == btnViewWorkout) {
                //open file,read and append to textArea,close it
                filePrint.openDietWorkoutFile(txtWorkout.getText());
                filePrint.readRecordsWorkoutFile(textAreaWorkout);
                filePrint.closeFile();
            }
            if (e.getSource() == btnModifyC)//modify a client
            {

                //if getText is "" then pass the default value of the variable
                if (txtMCustomerID.getText().equals("")) {
                    client.setCustomerID(0);
                } else {
                    client.setCustomerID(Integer.parseInt(txtMCustomerID.getText()));
                }

                if (txtMFirstname.getText().equals("")) {
                    client.setCustomerFirstName("");
                } else {
                    client.setCustomerFirstName(txtMFirstname.getText());
                }

                if (txtMLastname.getText().equals("")) {
                    client.setCustomerLastName("");
                } else {
                    client.setCustomerLastName(txtMLastname.getText());
                }

                if (txtMCivilID.getText().equals("")) {
                    client.setCivilID(0);
                } else {
                    client.setCivilID(Integer.parseInt(txtMCivilID.getText()));
                }

                if (txtMAge.getText().equals("")) {
                    client.setCustomerAge(0);
                } else {
                    client.setCustomerAge(Integer.parseInt(txtMAge.getText()));
                }

                if (txtMDietPlan.getText().equals("")) {
                    client.setDietPlan("");
                } else {
                    client.setDietPlan(txtMDietPlan.getText());
                }

                if (txtMWorkoutPlan.getText().equals("")) {
                    client.setWorkoutPlan("");
                } else {
                    client.setWorkoutPlan(txtMWorkoutPlan.getText());
                }

                if (txtMFee.getText().equals("")) {
                    client.setFee(0);
                } else {
                    client.setFee(Integer.parseInt(txtMFee.getText()));
                }

                if (txtMTelephone.getText().equals("")) {
                    client.setTelephone(0);
                } else {
                    client.setTelephone(Integer.parseInt(txtMTelephone.getText()));
                }

                if (cboMGender.getSelectedItem().toString().equals("")) {
                    client.setGender("");
                } else {
                    client.setGender(cboMGender.getSelectedItem().toString());
                }

                fileModify.setClient(client);

                fileModify.ModifyClientRecord(Integer.parseInt(txtMCustomerID.getText()));

                clearContentModifyClient();
                JOptionPane.showMessageDialog(null, "Client data modified successfully", "Health Center", JOptionPane.INFORMATION_MESSAGE);

            }

            if (e.getSource() == btnModifyD)// modify a diet
            {
                if (txtMDietName.getText().equals("")) {
                    diet.setDietName("");
                } else {
                    diet.setDietName(txtMDietName.getText());
                }

                if (cboMDietDay.getSelectedItem().toString().equals("")) {
                    diet.setDay("");
                } else {
                    diet.setDay(cboMDietDay.getSelectedItem().toString());
                }

                if (txtMNumOfMeal.getText().equals("")) {
                    diet.setNumOfMeal(0);
                } else {
                    diet.setNumOfMeal(Integer.parseInt(txtMNumOfMeal.getText()));
                }

                if (txtMMealName.getText().equals("")) {
                    diet.setMealName("");
                } else {
                    diet.setMealName(txtMMealName.getText());
                }

                if (txtMDrink.getText().equals("")) {
                    diet.setDrink("");
                } else {
                    diet.setDrink(txtMDrink.getText());
                }

                if (txtMCal.getText().equals("")) {
                    diet.setCal(0);
                } else {
                    diet.setCal(Integer.parseInt(txtMCal.getText()));
                }

                fileModify.setDiet(diet);
                fileModify.ModifyDietFile(txtMDietName.getText(), cboMDietDay.getSelectedItem().toString(), Integer.parseInt(txtMNumOfMeal.getText()));
                clearContentModifyDiet();
                JOptionPane.showMessageDialog(null, "Diet modified successfully", "Health Center", JOptionPane.INFORMATION_MESSAGE);

            }

            if (e.getSource() == btnModifyW)//modify a workout
            {

                if (txtMNameOfWP.getText().equals("")) {
                    workout.setNameOfWP("");
                } else {
                    workout.setNameOfWP(txtMNameOfWP.getText());
                }

                if (cboMWPDay.getSelectedItem().toString().equals("")) {
                    workout.setDay("");
                } else {
                    workout.setDay(cboMWPDay.getSelectedItem().toString());
                }

                if (txtMNumOfEx.getText().equals("")) {
                    workout.setNumberOfEx(0);
                } else {
                    workout.setNumberOfEx(Integer.parseInt(txtMNumOfEx.getText()));
                }

                if (txtMTypeOfEx.getText().equals("")) {
                    workout.setTypeOfEx("");
                } else {
                    workout.setTypeOfEx(txtMTypeOfEx.getText());
                }

                if (txtMSets.getText().equals("")) {
                    workout.setSets(0);
                } else {
                    workout.setSets(Integer.parseInt(txtMSets.getText()));
                }

                if (txtMReps.getText().equals("")) {
                    workout.setReps(0);
                } else {
                    workout.setReps(Integer.parseInt(txtMReps.getText()));
                }

                if (txtMTime.getText().equals("")) {
                    workout.setTime(0.0);
                } else {
                    workout.setTime(Double.parseDouble(txtMTime.getText()));
                }

                fileModify.setWorkout(workout);
                fileModify.ModifyWorkoutFile(txtMNameOfWP.getText(), cboMWPDay.getSelectedItem().toString(), Integer.parseInt(txtMNumOfEx.getText()));
                clearContentModifyWPlan();
                JOptionPane.showMessageDialog(null, "Workout modified successfully", "Health Center", JOptionPane.INFORMATION_MESSAGE);

            }

            if (e.getSource() == itemAbout) {
                if (panel == 1)//check if paneLogin
                {
                    JOptionPane.showMessageDialog(null, "Enter login credentials to proceed.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }

                if (panel == 2)//check if panelMain
                {
                    JOptionPane.showMessageDialog(null, "Select which section you want.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }

                if (panel == 3)//check if panelClient or panelDiet or panelWorkout
                {
                    JOptionPane.showMessageDialog(null, "Press the button of the operation you want to perform.", "Health Center", JOptionPane.INFORMATION_MESSAGE);

                }

                if (panel == 5)//check if panelAddClient
                {
                    JOptionPane.showMessageDialog(null, "Enter client's information to register them to the file.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }

                if (panel == 7)//check if panelModifyClient
                {
                    JOptionPane.showMessageDialog(null, "Enter the credentials you want to change\nThe rest leave them blank\nMust fill customerID.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }

                if (panel == 6)//check if panelDeleteClient
                {
                    JOptionPane.showMessageDialog(null, "Enter customerID to delete him/her from the file.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }

                if (panel == 8)//check if panelAddDiet
                {
                    JOptionPane.showMessageDialog(null, "Enter diet information to store to the file.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 9)//check if panelModifyDiet
                {
                    JOptionPane.showMessageDialog(null, "Enter the credentials you want to change\nThe rest leave them blank\nMust fill name of diet, day, number of meal.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 10)//check if panelDeleteDiet
                {
                    JOptionPane.showMessageDialog(null, "Enter diet name to delete it.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 11)//check if panelCreateWPlan
                {
                    JOptionPane.showMessageDialog(null, "Enter workout plan information to store to the file.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 12)//check if panelDeleteWPlan
                {
                    JOptionPane.showMessageDialog(null, "Enter workout plan name to delete from the file.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 13)//check if panelModifyWPlan
                {
                    JOptionPane.showMessageDialog(null, "Enter the credentials you want to change\nThe rest leave them blank\nMust fill name of WPlan, day, number of exercise.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 14)//check if panelSearchClient
                {
                    JOptionPane.showMessageDialog(null, "Enter customerID to show his/her information.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 15)//check if panelShowClients
                {
                    JOptionPane.showMessageDialog(null, "Press the button to show clients file.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 16)//check if panelShowDiet
                {
                    JOptionPane.showMessageDialog(null, "Enter diet name and press the button to show diet information.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
                if (panel == 17)//check if panelShowWorkout
                {
                    JOptionPane.showMessageDialog(null, "Enter workout plan name and press the button to show workout plan information.", "Health Center", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }

        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == cboSelect) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    activity = cboSelect.getSelectedItem().toString();
                }
            }

        }

        public void clearContentAddClient()//Reset textboxes content of add client to null
        {
            txtFirstname.setText("");
            txtLastname.setText("");
            txtAge.setText("");
            txtCivilID.setText("");
            txtTelephone.setText("");
            txtCustomerID.setText("");
            txtDietPlan.setText("");
            txtWorkoutPlan.setText("");
            txtFee.setText("");
            cboGender.setSelectedIndex(0);

        }

        public void clearContentCreateDiet()//Reset textboxes content of create diet to null
        {
            txtDietName.setText("");
            txtNumOfMeal.setText("");
            txtMealName.setText("");
            txtDrink.setText("");
            txtCal.setText("");
            cboDietDay.setSelectedIndex(0);
        }

        public void clearContentCreateWPlan()//Reset textboxes content of create workout plan to null
        {
            txtNameOfWP.setText("");
            txtNumOfEx.setText("");
            txtTypeOfEx.setText("");
            txtSets.setText("");
            txtReps.setText("");
            txtTime.setText("");
            cboWPDay.setSelectedIndex(0);
        }

        public void clearContentModifyClient()//Reset textboxes content of modify client to null
        {
            txtMFirstname.setText("");
            txtMLastname.setText("");
            txtMAge.setText("");
            txtMCivilID.setText("");
            txtMTelephone.setText("");
            txtMCustomerID.setText("");
            txtMDietPlan.setText("");
            txtMWorkoutPlan.setText("");
            txtMFee.setText("");
            cboMGender.setSelectedIndex(0);

        }

        public void clearContentModifyDiet()//Reset textboxes content of modify diet to null
        {
            txtMDietName.setText("");
            txtMNumOfMeal.setText("");
            txtMMealName.setText("");
            txtMDrink.setText("");
            txtMCal.setText("");
            cboMDietDay.setSelectedIndex(0);
        }

        public void clearContentModifyWPlan()//Reset textboxes content of modify workout plan to null
        {
            txtMNameOfWP.setText("");
            txtMNumOfEx.setText("");
            txtMTypeOfEx.setText("");
            txtMSets.setText("");
            txtMReps.setText("");
            txtMTime.setText("");
            cboMWPDay.setSelectedIndex(0);
        }

        public void clearContentSearchClient()//Reset lbls of searchClient
        {
            lblCusFirstname.setText("Firstname: ");
            lblCusLastname.setText("Lastname: ");
            lblCusCivID.setText("Civil ID:");
            lblCusID.setText("Customer ID: ");
            lblCusTelephone.setText("Telephone: ");
            lblCusAge.setText("Age: ");
            lblCusDietPlan.setText("Diet Plan: ");
            lblCusWorkoutPlan.setText("Workout Plan: ");
            lblCusFee.setText("Fee: ");
            lblCusGender.setText("Gender: ");
        }
    }
}
