package br.com.fjr.HarryPotter.exeptionConf;

public class NotFoundException extends RuntimeException{
	
	public NotFoundException (String mensagem) {
		super(mensagem);
	}

}
