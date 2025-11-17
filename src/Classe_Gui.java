import javax.swing.*;

public class Classe_Gui extends JFrame {
    private Lutador jogador;
    private Lutador oponente;

    // Construtor deve ter o mesmo nome da classe
    public Classe_Gui() {
        // Inicialização de exemplo
        jogador = new Lutador_Leve("Ryu", 50, 15);
        oponente = new Lutador_Pesado("Zangief", 40, 25);

        setTitle("Torneio de Lutadores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Classe_Gui::new); // corrigido aqui
    }
}
