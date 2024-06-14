package dao;

import database.PolyNamesDatabase;
import java.sql.SQLException;


public abstract class generiqueDAO {

    protected PolyNamesDatabase pnDatabase;

    public generiqueDAO() {
        try {
            this.pnDatabase = new PolyNamesDatabase();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
