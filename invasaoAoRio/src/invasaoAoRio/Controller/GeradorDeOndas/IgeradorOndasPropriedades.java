package invasaoAoRio.Controller.GeradorDeOndas;

public interface IgeradorOndasPropriedades {
	public void gerarOnda(int quantidadeNavios, long duracao, int dificuldade) throws InterruptedException;
	public void pararOnda();
}
