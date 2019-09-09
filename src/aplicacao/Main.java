package aplicacao;

import jogoTabuleiro.Posicao;
import jogoTabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;

public class Main {

	public static void main(String[] args) 
	{
		
		PartidaDeXadrez partida = new PartidaDeXadrez();
		UI.printTabuleiro(partida.getPecas());
	
	}

}
