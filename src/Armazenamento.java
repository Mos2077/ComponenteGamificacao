import java.util.ArrayList;

public interface Armazenamento {
	
	public void armazenarUsuario(Usuario usuario, Ponto ponto);
	
	public int getPontosPorUsuarioETipo(Usuario usuario, String tipoPonto);
	
	public ArrayList<Usuario> getUsuariosComTipoPonto(String tipo);
	
	public Usuario getUsuarioArmazenado(Usuario usuario);
	
	public Ponto getPontoPorTipo(Usuario usuario, String tipoPonto);
	
	public String getUsuariosComPontos(String tipoPonto);
	
	public String getTipoPontoPorUsuario(Usuario usuario);
}
