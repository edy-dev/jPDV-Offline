package br.com.ernanilima.jPDV.Dao;

import br.com.ernanilima.jPDV.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.ernanilima.jPDV.Connetion.ConnectionSQLite.closeSQLite;
import static br.com.ernanilima.jPDV.Connetion.ConnectionSQLite.openConnectionParame;

/**
 *
 * @author Ernani Lima
 */
public class UserDao {

    /**
     * Metodo para realizar login de usuario
     * @param mUser
     * @return se login foi bem sucedido ou nao
     */
    public boolean userLogin(User mUser) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tabuser WHERE user_id = ? AND user_senha = ?";

        try {
            conn = openConnectionParame();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, mUser.getId());
            pst.setString(2, mUser.getPwd());

            rs = pst.executeQuery();

            if (rs.next()) {
                mUser.setId(rs.getInt("user_id"));
                mUser.setName(rs.getString("user_nome"));
                mUser.setLevel(rs.getInt("user_nivel"));
                return true;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO AO ABRIR CONEXAO COM PARAME: " + e);
        } catch (SQLException e) {
            System.out.println("ERRO AO REALIZAR LOGIN DE USUARIO: " + e);
        } finally {
            closeSQLite(conn);
        }
        return false;
    }
}