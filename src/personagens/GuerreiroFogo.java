package personagens;

class GuerreiroFogo extends Personagem {
 public GuerreiroFogo(String nome) {
  super(nome, 100);
 }

 @Override
 public void atacar(Inimigo alvo){
  System.out.println("\n" + this.nome + " desfere um Golpe Flamejante em " + alvo.nome + "!");

  if (alvo.getStatus().equals("Molhado")) {
   System.out.println("COMBO! EXPLOSÃO DE VAPOOOR!");
   alvo.receberDano(30);
   alvo.setStatus("Normal");
   } else {
        alvo.receberDano(15);
   }
  }
}
