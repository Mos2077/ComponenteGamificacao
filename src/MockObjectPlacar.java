import java.util.ArrayList;
import java.util.Collections;

public class MockObjectPlacar implements Placar{
	private MockObjectArmazenamento armazenamento;
	
	public void iniciarArmazenamento() {
		this.armazenamento = new MockObjectArmazenamento();
	}

	public Armazenamento getArmazenamento() {
		return armazenamento;
	}

	@Override
	public void registrarTipoPontoUsuario(Usuario usuario, Ponto ponto) {
		if (armazenamento != null)
			armazenamento.armazenarUsuario(usuario, ponto);
		else 
			throw new RuntimeException("O armazenamento precisa ser inicializado.");		
	}
	@Override
	public String getPontosPorUsuario(Usuario usuario) {
		usuario = armazenamento.getUsuarioArmazenado(usuario);
		String resultado = "";
		for (Ponto ponto : usuario.getPontos()) {
			if (ponto.getQuantidade() == 0) continue;
			
			resultado += ponto.getQuantidade() + " pontos do tipo " + ponto.getTipoPonto() + "\n";
		}
		
		return resultado;
	}

	@Override
	public String getRankingUsuarioComMaisTipoPonto(String tipo) {
		ArrayList<Usuario> usuarios = armazenamento.getUsuariosComTipoPonto(tipo);
		String resultado = "";
		Collections.sort(usuarios, new SortPontosUsuarios());
		for (Usuario usuario : usuarios)
			resultado += "Usuario: " + usuario.getLogin() + " com " + usuario.getPontos().get(0).getQuantidade() + "\n";
		
		return resultado;
	}

	@Override
	public int quantidadeUsuariosRegistrados() {
		return armazenamento.getUsuarios().size();
	}

}
