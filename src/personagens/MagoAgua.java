package personagens;

class MagoAgua extends Personagem {

    public MagoAgua(String nome) {
        super(nome, 80);
    }

    @Override
    public void atacar(Inimigo alvo) {
        System.out.println("\n" + this.nome +
                " lança um Jato de Água em " + alvo.nome + "!");
        alvo.receberDano(10);
        alvo.setStatus("Molhado");
    }
}
