package personagens;

public class Lutador_Medio extends Lutador {

    public Lutador_Medio(String nome, int energia, int forca) {
        super(nome, energia, forca);
    }

    @Override
    public void caracteristicas() {
        System.out.println("=== LUTADOR MÉDIO ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
        System.out.println("Força: " + this.forca);
        System.out.println("Golpes: dano normal, equilibrado entre ataque e defesa");
        System.out.println("====================");
    }
}
