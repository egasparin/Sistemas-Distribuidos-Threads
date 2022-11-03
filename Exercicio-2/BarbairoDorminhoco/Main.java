package BarbairoDorminhoco;

import java.util.ArrayList;

public class Main {
		public static void main(String[] args) {
			int qntCli = 5;
			Barbearia barbershop = new Barbearia();
		    
		    Barbeiro barber = new Barbeiro("[barber 1]", barbershop);
//		    
		    ArrayList<Cliente> lista = new ArrayList<>();
		    
		    for (int i = 0; i < qntCli; i++) {
		    	Cliente cli = new Cliente("[Cliente "+ i + "]", barbershop);
		    	lista.add(cli);
		    }
		    
		    barber.start();
		    for (int i = 0; i < qntCli; i++) {
		    	lista.get(i).start();
		    }
		    
//		    System.out.println("------- Fim do main -------");
		    
		}
}

