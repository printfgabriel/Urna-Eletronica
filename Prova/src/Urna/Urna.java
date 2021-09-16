package Urna;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Candidatos.Prefeito;
import Candidatos.Vereador;
import Eleitor.Eleitor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public final class Urna {

    private Urna(){}
    static String zona;
    static String secao;
    static String tituloPres; 
    static String nomePres;
    static String horaAbertura; 
    static int numEleitores;
    static int votosBrancoP = 0;
    static int votosBrancoV = 0;
    static int votosNuloP = 0;
    static int votosNuloV = 0;

    static Scanner leitor = new Scanner(System.in);

    public static void iniciarVotacao(){
        System.out.print("\n\n**Hora de iniciar a votacao, presidente!**\nInforme a zona: ");
        zona = leitor.nextLine();
        System.out.print("Informe a secao: ");
        secao = leitor.nextLine();
        System.out.print("Titulo do presidente da secao: ");
        tituloPres = leitor.nextLine();
        System.out.print("Informe o nome do presidente da secao: ");
        nomePres = leitor.nextLine();
        System.out.print("Hora de abertura: ");
        horaAbertura = leitor.nextLine();
        System.out.print("Numero de eleitores: ");
        numEleitores = leitor.nextInt();
        leitor.nextLine();
    }

    public static List<Eleitor> votar(List<Prefeito> candidatosP, List<Vereador> candidatosV){
        int votes = 0;
        List<Eleitor> eleitores = new ArrayList<>();

        while (votes < numEleitores) {
            
            System.out.print("Caro eleitor,\nDigite seu nome: ");
            Eleitor temp = new Eleitor(leitor.nextLine());
            System.out.print("Data de nascimento: ");
            temp.setDataNascimento(leitor.nextLine());
            System.out.print("Titulo de eleitor: ");
            temp.setTituloEleitor(leitor.nextLine());

            temp.setZona(zona);
            temp.setSecao(secao);
            
            eleitores.add(temp);
            
            votacaoPrefeito(candidatosP);
            clearScreen();
            votacaoVereador(candidatosV);
            leitor.nextLine();
            clearScreen();
            votes++;
        }
        finalizarEleicao(candidatosP, candidatosV);
        return eleitores;
    }

    public static void finalizarEleicao(List<Prefeito> candidatosP, List<Vereador> candidatosV){

        int maiorQtdVotosP = 0;
        int maiorQtdVotosV = 0;
        int indexVerEleito = 0;
        int indexPreEleito = 0;
        boolean segundoTurnoP = false;
        boolean segundoTurnoV = false;
        

        for (Vereador vereador : candidatosV) {
            if (vereador.getVotosRecebidos() > maiorQtdVotosV) {
                maiorQtdVotosV = vereador.getVotosRecebidos();
                indexVerEleito = candidatosV.indexOf(vereador);
                segundoTurnoV = false;
            }
            else if(vereador.getVotosRecebidos() == maiorQtdVotosV)
                segundoTurnoV = true;
        }
        for (Prefeito prefeito : candidatosP) {
            if (prefeito.getVotosRecebidos() > maiorQtdVotosP) {
                maiorQtdVotosP = prefeito.getVotosRecebidos();
                indexPreEleito = candidatosP.indexOf(prefeito);
                segundoTurnoP = false;
            }
            else if(prefeito.getVotosRecebidos() == maiorQtdVotosP)
                segundoTurnoP = true;
        }
        Vereador vereadorEleito = candidatosV.get(indexVerEleito);
        Prefeito prefeitoEleito = candidatosP.get(indexPreEleito);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaTermino = formato.format(LocalDateTime.now());

        clearScreen();
        System.out.println("Hora de inicio da eleicao: " + horaAbertura + "\nHora termino da eleicao: " + horaTermino + "\n");
        System.out.println("----Eleicao prefeitos----");
        for (Prefeito prefeito : candidatosP) {
            System.out.println(prefeito.getNome() + ": " + prefeito.getVotosRecebidos() + " votos");
        }
        System.out.println("\nVotos nulo: " + votosNuloP);
        System.out.println("\nVotos em branco: " + votosBrancoP);

        System.out.println("\n----Eleicao vereadores----");
        for (Vereador vereador : candidatosV) {
            System.out.println(vereador.getNome() + ": " + vereador.getVotosRecebidos() + " votos");
            System.out.println("\nVotos em branco: " + votosBrancoV);
            System.out.println("\nVotos nulo: " + votosNuloV);
        }
    
        if(!segundoTurnoP)
            System.out.println("\nO prefeito eleito foi: " + prefeitoEleito.getNome() + " (Vice: " + prefeitoEleito.getVice().getNome() + "), com " +prefeitoEleito.getVotosRecebidos() + " votos");
        else   
            System.out.println("Houve empate, portanto deverá ocorrer um segundo turno para a eleicao de prefeito!");
        
        if(!segundoTurnoV)
            System.out.println("O vereador eleito foi: " + vereadorEleito.getNome() + " (" + vereadorEleito.getCodigo() + "), com " +vereadorEleito.getVotosRecebidos() + " votos");
        else   
            System.out.println("Houve empate, portanto deverá ocorrer um segundo turno para a eleicao de vereador!"); 
        
    }


    public static void votacaoPrefeito(List<Prefeito> candidatos){
        System.out.print("\n**Candidatos a prefeito**\n");
        for (Prefeito prefeito : candidatos) {
            System.out.println(prefeito.getNome() + ": " +prefeito.getCodigo() + " (Vice: " + prefeito.getVice().getNome() + ")");
        }
        System.out.print("Para anular o voto, digite \"99\"\nCodigo do partido do voto: ");
        int voto = leitor.nextInt();
        if(voto == 99){
            System.out.println("Deseja confirmar seu voto em branco?\n 1.Sim            2.Nao");
            if (leitor.nextInt() == 2) {
                votacaoPrefeito(candidatos);
                return;
            }   
            votosBrancoP++;
            return;
        }
        else{
            for (Prefeito prefeito : candidatos) {
                if (voto == prefeito.getCodigo()) {
                    System.out.println("Deseja confirmar seu voto em " + prefeito.getNome() + "?\n 1.Sim            2.Nao");
                    if (leitor.nextInt() == 2){
                        votacaoPrefeito(candidatos);
                        return;
                    }
                    prefeito.receberVoto();
                    return;
                }                
            }
        }
        System.out.println("Deseja anular seu voto?\n 1.Sim            2.Nao");
        if (leitor.nextInt() == 2) {
            votacaoPrefeito(candidatos);
            return;
        }
        votosNuloP++;
    }
    public static void votacaoVereador(List<Vereador> candidatos){
        System.out.print("\n**Candidatos a vereador**\n");
        for (Vereador vereador : candidatos) {
            System.out.println(vereador.getNome() + ": " +vereador.getCodigo());
        }
        System.out.print("Para anular o voto, digite \"9999\"\nCodigo do partido do voto: ");
        int voto = leitor.nextInt();

        if(voto == 9999){
            System.out.println("Deseja confirmar seu voto em branco?\n 1.Sim            2.Nao");
            if (leitor.nextInt() == 2) {
                votacaoVereador(candidatos);
                return;
            }
            votosBrancoV++;
            return;
        }
        else{
            for (Vereador vereador : candidatos) {
                if (voto == vereador.getCodigo()) {
                    System.out.println("Deseja confirmar seu voto em " + vereador.getNome() + "?\n1.Sim            2.Nao");
                    if (leitor.nextInt() == 2) {
                        votacaoVereador(candidatos);
                        return;
                    }
                    vereador.receberVoto();
                    return;
                }                
            }
        } 
        System.out.println("Deseja confirmar seu voto nulo?\n 1.Sim            2.Nao");
        if (leitor.nextInt() == 2) {
            votacaoVereador(candidatos);
            return;
        }
        votosNuloV++;
    }

    public static void clearScreen() {
        //LIMPAR TELA - FUNCIONA NO VSCODE MAS APARENTEMENTE NO ECLIPSE NAO --- EU USO VSCODE
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
