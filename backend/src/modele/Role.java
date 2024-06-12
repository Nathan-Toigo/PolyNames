package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Role extends TableBDD {
    private int id_role;
    private String role;

    public Role(){
        super("Role",new ArrayList<>(Arrays.asList("id_role")));
        this.id_role = 0;
        this.role = "";
    }

    public Role(int id_role,String role){
        super("Role",new ArrayList<>(Arrays.asList("id_role")));
        this.id_role = id_role;
        this.role = role;
    }

    public int getId_role() {
        return id_role;
    }

    public String getRole() {
        return role;
    }
}
