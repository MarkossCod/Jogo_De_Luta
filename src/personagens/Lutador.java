package personagens;

public abstract class Lutador {
    protected String nome;
    protected int vida;
    protected int energia;
    protected int forca;
    protected boolean defendendo;

    public Lutador(String nome, int energia, int forca) {
        this.nome = nome;
        this.vida = 100;  // todos os lutadores começam com 100 de vida
        this.energia = energia;
        this.forca = forca;
        this.defendendo = false;
    }
    public int getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    // MÉTODO 1: atacar
    public void atacar(Lutador oponente) {
        if (!this.estaVivo()) {
            System.out.println(this.nome + " não pode atacar. Está derrotado!");
            return;
        }

        int dano = this.forca;
        if (oponente.defendendo) {
            dano /= 2;
        }

        oponente.vida -= dano;
        System.out.println(this.nome + " atacou " + oponente.nome + " causando " + dano + " de dano!");
        oponente.defendendo = false;
    }

    // MÉTODO 2: golpe especial
    public void especial(Lutador oponente) {
        int custoEnergia = 20;

        if (this.energia < custoEnergia) {
            System.out.println(this.nome + " tentou usar golpe especial, mas não tem energia suficiente!");
            return;
        }

        int dano = this.forca * 2;
        if (oponente.defendendo) {
            dano /= 2;
        }

        this.energia -= custoEnergia;
        oponente.vida -= dano;
        System.out.println(this.nome + " usou GOLPE ESPECIAL em " + oponente.nome + " causando " + dano + " de dano!");
        oponente.defendendo = false;
    }

    // MÉTODO 3: defender
    public void defender() {
        this.defendendo = true;
        this.energia += 10;
        System.out.println(this.nome + " está se defendendo! (+10 energia)");
    }

    // MÉTODO 4: mostrarStatus
    public void mostrarStatus() {
        System.out.println("----- STATUS -----");
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Energia: " + this.energia);
        System.out.println("Força: " + this.forca);
        System.out.println("------------------");
    }

    // MÉTODO 5: estáVivo
    public boolean estaVivo() {
        return this.vida > 0;
    }

    // MÉTODO ABSTRATO: cada subclasse deve implementar suas características
    public abstract void caracteristicas();
}
