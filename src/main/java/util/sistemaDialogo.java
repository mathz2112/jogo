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
                        return "Dialogo de teste 1";

                    case 1:
                        return "Dialogo de teste 2";

                    case 2:
                        return "Para onde devo ir?";
                }

                break;

            case BLOCO_A:
                return "Dialogo temporario do Bloco A.";

            case BLOCO_B:
                return "Dialogo temporario do Bloco B.";

            case BLOCO_C:
                return "Dialogo temporario do Bloco C.";

            case BLOCO_D_TERREO:
                return "Dialogo temporario do Bloco D Terreo.";

            case BLOCO_D_SEGUNDO_ANDAR:
                return "Dialogo temporario do Bloco D Segundo Andar.";

            case CAMINHO_BLOCO_E:
                return "Dialogo temporario do Caminho para o Bloco E.";

            case BLOCO_E:
                return "Dialogo temporario do Bloco E.";

            case BLOCO_F:
                return "Dialogo temporario do Bloco F.";

            case QUADRA:
                return "Dialogo temporario da Quadra.";

            case FLORESTA_AMORAS:
                return "Dialogo temporario da Floresta de Amoras.";
        }

        return "";
    }

    public String getOpcao1() {

        switch(localAtual) {

            case ENTRADA:

                if(dialogoAtual < 2) {
                    return "Continuar";
                }

                return "Ir para o Bloco A";

            default:
                return "Continuar";
        }
    }
    
    public String getOpcao2() {

        switch(localAtual) {

            case ENTRADA:

                if(dialogoAtual < 2) {
                    return "";
                }

                return "Ir para o Bloco B";

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
        }
    }

    public void escolha2() {

        switch(localAtual) {

            case ENTRADA:

                if(dialogoAtual >= 2) {
                    mudarLocal(Local.BLOCO_B);
                }

                break;
        }
    }
}

