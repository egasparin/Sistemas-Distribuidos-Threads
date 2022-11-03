package BarbairoDorminhoco;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Barbearia{

    public static int MAX_ATENDIMENTO = 1;
    public static int MAX_CHAIRS = 2;
    
    private int qtdeCadeiras;

    private boolean dormindo = true;
    
    public Queue<Cliente> fila = new LinkedList<>();
    private int qtdeClienteAtendidos = 0;
    public ArrayList<Cliente> listaAtendidos = new ArrayList<>();
    boolean cortando = false;

    public Barbearia() {
    	qtdeCadeiras = MAX_ATENDIMENTO + MAX_CHAIRS;
    }
    
    
    public synchronized Queue<Cliente> getFila() {
		return fila;
	}
    
    public synchronized Cliente primeiroFila() {
    	return this.fila.remove();
    }

	public synchronized void addtFila(Cliente client) {
		this.fila.add(client);
	}
	
	public synchronized int tamanhoFila() {
		return this.fila.size();	
	}
	
	public synchronized void cortarCabelo(Barbeiro barber) {
		try {
			while (this.tamanhoFila() == 0) {
				System.out.println("Não tem nenhum cliente esperando, o barbeiro resolveu dormir");
				wait();
				System.out.println("Barbeiro continua seu trabalho..........");
			}
			
			if (this.tamanhoFila() > 0) {
					Cliente atendimento = primeiroFila();
					cortando = true;
					System.out.println("Aguarde enquando o " + atendimento.getNameClient() + " é atendido......");
					Thread.sleep((int) (Math.random() * 5000));
					qtdeClienteAtendidos++;
					System.out.println("Foram atendidos " + qtdeClienteAtendidos + " clientes");
					atendimento.leave();
			}
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void aguardaVez(Cliente cliente) {
		try {
			if (!listaAtendidos.contains(cliente)) {
				if (this.tamanhoFila() < qtdeCadeiras) {
					fila.offer(cliente);
					listaAtendidos.add(cliente);
					System.out.println("Cliente " + cliente.getNameClient() + " entrou na fila");
					System.out.println("Quantidade clientes esperando para cortar = "+ tamanhoFila());
				} else {
					System.out.println("O Cliente "+ cliente.getNameClient() +" chegou mas não existem cadeiras vazias, ele voltará em breve.");
					Thread.sleep((int) (Math.random() * 7000));
				}
			}
			
			while (this.tamanhoFila() < qtdeCadeiras) {
				if (dormindo) {
					System.out.println("Acordando o barbeiro...");
					notify();
					dormindo = false;
				}
				wait();
			}
			notifyAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getAtendidos(){
		return qtdeClienteAtendidos;
	}


	public boolean isDormindo() {
		return dormindo;
	}


	public boolean isCortando() {
		return cortando;
	}
	

  
}
