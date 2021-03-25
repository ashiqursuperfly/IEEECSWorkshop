package strings;

class MyVeryImportantDatabase {

    private static MyVeryImportantDatabase instance = new MyVeryImportantDatabase();

    public static MyVeryImportantDatabase getInstance() {
        return instance;
    }

    private MyVeryImportantDatabase() { /* why is this constructor private */
    }

    void executeSQL(String sql) {
        // assume very important sql is being executed to my very important database
    }

    public boolean securityCheck(String userName, String balance) {
        // some logic
        return true;
    }
}

public class StringImmutability {

    static void updateUserBalance(String userName, String balance) {

        MyVeryImportantDatabase db = MyVeryImportantDatabase.getInstance();

        if (db.securityCheck(userName, balance)) {
            db.executeSQL("UPDATE Customers SET balance ="+ balance + " WHERE UserName = '" + userName + "'"); // sql-injection vulnerability avoided due to String Immutability
        }

    }
}

class Main {
    public static void main(String[] args) {
        String userName = "ashiq";
        StringImmutability.updateUserBalance(userName, "3213123");
    }
}
