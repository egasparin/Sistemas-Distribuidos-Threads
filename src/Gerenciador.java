import java.util.ArrayList;

class  Gerenciador {
    public static int MAX_ATENDIMENTO = 1;
    public static int MAX_RODADAS = 3;

    public int rodada = 0;
    public int totalPedidos = 0;
    public int clienteIndex = 0;
    public boolean barAberto = true;
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public ArrayList<Garcon> garcons = new ArrayList<Garcon>();


    public void esperarPedir() {
        if(totalPedidos == clientes.size()) {

            if (this.faltaPedir() == 0) {
                this.rodada += 1;
                if (this.rodada == Gerenciador.MAX_RODADAS) {
                    this.barAberto = false;
                    System.out.println("*** BAR FECHOU ***");
                }
                else  {
                    this.totalPedidos = 0;
                    this.liberarClientes();
                }
            }

        } else {

        }
    }

    public int faltaPedir() {
        int clientesSemPedidos = 0;
        for (Cliente cliente: this.clientes) {
            if (!cliente.pedido) {
                clientesSemPedidos += 1;
            }
        }
        return clientesSemPedidos;
    }

    public void liberarClientes() {
        for (Cliente cliente: this.clientes) {
            cliente.pedido = false;
        }
    }
}