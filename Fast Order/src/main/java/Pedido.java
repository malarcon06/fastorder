import java.util.ArrayList;

public class Pedido {

    private ArrayList<String> productos;
    private ArrayList<Integer> cantidades;
    private ArrayList<Double> precios;
    private ArrayList<Double> preciosTotal;
    private ArrayList<String> comentarios;
    private double propinaSugerida;
    private double total;

    public Pedido(){
        productos = new ArrayList<String>();
        cantidades = new ArrayList<Integer>();
        precios = new ArrayList<Double>();
        preciosTotal = new ArrayList<Double>();
        comentarios = new ArrayList<String>();
        total = 0;
        propinaSugerida = 0;
    }

    public Pedido(Pedido pedido){

    }

    public void generarPedido(String producto, int cantidad, double precio, String comentario){
        productos.add(producto);
        cantidades.add(cantidad);
        precios.add(precio);
        preciosTotal.add(cantidad*precio);
        comentarios.add(comentario);
        setTotal();
    }

    private void setTotal(){
        double sum = 0;
        for(Double precio: preciosTotal){
            sum += precio;
        }
        total = sum;
    }

}
