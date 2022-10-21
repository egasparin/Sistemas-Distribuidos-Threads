
class Cliente extends Thread {

    public String nome;
    public boolean pedido = false;
    public Gerenciador gerenciador;

    public Cliente(String nome, Gerenciador gerenciador) {
        this.nome = nome;
        this.gerenciador = gerenciador;
        this.gerenciador.clientes.add(this);
    }

    @Override
    public void run() {
        while (this.gerenciador.barAberto) {
            fazPedido();
            esperaPedido();
            recebePedido();
            consomePedido();
        }
    }


    public void fazPedido() {
        if(!this.pedido) {
            this.pedido = true;
            System.out.println(this.nome.toUpperCase() + " -> Fez Pedido");
        }
    }

    public void esperaPedido() {
        synchronized (this) {
			
    	try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    public void recebePedido() {
    		try {
                long time = (long) Math.floor(Math.random() * 100);
                Cliente.sleep(time);
                System.out.println(this.nome.toUpperCase() + " -> Recebeu Pedido");
            } catch (InterruptedException e) {
                e.printStackTrace();
		}
    	
    }

    public void consomePedido() {
        try {
            System.out.println(this.nome.toUpperCase() + " -> Consumindo Pedido...");
            long time = (long) Math.floor(Math.random() * 100);
            Cliente.sleep(time);
            this.gerenciador.esperarPedir();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}