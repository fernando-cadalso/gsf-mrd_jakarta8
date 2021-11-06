package local.fmc.gsf.mrd.dominio;

public class MoradorBuilder {
	private Morador morador;

	public MoradorBuilder cadNomeUsuarioPapel(String nome, String usuario, String papel) {
		morador = new Morador(nome, usuario, papel);

		return this;
	}

	public MoradorBuilder cadSenha(String senha) {
		morador.criarSenha(senha);

		return this;
	}

	public Morador criar() {
		return this.morador;
	}
}
