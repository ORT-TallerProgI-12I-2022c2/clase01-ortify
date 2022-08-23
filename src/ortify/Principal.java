package ortify;

public class Principal {

    public static void main(String[] args) {
        Ortify app = new Ortify("DVtify");
        cargarDatos(app);
        
        System.out.println("Test de mostrarDuracionPromedio");
        app.buscarArtista("CS").mostrarDuracionPromedio();
        app.buscarArtista("EC").mostrarDuracionPromedio();
        app.buscarArtista("QU").mostrarDuracionPromedio();
        System.out.println("----------------------");
        System.out.println("Test de esFanDestacado");
        System.out.println( app.esFanDestacado("pepe123", "QU"));
        System.out.println( app.esFanDestacado("mePortoMal", "EC"));
        System.out.println( app.esFanDestacado("mariaa", "CS"));
    }

    private static void cargarDatos(Ortify app) {
        app.agregarArtista(new Artista("CS", "Carlos Santana"));
        app.agregarArtista(new Artista("EC", "Eric Clapton"));
        app.agregarArtista(new Artista("QU", "Queen"));

        app.agregarUsuarioEnApp("pepe123", Estado.HABILITADO);
        app.agregarUsuarioEnApp("mariaa", Estado.HABILITADO);
        app.agregarUsuarioEnApp("lolo_10", Estado.SUSPENDIDO);
        app.agregarUsuarioEnApp("qwerty", Estado.HABILITADO);
        app.agregarUsuarioEnApp("mePortoMal", Estado.SUSPENDIDO);
        app.agregarUsuarioEnApp("user-curioso", Estado.PRUEBA_GRATIS);

        app.agregarCancionParaArtista("BMW", "Black Magic Woman", 335, "CS");
        app.agregarCancionParaArtista("OCV", "Oye Como Va", 259, "CS");
        app.agregarCancionParaArtista("EUR", "Europa", 322, "CS");
        app.agregarCancionParaArtista("CES", "Corazon Espinado", 276, "CS");
        app.agregarCancionParaArtista("SMO", "Smooth", 257, "CS");
        app.agregarCancionParaArtista("LAY", "Layla", 425, "EC");
        app.agregarCancionParaArtista("MFE", "My Father Eyes", 325, "EC");
        app.agregarCancionParaArtista("CTW", "Change The World", 237, "EC");
        app.agregarCancionParaArtista("BRA", "Bohemian Rapsody", 360, "QU");
        app.agregarCancionParaArtista("WCH", "We Are The Champions", 210, "QU");
        app.agregarCancionParaArtista("WBF", "I Want To Break Free", 272, "QU");
        app.agregarCancionParaArtista("STL", "Somebody To Love", 310, "QU");
        app.agregarCancionParaArtista("XXX", "No deberia existir", -1, "fakeArtista");
        
        app.likeDeUsuarioEnCancion("pepe123", "BRA");
        app.likeDeUsuarioEnCancion("pepe123", "WBF");
        app.likeDeUsuarioEnCancion("mePortoMal", "LAY");
        app.likeDeUsuarioEnCancion("mePortoMal", "CTW");
        app.likeDeUsuarioEnCancion("mePortoMal", "MFE");
        app.likeDeUsuarioEnCancion("mariaa", "SMO");
        app.likeDeUsuarioEnCancion("mariaa", "CES");
        app.likeDeUsuarioEnCancion("fakeUser", "CES"); 
        app.likeDeUsuarioEnCancion("mariaa", "fakeCancion");
        
    }

}
