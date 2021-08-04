package training.internet.banking.repository;

import training.internet.banking.entity.Nasabah;
import training.internet.banking.helper.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NasabahRepositoryImpl implements NasabahRepository{
    private final String SQL_INSERT = "INSERT INTO nasabah (nama,email) values (?,?)";
    private final String SQL_SELECT_ALL = "SELECT * FROM nasabah";

    Connection connection;

    public boolean connect(){
        try {
           connection = DriverManager.getConnection(Config.JDBC_URL, Config.JDBC_USERNAME, Config.JDBC_PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean disconnect(){
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return true;
    }

    @Override
    public void insert(Nasabah nasabah) {
        try {
            connect();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setString(1, nasabah.getName());
            ps.setString(2, nasabah.getEmail());
            ps.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            disconnect();
        } catch (SQLException exception) {
            exception.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<Nasabah> getAll() {

        return null;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }
}
