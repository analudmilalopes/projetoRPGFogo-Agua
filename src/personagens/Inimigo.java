package personagens;

class Inimigo extends Personagem {
    private String statusElemento; // podendo ser normal, molhado ou congelado

    public Inimigo(String nome, int vida) {
        super(nome, vida);
        this.statusElemento = "Normal";
    }

    public String getStatus() {
        return statusElemento;
    }

    public void setStatus(String status) {
        this.statusElemento = status;
        System.out.println("-> O " + this.nome + " agora está " + status.toUpperCase() + "!");
    }
}
