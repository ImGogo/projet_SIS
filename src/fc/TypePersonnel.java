package fc;

public enum TypePersonnel {
    SecretaireMedical("secretaire"),
    Administratif("secretaire"),
    PraticienHospitalier("praticien");
    
    private final String val;
    
    TypePersonnel(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
