package personagens;

abstract class Personagem {
    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vidaMax = vida;
        this.vidaAtual = vida;
    }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0) this.vidaAtual = 0;
        System.out.println(this.nome + " recebeu " + dano + " de dano! (Vida: " + this.vidaAtual + "/" + this.vidaMax + ")");
    }

    public boolean estaVivo() {
        return this.vidaAtual > 0;
    }
}

