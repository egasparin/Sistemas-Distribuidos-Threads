
public class Main {

  public static void main(String[] args) {

    Gerenciador gerenciador = new Gerenciador();

    Cliente c1 = new Cliente("Mateus", gerenciador);
    Cliente c2 = new Cliente("Guilherme", gerenciador);
    Cliente c3 = new Cliente("Eduardo", gerenciador);
    Cliente c4 = new Cliente("Thiago", gerenciador);

    Garcon g1 = new Garcon(gerenciador);
    Garcon g2 = new Garcon(gerenciador);

    c1.start();
    c2.start();
    c3.start();
    c4.start();
    g1.start();
    g2.start();

    try {
      c1.join();
      c2.join();
      c3.join();
      c4.join();
      g1.join();
      g2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(gerenciador);
  }
}
