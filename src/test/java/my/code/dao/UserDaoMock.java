package my.code.dao;

import java.util.HashMap;
import java.util.Map;

public class UserDaoMock extends UserDao {

    private Map<Integer, Boolean> asnwers = new HashMap<>();

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
