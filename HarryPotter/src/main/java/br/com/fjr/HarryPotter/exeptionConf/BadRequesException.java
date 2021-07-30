package br.com.fjr.HarryPotter.exeptionConf;

public class BadRequesException extends RuntimeException{
	
	public BadRequesException(String mensagem) {
        super(mensagem);
    }
}
