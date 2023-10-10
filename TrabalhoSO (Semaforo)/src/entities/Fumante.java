package entities;

public class Fumante extends Thread {
    public String nome;
    public int produtoNecessitado;
    public Mesa mesa;
    public Vendedor vendedor;

    

    public Fumante(String nome, int produtoNecessitado, Mesa mesa, Vendedor vendedor) {
		super();
		this.nome = nome;
		this.produtoNecessitado = produtoNecessitado;
		this.mesa = mesa;
		this.vendedor = vendedor;
	}



	@Override
    public void run() {
		System.out.println(nome + " está esperando ingredientes.");
        while (true) {
            if(mesa.get(produtoNecessitado,nome)){
            	System.out.println(nome + " está esperando ingredientes.");
            }
        }
    }
}