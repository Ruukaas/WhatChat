package com.chat.whatchat.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.chat.whatchat.dao.ConnectionDB;
import com.chat.whatchat.model.mensagem;

public class mensagemRepo {
    private static mensagemRepo myself = null;


    private mensagemRepo() {

    }

    public static mensagemRepo getCurrentInstance() {
        if(myself == null) {
            myself = new mensagemRepo();
        }
        return myself;
    }

    public void create(mensagem msg) throws SQLException {
        String sql = "insert into mensagens(send, mensagem, idSender, idReceiver) values (?,?,?,?)";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection()
                    .prepareStatement(sql);

                    
            pstm.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            pstm.setString(2, msg.getMensagem());
            pstm.setLong(3, msg.getIdSender());
            pstm.setLong(4, msg.getIdReceiver());

            pstm.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mensagemRepo.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void update(mensagem msg) throws SQLException {
        String sql = "update mensagens set mensagem = ?, idSender = ?, idReceiver = ? where id=?";

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);
            pstm.setString(1, msg.getMensagem());
            pstm.setLong(2, msg.getIdSender());
            pstm.setLong(3, msg.getIdReceiver());
            pstm.setLong(4, msg.getId());

            pstm.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mensagemRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public List<mensagem> readChat(long idSender, long idReceiver) throws SQLException {
        String sql = "select * from mensagens where idSender = ? and idReceiver = ?";
        List<mensagem> mensagens = new ArrayList<mensagem>();

        try {
            PreparedStatement pstm = ConnectionDB.getCurrentConnection().prepareStatement(sql);
            pstm.setLong(1, idSender);
            pstm.setLong(2, idReceiver);

            ResultSet result = pstm.executeQuery();

            while(result.next()) {
                mensagem msg = new mensagem();
                msg.setId(result.getLong("ID"));
                msg.setSend(result.getTimestamp("send").toLocalDateTime());
                msg.setMensagem(result.getString("mensagem"));
                msg.setIdSender(result.getLong("idSender"));
                msg.setIdReceiver(result.getLong("idReceiver"));
                mensagens.add(msg);
            }

            return mensagens;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mensagemRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }


}
