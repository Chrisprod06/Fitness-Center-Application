
package healthcenterapplication;

public class Diet {

    private String dietName;
    private String day;
    private int numOfMeal;
    private String mealName;
    private String drink;
    private int cal;

    public Diet() {
        setDietName("diet");
        setDay("day");
        setNumOfMeal(0);
        setMealName("meal");
        setDrink("drink");
        setCal(0);
    }

    public Diet(String dn, String da, int n, String mn, String dr, int c) {
        setDietName(dn);
        setDay(da);
        setNumOfMeal(n);
        setMealName(mn);
        setDrink(dr);
        setCal(c);
    }

    //Set functions
    public void setDietName(String dn) {
        if (dn.equals("")) {
            dietName = "diet";
        } else {
            dietName = dn;
        }

    }

    public void setDay(String da) {
        if (da.matches("Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday")) {
            day = da;
        } else {
            day = "day";
        }
    }

    public void setNumOfMeal(int n) {
        if (n > 0) {
            numOfMeal = n;
        } else {
            numOfMeal = 0;
        }
    }

    public void setMealName(String mn) {
        if (mn.equals("")) {
            mealName = "meal";
        } else {
            mealName = mn;
        }
    }

    public void setDrink(String dr) {
        if (dr.equals("")) {
            drink = "drink";
        } else {
            drink = dr;
        }
    }

    public void setCal(int c) {
        if (cal >= 0) {
            cal = c;
        } else {
            cal = 0;
        }
    }

    //Get functions
    public String getDietName() {
        return dietName;
    }

    public String getDay() {
        return day;
    }

    public int getNumOfMeal() {
        return numOfMeal;
    }

    public String getMealName() {
        return mealName;
    }

    public String getDrink() {
        return drink;
    }

    public int getCal() {
        return cal;
    }

}
