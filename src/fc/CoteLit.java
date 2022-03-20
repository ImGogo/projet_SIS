package fc;

public enum CoteLit {
    F("Fenetre"),
    P("Porte");
    
    private final String val;
    
    CoteLit(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
