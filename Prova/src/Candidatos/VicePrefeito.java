package Candidatos;

public class VicePrefeito extends Candidato{

    public VicePrefeito(String Cnome, String CdataNascimento, String Cemail) {
        super(Cnome, CdataNascimento, Cemail, 0);
    }

    Prefeito prefeito;

    public Prefeito getPrefeito() {
        return prefeito;
    }
    public void setPrefeito(Prefeito prefeito) {
        this.prefeito = prefeito;
    }  
}
