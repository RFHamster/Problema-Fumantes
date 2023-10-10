package entities;

public class Vendedor extends Thread{
	public Mesa mesa;
	
	
    public Vendedor(Mesa m) {
    	mesa = m;
    }
    
    @Override
	public void run() {
    	while(true) {
    		mesa.put(colocarIngredientes());
    	}
		
	}

    public int colocarIngredientes() {
        int random = (int) (Math.random() * 3);
        return random;
    }
    
    public void notificarVendedor() {
        synchronized (mesa) {
            mesa.notify();
        }
    }
}