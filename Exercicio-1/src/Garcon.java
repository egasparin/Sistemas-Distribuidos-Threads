import java.util.ArrayList;

class Garcon extends Thread {

    public ArrayList<Cliente> clientesAtendidos = new ArrayList<Cliente>();
    private Gerenciador gerenciador;

    public Garcon(Gerenciador gerenciador) {
        this.gerenciador = gerenciador;
        this.gerenciador.garcons.add(this);
    }

    @Override
    public void run() {
        receberMaxPedido();
        registrarPedido();
        entregarPedido();
    }

    public void receberMaxPedido() {
        while (this.clientesAtendidos.size() <= Gerenciador.MAX_ATENDIMENTO) {
            Cliente clienteAtual = this.gerenciador.clientes.get(this.gerenciador.clienteIndex);
            this.gerenciador.clienteIndex++;
            if (clienteAtual.pedido) {
                this.clientesAtendidos.add(clienteAtual);
                System.out.println("GARÇOM -> Coletar pedido.");
            }
        }
    }

    public void registrarPedido() {
        if (clientesAtendidos.size() > 0) {
            try {
                System.out.println("GARÇOM -> Registrando pedido...");
                long time = (long) Math.floor(Math.random() * 100);
                Garcon.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void entregarPedido() {
        if (clientesAtendidos.size() == Gerenciador.MAX_ATENDIMENTO) {
            this.gerenciador.totalPedidos += this.clientesAtendidos.size();
        }
    }

}