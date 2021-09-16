package Candidatos;

public class Prefeito extends Candidato{
    public Prefeito(String Cnome, String CdataNascimento, String Cemail, int Ccodigo) {
        super(Cnome, CdataNascimento, Cemail, Ccodigo);
    }

    VicePrefeito vice; 

    public VicePrefeito getVice() {
        return vice;
    }
    public void setVice(VicePrefeito vice) {
        this.vice = vice;
        vice.setCodigo(codigo);
    }
}
