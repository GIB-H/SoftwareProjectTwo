package database;

import org.junit.Test;
import java.sql.Connection;
import org.junit.Assert;

public class SQLiteDatabaseTest {

    @Test
    public void testDatabaseConnection() {
        Connection actual = SQLiteDatabase.connect();
        Assert.assertNotNull(actual);
    }

    @Test
    public void testInsertRecords() {

    }

    @Test
    public void testQueryRecords() {
    }

    @Test
    public void testUpdateRecord() {
    }

    @Test
    public void testDeleteRecord() {
    }

}