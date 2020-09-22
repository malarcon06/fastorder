import java.util.Scanner;

public class Mesa {

    private int capacidad;
    private int numero;
    private String horaLlegada;
    private String estado;
    private Pedido pedidoActual;

    public Mesa(int capacidad, String horaLlegada, int numero){
        this.capacidad = capacidad;
        this.horaLlegada = horaLlegada;
        this.numero = numero;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    public String getEstado() {
        return estado;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setPedidoActual() {
        tomarPedido();
    }

    private String tomarPedido(){
        Scanner myScanner = new Scanner(System.in);
        pedidoActual = new Pedido();
        System.out.println("Seleccione su pedido: ");
        System.out.println("Producto:");
        String producto = myScanner.nextLine();
        System.out.println("Cantidad:");
        int cantidad = Integer.parseInt(myScanner.nextLine());
        System.out.println("Comentario:");
        String comentario = myScanner.nextLine();
        return pedidoActual.generarPedido(producto, cantidad, 0, comentario);
    }

    public String pedirCuenta(){
        return pedidoActual.toStringBoleta();
    }

}
