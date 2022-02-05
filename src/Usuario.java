import java.util.ArrayList;

public class Usuario {
	private String login;
	private ArrayList<Ponto> ponto = new ArrayList<Ponto>();
	
	public Usuario(String login) {
		this.login = login;
	}
	
	public ArrayList<Ponto> getPontos() {
		return ponto;
	}
	
	public void setPonto(Ponto ponto) {
		this.ponto.add(ponto);
	}
	
	public String getLogin() {
		return login;
	}
}
