package Candidatos;

public class Candidato {
    
    String nome;
    String email;
    String dataNascimento;
    int codigo;
    int votosRecebidos = 0;

    public Candidato(String Cnome, String CdataNascimento, String Cemail, int Ccodigo){
        this.setNome(Cnome);
        this.setDataNascimento(CdataNascimento);
        this.setEmail(Cemail);
        this.setCodigo(Ccodigo);
    }
    
    public void receberVoto(){
        this.votosRecebidos++;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getVotosRecebidos() {
        return votosRecebidos;
    }
    
}
