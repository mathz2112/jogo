package util;

import java.util.ArrayList;
import java.util.List;
import model.Estudante;
import static util.Local.BLOCO_A;
import static util.Local.BLOCO_B;
import static util.Local.BLOCO_C;
import static util.Local.BLOCO_D_HALL;
import static util.Local.BLOCO_D_SEGUNDO_ANDAR;
import static util.Local.BLOCO_E;
import static util.Local.BLOCO_F;
import static util.Local.CAMINHO_BLOCO_E;
import static util.Local.CANTINA;
import static util.Local.ENTRADA;
import static util.Local.FLORESTA_AMORAS;
import static util.Local.QUADRA;

public class sistemaDialogo {
    private Local localAtual;
    private List<Fala> falas;
    private int indice;

    public sistemaDialogo() {
        mudarLocal(Local.ENTRADA);
    }

    public Local getLocalAtual() {
        return localAtual;
    }

    public String getNomeAtual() {
        if (indice < falas.size()) {
            return falas.get(indice).getPersonagem();
        }
        return "";
    }

    public String getTextoAtual() {
        if (indice < falas.size()) {
            return falas.get(indice).getTexto();
        }
        return "";
    }

    public boolean terminouDialogo() {
        return indice >= falas.size();
    }

    public void proximoDialogo() {
        if (indice < falas.size()) {
            indice++;
        }
    }

    public int getIndice() {
        return indice;
    }

    public void mudarLocal(Local novoLocal) {
        this.localAtual = novoLocal;
        this.indice = 0;
        this.falas = new ArrayList<>();

        Estudante jogador = GameState.getInstance().getEstudanteAtual();
        boolean queroQueroDerrotado = GameState.getInstance().isQueroQueroDerrotado();

        switch (novoLocal) {
            case ENTRADA:
                falas.add(new Fala("Estudante", "Já faz semanas que a Pintas desapareceu, e ninguém fez nada."));
                falas.add(new Fala("Estudante", "Talvez, procurando pelo campus, eu consiga encontrar alguma pista."));
                falas.add(new Fala("Estudante", "Eu sei que não é a melhor ideia entrar na escola tão tarde, mas o que de pior pode acontecer, né?"));
                break;
            case BLOCO_A:
                if (jogador != null && jogador.possuiItem("Livro do Governo")) {
                    falas.add(new Fala("Estudante", "Já peguei o Livro do Governo aqui. Não há mais nada útil."));
                } else {
                    falas.add(new Fala("Estudante", "Um livro do governo? Talvez eu possa usar isso para me defender."));
                    falas.add(new Fala("[Aviso]", "Você encontrou o Livro do Governo! Ele foi adicionado ao seu inventário."));
                }
                break;
            case BLOCO_B:
                falas.add(new Fala("Estudante", "Está trancado."));
                break;
            case BLOCO_C:
                if (queroQueroDerrotado) {
                    falas.add(new Fala("Estudante", "O quero-quero fugiu daqui. O caminho está livre."));
                } else {
                    falas.add(new Fala("[Aviso]", "Você se depara com um quero-quero raivoso. Você tenta se afastar, mas ele é mais rápido."));
                    falas.add(new Fala("[Jogo]", "[INICIAR BATALHA]"));
                    falas.add(new Fala("[Aviso]", "Você ganhou +50 de XP"));
                    falas.add(new Fala("Estudante", "O que foi isso? Que bloco esquisito..."));
                }
                break;
            case BLOCO_D_HALL:
                falas.add(new Fala("Estudante", "Estou no hall do Bloco D. Para a esquerda fica a cantina, e as escadas levam ao segundo andar."));
                break;
            case CANTINA:
                falas.add(new Fala("Estudante", "Aquelas são as gêmeas Lo e Ja? O que elas estão fazendo aqui a essa hora?"));
                falas.add(new Fala("Lo e Ja", "Ei! Gostaria de comprar um brownie? Custa R$ 10."));
                falas.add(new Fala("Estudante", "Mas o que vocês estão fazendo aqui?"));
                falas.add(new Fala("Lo e Ja", "Vendendo brownies."));
                falas.add(new Fala("Estudante", "Mas por quê?"));
                falas.add(new Fala("Lo e Ja", "E por que não?"));
                break;
            case BLOCO_D_SEGUNDO_ANDAR:
                if (jogador != null && jogador.possuiItem("Extintor")) {
                    falas.add(new Fala("Estudante", "O corredor do segundo andar está vazio agora."));
                } else {
                    falas.add(new Fala("Estudante", "Um corredor escuro..."));
                    falas.add(new Fala("[Aviso]", "Você encontrou um extintor de incêndio. Ele foi adicionado ao seu inventário."));
                }
                break;
            case QUADRA:
                if (jogador != null && (jogador.possuiItem("Corda") || jogador.possuiItem("Rede de Vôlei"))) {
                    falas.add(new Fala("Estudante", "A quadra poliesportiva está deserta. Não há mais itens aqui."));
                } else {
                    falas.add(new Fala("[Aviso]", "Você encontrou uma corda e uma rede de vôlei. A rede de vôlei pode ser usada apenas uma vez para reduzir o dano do adversário."));
                }
                break;
            case BLOCO_E:
                falas.add(new Fala("[Aviso]", "O bloco está mergulhado na escuridão. De uma das janelas vem a única fonte de luz, revelando ao longe um sombrio bosque de amoras."));
                break;
            case CAMINHO_BLOCO_E:
                boolean corujaDerrotada = GameState.getInstance().isCorujaDerrotada();
                if (corujaDerrotada) {
                    falas.add(new Fala("Estudante", "O caminho para o Bloco F está desimpedido."));
                } else {
                    falas.add(new Fala("[Aviso]", "No meio do caminho escuro, uma silhueta com olhos amarelos gigantes plana até você... É a Coruja!"));
                    falas.add(new Fala("[Jogo]", "[INICIAR BATALHA]"));
                    falas.add(new Fala("[Aviso]", "Você ganhou +100 de XP pela vitória!"));
                    falas.add(new Fala("Estudante", "Essa passou perto! Devo continuar correndo para o Bloco F."));
                }
                break;
            case BLOCO_F:
                if (jogador != null && jogador.possuiItem("Pastel do Tio")) {
                    falas.add(new Fala("Estudante", "O portão do Bloco F está silencioso."));
                } else {
                    falas.add(new Fala("[Aviso]", "Logo à frente está o Tio do Pastel. Que surpresa encontrá-lo por aqui a essa hora."));
                    falas.add(new Fala("Estudante", "Por que todo mundo está vendendo coisas a essa hora?"));
                    falas.add(new Fala("Tio do Pastel", "Hoje só temos pastel de carne. Toma, garoto."));
                }
                break;
            case FLORESTA_AMORAS:
                falas.add(new Fala("Estudante", "Que lugar escuro... O quê? Aquela é... a Pintas?"));
                falas.add(new Fala("Pintas", "Ai, que bom que você me encontrou! Mas fala baixo, ou ele pode nos ouvir."));
                falas.add(new Fala("Estudante", "Ele quem?"));
                falas.add(new Fala("Capi", "Eu!"));
                falas.add(new Fala("Estudante", "É aquela capivara da UF?"));
                falas.add(new Fala("Capi", "Eu não sou 'aquela capivara da UF'. Eu sou a maior mascote de Campo Grande, e não vou deixar que essa oncinha roube o meu lugar."));
                falas.add(new Fala("[Jogo]", "[BATALHA FINAL]"));
                falas.add(new Fala("Pintas", "Muitíssimo obrigado estudante aleatório, agora vou poder voltar a animar as torcidas do IF e..."));
                falas.add(new Fala("Estudante", "Espera. Como você veio parar aqui?"));
                falas.add(new Fala("Pintas", "Bem, eu sempre soube que o Capi tinha muita inveja de mim, talvez por ser mais descolada ou realmente promover o espírito estudantil, é difícil dizer."));
                falas.add(new Fala("Pintas", "Eu estava tomando meu cafezinho na DIRER quando esse rato maluco me sequestrou e me prendeu aqui. Mas vamos sair daqui antes que ele acorde."));
                falas.add(new Fala("Estudante", "Espera, tudo isso conta como horas extracurriculares?"));
                falas.add(new Fala("[Jogo]", "[FIM DE JOGO]"));
                break;
        }
    }

    public List<Local> getDestinos() {
        List<Local> destinos = new ArrayList<>();
        if (localAtual == null) return destinos;

        switch (localAtual) {
            case ENTRADA:
                destinos.add(Local.BLOCO_A);
                destinos.add(Local.BLOCO_B);
                destinos.add(Local.BLOCO_C);
                break;
            case BLOCO_A:
                destinos.add(Local.BLOCO_B);
                destinos.add(Local.BLOCO_C);
                break;
            case BLOCO_B:
                destinos.add(Local.BLOCO_A);
                destinos.add(Local.BLOCO_C);
                break;
            case BLOCO_C:
                destinos.add(Local.BLOCO_D_HALL);
                break;
            case BLOCO_D_HALL:
                destinos.add(Local.CANTINA);
                destinos.add(Local.BLOCO_D_SEGUNDO_ANDAR);
                break;
            case CANTINA:
                destinos.add(Local.BLOCO_D_SEGUNDO_ANDAR);
                destinos.add(Local.QUADRA);
                destinos.add(Local.BLOCO_E);
                break;
            case BLOCO_D_SEGUNDO_ANDAR:
                destinos.add(Local.CANTINA);
                destinos.add(Local.QUADRA);
                destinos.add(Local.BLOCO_E);
                break;
            case QUADRA:
                destinos.add(Local.BLOCO_E);
                break;
            case BLOCO_E:
                destinos.add(Local.CAMINHO_BLOCO_E);
                break;
            case CAMINHO_BLOCO_E:
                destinos.add(Local.BLOCO_F);
                break;
            case BLOCO_F:
                destinos.add(Local.FLORESTA_AMORAS);
                break;
            default:
                break;
        }
        return destinos;
    }
}
