

public interface Placar {

	public void registrarTipoPontoUsuario(Usuario usuario, Ponto ponto);
	
	public String getPontosPorUsuario(Usuario usuario);
	
	public String getRankingUsuarioComMaisTipoPonto(String tipo);
	
	public int quantidadeUsuariosRegistrados();
}