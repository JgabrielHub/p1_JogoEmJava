public class Personagem {

  // atributos ou propriedades
  private String nome;
  private int energia = 5;
  private int fome = 0;
  private int sono = 0;
  private int item = 4;
  private boolean vivo = true;
  // construtor: lista de parâmetros vazia
  // Personagem(){

  // }

  Personagem(String nome, boolean vivo) {
    this.nome = nome;
    this.vivo = vivo;
  }

  Personagem(String nome, int energia, int fome, int sono, int item, boolean vivo) {
    this.nome = nome;
    this.vivo = vivo;
    if (energia >= 0 && energia <= 10)
      this.energia = energia;
    if (fome >= 0 && fome <= 10)
      this.fome = fome;
    if (sono >= 0 && sono <= 10)
      this.sono = sono;
    if (item >= 0 && item <= 10)
      this.item = item;

  }

  // comportamentos (métodos)
  void cacar() {
    if (energia >= 2) {
      System.out.println(nome + " caçando...");
      energia -= 2; // energia = energia - 2;
      item = Math.min(10, item + 1);
    } else {
      System.out.println(nome + " sem energia para caçar...");
    }
    fome = Math.min(fome + 1, 10);
    sono = Math.min(sono + 1, 10);
  }

  void comer() {
    if (fome >= 1 && item >= 1) {
      System.out.println(nome + " comendo...");
      // operador ternário
      energia = energia + 1 > 10 ? 10 : energia + 1;
      fome--;
      item--;
    } else if (item >= 1) {
      System.out.println(nome + " sem fome...");
    } else {
      System.out.println(nome + " sem alimento...");
    }
  }

  void dormir() {
    if (sono > 0) {
      System.out.println(nome + " dormindo...");
      sono -= 1;
      energia = Math.min(10, energia + 1);
    } else {
      System.out.println(nome + " sem sono");
    }

  }

  void exibirEstado() {
    System.out.printf(
        "%s: e: %d, f: %d, s: %d, i: %d\n",
        nome,
        energia,
        fome,
        sono,
        item);
  }

  void morrer() {
    if (energia <= 0) {
      vivo = false;
      System.out.println(nome + " morreu");
    }
  }

  public boolean vive() {
    return vivo;
  }
}
