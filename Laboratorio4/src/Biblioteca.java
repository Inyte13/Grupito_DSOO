import java.util.ArrayList;

public class Biblioteca {
  ArrayList<Libro> libros=new ArrayList<>();
  ArrayList<Usuario> usuarios=new ArrayList<>();
  public boolean prestarLibro(Usuario usuario,Libro libro){
    if(verificarDisponibilidad(libro)){
      libro.setDisponible(false);
      usuario.setLibroPrestado(libro);
      return true;
    }
    return false;
  }
  public boolean verificarDisponibilidad(Libro libro){
    for(Libro li:libros){
      if(li.getISBN().equals(libro.getISBN())){
        return true;
      }
    }
    return false;
  }
  public boolean verificarLibroPrestado(Usuario usuario,Libro libro){
    for(Libro li:usuario.getLibrosPrestados()){
      if(li.getISBN().equals(libro.getISBN())){
        return true;
      }
    }
    return false;
  }
  public boolean devolverLibro(Usuario usuario,Libro libro){
    if(verificarLibroPrestado(usuario,libro)){
      usuario.getLibrosPrestados().remove(libro);
      libro.setDisponible(true);
      return true;
    }
    return false;    
  }
}
