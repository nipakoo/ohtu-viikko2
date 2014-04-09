package ohtu;

public class Submission {
    private String student_number;
    private String week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private int exercises;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        exercises = 0;
        String info = " viikko " + week + ": tehtyjä tehtäviä yhteensä: *"
                + ", aikaa kului " + hours + " tuntia, tehdyt "
                + "tehtävät: ";
        
        if (a1 == true) {
            info += "1 ";
            exercises++;
        }
        if (a2 == true) {
            info += "2 ";
            exercises++;
        }
        if (a3 == true) {
            info += "3 ";
            exercises++;
        }
        if (a4 == true) {
            info += "4 ";
            exercises++;
        }
        if (a5 == true) {
            info += "5 ";
            exercises++;
        }
        if (a6 == true) {
            info += "6 ";
            exercises++;
        }
        if (a7 == true) {
            info += "7 ";
            exercises++;
        }
        if (a8 == true) {
            info += "8 ";
            exercises++;
        }
        if (a9 == true) {
            info += "9 ";
            exercises++;
        }
        if (a10 == true) {
            info += "10 ";
            exercises++;
        }
        if (a11 == true) {
            info += "11 ";
            exercises++;
        }
        if (a12 == true) {
            info += "12 ";
            exercises++;
        }
        if (a13 == true) {
            info += "13 ";
            exercises++;
        }
        if (a14 == true) {
            info += "14 ";
            exercises++;
        }
        if (a15 == true) {
            info += "15 ";
            exercises++;
        }
        
        info = info.replace("*", "" + exercises);
        
        return info;
    }
    
}