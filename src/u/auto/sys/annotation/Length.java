package u.auto.sys.annotation;
public enum Length {

	// #验证对象（Array,Collection,Map,String）长度是否在给定的范围之内-限制字符长度必须在min到max之间
	// @Size(min = 2, max = 4, message = "@Size长度,2-4不能为空")
	SIZE("@Size(min = {min}, max = {max}, message = {msg})"),
	// #验证字符串的长度是否在给定的范围之内，包含两端
	// @Length(min = 2, max = 4, message = "@Length长度2-5不能为空")
	LENGTH("@Length(min = {min}, max = {max}, message = {msg})");
	private String value;

	private Length(String value) {
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

	public String ch(int min, int max, String msg) {
		return AnnotationUtil.changeInt(this.value, msg, min, max);
	}

	public String ch(int min, String max, String msg) {
		// 2147483647
		// 4294967295
		int maxInt = 0;
		if (("" + Integer.MAX_VALUE).compareTo(max) < 0) {
			maxInt = Integer.MAX_VALUE;
		} else {
			maxInt = Integer.valueOf(max);
		}
		return AnnotationUtil.changeInt(this.value, msg, min, maxInt);
	}

}
