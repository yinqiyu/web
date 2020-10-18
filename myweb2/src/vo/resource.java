package vo;

public class resource {
	private int resourceID;
	private String resourceName;
	private  String url;
	
	public resource(int resourceID, String resourceName, String url) {
			super();
			this.resourceID = resourceID;
			this.resourceName = resourceName;
			this.url = url;
		}


	public resource() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getResourceID() {
		return resourceID;
	}
	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public  String getUrl() {
		return url;
	}
	public  void setUrl(String url) {
		this.url = url;
	}
	


}
