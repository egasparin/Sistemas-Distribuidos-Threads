package BarbairoDorminhoco;

public class Cliente extends Thread{

    private String nameClient;
    private Barbearia gerencia;
    private boolean cortar = true;

    public Cliente(String name, Barbearia gerencia){
      this.nameClient = name;
      this.gerencia = gerencia;
    }

    public String getNameClient(){
      return this.nameClient;
    }

    public void enter() {
      System.out.println("Cliente: Entrou --- " + Thread.currentThread().getName() + " - " + this.getNameClient());
    }

    public void leave() {
      System.out.println("Cliente: Saiu --- " + Thread.currentThread().getName() + " - " + this.getNameClient());
      this.cortar = false;
    }

    public void cutHair() {
      System.out.println("Cliente: Começou a cortar --- " + Thread.currentThread().getName() + " - " + this.getNameClient());
    }

    @Override
    public void run() {
    	while(cortar) {
    		try {
				int sleepTime = 0;
				while (sleepTime < 1000) {
					sleepTime = ((int) (Math.random() * 5000));
				}

				Thread.sleep(sleepTime);
				gerencia.aguardaVez(this);
    		}catch (Exception e) {
				// TODO: handle exception
			}
    	}
    }

  

}
