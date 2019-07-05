package u.auto.sys.annotation;
public enum Null {

	// #验证对象是否为null-限制只能为null
	// @Null(message = "@Null为空不能为空")
	// 值只能为null或者不传,传""都不行
	// 例如：{"my00":""}--错误
	// 例如：{"my00":null}或{}--正确
	NULL("@Null(message = {msg})"),
	// #验证对象是否不为null,无法查检长度为0的字符串-限制必须不为null
	// @NotNull(message = "@NotNull不能为空不能为空")
	// 例如：{"my01":null}--错误
	// 例如：{"my01":""}--正确
	// 例如：{"my01":" "}--正确
	// 例如：{"my01":"12"}--正确
	NOTNULL("@NotNull(message = {msg})"),
	// #检查约束元素是否为NULL或者是EMPTY.
	// @NotEmpty(message = "@NotEmpty不能为空不能为空")
	// 例如：{"my01":""}--错误
	// 例如：{"my01":" "}--正确
	// 例如：{"my01":"12"}--正确
	NOTEMPTY("@NotEmpty(message = {msg})"),
	// #检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.
	// @NotBlank(message = "@NotBlank不能为空不能为空")
	// 例如：{"my01":""}--错误
	// 例如：{"my01":" "}--错误
	// 例如：{"my01":"12"}--正确
	NOTBLANK("@NotBlank(message = {msg})");
	private String value;

	private Null(String value) {
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
