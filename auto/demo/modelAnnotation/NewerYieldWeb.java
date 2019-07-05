package u.frame.web.demotra.model;

import java.io.Serializable;
import java.sql.*;

/**
 * <br>
 * @ModelAnnotation<br>
 * @className：NewerYield<br> 
 * @auto-generated<br>
 */
public class NewerYieldWeb implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/* 新手结算id */
	@NotEmpty(message = "新手结算id")
	@Length(min = 0, max = 20, message = "新手结算id")
	private String newerYieldId;
	/* 用户id */
	@NotEmpty(message = "用户id")
	@Length(min = 0, max = 20, message = "用户id")
	private String memberId;
	/* 新手日结算id */
	@NotEmpty(message = "新手日结算id")
	@Length(min = 0, max = 20, message = "新手日结算id")
	private String newerYieldMainId;
	/* 房产id */
	@NotEmpty(message = "房产id")
	@Length(min = 0, max = 20, message = "房产id")
	private String houseBuyId;
	/* 流水号 */
	@NotEmpty(message = "流水号")
	@Length(min = 0, max = 20, message = "流水号")
	private String yieldOrderno;
	/* 本金 */
	private BigDecimal amount;
	/* 收益 */
	private BigDecimal interest;
	/* 总金额 */
	private BigDecimal total;
	/* 收益率 */
	private BigDecimal ratio;
	/* 本金支付日期 */
	private Timestamp buyDate;
	/* 还款支付日期 */
	private Timestamp payDate;
	/* 支付状态：0未付款；1已付款；2结算中；3已结算；4:转账中；5已转账；6:打款中；7已打款，交易成功；9失败 */
	@NotEmpty(message = "支付状态：0未付款；1已付款；2结算中；3已结算；4:转账中；5已转账；6:打款中；7已打款，交易成功；9失败")
	@Length(min = 0, max = 2, message = "支付状态：0未付款；1已付款；2结算中；3已结算；4:转账中；5已转账；6:打款中；7已打款，交易成功；9失败")
	private String status;
	/* 交易服务费 */
	private BigDecimal serverAmount;
	/* 标的id,house_id */
	@NotEmpty(message = "标的id,house_id")
	@Length(min = 0, max = 20, message = "标的id,house_id")
	private String houseId;
	/* 江西银行的--accountId--电子账号--投资人 */
	@NotEmpty(message = "江西银行的--accountId--电子账号--投资人")
	@Length(min = 0, max = 19, message = "江西银行的--accountId--电子账号--投资人")
	private String accountId;
	/* 江西银行--债权授权码--在江西银行那里的购买凭证 */
	@NotEmpty(message = "江西银行--债权授权码--在江西银行那里的购买凭证")
	@Length(min = 0, max = 20, message = "江西银行--债权授权码--在江西银行那里的购买凭证")
	private String authCode;
	/* 实际还款支付日期 */
	private Timestamp actualPayDate;

}
