package u.auto.sys.annotation;
public enum Date {
	// #验证 Date 和 Calendar 对象是否在当前时间之前-限制必须是一个过去的日期
	// @Past(message = "@Past一定为过去的时间不能为空")
	PAST("@Past(message = {msg}"),
	// #验证 Date 和 Calendar 对象是否在当前时间之后-限制必须是一个将来的日期
	// @Future(message = "@Future一定为未来的时间不能为空")
	FUTURE("@Future(message = {msg})");
	private String value;

	private Date(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value.toString();

	}

	public String ch(String msg) {
		return AnnotationUtil.change(this.value, msg);
	}
}
