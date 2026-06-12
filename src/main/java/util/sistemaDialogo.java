/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import util.Local;

public class sistemaDialogo {

   private Local localAtual;
    private int dialogoAtual;

    public sistemaDialogo() {
        localAtual = Local.ENTRADA;
        dialogoAtual = 0;
    }

    public void proximoDialogo() {
        dialogoAtual++;
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

    public String getNomeAtual() {
        return "Voce";
    }

    public String getTextoAtual() {

        switch(localAtual) {

            case ENTRADA:

                switch(dialogoAtual) {

                    case 0:
                        return "Pintas desapareceu.";

                    case 1:
                        return "Preciso investigar o IFMS.";

                    case 2:
                        return "Por onde devo começar?";

                    default:
                        return "";
                }

            case BLOCO_A:
                return "Voce encontrou um Livro do Governo.";

            case BLOCO_B:
                return "A porta esta trancada.";

            case BLOCO_C:
                return "Um Quero-Quero bloqueia seu caminho.";

            case BLOCO_D_TERREO:
                return "Voce esta no terreo do Bloco D.";

            case BLOCO_D_SEGUNDO_ANDAR:
                return "Voce encontrou um extintor de incendio.";

            case CANTINA:
                return "Lo e Ja estao atendendo o caixa.";

            case CAMINHO_BLOCO_E:
                return "Uma coruja observa voce.";

            case BLOCO_E:
                return "O local parece abandonado.";

            case BLOCO_F:
                return "O Tio do Pastel sorri para voce.";

            case QUADRA:
                return "Ha varios objetos espalhados pela quadra.";

            case FLORESTA_AMORAS:
                return "Pintas esta presa!";

            default:
                return "";
        }
    }

    public String getOpcao1() {

        switch(localAtual) {

            case ENTRADA:

                if(dialogoAtual < 2)
                    return "Continuar";

                return "Bloco A";

            case BLOCO_B:
                return "Voltar";

            case BLOCO_D_TERREO:
                return "Cantina";

            case BLOCO_D_SEGUNDO_ANDAR:
                return "Voltar";

            case FLORESTA_AMORAS:
                return "Falar com Pintas";

            default:
                return "Continuar";
        }
    }

    public String getOpcao2() {

        switch(localAtual) {

            case ENTRADA:

                if(dialogoAtual < 2)
                    return "";

                return "Bloco B";

            case BLOCO_D_TERREO:
                return "2 Andar";

            default:
                return "";
        }
    }

    public void escolha1() {

        switch(localAtual) {

            case ENTRADA:

                if(dialogoAtual < 2) {
                    proximoDialogo();
                } else {
                    mudarLocal(Local.BLOCO_A);
                }
                break;

            case BLOCO_B:
                mudarLocal(Local.ENTRADA);
                break;

            case BLOCO_D_TERREO:
                mudarLocal(Local.CANTINA);
                break;

            case BLOCO_D_SEGUNDO_ANDAR:
                mudarLocal(Local.BLOCO_D_TERREO);
                break;
        }
    }

    public void escolha2() {

        switch(localAtual) {

            case ENTRADA:
                if(dialogoAtual >= 2) {
                    mudarLocal(Local.BLOCO_B);
                }
                break;

            case BLOCO_D_TERREO:
                mudarLocal(Local.BLOCO_D_SEGUNDO_ANDAR);
                break;
        }
    }
}

