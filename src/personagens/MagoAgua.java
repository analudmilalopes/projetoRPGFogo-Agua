package personagens;

public class MagoAgua extends Personagem {

    public MagoAgua(String nome) {
        super(nome, 80, 60);
    }

    @Override
    public void ataqueBasico(Personagem alvo) {
        System.out.println("\n" + this.nome + " bate com o cajado em " + alvo.nome + "!");
        alvo.receberDano(5);
    }

    // habilidades específicas da água
    public void jatoDeAgua(Personagem alvo) {
        if (this.usarMana(15)) {
            System.out.println("\n💧 " + this.nome + " lança um Jato de Água concentrado!");
            alvo.receberDano(10);
            alvo.setStatus("Molhado");
        }
    }

    public void ondaCurativa(Personagem aliado) {
        if (this.usarMana(20)) {
            System.out.println("\n✨ " + this.nome + " conjura ÁGUAS CURATIVAS em " + aliado.nome + "!");
            aliado.vidaAtual += 30;
            if (aliado.vidaAtual > aliado.vidaMax) aliado.vidaAtual = aliado.vidaMax;
            System.out.println("💚 " + aliado.nome + " recuperou vida! (Vida: " + aliado.vidaAtual + "/" + aliado.vidaMax + ")");
        }
    }
}