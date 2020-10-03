import java.util.ArrayList;

public class Local {

    public String nombre;
    private int numeroMesas;
    private ArrayList<Mesa> mesas;
    private MenuLocal menu;

    public Local(){
        numeroMesas = 0;
        mesas = new ArrayList<Mesa>();
        menu = new MenuLocal();
        this.nombre = "Local";
    }

    public ArrayList<Mesa> getMesas(){
        return mesas;
    }

    public void anadirMesa(int capacidad, String horaLlegada){
        mesas.add(new Mesa(capacidad, horaLlegada, mesas.size()+1, menu));
    }

    public void modificarMesa(int numero){

    }

    public void eliminarMesa(int numero){
        for(Mesa mesa: mesas){
            if(mesa.getNumero() == numero){
                mesas.remove(mesa);
            }
            break;
        }
    }

    public void eliminarTodasLasMesas(){
        mesas.clear();
    }

    //Anade una categoria al menu
    public void anadirCategoriaMenu(String nombreCategoria){
        this.menu.nuevaCategoria(nombreCategoria);
        actualizarMenu();
    }

    //Elimina una categoria del menu
    public void eliminarCategoriaMenu(String categoria){
        this.menu.borrarCategoria(categoria);
        actualizarMenu();
    }

    //Anade una subcategoria a la categoria seleccionada del menu
    public void anadirSubcategoriaMenu(String categoria, String nombreSubcategoria){
        this.menu.nuevaSubcategoria(categoria, nombreSubcategoria);
        actualizarMenu();
    }

    //Elimina una subcategoria de la categoria seleccionada del menu
    public void eliminarSubcategoriaMenu(String categoria, String subcategoria){
        this.menu.borrarSubcategoria(categoria, subcategoria);
        actualizarMenu();
    }

    //Anade un producto a la categoria SIN subcategorias seleccionada
    public void anadirProductoMenu(String categoria, String nombreProducto, double precio){
        this.menu.nuevoProducto(categoria, nombreProducto, precio);
        actualizarMenu();
    }

    //Anade un producto a la categoria CON subcategorias seleccionada
    public void anadirProductoMenu(String categoria, String subcategoria, String nombreProducto, double precio){
        this.menu.nuevoProducto(categoria, subcategoria, nombreProducto, precio);
        actualizarMenu();
    }

    //Eliminar un producto de la categoria SIN subcategorias seleccionada
    public void elimnarProductoMenu(String categoria, String nombreProducto){
        this.menu.borrarProducto(categoria, nombreProducto);
        actualizarMenu();
    }

    //Eliminar un producto de la categoria CON subcategorias seleccionada
    public void elimnarProductoMenu(String categoria, String subcategoria, String nombreProducto){
        this.menu.borrarProducto(categoria, subcategoria, nombreProducto);
        actualizarMenu();
    }

    //Despues de cualquier cambio al menu se usa esta funcion para actualizar el menu en todas las mesas
    private void actualizarMenu(){
        for(Mesa mesa: mesas){
            mesa.updateMenu(menu);
        }
    }
}


