package example.dao;

import example.ConnectionManager;
import example.entity.ACC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ACCDAO extends AbstractDAO {

    public Collection<ACC> findAcc() throws SQLException {
        String statement = "SELECT ACC_ID, GUID, OBJECT_CLASS_TERM, DEN, BASED_ACC_ID FROM ACC ORDER BY ACC_ID ASC";

        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ACC> accList = new ArrayList();

        try {
            conn = connectionManager.getConnection();
            ps = conn.prepareStatement(statement);
            rs = ps.executeQuery();

            while (rs.next()) {
                ACC acc = createAccFrom(rs);
                accList.add(acc);
            }
        } finally {
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(conn);
        }

        return accList;
    }

    public ACC findAccByAccId(Long accId) throws SQLException {
        String statement = "SELECT ACC_ID, GUID, OBJECT_CLASS_TERM, DEN, BASED_ACC_ID FROM ACC WHERE ACC_ID = ?";

        ConnectionManager connectionManager = ConnectionManager.getInstance();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ACC acc = null;
        try {
            conn = connectionManager.getConnection();
            ps = conn.prepareStatement(statement);
            int parameterIndex = 1;
            ps.setLong(parameterIndex++, accId);
            rs = ps.executeQuery();

            if (rs.next()) {
                acc = createAccFrom(rs);
            }
        } finally {
            closeQuietly(rs);
            closeQuietly(ps);
            closeQuietly(conn);
        }

        return acc;
    }

    private ACC createAccFrom(ResultSet rs) throws SQLException {
        ACC acc = new ACC();

        long accId = rs.getLong("ACC_ID");
        acc.setAccId(accId);

        String guid = rs.getString("GUID");
        acc.setGuid(guid);

        String objectClassTerm = rs.getString("OBJECT_CLASS_TERM");
        acc.setObjectClassTerm(objectClassTerm);

        String den = rs.getString("DEN");
        acc.setDen(den);

        long basedAccId = rs.getLong("BASED_ACC_ID");
        if (basedAccId > 0L) {
            acc.setBasedAccId(basedAccId);
        }

        return acc;
    }
}
