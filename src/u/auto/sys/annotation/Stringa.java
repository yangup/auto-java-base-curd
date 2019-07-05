package u.auto.sys.annotation;
public enum Stringa {

	// #验证 String 对象是否符合正则表达式的规则-限制必须符合指定的正则表达式
	// @Pattern(regexp = "\\d{8}", message = "@Pattern-正则表达式不能为空")
	PATTERN("@Pattern(regexp = {reg}, message = {msg})");
	private String value;

	private Stringa(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String ch(String reg, String msg) {
		return AnnotationUtil.change(this.value, reg, msg);
	}
}
