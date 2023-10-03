import java.util.Random;
public class Jogo {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();
    var personagem = new Personagem("John");
    
    
    while(true){
      int oQueFazer = gerador.nextInt(4); //[0..3[
      
      personagem.morrer();
      switch(oQueFazer){
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
        personagem.morrer();
        break;
      }
      personagem.exibirEstado();
      
      
      System.out.println("********************");
      Thread.sleep(1000);
    }
  }
}
