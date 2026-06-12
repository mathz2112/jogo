/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import java.util.ArrayList;
import java.util.List;
import util.Local;

public class sistemaDialogo {

 private Local localAtual;
    private int dialogoAtual;

    public sistemaDialogo() {
        localAtual = Local.ENTRADA;
        dialogoAtual = 0;
    }

    public Local getLocalAtual() {
        return localAtual;
    }

    public void mudarLocal(Local local) {
        localAtual = local;
        dialogoAtual = 0;
    }

    public String getNomeAtual() {
        return "Você";
    }

    private List<String> getDialogos() {

        List<String> falas = new ArrayList<>();

        switch(localAtual) {

            case ENTRADA:

                falas.add("Já fazem semanas que a Pintas desapareceu e ninguém fez nada.");
                falas.add("Talvez olhando pelo campus eu consiga encontrar alguma pista.");
                falas.add("Sei que não é a melhor ideia entrar na escola tão tarde assim, mas o que de pior pode acontecer, né?");
                break;

            case BLOCO_A:

                falas.add("Um livro do governo? Posso usar para me defender.");
                falas.add("[Você encontrou o Livro do Governo]");
                break;

            case BLOCO_B:

                falas.add("Está trancado.");
                break;

            case BLOCO_C:

                falas.add("[Você se depara com um quero-quero raivoso]");
                falas.add("[BATALHA]");
                falas.add("[Você ganhou +50 XP]");
                falas.add("O que foi isso? Que bloco esquisito!");
                break;

            case BLOCO_D_SEGUNDO_ANDAR:

                falas.add("[Você encontrou um extintor de incêndio]");
                break;

            case CANTINA:

                falas.add("Aquelas são as gêmeas Lo e Ja? O que elas estão fazendo aqui?");
                break;

            case CAMINHO_BLOCO_E:

                falas.add("[Você se depara com uma coruja assustadora]");
                falas.add("[BATALHA]");
                falas.add("[Você ganhou +50 XP]");
                falas.add("O que foi isso? Que bloco esquisito!");
                break;
        }

        return falas;
    }

    public String getTextoAtual() {

        List<String> falas = getDialogos();

        if(dialogoAtual < falas.size()) {
            return falas.get(dialogoAtual);
        }

        return "Escolha para onde ir.";
    }

    public boolean terminouDialogo() {
        return dialogoAtual >= getDialogos().size();
    }

    public void proximoDialogo() {
        dialogoAtual++;
    }
}

