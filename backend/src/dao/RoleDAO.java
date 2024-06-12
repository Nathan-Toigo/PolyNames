package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Role;

public class RoleDAO extends generiqueDAO<Role> {

    public RoleDAO(){
        super();
    }

    @Override
    protected Role genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_role = results.getInt("id_role");
        final String role = results.getString("role");
        
        return new Role(id_role,role);
    }
}
