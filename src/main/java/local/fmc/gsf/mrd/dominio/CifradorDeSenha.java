package local.fmc.gsf.mrd.dominio;

/*
 * Essa classe representa um conceito do domínio,
 * conhecido pelas pessoas da áres de negócio.
 * A implementação é feita pela área de infraestrutura
 * que é resposável por escolher a tecnologia adequada.
 */
public interface CifradorDeSenha {

	String cifrarSenha(String senha);
	
	boolean validarSenha(String senhaCifrada, String senhaAberta);
}
