package u.frame.web.demotra.model;

import java.io.Serializable;
import java.sql.*;

import u.frame.common.CommonEntity;

/**
 * <br>
 * @Do<br>
 * @className：NewerYield<br> 
 * @auto-generated<br>
 */
public class NewerYield extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/* 新手结算id */
	private String newerYieldId;
	/* 用户id */
	private String memberId;
	/* 新手日结算id */
	private String newerYieldMainId;
	/* 房产id */
	private String houseBuyId;
	/* 流水号 */
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
	private String status;
	/* 交易服务费 */
	private BigDecimal serverAmount;
	/* 标的id,house_id */
	private String houseId;
	/* 江西银行的--accountId--电子账号--投资人 */
	private String accountId;
	/* 江西银行--债权授权码--在江西银行那里的购买凭证 */
	private String authCode;
	/* 实际还款支付日期 */
	private Timestamp actualPayDate;

	public NewerYield() {

	}
	
	public String getNewerYieldId() {
		return newerYieldId;
	}

	public void setNewerYieldId(String newerYieldId) {
		this.newerYieldId = newerYieldId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getNewerYieldMainId() {
		return newerYieldMainId;
	}

	public void setNewerYieldMainId(String newerYieldMainId) {
		this.newerYieldMainId = newerYieldMainId;
	}

	public String getHouseBuyId() {
		return houseBuyId;
	}

	public void setHouseBuyId(String houseBuyId) {
		this.houseBuyId = houseBuyId;
	}

	public String getYieldOrderno() {
		return yieldOrderno;
	}

	public void setYieldOrderno(String yieldOrderno) {
		this.yieldOrderno = yieldOrderno;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}

	public Timestamp getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Timestamp buyDate) {
		this.buyDate = buyDate;
	}

	public Timestamp getPayDate() {
		return payDate;
	}

	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getServerAmount() {
		return serverAmount;
	}

	public void setServerAmount(BigDecimal serverAmount) {
		this.serverAmount = serverAmount;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public Timestamp getActualPayDate() {
		return actualPayDate;
	}

	public void setActualPayDate(Timestamp actualPayDate) {
		this.actualPayDate = actualPayDate;
	}

}
