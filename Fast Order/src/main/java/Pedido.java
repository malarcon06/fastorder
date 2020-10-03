import java.util.ArrayList;

public class Pedido {

    private ArrayList<String> productos;
    private ArrayList<Integer> cantidades;
    private ArrayList<Double> precios;
    private ArrayList<Double> preciosTotal;
    //private ArrayList<String> comentarios;
    private double propinaSugerida;
    private double total;

    public Pedido(){
        productos = new ArrayList<String>();
        cantidades = new ArrayList<Integer>();
        precios = new ArrayList<Double>();
        preciosTotal = new ArrayList<Double>();
        //comentarios = new ArrayList<String>();
        total = 0;
        propinaSugerida = 0;
    }


    // Se genera un nuevo pedido. Se agrega al pedido total y se envia el pedido actual a cocina.

    public String generarPedido(String producto, int cantidad, double precio, String comentario){

        if(productos.contains(producto)){
            int index = productos.indexOf(producto);
            int cant = cantidades.set(index, cantidades.get(index)+cantidad);
            precios.set(index, cant*precio);
        }else {
            productos.add(producto);
            cantidades.add(cantidad);
            precios.add(precio);
            preciosTotal.add(cantidad * precio);
        }
        setTotal();
        return toStringCocina(producto, cantidad, comentario);
    }

    private void setTotal(){
        double sum = 0;
        for(Double precio: preciosTotal){
            sum += precio;
        }
        total = sum;
        propinaSugerida = total*0.12;
    }

    public ArrayList<String> getProductos(){
        return productos;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public ArrayList<Double> getPrecios(){
        return precios;
    }

    public ArrayList<Double> getPreciosTotal() {
        return preciosTotal;
    }

    private String toStringCocina(String producto, int cantidad, String comentario){

        return producto+"\t"+cantidad+"\t"+comentario;
    }

    public String toStringBoleta(){
        String pedidoBoleta = "";

        for(int i = 0; i < productos.size(); i++){
            pedidoBoleta += productos.get(i)+"\t"+cantidades.get(i)+"\t"+preciosTotal.get(i)+"\n";
        }
        pedidoBoleta += "\n"+total+propinaSugerida;
        return pedidoBoleta;
    }
}
