public class Main {
    public static void main(String[] args) {
        Mesa m = new Mesa(5);
        for(int i = 1; i <= 5; i++){
            Filosofo f1 = new Filosofo(m, i );
            f1.start();
        }
    }
}