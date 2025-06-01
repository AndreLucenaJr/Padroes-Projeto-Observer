package observer;

import java.util.Observable;

public class EstacaoMeteorologica extends Observable {

    private String localizacao;
    private String condicaoAtual;

    public EstacaoMeteorologica(String localizacao) {
        this.localizacao = localizacao;
    }


    public void atualizarCondicao(String novaCondicao) {
        this.condicaoAtual = novaCondicao;
        setChanged();
        notifyObservers(novaCondicao);
    }

    @Override
    public String toString() {
        return "EstacaoMeteorologica{" +
                "localizacao='" + localizacao + '\'' +
                ", condicaoAtual='" + condicaoAtual + '\'' +
                '}';
    }
}
