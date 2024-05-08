package modelResponse;

public class Error {
	
	private int returN;
	private String code;
	private String message;
	private String detail;
	
	
	public int getReturN() {
		return returN;
	}
	public void setReturN(int returN) {
		this.returN = returN;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
