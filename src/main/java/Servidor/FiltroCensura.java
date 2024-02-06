package Servidor;

import java.util.ArrayList;
import java.util.List;

public class FiltroCensura {
    private List<String> palabrasProhibidas;

    public FiltroCensura() {
        palabrasProhibidas = new ArrayList<>();
        // Agrega las palabras prohibidas a la lista
        palabrasProhibidas.add("nazi");
        palabrasProhibidas.add("PerroS");
        palabrasProhibidas.add("sexo");
        palabrasProhibidas.add("LuisRebollo");
        // Agrega más palabras según sea necesario
    }

    public String filtrarMensaje(String mensaje) {
        for (String palabraProhibida : palabrasProhibidas) {
            mensaje = reemplazarConAsteriscos(mensaje, palabraProhibida);
        }
        return mensaje;
    }

    private String reemplazarConAsteriscos(String mensaje, String palabraProhibida) {
        StringBuilder asteriscos = new StringBuilder();
        for (int i = 0; i < palabraProhibida.length(); i++) {
            asteriscos.append("*");
        }
        return mensaje.replaceAll("\\b" + palabraProhibida + "\\b", asteriscos.toString());
    }
}
