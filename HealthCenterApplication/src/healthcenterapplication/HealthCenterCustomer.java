package healthcenterapplication;


public class HealthCenterCustomer {
    
    //Characteristics for each customer
    private String customerFirstName;
    private String customerLastName;
    private String gender;
    private int fee;
    private int civilID;
    private int telephone;
    private int customerID;
    private int customerAge;
    private String dietPlan;
    private String workoutPlan;
    
    //Empty constructor
    public HealthCenterCustomer()
    {
        setCustomerFirstName("firstname");
        setCustomerLastName("lastname");
        setCustomerID(0);
        setCustomerAge(0);
        setDietPlan("no diet plan");
        setWorkoutPlan("no workout plan");
        setCivilID(0);
        setTelephone(0);
        setFee(0);
        setGender("no gender");
                  
    }
    
    //Full constructor
    public HealthCenterCustomer(String fn, String ln, int id, int a, String dp, String wp,int cid,int tel, int f,String g)
    {
        setCustomerFirstName(fn);
        setCustomerLastName(ln);
        setCustomerID(id);
        setCustomerAge(a);
        setDietPlan(dp);
        setWorkoutPlan(wp);
        setCivilID(cid);
        setTelephone(tel);
        setFee(f);
        setGender(g);
    }
    
    //Set functions
    
    public void setCustomerFirstName(String fn)
    {
        if(fn.equals(""))
            customerFirstName = "first name";
        else
            customerFirstName = fn;
    
    }
    
    public void setCustomerLastName(String ln)
    {
        if(ln.equals(""))
            customerLastName = "last name";
        else
            customerLastName = ln;
        
    }
    
    public void setCustomerID(int id)
    {
        if(id>0)
            customerID = id;
        else
            customerID = 0;
        
    }
    
    public void setCustomerAge(int a)
    {
        if(a>=12)
            customerAge = a;
        else
            customerAge = 0;
    
    }
    
    
    public void setDietPlan(String dp)
    {
        if(dp.equals(""))
            dietPlan = "no diet plan";
        else
            dietPlan = dp;
                    
    }
    
    public void setWorkoutPlan(String wp)
    {
        if(wp.equals(""))
            workoutPlan = "no workout plan";
        else
            workoutPlan = wp;
    
    }
    
    public void setCivilID(int cid)
    {
        if(cid>0)
            civilID = cid;
        else
            civilID = 0;
    }
    
    public void setTelephone(int tel)
    {
        if(Integer.toString(tel).length()!=8)
            tel = 0;
        else
            telephone = tel;
    }
    
    public void setFee(int f)
    {
        if(f>0)
            fee = f;
        else
            fee = 0;
    
    }
    
    public void setGender(String g)
    {
        if(g.matches("Male|Female"))
            gender = g;
        else
            gender = "gender";
                    
    }
    //Get functions
    
    public String getCustomerFirstName()
    {
        return customerFirstName;
    }
    
    public String getCustomerLastName()
    {
        return customerLastName;
    }
    
    public int getCustomerID()
    {
        return customerID;
    }
    
    public int getCustomerAge()
    {
        return customerAge;
    }
    
    public String getDietPlan()
    {
        return dietPlan;
    }
    
    public String getWorkoutPlan()
    {
        return workoutPlan;
    }
    
    public int getTelephone()
    {
        return telephone;
    }
    
    public int getCivilID()
    {
        return civilID;
    }
    
    public int getFee()
    {
        return fee;
    }
    
    public String getGender()
    {
        return gender;
    }
}
