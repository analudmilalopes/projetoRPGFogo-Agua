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

        // método que a classe filho vai implementar do seu jeito
        public abstract void atacar(Inimigo alvo);
    }

    // 2 - classe Inimigo (Com controle de Status para os combos)
    class Inimigo extends Personagem {
        private String statusElemento; // "Normal", "Molhado", "Congelado"

        public Inimigo(String nome, int vida) {
            super(nome, vida);
            this.statusElemento = "Normal";
        }

        public String getStatus() { return statusElemento; }

        public void setStatus(String status) {
            this.statusElemento = status;
            System.out.println("-> O " + this.nome + " agora está " + status.toUpperCase() + "!");
        }
    }

    // 3. Classe do Herói de Água (Foco em Controle)
    class MagoAgua extends Personagem {
        public MagoAgua(String nome) {
            super(nome, 80); // Menos vida, mais utilidade
        }

        @Override
        public void atacar(Inimigo alvo) {
            System.out.println("\n" + this.nome + " lança um Jato de Água em " + alvo.nome + "!");
            alvo.receberDano(10);
            alvo.setStatus("Molhado");
        }
    }

    // 4. Classe do Herói de Fogo (Foco em Dano Massivo)
    class GuerreiroFogo extends Personagem {
        public GuerreiroFogo(String nome) {
            super(nome, 100);
        }

        @Override
        public void atacar(Inimigo alvo) {
            System.out.println("\n" + this.nome + " desfere um Golpe Flamejante em " + alvo.nome + "!");

            // A MÁGICA DA SINERGIA ACONTECE AQUI
            if (alvo.getStatus().equals("Molhado")) {
                System.out.println("COMBO! EXPLOSÃO DE VAPOR!");
                alvo.receberDano(30); // Dano massivo por causa do combo
                alvo.setStatus("Normal"); // O fogo secou a água
            } else {
                alvo.receberDano(15); // Dano normal
            }
        }
    }

    // 5. Motor do Jogo (Testando a Lógica)
    public class Main {
        public static void main(String[] args) {
            System.out.println("--- INÍCIO DA BATALHA ---");

            GuerreiroFogo fogo = new GuerreiroFogo("Ignis");
            MagoAgua agua = new MagoAgua("Aqua");
            Inimigo golem = new Inimigo("Golem de Pedra", 100);

            // parte 1: Fogo ataca sozinho (sem combo)
            fogo.atacar(golem);

            // parte 2: Água prepara o terreno
            agua.atacar(golem);

            // parte 3: Fogo ataca inimigo molhado (COMBO!)
            fogo.atacar(golem);

            System.out.println("\n--- FIM DO TURNO ---");
        }
    }
}
