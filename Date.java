import java.io.Serializable;

/**
 * Another class part of a previous hw extended to meet the requirements of the new interfaces learnt.
 * 
 * @author Deepali Juneja
 * @version 23 May 2020
 */
public class Date implements Comparable<Date>, Cloneable, Serializable{

    private int day, month, year;
    /**
     * Below is the first constructor and takes no argument so the date is just set to the January 1st, 2020.
     */
    public Date(){
        this.setDay(1);
        this.setMonth(1);
        this.setYear(2020);
    }

    /**
     * Below is the complete constructor that checks if the values taken for the month, day, and year are valid or not.
     * 
     * @param checkMonth
     * @param checkDay
     * @param checkYear
     */
    public Date(int checkMonth, int checkDay, int checkYear){
        this.setDay(checkDay);
        this.setMonth(checkMonth);
        this.setYear(checkYear);
    }

    /**
     * Below is the constructor that takes another date object and its copied into the class.
     * @param anotherObj
     */
    public Date(Date anotherObj){
        this.setDay(anotherObj.getDay());
        this.setMonth(anotherObj.getMonth());
        this.setYear(anotherObj.getYear());
    }
    
    /**
     * Getter for month.
     * 
     * @return numeric value of the month.
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Getter for day 
     * 
     * @return numeric value for the day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Getter for year 
     * 
     * @return Numeric value of the year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Setter for the day but also checks the range -> 1-31 days.
     * 
     * @param newDay 
     */
    public void setDay(int newDay) {
         if (newDay > 0 && newDay <= 31) {
            this.day = newDay;
        } else {
            throw new IllegalArgumentException("Please follow the range of days, thanks!");
        }
    }

    /**
     * Setter for the month but also checks the range -> 1-12 months.
     * @param newMonth 
     *
     */
    public void setMonth(int newMonth) {
        if (newMonth > 0 && newMonth < 13) {
            this.month = newMonth;
        } else {
            throw new IllegalArgumentException("Months need to be between 1-12 months, thanks!");
        }
    }

    /**
     * The setter for the year but also checks the range -> 2014- 2024.
     * 
     * @param newYear 
     */
    public void setYear(int newYear) {
         if (newYear >= 2014 && newYear <= 2024) {
            this.year = newYear;
        } else {
            throw new IllegalArgumentException("The range for years is between 2014-2024, please stick to it, thanks!");
        }
    }

    @Override
    /**
     * Below is the method which evaluates if two dates are equal.
     * 
     * @param anotherObj- some different date
     * @return true of false
     */
    public boolean equals(Object anotherObj) {
        boolean output = false;
        if(anotherObj != null && anotherObj instanceof Date){
            if(this.getDay() == ((Date) anotherObj).getDay()){
                if (this.getMonth() == ((Date) anotherObj).getMonth()) {
                    if (this.getYear() == ((Date) anotherObj).getYear()) {
                        output = true;
                    }
                }
            }
        }
        return output;
    }

    @Override
    /**
     * Below is the clone class.
     */
    public Date clone() {
        Date value = null;
        try {
            value = (Date) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Sorry! Clone didn't work.");
        }
        return value;
    }
    
    @Override
    /**
     * Below is the compare method with returns 0 or 1.
     */
    public int compareTo(Date o){
        int output = 0;
        if(this.equals(o)){
			output= 1;
        }
        return output;
	}
    
    /**
     * Prints out the final date object
     */
    public String toString(){
        String output = this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
        return output;
    }
}