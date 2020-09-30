import java.util.ArrayList;
import java.util.HashMap;

public class MenuLocal {

    ArrayList<Categoria> categorias;

    public MenuLocal(){
        categorias = new ArrayList<Categoria>();
    }

    public void nuevaCategoria(String nombreCategoria){
        categorias.add(new Categoria(nombreCategoria));
    }

    public void borrarCategoria(String nombreCategoria){
        int index = Integer.MIN_VALUE;
        for(Categoria categoria: categorias){
            if(categoria.nombreCategoria.equals(nombreCategoria)){
                index = categorias.indexOf(categoria);
                break;
            }
        }
        if(index > -1){
            categorias.remove(index);
        }
    }

    public void nuevaSubcategoria(String nombreCategoria, String nombreSubcategoria){
        for(Categoria categoria: categorias){
            if(categoria.nombreCategoria.equals(nombreCategoria)){
                categoria.agregarSubcategoria(nombreSubcategoria);
                break;
            }
        }
    }

    public void borrarSubcategoria(String nombreCategoria, String nombreSubcategoria){
        for(Categoria categoria: categorias){
            if(categoria.nombreCategoria.equals(nombreCategoria)){
                categoria.eliminarSubcategoria(nombreSubcategoria);
            }
        }
    }

    public void nuevoProducto(String nombreCategoria, String nombreSubcategoria, String nombreProducto,
                              double precioProducto){
        for(Categoria categoria: categorias){
            if(categoria.nombreCategoria.equals(nombreCategoria)){
                for(Subcategoria subcategoria: categoria.subcategorias){
                    if(subcategoria.nombreSubcategoria.equals(nombreSubcategoria)){
                        subcategoria.agregarProducto(nombreProducto, precioProducto);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void nuevoProducto(String nombreCategoria, String nombreProducto,
                              double precioProducto){
        for(Categoria categoria: categorias){
            if(categoria.nombreCategoria.equals(nombreCategoria)){
                categoria.agregarProducto(nombreProducto, precioProducto);
                break;
            }
        }
    }

    public void borrarProducto(String nombreCategoria, String nombreSubcategoria, String nombreProducto){
        for(Categoria categoria: categorias){
            if(categoria.nombreCategoria.equals(nombreCategoria)){
                for(Subcategoria subcategoria: categoria.subcategorias){
                    if(subcategoria.nombreSubcategoria.equals(nombreSubcategoria)){
                        subcategoria.eliminarProducto(nombreProducto);
                        break;
                    }
                }
                break;
            }
        }
    }

    public void borrarProducto(String nombreCategoria, String nombreProducto){
        for(Categoria categoria: categorias){
            if(categoria.nombreCategoria.equals(nombreCategoria)){
                categoria.eliminarProducto(nombreProducto);
                break;
            }
        }
    }


    public class Categoria{

        String nombreCategoria;
        HashMap<String, Double> productos;
        ArrayList<Subcategoria> subcategorias;

        public Categoria(String nombreCategoria){
            this.nombreCategoria = nombreCategoria;
            subcategorias = new ArrayList<Subcategoria>();
        }

        public void agregarSubcategoria(String nombreSubcategoria){
            subcategorias.add(new Subcategoria(nombreSubcategoria));
        }

        public void eliminarSubcategoria(String nombreSubcategoria){
            int index = Integer.MIN_VALUE;
            for(Subcategoria subcategoria: subcategorias){
                if(subcategoria.nombreSubcategoria.equals(nombreSubcategoria)){
                    index = subcategorias.indexOf(subcategoria);
                    break;
                }
            }
            if(index > -1) {
                subcategorias.remove(index);
            }
        }

        public void agregarProducto(String nombreProducto, double precioProducto){
            productos.put(nombreProducto, precioProducto);
        }

        public void eliminarProducto(String nombreProducto){
            productos.remove(nombreProducto);
        }
    }

    public class Subcategoria{

        String nombreSubcategoria;
        HashMap<String, Double> productos;

        public Subcategoria(String nombreSubcategoria){
            this.nombreSubcategoria = nombreSubcategoria;
            productos = new HashMap<String, Double>();
        }

        public void agregarProducto(String nombreProducto, double precioProducto){
            productos.put(nombreProducto, precioProducto);
        }

        public void eliminarProducto(String nombreProducto){
            productos.remove(nombreProducto);
        }
    }

}
