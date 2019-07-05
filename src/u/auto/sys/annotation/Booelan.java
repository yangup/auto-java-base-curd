package u.auto.sys.annotation;
/**
 * u.auto.sys.annotation.Booelan.java<br>
 * Description： 已经验证了<br>
 *
 * @author YangPu
 * @createTime 2017年4月25日 上午10:14:58
 */
public enum Booelan {

	// 只能为true
	// #验证对象是否为null-限制只能为null
	// @AssertTrue(message = "@AssertTrue一定为true不能为空")
	TRUE("@AssertTrue(message = {msg})"),
	// 只能为false
	// #验证对象是否为null-限制只能为null
	// @AssertFalse(message = "@AssertFalse一定为false不能为空")
	FALSE("@AssertFalse(message = {msg})");
	private String value;

	private Booelan(String value) {
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
