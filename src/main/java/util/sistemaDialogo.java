
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import java.util.ArrayList;
import java.util.List;

public class sistemaDialogo {

    private Local localAtual;
    private int dialogoAtual;
    private boolean introducaoConcluida;

    public sistemaDialogo() {
        localAtual = Local.ENTRADA;
        dialogoAtual = 0;
        introducaoConcluida = false;
    }

    public void proximoDialogo() {

        dialogoAtual++;

        if(localAtual == Local.ENTRADA &&
           dialogoAtual >= getDialogos().size()) {

            introducaoConcluida = true;
        }
    }

    public void mudarLocal(Local local) {
        localAtual = local;
        dialogoAtual = 0;
    }

    public Local getLocalAtual() {
        return localAtual;
    }

    public int getDialogoAtual() {
        return dialogoAtual;
    }

    public boolean terminouDialogo() {
        return dialogoAtual >= getDialogos().size();
    }

    public String getNomeAtual() {

        if(terminouDialogo()) {
            return "";
        }

        return getDialogos().get(dialogoAtual).getPersonagem();
    }

    public String getTextoAtual() {

        if(terminouDialogo()) {
            return "Escolha para onde deseja ir.";
        }

        return getDialogos().get(dialogoAtual).getTexto();
    }

    private List<Fala> getDialogos() {

        List<Fala> falas = new ArrayList<>();

        switch(localAtual) {

            case ENTRADA:

                if(introducaoConcluida) {
                    break;
                }

                falas.add(new Fala(
                        "Você",
                        "Já faz semanas que a Pintas desapareceu, e ninguém fez nada."
                ));

                falas.add(new Fala(
                        "Você",
                        "Talvez, procurando pelo campus, eu consiga encontrar alguma pista."
                ));

                falas.add(new Fala(
                        "Você",
                        "Eu sei que não é a melhor ideia entrar na escola tão tarde, mas o que de pior pode acontecer, né?"
                ));

                break;

            case BLOCO_A:

                falas.add(new Fala(
                        "Você",
                        "Um livro do governo? Talvez eu possa usar isso para me defender."
                ));

                falas.add(new Fala(
                        "",
                        "Você encontrou o Livro do Governo."
                ));

                break;

            case BLOCO_B:

                falas.add(new Fala(
                        "Você",
                        "Está trancado."
                ));

                break;

            case BLOCO_C:

                falas.add(new Fala(
                        "",
                        "Você se depara com um quero-quero raivoso. Você tenta se afastar, mas ele é mais rápido."
                ));

                falas.add(new Fala(
                        "",
                        "[INICIAR BATALHA]"
                ));

                falas.add(new Fala(
                        "",
                        "Você ganhou +50 de XP."
                ));

                falas.add(new Fala(
                        "Você",
                        "O que foi isso? Que bloco esquisito..."
                ));

                break;

            case BLOCO_D_HALL:

                falas.add(new Fala(
                        "Você",
                        "Para onde eu devo ir?"
                ));

                break;

            case BLOCO_D_SEGUNDO_ANDAR:

                falas.add(new Fala(
                        "",
                        "Você encontrou um extintor de incêndio."
                ));

                break;

            case CANTINA:

                falas.add(new Fala(
                        "Você",
                        "Aquelas são as gêmeas Lo e Ja? O que elas estão fazendo aqui a essa hora?"
                ));

                falas.add(new Fala(
                        "Lo e Ja",
                        "Ei! Gostaria de comprar um brownie? Custa 20 reais."
                ));

                falas.add(new Fala(
                        "Você",
                        "Mas o que vocês estão fazendo aqui?"
                ));

                falas.add(new Fala(
                        "Lo e Ja",
                        "Vendendo brownies."
                ));

                falas.add(new Fala(
                        "Você",
                        "Mas por quê?"
                ));

                falas.add(new Fala(
                        "Lo e Ja",
                        "E por que não?"
                ));

                falas.add(new Fala(
                        "",
                        "Você comprou um brownie. Coma-o para recuperar +20 de vida."
                ));

                break;

            case QUADRA:

                falas.add(new Fala(
                        "",
                        "Você encontrou a rede de vôlei. Ela pode ser usada uma única vez para reduzir o dano do adversário."
                ));

                break;

            case CAMINHO_BLOCO_E:

                falas.add(new Fala(
                        "",
                        "Você se depara com uma coruja assustadora. Você tenta se afastar, mas ela é mais rápida."
                ));

                falas.add(new Fala(
                        "",
                        "[INICIAR BATALHA]"
                ));

                falas.add(new Fala(
                        "",
                        "Você ganhou +50 de XP."
                ));

                falas.add(new Fala(
                        "Você",
                        "O que foi isso? Que bloco esquisito..."
                ));

                break;

            case BLOCO_E:

                falas.add(new Fala(
                        "",
                        "O bloco está mergulhado na escuridão. De uma das janelas vem a única fonte de luz, revelando ao longe um sombrio bosque de amoras."
                ));

                break;

            case BLOCO_F:

                falas.add(new Fala(
                        "",
                        "Logo à frente está o Tio do Pastel, do lado de fora das grades do IF."
                ));

                falas.add(new Fala(
                        "Você",
                        "Por que todo mundo está vendendo coisas a essa hora?"
                ));

                falas.add(new Fala(
                        "Tio do Pastel",
                        "Hoje só temos pastel de carne. Vinte reais."
                ));

                falas.add(new Fala(
                        "",
                        "Vida totalmente recuperada."
                ));

                break;

            case FLORESTA_AMORAS:

                falas.add(new Fala(
                        "Você",
                        "Que lugar escuro... O quê? Aquela é... a Pintas?"
                ));

                falas.add(new Fala(
                        "Pintas",
                        "Ai, que bom que você me encontrou! Mas fala baixo, ou ele pode nos ouvir."
                ));

                falas.add(new Fala(
                        "Você",
                        "Ele quem?"
                ));

                falas.add(new Fala(
                        "Capi",
                        "Eu!"
                ));

                falas.add(new Fala(
                        "Você",
                        "É aquela capivara da UF?"
                ));

                falas.add(new Fala(
                        "Capi",
                        "Eu não sou aquela capivara da UF. Eu sou a maior mascote de Campo Grande e não vou deixar que essa oncinha roube meu lugar."
                ));

                falas.add(new Fala(
                        "",
                        "[BATALHA FINAL]"
                ));

                falas.add(new Fala(
                        "Pintas",
                        "Muito obrigado, estudante aleatório."
                ));

                falas.add(new Fala(
                        "Você",
                        "Espera. Como você veio parar aqui?"
                ));

                falas.add(new Fala(
                        "Pintas",
                        "Eu sempre soube que o Capi tinha inveja de mim."
                ));

                falas.add(new Fala(
                        "Pintas",
                        "Eu estava tomando café na DIRER quando esse maluco me sequestrou."
                ));

                falas.add(new Fala(
                        "Você",
                        "Espero que tudo isso conte como horas extracurriculares."
                ));

                falas.add(new Fala(
                        "",
                        "[FIM DE JOGO]"
                ));

                break;
        }

        return falas;
    }

    public String getOpcao1() {

        switch(localAtual) {

            case ENTRADA:
                return "Ir para Bloco A";

            case BLOCO_A:
            case BLOCO_B:
                return "Voltar";

            case BLOCO_D_HALL:
                return "Ir para Cantina";

            default:
                return "";
        }
    }

    public String getOpcao2() {

        switch(localAtual) {

            case ENTRADA:
                return "Ir para Bloco B";

            case BLOCO_D_HALL:
                return "Ir para 2º Andar";

            default:
                return "";
        }
    }

    public void escolha1() {

        switch(localAtual) {

            case ENTRADA:
                mudarLocal(Local.BLOCO_A);
                break;

            case BLOCO_A:
            case BLOCO_B:
                mudarLocal(Local.ENTRADA);
                break;

            case BLOCO_D_HALL:
                mudarLocal(Local.CANTINA);
                break;
        }
    }

    public void escolha2() {

        switch(localAtual) {

            case ENTRADA:
                mudarLocal(Local.BLOCO_B);
                break;

            case BLOCO_D_HALL:
                mudarLocal(Local.BLOCO_D_SEGUNDO_ANDAR);
                break;
        }
    }
}

    


