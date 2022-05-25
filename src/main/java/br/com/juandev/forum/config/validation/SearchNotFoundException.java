package br.com.juandev.forum.config.validation;

public class SearchNotFoundException extends RuntimeException {

    public SearchNotFoundException(String resourceName) {
        super(String.format("%s não encontrado(a)", resourceName));
    }

    public SearchNotFoundException(String resourceName, Long id) {
        super(String.format("%s com identificador: %d não encontrado(a)", resourceName, id));
    }


}
