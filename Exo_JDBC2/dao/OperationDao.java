package org.example.Exo_JDBC2.dao;

import org.example.Exo_JDBC2.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OperationDao extends BaseDaoExo2c<Operation>{


    protected OperationDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean createOp(Operation element) throws SQLException {
        request = "INSERT INTO operations (op_amount,op_status, op_acc_id) values (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1,element.getOp_amount());
        statement.setString(2,element.getOp_status());
        statement.setInt(2,element.getOp_acc_id());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setOp_acc_id(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean updateOp(Operation element) throws SQLException {
        return false;
    }

    @Override
    public Operation get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Operation> get() throws SQLException {
        return List.of();
    }
}

// je suis arrivé ici vendredi 23/5