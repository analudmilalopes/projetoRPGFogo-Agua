package principal;

import gerenciarBatalhas.GerenciadorDeBatalha;
import personagens.GuerreiroFogo;
import personagens.Inimigo;
import personagens.MagoAgua;

import java.util.Scanner;

public class TelaInicial {
    private Scanner scanner;

    public TelaInicial() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJogo() {
        telaInicial();


    int modoJogo = 0;

    while (modoJogo != 1 && modoJogo != 2) {
        System.out.println("ESCOLHA O MODO QUE DESEJA JOGAR:");
        System.out.println("[1] Individual (Escolha um herói para jogar sozinho)");
        System.out.println("[2] Multiplayer Local (Vocês controlam Fogo e Água juntos)");
        System.out.print("Modo: ");
        modoJogo = scanner.nextInt();

        if (modoJogo != 1 && modoJogo != 2) {
            System.out.println("❌ Opção inválida! Escolha entre 1 e 2.");
        }
    }

        GuerreiroFogo fogo = null;
        MagoAgua agua = null;

        if (modoJogo == 1) {
            int escolhaPersonagem = 0;

        while (escolhaPersonagem != 1 && escolhaPersonagem != 2) {
            System.out.println("\n🔥 OU 💧? ESCOLHA SEU ELEMENTO:");
            System.out.println("[1] Jogar com o Guerreiro de Fogo");
            System.out.println("[2] Jogar com a Maga de Água");
            escolhaPersonagem = scanner.nextInt();

            if (escolhaPersonagem == 1) {
                fogo = new GuerreiroFogo("Ignis (Fogo)");
            } else if (escolhaPersonagem == 2) {
                agua = new MagoAgua("Aqua (Água)");
            } else {
                System.out.println("❌ Personagem inválido! Por favor, digite 1 ou 2.");
            }
        }
        }else {
            fogo = new GuerreiroFogo("Ignis (Fogo)");
            agua = new MagoAgua("Aqua (Água");
            }

            Inimigo iron_golem = new Inimigo("Golem de Ferro", 120, 0);

            GerenciadorDeBatalha batalha = new GerenciadorDeBatalha(fogo, agua, iron_golem);

    }

    private void telaInicial() {
        System.out.println("==================================================");
        System.out.println("🔥💧 FOGO E ÁGUA 💧🔥");
        System.out.println("==================================================");
        System.out.println("Há séculos, o Cristal Primordial mantinha o equilíbrio do mundo.");
        System.out.println("Até que as Criaturas de Obsidiana o roubaram das profundezas do templo.");
        System.out.println("Agora, dois guerreiros opostos precisam unir suas forças.");
        System.out.println("Sozinhos, eles são fortes. Juntos, eles causam Tempestades de Vapor.");
        System.out.println("A invasão ao templo começa agora...\n");

        try{
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
