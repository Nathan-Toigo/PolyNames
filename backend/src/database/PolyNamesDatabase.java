package database;

import java.sql.SQLException;

public class PolyNamesDatabase extends MySQLDatabase {

    public PolyNamesDatabase() throws SQLException{
        super("127.0.0.1", 3306, "polynames_db", "root", "");
    }
    
}
