package fc;

public enum CoteLit {
    Fenetre("F"),
    Porte("P");
    
    private final String val;
    
    CoteLit(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
