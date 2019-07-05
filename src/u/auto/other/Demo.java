//package com.momfo.manger.modelf;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.util.List;
//
//import javax.validation.constraints.AssertFalse;
//import javax.validation.constraints.AssertTrue;
//import javax.validation.constraints.DecimalMax;
//import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.Digits;
//import javax.validation.constraints.Future;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Null;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//
///**
// * @Model<br>
// * @className：ProjectInfo<br>
// * @auto-generated<br>
// */
//public class Demo implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Null(message = "@Null为空不能为空")
//	private String my00;
//
//	@NotNull(message = "@NotNull不能为空不能为空")
//	private String my01;
//
//	@NotBlank(message = "@NotBlank不能为空不能为空")
//	private String my02;
//
//	@NotEmpty(message = "@NotEmpty不能为空不能为空")
//	private String my03;
//
//	@AssertTrue(message = "@AssertTrue一定为true不能为空")
//	private Boolean my04;
//
//	@AssertFalse(message = "@AssertFalse一定为false不能为空")
//	private Boolean my05;
//
//	@Size(min = 2, max = 4, message = "@Size长度,2-4不能为空")
//	private List<String> my06;
//
//	@Length(min = 2, max = 4, message = "@Length长度2-5不能为空")
//	private String my07;
//
//	@Past(message = "@Past一定为过去的时间不能为空")
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private Date my08;
//
//	@Future(message = "@Future一定为未来的时间不能为空")
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private Date my09;
//
//	@Pattern(regexp = "\\d{8}", message = "@Pattern-正则表达式不能为空")
//	private String my10;
//
//	@Min(value = 2L, message = "@Min-2-最小值不能为空")
//	private Integer my11;
//
//	@Max(value = 4L, message = "@Max-4-最大值不能为空")
//	private Integer my12;
//
//	@DecimalMin(value = "2", message = "@DecimalMin-2-最小值不能为空")
//	private BigDecimal my13;
//
//	@DecimalMax(value = "4", message = "@DecimalMax-4-最大值不能为空")
//	private BigDecimal my14;
//
//	@Digits(integer = 5, fraction = 2, message = "@Digits-5,2-值不能为空")
//	private BigDecimal my15;
//
//	public String getMy00() {
//		return my00;
//	}
//
//	public String getMy01() {
//		return my01;
//	}
//
//	public String getMy02() {
//		return my02;
//	}
//
//	public String getMy03() {
//		return my03;
//	}
//
//	public Boolean getMy04() {
//		return my04;
//	}
//
//	public Boolean getMy05() {
//		return my05;
//	}
//
//	public List<String> getMy06() {
//		return my06;
//	}
//
//	public String getMy07() {
//		return my07;
//	}
//
//	public Date getMy08() {
//		return my08;
//	}
//
//	public Date getMy09() {
//		return my09;
//	}
//
//	public String getMy10() {
//		return my10;
//	}
//
//	public Integer getMy11() {
//		return my11;
//	}
//
//	public Integer getMy12() {
//		return my12;
//	}
//
//	public BigDecimal getMy13() {
//		return my13;
//	}
//
//	public BigDecimal getMy14() {
//		return my14;
//	}
//
//	public BigDecimal getMy15() {
//		return my15;
//	}
//
//	public void setMy00(String my00) {
//		this.my00 = my00;
//	}
//
//	public void setMy01(String my01) {
//		this.my01 = my01;
//	}
//
//	public void setMy02(String my02) {
//		this.my02 = my02;
//	}
//
//	public void setMy03(String my03) {
//		this.my03 = my03;
//	}
//
//	public void setMy04(Boolean my04) {
//		this.my04 = my04;
//	}
//
//	public void setMy05(Boolean my05) {
//		this.my05 = my05;
//	}
//
//	public void setMy06(List<String> my06) {
//		this.my06 = my06;
//	}
//
//	public void setMy07(String my07) {
//		this.my07 = my07;
//	}
//
//	public void setMy08(Date my08) {
//		this.my08 = my08;
//	}
//
//	public void setMy09(Date my09) {
//		this.my09 = my09;
//	}
//
//	public void setMy10(String my10) {
//		this.my10 = my10;
//	}
//
//	public void setMy11(Integer my11) {
//		this.my11 = my11;
//	}
//
//	public void setMy12(Integer my12) {
//		this.my12 = my12;
//	}
//
//	public void setMy13(BigDecimal my13) {
//		this.my13 = my13;
//	}
//
//	public void setMy14(BigDecimal my14) {
//		this.my14 = my14;
//	}
//
//	public void setMy15(BigDecimal my15) {
//		this.my15 = my15;
//	}
//
//}
