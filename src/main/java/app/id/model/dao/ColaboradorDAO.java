/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.id.model.dao;

/**
 *
 * @author
 */
public interface ColaboradorDAO <Colaborador> extends InterfaceDao <Colaborador> {
    public void alterarSenha(Colaborador colaborador);
}
