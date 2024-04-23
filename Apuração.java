import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class Apuração {
    public static void main(String[] args) {
        HashMap<String, Integer> votos = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            String votoEm = JOptionPane.showInputDialog("Em quem você vota para sair da casa?");
            votos.put(votoEm, votos.getOrDefault(votoEm, 0) + 1);
        }

        StringBuilder votosText = new StringBuilder("Votos recebidos:\n");
        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
            votosText.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(null, votosText.toString(), "Votos Recebidos", JOptionPane.INFORMATION_MESSAGE);

        String pessoaEliminada = "";
        int maxVotos = 0;
        boolean empate = false;
        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
            int votosParaJogador = entry.getValue();
            if (votosParaJogador > maxVotos) {
                maxVotos = votosParaJogador;
                pessoaEliminada = entry.getKey();
                empate = false;
            } else if (votosParaJogador == maxVotos) {
                empate = true;
            }
        }


    }
}