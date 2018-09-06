
import org.junit.*;

public class PodcastControllerTest{

	private Usuario ouvinte;
	private Usuario criador;

@Before
public void criarUsuarios(){
	this.ouvinte = new Usuario();
	this.criador = new Usuario();
}

@Test
public void deveCriarPodCastDoUsuarioCiadorDeConteudo(){
	
}

@Test
public void naoDeveCriarPodCastDoUsuarioOuvinte(){
	
}

}