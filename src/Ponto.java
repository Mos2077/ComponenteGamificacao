public class Ponto {
	private int quantidade;
	private String tipoPonto;
	
	public Ponto(int quantidade, String tipoPonto) {
		this.quantidade = quantidade;
		this.tipoPonto = tipoPonto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getTipoPonto() {
		return tipoPonto;
	}
	public void setTipoPonto(String tipoPonto) {
		this.tipoPonto = tipoPonto;
	}
}
