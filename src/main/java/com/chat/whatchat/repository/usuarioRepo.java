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

public class usuarioRepo {
    private static usuarioRepo myself = null;

    private usuarioRepo() {

    }

    public static usuarioRepo getCurrentInstance() {
        if (myself == null) {
            myself = new usuarioRepo();
        }
        return myself;
    }

    public void create(usuario usr) throws SQLException {
        String sql = "insert into usuarios(nome, email, senha, usertag) values (?,?,?,?)";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);

            pstm.setString(1, usr.getNome());
            pstm.setString(2, usr.getEmail());
            pstm.setString(3, usr.getSenha());
            pstm.setString(4, usr.getUsertag());

            pstm.execute();
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(usuario usr) throws SQLException {
        String sql = "update usuarios set nome = ?, email = ?, senha = ?, usertag = ? where id=?";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, usr.getNome());
            pstm.setString(2, usr.getEmail());
            pstm.setString(3, usr.getSenha());
            pstm.setString(4, usr.getUsertag());
            pstm.setLong(5, usr.getId());

            pstm.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public usuario read(long id) throws SQLException {
        String sql = "select * from usuarios where ID=?";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);
            pstm.setLong(1, id);
            ResultSet result = pstm.executeQuery();

            if (result.next()) {
                usuario usr = new usuario();
                usr.setId(result.getLong("ID"));
                usr.setNome(result.getString("nome"));
                usr.setEmail(result.getString("email"));
                usr.setSenha(result.getString("senha"));
                usr.setUsertag(result.getString("usertag"));
                usr.setContatos(contatosRepo.getCurrentInstance().readContatos(result.getLong("ID")));
                return usr;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public usuario read(String field, String column) throws SQLException {
        String sql = "select * from usuarios where ";

        if (column.equals("email") || column.equals("usertag")) {
            sql += column + "=?";
        } else
            return null;

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, field);
            System.out.println(pstm);
            ResultSet result = pstm.executeQuery();

            if (result.next()) {
                usuario usr = new usuario();
                usr.setId(result.getLong("ID"));
                usr.setNome(result.getString("nome"));
                usr.setEmail(result.getString("email"));
                usr.setSenha(result.getString("senha"));
                usr.setUsertag(result.getString("usertag"));
                usr.setContatos(contatosRepo.getCurrentInstance().readContatos(result.getLong("ID")));
                return usr;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public void delete(long id) throws SQLException {
        String sql = "delete from usuarios where ID=?";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection()
                    .prepareStatement(sql);

            pstm.setLong(1, id);
            pstm.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<usuario> readAll() throws SQLException {
        String sql = "select * from usuarios";

        List<usuario> usuarios = new ArrayList<usuario>();
        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection()
            .prepareStatement(sql);

            ResultSet result = pstm.executeQuery();


            while(result.next()) {
                usuario usr = new usuario();
                usr.setId(result.getLong("ID"));
                usr.setNome(result.getString("nome"));
                usr.setEmail(result.getString("email"));
                usr.setSenha(result.getString("senha"));
                usr.setUsertag(result.getString("usertag"));
                usr.setContatos(contatosRepo.getCurrentInstance().readContatos(result.getLong("ID")));
                usuarios.add(usr);
            }
            return usuarios;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usuarioRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
