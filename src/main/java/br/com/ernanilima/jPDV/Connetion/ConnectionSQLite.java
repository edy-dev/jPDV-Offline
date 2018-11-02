package br.com.ernanilima.jPDV.Connetion;


import java.io.File;
import java.sql.*;

/**
 *
 * @author Ernani Lima
 */
public class ConnectionSQLite {

    /**
     * Arquivo SQLite referente a base de dados
     */
    protected static final File DB_JPDV = new File("dbjpdv.db");
    protected static final File DB_JPDV_PARAME = new File("parame.db");

    /**
     * Driver de conexao para banco de dados SQLite
     */
    private static final String DRIVER = "org.sqlite.JDBC";

    /**
     * Caminho para a base de dados
     */
    private static final String PATH_DB = "jdbc:sqlite:" + DB_JPDV.getPath();
    private static final String PATH_DB_PARAME = "jdbc:sqlite:" + DB_JPDV_PARAME.getPath();

    /**
     * @return Abrir conexao com base de dados
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(PATH_DB);
    }

    /**
     * @return Abrir conexao com base de dados que armazena os parametros de PDV
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static Connection openConnectionParame() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(PATH_DB_PARAME);
    }

    /**
     * Fechar Connection
     *
     * @param conn
     */
    public static void closeSQLite(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Fechar Connection e PreparedStatement
     *
     * @param conn
     * @param pst
     */
    public static void closeSQLite(Connection conn, PreparedStatement pst) {
        closeSQLite(conn);
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Fechar Connection, PreparedStatement e ResultSet
     *
     * @param conn
     * @param pst
     * @param rs
     */
    public static void closeSQLite(Connection conn, PreparedStatement pst, ResultSet rs) {
        closeSQLite(conn, pst);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
