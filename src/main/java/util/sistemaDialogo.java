/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

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

}

