package Eleitor;

public class Eleitor {
    
    String nome;
    String dataNascimento;
    String tituloEleitor;
    String zona;
    String secao;

    public Eleitor(String name) {
        this.setNome(name);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getTituloEleitor() {
        return tituloEleitor;
    }
    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    public String getSecao() {
        return secao;
    }
    public void setSecao(String secao) {
        this.secao = secao;
    }
}
