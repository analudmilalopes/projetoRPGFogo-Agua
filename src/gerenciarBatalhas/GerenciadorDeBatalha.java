public class GerenciadorDeBatalha {
    // Agora o gerenciador conhece os tipos exatos!
    private GuerreiroFogo fogo;
    private MagoAgua agua;
    private Inimigo inimigo;
    private Scanner leitor;

    public GerenciadorDeBatalha(GuerreiroFogo fogo, MagoAgua agua, Inimigo inimigo) {
        this.fogo = fogo;
        this.agua = agua;
        this.inimigo = inimigo;
        this.leitor = new Scanner(System.in);
    }

    // ... (o while do Game Loop continua igual) ...

    // Menu exclusivo da Água
    private void turnoAgua() {
        System.out.println("\n▶ TURNO DA ÁGUA | Mana: " + agua.manaAtual);
        System.out.println("[1] Cajadada Básica");
        System.out.println("[2] Jato de Água (Molha o Inimigo)");
        System.out.println("[3] Curar o Guerreiro de Fogo");

        int escolha = leitor.nextInt();
        switch(escolha) {
            case 1: agua.ataqueBasico(inimigo); break;
            case 2: agua.jatoDeAgua(inimigo); break;
            case 3: agua.ondaCurativa(fogo); break; // Chama o método específico!
        }
    }

    // Menu exclusivo do Fogo
    private void turnoFogo() {
        System.out.println("\n▶ TURNO DO FOGO | Mana: " + fogo.manaAtual);
        System.out.println("[1] Soco Básico");
        System.out.println("[2] Meteoro (Dano Massivo)");
        System.out.println("[3] Transferir Mana para Água");

        int escolha = leitor.nextInt();
        switch(escolha) {
            case 1: fogo.ataqueBasico(inimigo); break;
            case 2: fogo.meteoro(inimigo); break; // Chama o método específico!
            case 3: fogo.transferirMana(agua); break;
        }
    }
}