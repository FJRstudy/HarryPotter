package br.com.fjr.HarryPotter.exeptionConf;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
	private Integer code;
    private String statusMessage;
    private String method;
    private String message;
    private String error;
    private String detalhe;
    private String path;
    
	
	
	 public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getStatusMessage() {
		return statusMessage;
	}


	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getDetalhe() {
		return detalhe;
	}


	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public static Builder builder() {
	        return new Builder();
	    }

	
	public static class Builder {

        private Error error;

        Builder() {
            this.error = new Error();
        }

        public Builder addStatus(HttpStatus status) {
            this.error.code = status.value();
            this.error.statusMessage = status.getReasonPhrase();
            return this;
        }

        public Builder addHttpMethod(String method) {
            this.error.method = method;
            return this;
        }

        public Builder addMessage(String erro) {
            this.error.message = erro;
            return this;
        }

        public Builder addErroCause(String erroCause) {
            this.error.error = erroCause;
            return this;
        }

        public Builder addDetalhe(String detalhe) {
            this.error.detalhe = detalhe;
            return this;
        }

        public Builder addPath(String path) {
            this.error.path = path;
            return this;
        }

        public Error build() {
            return this.error;
        }
    }
    
}
