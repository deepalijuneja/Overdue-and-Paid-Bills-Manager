/**
 * This class extends the ArrayList. It can add/remove bills.
 * 
 * @author Deepali Juneja
 * @version 25 May 2020
 */
public class ExpenseAccount extends ArrayList<Bill> {
    private ArrayList<Bill> b; // b is an easy variable I used for bill
    private int eval;

    /**
     * Below is an empty constructor.
     */
    public ExpenseAccount() {
        b = new ArrayList<>(10);
        eval = 0;
    }

    /**
     * Below addBill methods adds a new bill(nBill) and evaluates if it is null.
     * 
     * @param nBill  the new bill
     */
    public void addBill(Bill nBill) {
        if (nBill != null) {
            b.insert(nBill, eval);
            eval++;
        } else {
            throw new IllegalArgumentException("Null bill!");
        }
    }

    /**
     * Below removeBill method removed a bill when it is either already paid or needs to be removed.
     * 
     * @param rBill  the bill that is removed
     */
    public void removeBill(Bill rBill) {
        if (rBill != null && !rBill.isPaid()) {
            b.remove(b.indexOf(rBill));
        } else {
            throw new IllegalArgumentException("Null bill");
        }
    }

    @Override
    /**
     * Method below prints the bill
     */
    public String toString() {
        String output = "[ ";
        for (int i = 0; i < b.size(); i++){
            if(b.get(i) != null){
                output += b.get(i) + "\n";
            }
        }
        output += "]";
        return output;
    }
}