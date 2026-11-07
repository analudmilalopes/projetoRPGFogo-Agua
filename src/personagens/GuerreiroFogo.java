package personagens;

public class GuerreiroFogo extends Personagem {

 public GuerreiroFogo(String nome) {
  super(nome, 100, 150);
 }

 @Override
 public void ataqueBasico(Personagem alvo) {
  System.out.println("\n" + this.nome + " dá um soco flamejante em " + alvo.nome + "!");
  alvo.receberDano(8);
 }

 // habilidades específicas do fogo
 public void meteoro(Personagem alvo) {
  int custo = 40;
  if (this.usarMana(custo)) {
   System.out.println("\n🔥 " + this.nome + " conjura um METEORO FLAMEJANTE!");
   if (alvo.getStatus().equals("Molhado")) {
    System.out.println("💥 COMBO! EXPLOSÃO DE VAPOR! DANO CRÍTICO ABSURDO!");
    alvo.receberDano(70);
    alvo.setStatus("Normal");
   } else {
    alvo.receberDano(35);
   }
  }
 }

 public void transferirMana(Personagem aliado) {
  System.out.println("\n🔥 " + this.nome + " irradia calor e energia para " + aliado.nome + "!");
  aliado.manaAtual += 25;
  if (aliado.manaAtual > aliado.manaMax) aliado.manaAtual = aliado.manaMax;
  System.out.println("🔋 " + aliado.nome + " recuperou 25 de Mana! (Mana: " + aliado.manaAtual + "/" + aliado.manaMax + ")");
 }
}