package UI.testcases;


import UI.dbutil.DbOps;
import UI.dbutil.SQLQueryConstatnts;
import UI.factory.DataBaseFactory;
import org.bson.io.BsonOutput;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest{
    Connection con;

    public DBTest() throws SQLException {
    }

    @BeforeMethod
    public void init() throws ClassNotFoundException {
        con = DataBaseFactory.getDB("hsqldb");
    }

   @Test
    public void createTable () throws SQLException {
        DbOps.executeStmnt(con, SQLQueryConstatnts.CREATE_DETAILS_TABLE);
    }

    @Test
    public void selectTitle() throws SQLException {
        String username = DbOps.executeStmntsSelect(con, SQLQueryConstatnts.SELECT_QUERY_DETAILS_PAGE_TITLE).getString(1);
        System.out.println("Expected home page Title is " + username);
    }

    @Test
    public void insertData() throws SQLException {
        DbOps.executeInsertStatement(con, SQLQueryConstatnts.INSERT_QUERY_DETAILS, "10");
    }

    @Test
    public void selectQuery() throws SQLException {
        ResultSet result = DbOps.executeStmntsSelect(con, SQLQueryConstatnts.SELECT_QUERY_DETAILS_PAGE_TITLE);
        System.out.println(result.getString(1));
        result.close();
    }

    @Test
    public void selectAll() throws SQLException {
        ResultSet result = DbOps.executeStmntsSelect(con, SQLQueryConstatnts.SELECT_QUERY_DETAILS_ALL);
        System.out.println(result.getString(1));
        System.out.println(result.getString(2));
        System.out.println(result.getString(3));
        result.close();
    }

    @Test
    public void updateData() throws SQLException {
        DbOps.executeStmnt(con, SQLQueryConstatnts.UPDATE_QUERY_DETAILS);
    }

   /* @Test
    public void dropTable() throws SQLException {
        DbOps.executeStmnt(con, SQLQueryConstatnts.DROP_QUERY_DETAILS);
    }*/


    @AfterTest
    public void end() throws SQLException {
        con.commit();
        con.close();
    }
}

