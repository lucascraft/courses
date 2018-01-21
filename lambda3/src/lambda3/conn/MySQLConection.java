package lambda3.conn;

import lambda3.cfg.IConectionManager;

public class MySQLConection implements IConectionManager {

	@Override
	public boolean connect() {
		return false;
	}

	@Override
	public boolean close() {
		return false;
	}

}
