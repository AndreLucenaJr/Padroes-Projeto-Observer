package observer;

import java.util.Observable;
import java.util.Observer;


public class Usuario implements Observer {

    private String nome;
    private String ultimaMensagem;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String obterUltimaMensagem() {
        return this.ultimaMensagem;
    }


    public void registrarEm(EstacaoMeteorologica estacao) {
        estacao.addObserver(this);
    }


    @Override
    public void update(Observable estacao, Object mensagem) {
        this.ultimaMensagem = this.nome + ", novo alerta meteorológico: " + mensagem;
    }
}
