package database;

public class SQLiteDatabaseMain {

    public static void main(String[] args) {
        SQLiteDatabase app = new SQLiteDatabase();
        app.insertRecords("databaseuser", "ilovedatabases", 0, "databasedan@hotmail.com", "Database", "Dan", 0);
    }
}
