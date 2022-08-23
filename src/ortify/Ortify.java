package ortify;

import java.util.ArrayList;

/**
 *
 * @author caemci
 */
public class Ortify {

    private String nombre;
    private ArrayList<Artista> artistas;
    private ArrayList<Usuario> usuarios;

    public Ortify(String nombre) {
        setNombre(nombre);
        this.artistas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    
    public void setNombre(String nombre) {
    	if (!(nombre != null && nombre.length() >= 3)) {
    		throw new RuntimeException("Nombre invalido");
    	}
    }

    public boolean esFanDestacado(String nombreUsuario, String IDArtista) {
        Usuario u = buscarUsuario(nombreUsuario);
        Artista a = buscarArtista(IDArtista);
        boolean esFan = false;
        if (a != null && u != null && u.getEstado() != Estado.SUSPENDIDO) {
            esFan = a.esFanDestacado(u);
        }
        return esFan;
    }

    public void agregarArtista(Artista c) {
        this.artistas.add(c);
    }

    public void agregarUsuarioEnApp(String nombre, Estado estado) {
        this.usuarios.add(new Usuario(nombre, estado));
    }

    public void likeDeUsuarioEnCancion(String nombreUsuario, String IDCancion) {
        Usuario u = buscarUsuario(nombreUsuario);
        Cancion c = buscarCancion(IDCancion);
        if (c != null && u != null) {
            c.agregarLiker(u);
        }
    }

    public void agregarCancionParaArtista(String ID, String nombre, int duracionSeg, String IDArtista) {
        Artista a = buscarArtista(IDArtista);
        if (a != null) {
            a.agregarCancion(new Cancion(ID, nombre, duracionSeg));
        }
    }

    private Cancion buscarCancion(String IDCancion) {
        int i = 0;
        Cancion can = null;
        while (i < this.artistas.size() && can == null) {
            can = this.artistas.get(i).buscarCancion(IDCancion);
            i++;
        }
        return can;
    }

    private Usuario buscarUsuario(String nombreUsuario) {
        int i = 0;
        Usuario usu = null;
        while (i < this.usuarios.size() && usu == null) {
            if (this.usuarios.get(i).getNombre().equals(nombreUsuario)) {
                usu = this.usuarios.get(i);
            }
            i++;
        }
        return usu;
    }

    public Artista buscarArtista(String IDArtista) {
        int i = 0;
        Artista art = null;
        while (i < this.artistas.size() && art == null) {
            if (this.artistas.get(i).getID().equals(IDArtista)) {
                art = this.artistas.get(i);
            }
            i++;
        }
        return art;
    }

}
