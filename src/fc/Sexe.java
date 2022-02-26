package fc;

public enum Sexe {
    Femme("F"),
    Homme("H");
    
    private final String val;
    
    Sexe(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
