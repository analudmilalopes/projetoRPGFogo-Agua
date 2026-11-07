package personagens;

public class Inimigo extends Personagem {

    public Inimigo(String nome, int vida, int mana) {
        super(nome, vida, mana);
    }

    @Override
    public void ataqueBasico(Personagem alvo) {
        System.out.println("\n⚠️ " + this.nome + " avança furiosamente e ataca " + alvo.nome + "!");
        alvo.receberDano(12);
    }
}