import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Candidatos.Prefeito;
import Candidatos.Vereador;
import Candidatos.VicePrefeito;
import Eleitor.Eleitor;
import Urna.Urna;

public class App {

    Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        List<Prefeito> candidatosPrefeito = new ArrayList<>();
        List<Vereador> candidatosVereador = new ArrayList<>();

        Prefeito Kalil = new Prefeito("Kalil", "20/10/1980", "kalil@email.com", 55);
        Prefeito Lula = new Prefeito("Lula", "20/10/1970", "lula@email.com", 13);
        Prefeito Ciro = new Prefeito("Ciro Gomes", "20/10/1970", "ciro@email.com", 12);
        
        VicePrefeito Joao = new VicePrefeito("Joao", "12/03/2000", "joao@email.com");
        VicePrefeito Cleber = new VicePrefeito("Cleber", "12/03/1999", "cleber@email.com");
        VicePrefeito Maria = new VicePrefeito("Maria", "12/03/1998", "maria@email.com");
        
        Kalil.setVice(Joao);
        Lula.setVice(Cleber);
        Ciro.setVice(Maria);

        candidatosPrefeito.add(Kalil);
        candidatosPrefeito.add(Lula);
        candidatosPrefeito.add(Ciro);

        Vereador Daciolo = new Vereador("Daciolo", "24/02/1980", "daciolo@email.com", 20);
        Vereador Aecio = new Vereador("Aecio", "24/02/1981", "aecio@email.com", 21);
        Vereador Amoedo = new Vereador("Joao Amoedo", "24/02/1980", "amoedo@email.com", 25);

        candidatosVereador.add(Daciolo);
        candidatosVereador.add(Aecio);
        candidatosVereador.add(Amoedo);

        Urna.clearScreen();
        Urna.iniciarVotacao();
        List<Eleitor> Eleitores = Urna.votar(candidatosPrefeito, candidatosVereador);

        
        // for (Eleitor eleitor : Eleitores) {
        //     System.out.println(eleitor.getNome());
        // }
    }
}

