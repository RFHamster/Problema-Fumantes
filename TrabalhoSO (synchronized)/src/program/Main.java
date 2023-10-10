package program;

import entities.Fumante;
import entities.Mesa;
import entities.Vendedor;

public class Main {
    public static void main(String[] args) {
    	Mesa m = new Mesa();
    	Vendedor vendedor = new Vendedor(m);
        Fumante fumante1Thread = new Fumante("Rhuan", 0, m, vendedor);
        Fumante fumante2Thread = new Fumante("Lucas",1, m, vendedor);
        Fumante fumante3Thread = new Fumante("Fernanda",2, m, vendedor);

        vendedor.start();
        fumante1Thread.start();
        fumante2Thread.start();
        fumante3Thread.start();
    }
}