package mvc.control;

public class ActionForward {
	private String url; 		//啊具且 其捞瘤林家
	private boolean redirect;	//啊绰规过true : redirect / false : forward
	
	public ActionForward() {
	}
	public ActionForward(String url) {
		this.url = url;
	}
	public ActionForward(String url, boolean redirect) {
		this.url = url;
		this.redirect = redirect;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}	
	
}
