package entities;

public class Mesa{
	public int produtos;
	
	public Mesa(){
		produtos = -1;
	}
	
	public synchronized void put(int value) {
		while (produtos != -1) {
	        try {
	            wait();
	        } catch (InterruptedException e) { }
	    }
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
	    notifyAll();
	}
	
	public synchronized boolean get(int produtosNecessitados, String nome) {
		while (produtos == -1) {
	        try {
	            wait();
	        } catch (InterruptedException e) { }
	    }
		if(produtos == produtosNecessitados) {
			System.out.println(nome + " está fumando.");
			try {
				Thread.sleep(3000);
                System.out.println(nome + " terminou de fumar.");
                produtos = -1;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
			notifyAll();
			return true;
		}
	    return false;
	}
}