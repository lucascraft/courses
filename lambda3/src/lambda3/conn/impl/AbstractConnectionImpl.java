package lambda3.conn.impl;

import lambda3.conn.settings.IConnectionConnector;

public abstract class AbstractConnectionImpl implements IConnectionConnector
{
	
	/** url */
	protected String url;
	
	@Override
	public String getURL() {
		return url;
	}
	
	@Override
	public void setURL(String url) {
		this.url = url;
	}

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
