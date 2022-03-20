package fc;

public enum Sexe {
    Femme("F"),
    Homme("H"),
    Inconnu("I");
    
    private final String val;
    
    Sexe(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
