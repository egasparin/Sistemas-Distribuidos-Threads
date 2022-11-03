package BarbairoDorminhoco;

public class Barbeiro extends Thread{

    private String nameBarber;
    private Barbearia gerencia;
    private boolean cortar = true;

    public Barbeiro(String name, Barbearia gerencia){
      this.nameBarber = name;
      this.gerencia = gerencia;
    }

    public String getNameBarber(){
      return this.nameBarber;
    }

    public void cutHair(String Cliente){
      System.out.println("Cortando o Cabelo --- " + Thread.currentThread().getName() + " - " + this.getNameBarber() + " --- " + Cliente); 
    }
    
    public void leave() {
        System.out.println("O Barbeiro: Fechou --- " + Thread.currentThread().getName() + " - " + this.getNameBarber());
        this.cortar = false;
      }
    
    public void aMimir(){
        System.out.println("Está dormindo --- " + Thread.currentThread().getName() + " - " + this.getNameBarber()); 
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
    			gerencia.cortarCabelo(this);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    }

}
