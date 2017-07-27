package example;


import example.dao.ACCDAO;
import example.entity.ACC;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Collection;

import static org.junit.Assert.*;

public class ACCDAOTestCase {

    private ACCDAO accDao;

    @Before
    public void init() {
        accDao = new ACCDAO();
    }

    @Test
    public void findAccTest() throws SQLException {
        Collection<ACC> accList = accDao.findAcc();

        assertNotNull(accList);
        assertTrue(!accList.isEmpty());
        assertEquals(3933, accList.size());
    }

    @Test
    public void findAccByAccIdTest() throws SQLException {
        ACC acc = accDao.findAccByAccId(1L);

        assertNotNull(acc);
        assertEquals(1L, (long) acc.getAccId());
        assertEquals("oagis-id-e311c9e573804722876febb3239fc1ac", acc.getGuid());
        assertEquals("Any Structured Content", acc.getObjectClassTerm());
        assertEquals("Any Structured Content. Details", acc.getDen());
        assertEquals(null, acc.getBasedAccId());
    }
}
