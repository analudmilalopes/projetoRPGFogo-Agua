package personagens;

public abstract class Personagem {
    // atributos de todos os personagens
    public String nome; // public para facilitar a leitura no Gerenciador de batalhas
    public int vidaMax, vidaAtual;
    public int manaMax, manaAtual;
    public String statusElemento;

    public Personagem(String nome, int vida, int mana) {
        this.nome = nome;
        this.vidaMax = vida;
        this.vidaAtual = vida;
        this.manaMax = mana;
        this.manaAtual = mana;
        this.statusElemento = "Normal";
    }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0) this.vidaAtual = 0;
        System.out.println("💥 " + this.nome + " recebeu " + dano + " de dano! (Vida: " + this.vidaAtual + "/" + this.vidaMax + ")");
    }

    public boolean estaVivo() {
        return this.vidaAtual > 0;
    }

    public String getStatus() { return statusElemento; }

    public void setStatus(String status) {
        this.statusElemento = status;
        System.out.println("-> " + this.nome + " agora está " + status.toUpperCase() + "!");
    }

    public boolean usarMana(int custo) {
        if (this.manaAtual >= custo) {
            this.manaAtual -= custo;
            return true;
        }
        System.out.println("❌ " + this.nome + " não tem Mana suficiente! (Custo: " + custo + " | Atual: " + this.manaAtual + ")");
        return false;
    }

    // ataque obrigatório para todos
    public abstract void ataqueBasico(Personagem alvo);
}