package Zoo;

import java.util.Random;

/**
 * Clase que representa a un salmón en un zoológico.
 * Extiende la clase Pez.
 * @author Cristian M González Ramos
 */
public class Salmon extends Pez {
    /** Etapa de vida actual del salmón. */
    String etapaDeVida;
    /** Indica si el salmón ha migrado o no. */
    boolean haMigrado;

    /** Arreglo que contiene las distintas etapas de vida de un salmón. */
    String[] estapasDeVida = {"Alevín", "Juvenil", "Adulto"};

    /** Generador de números aleatorios. */
    Random rd = new Random();

    /**
     * Constructor por defecto de la clase Salmon.
     * Inicializa la etapa de vida y si el salmón ha migrado aleatoriamente.
     */
    public Salmon() {
        super();
        this.etapaDeVida = estapasDeVida[rd.nextInt(estapasDeVida.length)];
        this.haMigrado = rd.nextBoolean();
    }

    /**
     * Constructor de la clase Salmon.
     * @param nombre Nombre del salmón.
     * @param edad Edad del salmón.
     * @param peso Peso del salmón.
     * @param tamaño Tamaño del salmón.
     * @param colorescamas Colores de las escamas del salmón.
     * @param tipoAgua Tipo de agua en el que vive el salmón.
     * @param etapaDeVida Etapa de vida del salmón.
     * @param haMigrado Indica si el salmón ha migrado.
     */
    public Salmon(String nombre, int edad, float peso, String tamaño, String colorescamas, String tipoAgua, String etapaDeVida, boolean haMigrado) {
        super(nombre, edad, peso, tamaño, colorescamas, tipoAgua);
        this.etapaDeVida = etapaDeVida;
        this.haMigrado = haMigrado;
    }

    /**
     * Método que simula la migración del salmón.
     */
    public void migrar() {
        System.out.println(nombre + " abandona el mar y comienza su viaje de regreso al agua dulce.");
    }

    /**
     * Método que muestra las acciones realizadas por el salmón durante un periodo de tiempo.
     * Heredado de la clase Pez y sobreescrito para incluir la migración.
     */
    @Override
    public void verAnimal() {
        Runnable[] acciones = {
            this::comer,
            this::dormir,
            this::moverse,
            this::nadar,
            this::respirarBajoAgua,
            this::ponerHuevos,
            this::migrar
        };

        try {
            for (int i = 0; i < 7; i++) {
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run();

                int tiempoEspera = random.nextInt(2000) + 1000;
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
