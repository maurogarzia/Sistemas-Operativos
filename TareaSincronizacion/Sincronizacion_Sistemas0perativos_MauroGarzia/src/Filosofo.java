public class Filosofo extends Thread{
    private Mesa mesa;
    private int idFilosofo;
    private int indiceFilosofo;

    public Filosofo (Mesa m, int idFilosofo){
        this.mesa = m;
        this.idFilosofo = idFilosofo;
        this.indiceFilosofo = idFilosofo - 1;
    }

    @Override
    public void run() {
        while (true){
            this.piensa();
            this.mesa.agarrarCubiertos(this.indiceFilosofo);
            this.come();
            this.mesa.dejarCubiertos(this.indiceFilosofo);
        }
    }


    //Metodo en el que Piensa
    public void piensa(){
        System.out.println("Filosofo " + this.idFilosofo + " esta pensando" );
        try {
            sleep((long) (Math.random() * 5000) + 1000);
        }catch (InterruptedException e){
            System.out.println("Error en piensa " + e);
        }
    }

    //Metodo en el que come
    public void come() {
        System.out.println("Filosofo " + this.idFilosofo + " comiendo");
        try {
            sleep((long) (Math.random() * 5000) + 1000);
        } catch (InterruptedException e) {
            System.out.println("Error en piensa " + e);
        }
    }
}
