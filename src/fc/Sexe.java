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
    
    public static Sexe getSexe(String s){
        switch(s){
            case "Femme": return Sexe.F;
            case "Homme": return Sexe.H;
            default: return Sexe.I;
        }
    }
    
    public static String[] getVals(){
        String[] t = new String[ Sexe.values().length ];
        for(int i = 0; i < Sexe.values().length; i++){
            t[i] = Sexe.values()[i].getVal();
        }
        return t;
    }
}
