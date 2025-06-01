package observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void deveReceberNotificacao() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("São Paulo");
        Usuario usuario = new Usuario("Maria");

        usuario.registrarEm(estacao);
        estacao.atualizarCondicao("Tempestade a caminho");

        assertEquals("Maria, novo alerta meteorológico: Tempestade a caminho", usuario.obterUltimaMensagem());
    }

    @Test
    public void deveNotificarMultiplosUsuarios() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("Rio de Janeiro");
        Usuario usuario1 = new Usuario("Ana");
        Usuario usuario2 = new Usuario("Bruno");

        usuario1.registrarEm(estacao);
        usuario2.registrarEm(estacao);

        estacao.atualizarCondicao("Frente fria se aproximando");

        assertEquals("Ana, novo alerta meteorológico: Frente fria se aproximando", usuario1.obterUltimaMensagem());
        assertEquals("Bruno, novo alerta meteorológico: Frente fria se aproximando", usuario2.obterUltimaMensagem());
    }

    @Test
    public void naoDeveReceberNotificacaoSeNaoInscrito() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("Porto Alegre");
        Usuario usuario = new Usuario("Carlos");


        estacao.atualizarCondicao("Dia ensolarado");

        assertNull(usuario.obterUltimaMensagem());
    }

    @Test
    public void deveAtualizarMensagemQuandoNotificadoNovamente() {
        EstacaoMeteorologica estacao = new EstacaoMeteorologica("Curitiba");
        Usuario usuario = new Usuario("Diana");

        usuario.registrarEm(estacao);

        estacao.atualizarCondicao("Vento forte");
        assertEquals("Diana, novo alerta meteorológico: Vento forte", usuario.obterUltimaMensagem());

        estacao.atualizarCondicao("Granizo previsto");
        assertEquals("Diana, novo alerta meteorológico: Granizo previsto", usuario.obterUltimaMensagem());
    }
}
