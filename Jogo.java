import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();
    List<Personagem> personagens = new ArrayList<>();
    personagens.add(new Personagem("John", true));
    personagens.add(new Personagem("Steve", true));

    while (existeVivo(personagens)) {
      for (Personagem personagem : personagens) {
        if (personagem.vive()) {
          int oQueFazer = gerador.nextInt(4); // [0..3[

          switch (oQueFazer) {
            case 0:
              personagem.cacar();
              break;
            case 1:
              personagem.comer();
              break;
            case 2:
              personagem.dormir();
              break;
            case 3:
              int indiceAtacante = gerador.nextInt(2);
              int indiceAlvo = 1 - indiceAtacante; 
              Personagem atacante = personagens.get(indiceAtacante);
              Personagem alvo = personagens.get(indiceAlvo);
              
              
              atacante.atacar(alvo);
              break;
          }
          personagem.exibirEstado();

          personagem.morrer();

          System.out.println("--------------------");
          Thread.sleep(1000);
        }
      }
    }
  }

  private static boolean existeVivo(List<Personagem> personagens) {
    for (Personagem personagem : personagens) {
      if (personagem.vive()) {
        return true;
      }
    }
    System.out.println("Game Over");
    return false;
  }
}