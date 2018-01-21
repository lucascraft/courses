package lambda3.conn.impl;

import lambda3.conn.IConnectionConnector;

public class HiveConnectionImpl implements IConnectionConnector {

	@Override
	public boolean connect(String url) {
		return false;
	}

	@Override
	public boolean close() {
		return false;
	}

	@Override
	public byte[] read() {
		return null;
	}

	@Override
	public void write(byte[] bytes) {
		
	}
	
}
