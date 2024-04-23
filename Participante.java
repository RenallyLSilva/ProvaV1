import java.util.ArrayList;
import java.util.Scanner;


class Jogador {
    private String nome;
    private int votos;

    public Jogador(String nome) {
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementaUmVoto() {
        this.votos++;
    }
}

class CasaMaisVigiada {

    public static void main(String[] args) {
        ArrayList<Jogador> jogadores = inicializarJogadores();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à Casa Mais Vigiada do Brasil!");
        System.out.println("Vote em quem você deseja eliminar da casa (digite 'sair' para encerrar):");

        while (true) {
            String voto = scanner.nextLine();
            if (voto.equalsIgnoreCase("sair")) {
                break;
            } else {
                registrarVoto(jogadores, voto);
            }
        }

        scanner.close();

        Jogador eliminado = encontrarEliminado(jogadores);
        if (eliminado != null) {
            System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir "
                    + "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu conseguir "
                    + "dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou conseguir te "
                    + "eliminar com alegria. Com " + eliminado.getVotos() + " votos, é você quem sai " + eliminado.getNome());
        } else {
            System.out.println("Não houve eliminação nesta votação.");
        }
    }

    private static ArrayList<Jogador> inicializarJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        String[] nomes = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Deniziane Ferreira", "Fernanda Bande",
                "Giovanna Lima", "Giovanna Pitel", "Isabelle Nogueira", "Juninho", "Leidy Elin",
                "Lucas Henrique", "Lucas Luigi", "Lucas Pizane", "Marcus Vinicius", "Matteus Amaral",
                "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam", "Raquele Cardozo",
                "Rodriguinho", "Thalyta Alves", "Vanessa Lopes", "Vinicius Rodrigues", "Wanessa Camargo",
                "Yasmin Brunet"};
        for (String nome : nomes) {
            jogadores.add(new Jogador(nome));
        }
        return jogadores;
    }

    private static void registrarVoto(ArrayList<Jogador> jogadores, String voto) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(voto)) {
                jogador.incrementaUmVoto();
                System.out.println("Voto registrado para " + jogador.getNome());
                return;
            }
        }
        System.out.println("O jogador '" + voto + "' não foi encontrado.");
    }

    private static Jogador encontrarEliminado(ArrayList<Jogador> jogadores) {
        Jogador eliminado = null;
        int maxVotos = 0;
        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > maxVotos) {
                maxVotos = jogador.getVotos();
                eliminado = jogador;
            }
        }
        return eliminado;
    }
}
