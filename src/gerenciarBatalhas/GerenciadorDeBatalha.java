package gerenciarBatalhas;

import personagens.GuerreiroFogo;
import personagens.MagoAgua;
import personagens.Inimigo;
import personagens.Personagem;
import java.util.Scanner;

public class GerenciadorDeBatalha {
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

    public void iniciarBatalha() {
        System.out.println("\n================================================");
        System.out.println("⚠️ UM " + inimigo.nome.toUpperCase() + " SURGE DAS SOMBRAS! ⚠️");
        System.out.println("================================================\n");

        while (inimigo.estaVivo() && (fogo.estaVivo() || agua.estaVivo())) {

            if (fogo.estaVivo() && inimigo.estaVivo()) turnoFogo();
            if (agua.estaVivo() && inimigo.estaVivo()) turnoAgua();
            if (inimigo.estaVivo()) turnoInimigo();

            System.out.println("\n--- FIM DA RODADA ---\n");
        }

        if (!inimigo.estaVivo()) {
            System.out.println("🏆 VITÓRIA! O " + inimigo.nome + " foi destruído!");
        } else {
            System.out.println("💀 GAME OVER... O Templo dos Elementos caiu.");
        }
    }

    private void turnoFogo() {
        System.out.println("\n▶ TURNO DO FOGO | " + fogo.nome + " | Vida: " + fogo.vidaAtual + " | Mana: " + fogo.manaAtual);
        System.out.println("[1] Soco Básico (0 MP)");
        System.out.println("[2] Meteoro Flamejante (40 MP - Dano Massivo)");
        System.out.println("[3] Transferir Mana para a Água");
        System.out.print("Escolha: ");

        int escolha = leitor.nextInt();
        switch(escolha) {
            case 1: fogo.ataqueBasico(inimigo); break;
            case 2: fogo.meteoro(inimigo); break;
            case 3: fogo.transferirMana(agua); break;
            default: System.out.println("❌ Comando inválido! O Fogo hesitou e perdeu o turno.");
        }
    }

    private void turnoAgua() {
        System.out.println("\n▶ TURNO DA ÁGUA | " + agua.nome + " | Vida: " + agua.vidaAtual + " | Mana: " + agua.manaAtual);
        System.out.println("[1] Cajadada Básica (0 MP)");
        System.out.println("[2] Jato de Água (15 MP - Molha o Inimigo)");
        System.out.println("[3] Onda Curativa (20 MP - Cura o Fogo)");
        System.out.print("Escolha: ");

        int escolha = leitor.nextInt();
        switch(escolha) {
            case 1: agua.ataqueBasico(inimigo); break;
            case 2: agua.jatoDeAgua(inimigo); break;
            case 3: agua.ondaCurativa(fogo); break;
            default: System.out.println("❌ Comando inválido! A Água tropeçou e perdeu o turno.");
        }
    }

    private void turnoInimigo() {
        System.out.println("\n⚠️ TURNO DO INIMIGO: " + inimigo.nome);
        Personagem alvo;
        // Inimigo foca em quem tem menos vida
        if (fogo.estaVivo() && agua.estaVivo()) {
            alvo = (fogo.vidaAtual <= agua.vidaAtual) ? fogo : agua;
        } else {
            alvo = fogo.estaVivo() ? fogo : agua;
        }
        inimigo.ataqueBasico(alvo);
    }
}