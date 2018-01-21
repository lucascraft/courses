package lambda3.conn;

public class ConnectionSetting implements Comparable<ConnectionSetting> {
	String type;
	String url;
	public ConnectionSetting(String type, String url)
	{
		this.type = type;
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public String getUrl() {
		return url;
	}
	@Override
	public int compareTo(ConnectionSetting o) {
		return (o.getType()+"###"+o.getUrl()).compareTo(type+"###"+url);
	}
}
