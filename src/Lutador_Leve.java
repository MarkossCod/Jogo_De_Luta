public class Lutador_Leve extends Lutador {

    public Lutador_Leve(String nome, int energia, int forca) {
        super(nome, energia, forca); // define defendendo=false e vida=100
    }

    public void caracteristicas() {
        System.out.println("=== LUTADOR LEVE ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
        System.out.println("Força: " + this.forca);
        System.out.println("====================");
    }
}
