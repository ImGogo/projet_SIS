package fc;

public enum Sexe {
    F("Femme"), // femme
    H("Homme"), // homme
    I("Inconnu"); // inconnu
    
    private final String val;
    
    Sexe(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
