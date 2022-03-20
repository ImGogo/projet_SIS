package fc;

public enum Sexe {
    F("F"), // femme
    H("H"), // homme
    I("I"); // inconnu
    
    private final String val;
    
    Sexe(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
