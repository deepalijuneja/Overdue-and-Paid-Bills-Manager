import java.io.Serializable;

/**
 * This class is taken from my previous homework and been modified to meet the requirements of the new interfaces learnt.
 * 
 * @author Deepali Juneja
 * @version 24 May 2020
 */
public class Bill implements Comparable<Bill>, Cloneable, Serializable{

    
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    //instance variables as provided.

    /**
     * Below is the constructor and takes the following 3 parameters except paidDate.
     * 
     * @param amount     
     * @param dueDate    
     * @param originator 
     */
    public Bill(Money amount, Date dueDate, String originator) {
        this.setAmount(amount);
        this.setDueDate(dueDate);
        this.setOriginator(originator);
        this.paidDate = null;
    }

    /**
     * Below is the copy constructor which takes in another bill object, which in-turn is copied to the current one.
     * 
     * @param anotherObj
     */
    public Bill(Bill anotherObj) {
        if (anotherObj != null) {
            this.amount = new Money(anotherObj.getAmount());
            this.dueDate = new Date(anotherObj.getDueDate());
            this.paidDate = new Date(anotherObj.getPaidDate());
            this.originator = new String(anotherObj.getOriginator());
        }
    }

    /**
     * Getter for amount.
     * 
     * @return
     */
    public Money getAmount() {
        Money tMoney = new Money(this.amount);
        return tMoney;
    }

    /**
     * Getter for when's the due date.
     * 
     * @return
     */
    public Date getDueDate() {
        Date tDate = new Date(this.dueDate);
        return tDate;
    }

    /**
     * Getter for when the bill was paid.
     * 
     * @return
     */
    public Date getPaidDate() {
        Date tDate = new Date(this.paidDate);
        return tDate;
    }

    /**
     * Getter for string
     * 
     * @return
     */
    public String getOriginator() {
        String tString = new String(this.originator);
        return tString;
    }

    /**
     * Setter for amount.
     * 
     * @param changeAmount 
     * 
     */
    public void setAmount(Money changeAmount) {
        if (changeAmount != null) {
            this.amount = new Money(changeAmount);
        } else {
            throw new IllegalArgumentException("Null!");
        }
    }

    /**
     * Setter for when's the due date.
     * 
     * @param changeDate
     * 
     */
    public void setDueDate(Date changeDate) {
         if (changeDate != null) {
            this.dueDate = new Date(changeDate);
        } else {
            throw new IllegalArgumentException("Null values are not acceptable, sorry!");
        }
    }

    /**
     * Setter for the string
     * 
     * @param changeOriginator 
     */
    public void setOriginator(String changeOriginator) {
        if (changeOriginator != null && !changeOriginator.isEmpty()) {
            this.originator = new String(changeOriginator);
         } else {
            throw new IllegalArgumentException("Null values are not acceptable, sorry!");
        }
    }

    /**
     * Setter for when's the paid date of the bill.
     *  
     * @param changePaid 
     * 
     */
    public void setPaid(Date changePaid) {
         if (changePaid.getYear() <= this.getDueDate().getYear() && changePaid.getMonth() <= this.getDueDate().getMonth()
        && changePaid.getDay() <= this.getDueDate().getDay()) {
            this.paidDate = new Date(changePaid);
        } else {
            throw new IllegalArgumentException("Either the amount is enough or the due date has passed, sorry!");
        }
    }

    /**
     * Below is the method which checks if bill was paid- set to 'true' is yes.
     * 
     * @return true or false
     */
    public boolean isPaid() {
        boolean paid = false;
        Money tMoney = new Money(this.amount);
        if (tMoney.getMoney() == 0) {
            paid = true;
        } else {
            paid = false;
        }
        return paid;
    }

    /**
     * Setter to make the bill unpaid.
     */
    public void setUnpaid() {
        this.setPaid(null);
    }

    /**
     * Below is the method to check if two bills are identical or not.
     * 
     * @param anotherObj
     * @return true or false
     */
    public boolean equals(Bill anotherObj) {
        boolean output = false;
        Money tMoney = new Money(this.getAmount());
        Date tDueDate = new Date(this.getDueDate());
        Date tPaid = new Date(this.getPaidDate());
        String tOrig = new String(this.getOriginator());
        if (anotherObj != null) {
            if (tMoney.equals(anotherObj.getAmount()) && tDueDate.equals(anotherObj.getDueDate())
                    && tPaid.equals(anotherObj.getPaidDate()) && tOrig.equals(anotherObj.getOriginator())) {
                output = true;
            }
        }
        return output;
    }

    /**
     * Prints the amount, due date, whom it's due to, and if paid (also gives when paid) or unpaid.
     */
    @Override
    public String toString() {
        String output = "";
        if (this.isPaid()) {
             output += "You amount due is: " + this.getAmount() + "and the due date is: " + this.getDueDate() + " issued by: " + this.getOriginator()
                    + " and was paid on:" + this.getPaidDate();
        } else {
            output += " Your amount due is: " + this.getAmount() + "and the due date is:" + this.getDueDate() + "issued by: " + this.getOriginator()
                    + " and was paid on:";
        }
        return output;
    }

    @Override
    /**
     * Below is the compare method with returns 0 or 1.
     */
    public int compareTo(Bill o) {
        int output = 0;
        if(this.equals(o)){
            output = 1;
        }
        return output;
    }

    @Override
    /**
     * Final clone method.
     */
    public Bill clone(){
        Bill value = null;
        try {
            value = (Bill)super.clone();
        } catch (Exception e) {
            throw new InternalError("Clone failure!");
        }
        return value;
    }
}