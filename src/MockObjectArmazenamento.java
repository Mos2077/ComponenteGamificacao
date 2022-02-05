import java.util.ArrayList;

public class MockObjectArmazenamento implements Armazenamento {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public ArrayList<Usuario> getUsuarios(){
		return usuarios;
	}

	@Override
	public void armazenarUsuario(Usuario usuario, Ponto ponto) {
		usuario.setPonto(ponto);

		if (usuarios.contains(usuario)) {
			return;
		}
		usuarios.add(usuario);
	}

	@Override
	public int getPontosPorUsuarioETipo(Usuario usuario, String tipoPonto) {
		Ponto ponto = null;
		usuario = getUsuarioArmazenado(usuario);
		if (usuario != null) 
			ponto = getPontoPorTipo(usuario, tipoPonto);
		
		if (ponto != null) 
			return ponto.getQuantidade();
		    return 0;
}
	@Override
	public ArrayList<Usuario> getUsuariosComTipoPonto(String tipo){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for (Usuario usuario : this.usuarios) {
			for (Ponto ponto : usuario.getPontos()) {
				if (ponto.getTipoPonto() == tipo) {
					Usuario u = new Usuario(usuario.getLogin());
					u.setPonto(ponto);
					usuarios.add(u);
				}
			}
		}
		
		return usuarios;
	}

	@Override
	public Usuario getUsuarioArmazenado(Usuario usuario) {
		for (Usuario u : usuarios) {
			if (u.getLogin() == usuario.getLogin()) {
				return u;
			}
		}
		return null;
	}

	@Override
	public Ponto getPontoPorTipo(Usuario usuario, String tipoPonto) {
		for (Ponto ponto : usuario.getPontos()) {
			if (ponto.getTipoPonto() == tipoPonto) {
				return ponto;
			}
		}

		return null;
	}

	public String getUsuariosComPontos(String tipoPonto){
		String usuarios = "";
		for (Usuario usuario : this.usuarios) {
			for (Ponto ponto : usuario.getPontos()) {
				if (ponto.getTipoPonto() == tipoPonto) {
					usuarios += usuario.getLogin() + ",";
				}
			}
		}
		
		return usuarios.substring(0, usuarios.length() - 2);
	}

	@Override
	public String getTipoPontoPorUsuario(Usuario usuario){
		String tipoPonto = "";
		usuario = getUsuarioArmazenado(usuario);
		for (Ponto ponto : usuario.getPontos())
			tipoPonto += ponto.getTipoPonto() + ",";
		
		return tipoPonto.substring(0, tipoPonto.length() - 2);
	}
}
