public class Mesa {
    private boolean[] cubiertos;

    //Constructor

    public Mesa(int numCubiertos) {
        this.cubiertos = new boolean[numCubiertos];
    }

    //Si esta en la izquierda
    public int cubiertoIzquierda(int i){ //Si esta en la izquierda me va a devolver el mismo numero de cubierto que el Filosofo
        return i;
    }


    //Si esta en la derecha
    public int cubiertoDerecha(int i){
        if (i == 0){
            return this.cubiertos.length - 1; //Me devuelve el ultimo cubierto si es el primer filosofo
        }else {
            return i - 1; //Sino me devuelve el anterior al numero del filosofo
        }
    }


    public synchronized void agarrarCubiertos(int filosofo){
        while (cubiertos[cubiertoIzquierda(filosofo)] || cubiertos[cubiertoDerecha(filosofo)]){
            try {
                wait(); //Si el cubierto de la izquierda y el de la derecha del filsofo estan ocupados espera
            }catch (InterruptedException e){
                System.out.println("Error en el wait de agarrar tenedores" + e);
            }
        }

        cubiertos[cubiertoIzquierda(filosofo)] = true;
        cubiertos[cubiertoDerecha(filosofo)] = true;

    }

    public synchronized void dejarCubiertos(int filosofo){ //Deja los cubiertos
        cubiertos[cubiertoIzquierda(filosofo)] = false;
        cubiertos[cubiertoDerecha(filosofo)] = false;

        notifyAll(); //Notifica que deja los cubiertos
    }


}
