package UI.dbutil;

public class SQLQueryConstatnts {

    public static String CREATE_DETAILS_TABLE = "create table details (id VARCHAR(50) NOT NULL,\n" +
            "\t\tpage_title VARCHAR(50),\n"+
            "\t\tcomments VARCHAR(50))";

    public static String SELECT_QUERY_DETAILS_ID= "select id from public.details";
    public static String SELECT_QUERY_DETAILS_PAGE_TITLE = "select page_title from public.details";
    public static String SELECT_QUERY_DETAILS_COMMENTS= "select comments from public.details";
    public static String SELECT_QUERY_DETAILS_ALL="select * from public.details where id= 10";
    public static String INSERT_QUERY_DETAILS = "INSERT INTO \"PUBLIC\".\"DETAILS\"\n" +
            "(\"ID\", \"PAGE_TITLE\", \"COMMENTS\")\n" +
            "VALUES(?,?,?)";
    public static String UPDATE_QUERY_DETAILS = "UPDATE \"PUBLIC\".\"DETAILS\" SET page_title='Home' where id= 10";
    public static String DROP_QUERY_DETAILS = "DROP TABLE details" ;

    public static String CREATE_WEBPAGE_TABLE = "create TABLE webpage (id VARCHAR(50) NOT NULL,\n" +
            "\t\ttitle VARCHAR(50), \n" +
            "\t\tusername VARCHAR(50) NOT NULL,\n" +
            "\t\tpasswd VARCHAR(50),\n" +
            "\t\tcomment VARCHAR(50))";
    public static String SELECT_QRY_WEBPAGE_TABLE_CREATION = "select count(*) from information_schema.tables where table_name = 'WEBPAGE'";
    public static String SELECT_QRY_WEBPAGE_TITLE = "SELECT title FROM public.webpage";
    public static String SELECT_QRY_WEBPAGE_USERNAME = "SELECT username FROM public.webpage";
    public static String SELECT_QRY_WEBPAGE_ALL = "SELECT * FROM public.webpage where id = 10";
    public static String INSERT_QRY_WEBPAGE = "INSERT INTO \"PUBLIC\".\"WEBPAGE\"\n" +
            "( \"ID\", \"TITLE\", \"USERNAME\", \"PASSWD\", \"COMMENT\" )\n" +
            "VALUES (?,?,?,?,?)";
    public static String DELETE_QRY_WEBPAGE = "DELETE * FROM webpage";
    public static String DROP_QRY_WEBPAGE = "DROP TABLE webpage";
    public static String UPDATE_QRY_WEBPAGE = "UPDATE \"PUBLIC\".\"WEBPAGE\" SET title='Home' where id = 10";



}
