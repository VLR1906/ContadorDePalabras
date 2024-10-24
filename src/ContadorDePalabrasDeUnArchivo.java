//estas importaciones nos permiten leer los archivos y hacer uso de hashmaps
import java.io.*;
import java.util.*;

public class ContadorDePalabrasDeUnArchivo {

    public static void main(String[] args) {
        //establecemos que al iniciar el codigo se lea el archivo
        ContadorDePalabrasDeUnArchivo.leer();
    }

    public static void leer() {
        //creamos un HashMap para almacenar las palabras junto a las veces que se repite
        Map<String, Integer> palabrasRepetidas = new HashMap<>();
        try {
            //establecemos el contador en cero
            int c = 0;
            String linea;
            //esta linea de codigo es el lector de archivos
            //agregamos la ruta del archivo que queremos leer
            BufferedReader leer = new BufferedReader(new FileReader("C:/Users/victo/Downloads/practica.csv"));
//repetimos la accion de leer el archivo con un maximo de 3000 lineas
            while ((linea = leer.readLine()) != null && c < 3000) {
                // convertimos a minusculas y eliminamos caracteres no deseados
                linea = linea.toLowerCase().replaceAll("[^a-z]", " ");

                // dividimos las líneas en palabras por espacios separando donde haya uno o mas espacios
                String[] palabras = linea.split("\\s+");

                // Contamos las veces que se repite cada palabra
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        palabrasRepetidas.put(palabra, palabrasRepetidas.getOrDefault(palabra, 0) + 1);
                    }
                }
                c++;
            }
            leer.close();
            //opciones en caso de que no se pueda leer correctamente el archivo que seleccionamos
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo");
            return;
        } catch (IOException ex) {
            System.err.println("No se pudo leer el archivo");
            return;
        }

        // Mostrar todas las palabras y sus frecuencias
        System.out.println("Palabras encontradas y su frecuencia:");
        for (Map.Entry<String, Integer> entrada : palabrasRepetidas.entrySet()) {
            System.out.println(entrada.getKey() + "," + entrada.getValue());
        }
    }
}

