import javax.swing.*;
import java.util.ArrayList;

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
        ArrayList<Jogador> jogadores = cadastrarJogadores();
        votar(jogadores);
        apurarEliminado(jogadores);
    }

    private static ArrayList<Jogador> cadastrarJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Beatriz Reis"));
        jogadores.add (new Jogador("Davi Brito"));
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add (new Jogador("Giovanna Lima"));
        jogadores.add(new Jogador("Giovanna Pitel"));
        jogadores.add(new Jogador("Isabelle Nogueira"));
        jogadores.add (new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add (new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Lucas Pizanel"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add (new Jogador("Matteus Amaral"));
        jogadores.add(new Jogador("Maycon Cosmer"));
        jogadores.add(new Jogador("MC Bin Laden"));
        jogadores.add (new Jogador("Michel Nogueira"));
        jogadores.add(new Jogador("Nizam"));
        jogadores.add(new Jogador("Raquele Cardozo"));
        jogadores.add (new Jogador("Rodriguinho"));
        jogadores.add(new Jogador("Thalyta Alves"));
        jogadores.add (new Jogador("Vanessa Lopes"));
        jogadores.add(new Jogador("Vinicius Rodrigues"));
        jogadores.add(new Jogador("Wanessa Camargo"));
        jogadores.add (new Jogador("Yasmin Brunet"));


        return jogadores;
    }

    private static void votar(ArrayList<Jogador> jogadores) {
        String votoEm = "";
        while (!votoEm.equalsIgnoreCase("sair")) {
            votoEm = JOptionPane.showInputDialog("Em quem você vota para sair da casa?");
            if (!votoEm.equalsIgnoreCase("sair")) {
                for (Jogador jogador : jogadores) {
                    if (jogador.getNome().equalsIgnoreCase(votoEm)) {
                        jogador.incrementaUmVoto();
                        JOptionPane.showMessageDialog(null, "Voto computado para " + jogador.getNome() + "!");
                        break;
                    }
                }
            }
        }
    }

    private static void apurarEliminado(ArrayList<Jogador> jogadores) {
        Jogador eliminado = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > eliminado.getVotos()) {
                eliminado = jogador;
            }
        }
        String mensagem = "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, \n" +
                "se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, \n" +
                "se eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou \n" +
                "conseguir te eliminar com alegria. Com " + eliminado.getVotos() + " votos, é você quem sai " +
                eliminado.getNome() + "!";
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
