import java.util.Comparator;

public class SortPontosUsuarios implements Comparator<Usuario>
{
    public int compare(Usuario usuario1, Usuario usuario2)
    {   	
    	return usuario2.getPontos().get(0).getQuantidade() - usuario1.getPontos().get(0).getQuantidade();
    }
}