package com.chat.whatchat.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.chat.whatchat.dao.ConnectionDB;
import com.chat.whatchat.model.usuario;

public class contatosRepo {

    private static contatosRepo myself = null;

    private contatosRepo() {

    }

    public static contatosRepo getCurrentInstance() {
        if (myself == null) {
            myself = new contatosRepo();
        }
        return myself;
    }

    public void create(long idDono, long idContato) {
        String sql = "insert into usuarioContato(donoID, contatoID) values ?,?";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);

            pstm.setLong(1, idDono);
            pstm.setLong(2, idContato);

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(long idDono, long idContato) {
        String sql = "update usuarioContato set donoID = ?, contatoID =? where donoID = ?";
        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);

            pstm.setLong(1, idDono);
            pstm.setLong(2, idContato);
            pstm.setLong(3, idDono);

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<usuario> readContatos(long idDono) {
        String sql = "select * from usuarioContato where donoID = ?";
        List<usuario> contatos = new ArrayList<usuario>();
        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection()
            .prepareStatement(sql);

            pstm.setLong(1, idDono);

            ResultSet result = pstm.executeQuery();


            while(result.next()) {
                usuario usr = usuarioRepo.getCurrentInstance().read(result.getLong("contatoID"));
                contatos.add(usr);
            }

            return contatos;
        }  catch (SQLException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void delete(long idDono, long idContato) {
        String sql = "delete from usuarioContato where donoID = ? and contatoID = ?";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);

            pstm.setLong(1, idDono);
            pstm.setLong(2, idContato);

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(contatosRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
