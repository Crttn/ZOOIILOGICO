// Apartado desarrollado por Cristian M Gonzáelz Ramos

package Zoo;

import java.util.Random;

public class Pez_Salmon extends Pez {
    String etapaDeVida;
    boolean haMigrado;

    String[] estapasDeVida = {"Alevín", "Juvenil", "Adulto"};

    Random rd = new Random();

    public Pez_Salmon() {
        super();
        this.etapaDeVida = estapasDeVida[rd.nextInt(estapasDeVida.length)];
        this.haMigrado = rd.nextBoolean();
    }

    public Pez_Salmon(String nombre, int edad, float peso, String tamaño, String colorescamas, String tipoAgua, String etapaDeVida, boolean haMigrado) {
        super(nombre, edad, peso, tamaño, colorescamas, tipoAgua);
        this.etapaDeVida = etapaDeVida;
        this.haMigrado = haMigrado;
    }

    public void migrar() {
        System.out.println(nombre + " abandona el mar y comienza su viaje de regreso al agua dulce.");
    }

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
