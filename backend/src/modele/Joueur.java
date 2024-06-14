package modele;

public class Joueur {
    private String jeton;
    private Boolean est_hote;
    private int role;
    private String code_partie;
    
    public Joueur() {
    }

    public Joueur(String jeton, Boolean est_hote, int role, String code_partie) {
        this.jeton = jeton;
        this.est_hote = est_hote;
        this.role = role;
        this.code_partie = code_partie;
    }

    public String getJeton() {
        return jeton;
    }

    public Boolean getEst_hote() {
        return est_hote;
    }

    public int getRole() {
        return role;
    }

    public String getCode_partie() {
        return code_partie;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

    public void setEst_hote(Boolean est_hote) {
        this.est_hote = est_hote;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setCode_partie(String code_partie) {
        this.code_partie = code_partie;
    }
    
}
