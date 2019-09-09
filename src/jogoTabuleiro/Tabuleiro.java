package jogoTabuleiro;

import java.util.Arrays;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public int getLinhas() {
		return linhas;
	}
	public int getColunas() {
		return colunas;
	}

	public Peca[][] getPecas() {
		return pecas;
	}
	public void setPecas(Peca[][] pecas) {
		this.pecas = pecas;
	}
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas<1 || colunas <1)
			throw new ExcecaoTabuleiro("Erro criando tabuleiro, é necessario pelo menos uma linha ou coluna");
		this.linhas = linhas;
		this.colunas = colunas;
		this.pecas = new Peca[linhas][colunas];
	}
	@Override
	public String toString() {
		return "Tabuleiro [linhas=" + linhas + ", colunas=" + colunas + ", pecas=" + Arrays.toString(pecas) + "]";
	}
	
	
	public Peca peca(int linha, int coluna)
	{
		if(!posicaoExiste(linha,coluna))
			throw new ExcecaoTabuleiro("Posicao nao esta no tabuleiro");
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao)
	{
		if(!posicaoExiste(posicao))
			throw new ExcecaoTabuleiro("Posicao nao esta no tabuleiro");
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca, Posicao posicao)
	{
		if(existePeca(posicao))
			throw new ExcecaoTabuleiro("Posicao: " + posicao+  " ocupada");
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.setPosicao(posicao);
	}
	
	private boolean posicaoExiste(int linha, int coluna)
	{
		return linha>=0 && linha<linhas && coluna>=0 && coluna<colunas;
	}
	
	public boolean posicaoExiste(Posicao posicao)
	{
		return posicaoExiste(posicao.getLinha(),posicao.getColuna()); 
	}
	
	public boolean existePeca(Posicao posicao)
	{
		if(!posicaoExiste(posicao))
			throw new ExcecaoTabuleiro("Posicao nao esta no tabuleiro");
		
		return peca(posicao)!=null;
	}
}
