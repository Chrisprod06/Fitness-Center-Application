package healthcenterapplication;

public class Exercise {

    private String nameOfWP;
    private String day;
    private int numOfEx;
    private String typeOfEx;
    private int sets;
    private int reps;
    private double time;

    public Exercise(String n, String d, int nex, String tex, int r, double t) {
        setNameOfWP(n);
        setDay(d);
        setNumberOfEx(nex);
        setTypeOfEx(tex);
        setReps(r);
        setTime(t);

    }

    public Exercise() {
        setNameOfWP("");
        setDay("");
        setNumberOfEx(0);
        setTypeOfEx("");
        setReps(0);
        setTime(0);
    }

    //Set functions
    public void setNameOfWP(String n) {
        if (n.equals("")) {
            nameOfWP = "wp";
        } else {
            nameOfWP = n;
        }
    }

    public void setDay(String d) {
        if (d.matches("Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday")) {
            day = d;
        } else {
            day = "day";
        }
    }

    public void setNumberOfEx(int nex) {
        if (nex > 0) {
            numOfEx = nex;
        } else {
            numOfEx = 0;
        }
    }

    public void setTypeOfEx(String tex) {
        if (tex.equals("")) {
            typeOfEx = "ex";
        } else {
            typeOfEx = tex;
        }
    }

    public void setReps(int r) {
        if (r > 0) {
            reps = r;
        } else {
            reps = 0;
        }
    }

    public void setSets(int s) {
        if (s > 0) {
            sets = s;
        } else {
            sets = 0;
        }
    }

    public void setTime(double t) {
        if (t > 0.0) {
            time = t;
        } else {
            time = 0;
        }
    }

    //Get functions
    public String getNameOfWP() {
        return nameOfWP;
    }

    public String getDay() {
        return day;
    }

    public int getNumOfEx() {
        return numOfEx;
    }

    public String getTypeOfEx() {
        return typeOfEx;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getTime() {
        return time;
    }

}
