import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoLutadoresGUI extends JFrame {
    private Lutador jogador;
    private Lutador oponente;

    private JLabel lblVidaJogador, lblEnergiaJogador;
    private JLabel lblVidaOponente, lblEnergiaOponente;
    private JTextArea logArea;

    public JogoLutadoresGUI() {
        // Configuração da janela
        setTitle("Torneio de Lutadores 2D");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criando lutadores
        jogador = new Lutador_Leve("Ryu", 50, 15);
        oponente = new Lutador_Pesado("Zangief", 40, 25);

        // Painel superior com status
        JPanel statusPanel = new JPanel(new GridLayout(2, 2));
        lblVidaJogador = new JLabel("Vida Jogador: " + jogador.vida);
        lblEnergiaJogador = new JLabel("Energia Jogador: " + jogador.energia);
        lblVidaOponente = new JLabel("Vida Oponente: " + oponente.vida);
        lblEnergiaOponente = new JLabel("Energia Oponente: " + oponente.energia);
        statusPanel.add(lblVidaJogador);
        statusPanel.add(lblVidaOponente);
        statusPanel.add(lblEnergiaJogador);
        statusPanel.add(lblEnergiaOponente);

        add(statusPanel, BorderLayout.NORTH);

        // Área de log de ações
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(logArea);
        add(scroll, BorderLayout.CENTER);

        // Painel inferior com botões de ação
        JPanel buttonPanel = new JPanel();
        JButton btnAtacar = new JButton("Atacar");
        JButton btnEspecial = new JButton("Golpe Especial");
        JButton btnDefender = new JButton("Defender");

        buttonPanel.add(btnAtacar);
        buttonPanel.add(btnEspecial);
        buttonPanel.add(btnDefender);

        add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        btnAtacar.addActionListener(e -> jogarAcao("atacar"));
        btnEspecial.addActionListener(e -> jogarAcao("especial"));
        btnDefender.addActionListener(e -> jogarAcao("defender"));

        setVisible(true);
    }

    // Função para atualizar os status no GUI
    private void atualizarStatus() {
        lblVidaJogador.setText("Vida Jogador: " + Math.max(jogador.vida, 0));
        lblEnergiaJogador.setText("Energia Jogador: " + jogador.energia);
        lblVidaOponente.setText("Vida Oponente: " + Math.max(oponente.vida, 0));
        lblEnergiaOponente.setText("Energia Oponente: " + oponente.energia);
    }

    // Função para executar a ação do jogador e IA
    private void jogarAcao(String acao) {
        if (!jogador.estaVivo() || !oponente.estaVivo()) {
            JOptionPane.showMessageDialog(this, "O combate acabou!");
            return;
        }

        // Ação do jogador
        switch (acao) {
            case "atacar":
                jogador.atacar(oponente);
                logArea.append(jogador.nome + " atacou " + oponente.nome + "\n");
                break;
            case "especial":
                jogador.especial(oponente);
                logArea.append(jogador.nome + " usou Golpe Especial em " + oponente.nome + "\n");
                break;
            case "defender":
                jogador.defender();
                logArea.append(jogador.nome + " está se defendendo\n");
                break;
        }

        atualizarStatus();

        // Turno do oponente (IA simples)
        if (oponente.estaVivo()) {
            int acaoIA = (int) (Math.random() * 3);
            switch (acaoIA) {
                case 0:
                    oponente.atacar(jogador);
                    logArea.append(oponente.nome + " atacou " + jogador.nome + "\n");
                    break;
                case 1:
                    oponente.especial(jogador);
                    logArea.append(oponente.nome + " usou Golpe Especial em " + jogador.nome + "\n");
                    break;
                case 2:
                    oponente.defender();
                    logArea.append(oponente.nome + " está se defendendo\n");
                    break;
            }
        }

        atualizarStatus();

        // Verifica vitória
        if (!jogador.estaVivo()) {
            JOptionPane.showMessageDialog(this, "Você foi derrotado!");
        } else if (!oponente.estaVivo()) {
            JOptionPane.showMessageDialog(this, "Você venceu o combate!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JogoLutadoresGUI::new);
    }
}
