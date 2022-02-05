import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGameficacao {
	
	MockObjectPlacar placar = new MockObjectPlacar();

	@Test
	public void armazenaUsuario() {
		placar.iniciarArmazenamento();
		
		criarUsuarios();
		
		assertEquals(placar.quantidadeUsuariosRegistrados(), 4);
	}

	@Test
	public void pontosPorTipoEUsuario() {
		placar.iniciarArmazenamento();
		criarUsuarios();
		
		Usuario usuario = new Usuario("matheus");
		int pontos = placar.getArmazenamento().getPontosPorUsuarioETipo(usuario, "curtida");
		assertEquals(pontos, 5);
	}
	
	@Test
	public void tiposPontoPorUsuario() {
		placar.iniciarArmazenamento();
		criarUsuarios();
		
		Usuario usuario = new Usuario("joao");
		String pontos = placar.getArmazenamento().getTipoPontoPorUsuario(usuario);
		assertEquals(pontos, "estrela, topico");
	}
	
	@Test
	public void usuariosPorTipoPonto() {
		placar.iniciarArmazenamento();
		criarUsuarios();
		
		String usuariosComAlgumPonto = placar.getArmazenamento().getUsuariosComPontos("moeda");
		assertEquals(usuariosComAlgumPonto, "tiago, matheus");
	}
	
	@Test
	public void pontosPorUsuario() {
		placar.iniciarArmazenamento();
		criarUsuarios();
		
		Usuario usuario = new Usuario("tiago");
		String pontuacao = placar.getPontosPorUsuario(usuario);
		assertEquals(pontuacao, "5 pontos do tipo comentario\n13 pontos do tipo moeda\n10 pontos do tipo curtida\n");
	}
	
	@Test
	public void rankingUsuarioComMaisTipoPonto() {
		placar.iniciarArmazenamento();
		criarUsuarios();
		
		String ranking = placar.getRankingUsuarioComMaisTipoPonto("comentario");
		assertEquals(ranking, "Usuario: tiago com 5\nUsuario: matheus com 5\nUsuario: pedro com 2\n");
	}
	
	private void criarUsuarios() {
		Usuario joao = new Usuario("joao");
		criarPontosJoao(joao);
	
		Usuario pedro = new Usuario("pedro");
		criarPontosPedro(pedro);
		
		Usuario tiago = new Usuario("tiago");
		criarPontosTiago(tiago);
		
		Usuario matheus = new Usuario("matheus");
		criarPontosMatheus(matheus);
	}
	
	
	public void criarPontosJoao(Usuario joao){
		Ponto estrela = new Ponto(10, "estrela");
		Ponto topico = new Ponto(5, "topico");
		
		placar.registrarTipoPontoUsuario(joao, estrela);
		placar.registrarTipoPontoUsuario(joao, topico);
	}
	
	public void criarPontosPedro(Usuario pedro){
		Ponto curtida = new Ponto(6, "curtida");
		Ponto comentario = new Ponto(2, "comentario");
		Ponto topico = new Ponto(7, "topico");
		Ponto estrela = new Ponto(13, "estrela");

		placar.registrarTipoPontoUsuario(pedro, curtida);
		placar.registrarTipoPontoUsuario(pedro, comentario);
		placar.registrarTipoPontoUsuario(pedro, topico);
		placar.registrarTipoPontoUsuario(pedro, estrela);

	}
	
	public void criarPontosTiago(Usuario tiago){
		Ponto curtida = new Ponto(10, "curtida");
		Ponto comentario = new Ponto(5, "comentario");
		Ponto moeda = new Ponto(13, "moeda");

		placar.registrarTipoPontoUsuario(tiago, comentario);
		placar.registrarTipoPontoUsuario(tiago, moeda);
		placar.registrarTipoPontoUsuario(tiago, curtida);
	}
	
	public void criarPontosMatheus(Usuario matheus){
		Ponto curtida = new Ponto(5, "curtida");
		Ponto comentario = new Ponto(5, "comentario");
		Ponto moeda = new Ponto(2, "moeda");
		Ponto estrela = new Ponto(15, "estrela");

		placar.registrarTipoPontoUsuario(matheus, comentario);
		placar.registrarTipoPontoUsuario(matheus, moeda);
		placar.registrarTipoPontoUsuario(matheus, estrela);
		placar.registrarTipoPontoUsuario(matheus, curtida);
	}
}
