package personagens;

public class Lutador_Pesado extends Lutador {

    public Lutador_Pesado(String nome, int energia, int forca) {
        super(nome, energia, forca);
    }

    @Override
    public void caracteristicas() {
        System.out.println("=== LUTADOR PESADO ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
        System.out.println("Força: " + this.forca);
        System.out.println("======================");
    }
}
