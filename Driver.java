/**
 * This is the final driver class
 * 
 * @author Deepali Juneja
 * @version 26 May 2020
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("My test for Money: \n"); testMoney();
        System.out.println("\nMy test for Date: \n"); testDate();
        System.out.println("\nMy test for Bill: \n"); testBill();
        System.out.println("\n My test for ArrayList: \n"); testArrayList();
        System.out.println("\n My test for accounts: \n"); testExpenseAccounts();
    }

    /**
    * Below is a test for date.
    */
   private static void testDate() {
       Date day1 = new Date();
       Date day2 = new Date(04, 28, 2020);
       Date day3 = day2.clone();

       System.out.println("Wishing everyone a happy and prosperous new year: " + day1);
       System.out.println(day2);
       System.out.println("Today's date is" + day3);

       System.out.println("D2== D3: " + day2.equals(day3));

       day3.setDay(day3.getDay()+ 1);
       System.out.println("Tomorrow's date is: " + day3);
    }


    /**
     * Below is the test for money
     */
    private static void testMoney() {
        Money mon1 = new Money();
        Money mon2 = new Money(30);
        Money mon3 = new Money(5, 88);
        Money mon4 = mon1.clone();

        System.out.println("Amount 1 is: " + mon1);
        System.out.println("Amount 2 is: " + mon2);
        System.out.println("Amount 3 is: " + mon3);
        System.out.println("Amount 4 is: " + mon4);
        mon1.add(5, 34);
        System.out.println("The new amount 1: " + mon1);
        mon3.add(5);
        System.out.println("The new amount 3: " + mon3);
        System.out.println("Amount 1 equals amount 3: " + mon1.equals(mon3));
        mon2.add(10, 100);
        System.out.println("The new amount 2: " + mon2);
        mon4.add(mon2);
        System.out.println("The new amount 4" + mon4);
    }

    /**
     * Below is the test for bill
     */
    private static void testBill() {
        Date dueDate = new Date(04, 04, 2020);
        Date paidDate = new Date(04, 03, 2020);
        Money amount = new Money(30, 10);
        Bill bl = new Bill(amount, dueDate, "iTunes bill");
        System.out.println(bl);
        bl.setPaid(paidDate);
        bl.setAmount(new Money());
        System.out.println(bl);
        bl.setDueDate(new Date(05, 01, 2020));
        bl.setAmount(amount);
        System.out.println(bl);
        if (bl.isPaid()) {
            System.out.println("Bill paid, thanks!");
        } else {
            System.out.println("Your bill is due" + bl.getAmount() + " and this amount!");
        }
        bl.setPaid(new Date(03, 01, 2020));
        bl.setAmount(new Money());
        System.out.println(bl);
    }

    private static void testArrayList() {
        Integer[] array1 = { 1, 3, 4, 7, 8, 6, 1, 3, 2, 1 };
        Integer[] array2 = { 14, 41, 15, 51, 16, 61 };
        Integer[] array1Copy = { 1, 3, 5, 5, 3, 1, 4, 8, 7, 5 };

        ArrayList<Integer> arrayList1 = new ArrayList<>(array1);
        ArrayList<Integer> arrayList2 = new ArrayList<>(array2);
        ArrayList<Integer> arrayList3 = new ArrayList<>(array1Copy);

        System.out.println(arrayList2);
        System.out.println("4th index " + arrayList2.get(4));
        System.out.println("51 is on index: " + arrayList2.indexOf(40));
        System.out.println("Array list 2 size: " + arrayList2.size());

        System.out.println();

        boolean isEmpty = arrayList2.isEmpty();
        if (!isEmpty) {
            System.out.println(arrayList2 + " isn't empty!");
        }

        System.out.println();

        System.out.println();

        arrayList1.insert(0, 0);
        arrayList1.insert(620, 2);
        boolean equals = arrayList1.equals(arrayList3);
        if (equals) {
            System.out.println(arrayList1 + " = " + arrayList3);
        } else {
            System.out.println(arrayList1 + " = " + arrayList3);
        }

        System.out.println();

        System.out.println("2ND Array list " + arrayList2);
        System.out.println(arrayList2.remove(arrayList2.size() - 1) + " finally removed");
        System.out.println("2ND Array list" + arrayList2);
    }

    private static void testExpenseAccounts() {
        ExpenseAccount expAcc = new ExpenseAccount();
        Date dueDate = new Date(04, 04, 2020);
        Date paidDate = new Date(04, 03, 2020);
        Money amount = new Money(30, 10);
        Bill bl = new Bill(amount, dueDate, "iTunes");
        amount.setMoney(1800, 00);
        Bill bl_1 = new Bill(amount, dueDate, "RENT");
        expAcc.addBill(bl);
        expAcc.addBill(bl_1);
        bl_1.setPaid(paidDate);
        System.out.println(expAcc);
    }

}