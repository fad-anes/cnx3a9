import utils.Datasource;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Datasource ds1= new Datasource().getInstance();
        System.out.println(ds1);

    }
}