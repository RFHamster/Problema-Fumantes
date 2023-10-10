package entities;

import java.util.concurrent.Semaphore;

public class Mesa {
    private int produtos;
    private Semaphore semaforoMesa;
    private Semaphore semaforoFumante;
    
    public Mesa() {
        produtos = -1; // Inicialmente, nenhum produto disponível
        semaforoMesa = new Semaphore(1); // Semáforo para controlar o acesso à mesa (inicializado com 1 permissão)
        semaforoFumante = new Semaphore(0); // Semáforo para controlar o fumante (inicializado com 0 permissões)
    }

    public void put(int value) {
        try {
        	if(produtos == -1) {
        		semaforoMesa.acquire(); // Bloqueia o acesso à mesa
                produtos = value;
                switch (produtos) {
	    	        case 0:
	    	            System.out.println("Vendedor possui papel e tabaco na mesa.");
	    	            break;
	    	        case 1:
	    	            System.out.println("Vendedor possui papel e fósforo na mesa.");
	    	            break;
	    	        case 2:
	    	            System.out.println("Vendedor possui tabaco e fósforo na mesa.");
	    	            break;
	    	    }
                semaforoFumante.release();
                semaforoMesa.release();
        	}
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean get(int produtosNecessitados, String nome) {
        try {
        	if(produtos != -1) {
        		semaforoFumante.acquire();
                semaforoMesa.acquire();

                if (produtos == produtosNecessitados) {
                    System.out.println(nome + " está fumando.");
                    Thread.sleep(3000);
                    System.out.println(nome + " terminou de fumar.");
                    produtos = -1;
                    return true;
                }else {
                	semaforoFumante.release();
                }
        	}
            return false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            semaforoMesa.release();
        }
    }
}
