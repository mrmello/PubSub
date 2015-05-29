package pubsub;

public class Informacao {

	private int seq;
	private int tipo;
	private int valor;
	/**
	 * @param args
	 */
	public Informacao(int seq, int tipo, int valor) {
		this.seq = seq;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public String empacota(){
		return ""+this.seq+";"+this.tipo+";"+this.valor+";";
	}
	
	public Informacao desempacota(String msg){
		String[] parts = msg.split(";");
		
		String part1 = parts[0]; // seq
		String part2 = parts[1]; // tipo
		String part3 = parts[2]; // valor
		
		int seq = Integer.parseInt(part1);
		int tipo = Integer.parseInt(part2);
		int valor = Integer.parseInt(part3);
		Informacao info = new Informacao(seq, tipo, valor); 
		return info;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

}
