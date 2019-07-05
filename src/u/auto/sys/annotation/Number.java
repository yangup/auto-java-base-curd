package u.auto.sys.annotation;
public enum Number {

	// #数值检查：建议使用在Stirng,Integer类型，不建议使用在int类型上，因为表单值为“”时无法转换为int，但可以转换为Stirng为"",Integer为null
	// #验证 Number 和 String 对象是否大等于指定的值-限制必须为一个不大于指定值的数字
	// @Min(value = 2L, message = "@Min-2-最小值不能为空")
	min("@Min(value = {val}, message = {msg})"),
	// #验证 Number 和 String 对象是否小等于指定的值-限制必须为一个不小于指定值的数字
	// @Max(value = 4L, message = "@Max-4-最大值不能为空")
	max("@Max(value = {val}, message = {msg})"),
	// #被标注的值必须不大于约束中指定的最大值.
	// 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度-限制必须为一个不大于指定值的数字
	// @DecimalMin(value = "2", message = "@DecimalMin-2-最小值不能为空")
	dMax("@DecimalMin(value = {val}, message = {smg})"),

	// #被标注的值必须不小于约束中指定的最小值.
	// 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度-限制必须为一个不小于指定值的数字<br>
	// @DecimalMax(value = "4", message = "@DecimalMax-4-最大值不能为空")
	dMin("@DecimalMax(value = {val}, message = {msg})"),

	// #验证 Number 和 String 的构成是否合法
	// #@Digits(integer=,fraction=)
	// 验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。-限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction
	// @Digits(integer = 5, fraction = 2, message = "@Digits-5,2-值不能为空")
	digits("@Digits(integer = {int}, fraction = {fra}, message = {msg})");
	private String value;

	private Number(String value) {
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

	public String ch(String... msg) {
		return AnnotationUtil.change(this.value, msg);
	}

}
