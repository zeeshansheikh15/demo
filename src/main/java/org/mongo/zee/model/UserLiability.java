package org.mongo.zee.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "liability")
public class UserLiability {

	@Indexed
	private String id;

	@Indexed
	private String userid;
	
	@Indexed
	private String dealerid;
	
	@Indexed
	private String masterid;
	
	@Indexed
	private String adminid;
	@Indexed
	private String sstid;
	
	@Indexed
	private int sportid;
	
	@Indexed
	private String date;
	private Double totalpnl;
	
	private Double totalfancyStake;
	private Double liability;
	
	private String runnerid;
	
	@Indexed
	private String marketid;
	
	@Indexed
	private int matchid;
	
	@Indexed
	private String fancyid;
	
	private String fancyname;
	
	@Indexed
	private String type;
	
	private int selection1;
	
	private BigDecimal adminpartnership;
	
	private BigDecimal masterpartnership;
	
	private BigDecimal dealerpartnership;
	
	private BigDecimal sstpartnership;

	
	private int selection2;
	
	
	private int selection3;
	
	private int selection4;
	
	private Double pnl1;
	
	
	private Double pnl2;
	
	
	private Double pnl3;
	private Double pnl4;
	@Indexed
	private Date createdon;
	
	private String matchname;
	
	@Indexed
	private Boolean isactive;
	
	
	private Double netpnl;
	
	private Double adminpnl1;

	private Double dealerpnl1;
	
	private Double sstpnl1;
	
	private Double masterpnl1;
	
	private Double adminpnl2;
	
	private Double dealerpnl2;
	
	private Double sstpnl2;
	
	private Double masterpnl2;
	
	private Double adminpnl3;
	
	private Double dealerpnl3;
	
	private Double sstpnl3;
	
	private Double masterpnl3;
	
	private Double adminpnl;
	
	private Double dealerpnl;
	
	private Double sstpnl;
	
	private Double masterpnl;
	
	private Double adminfancypnl;
	
	private Double dealerfancypnl;
	
	private Double sstfancypnl;
	
	private Double masterfancypnl;
	
	private Double usercommission;
	
	private Double dealercommission;
	
	private Double sstcommission;
	
	private Double mastercommission;
	
	private Double userfancycommission;
	
	private Double dealerfancycommission;
	
	private Double sstfancycommission;
		
	private Double masterfancycommission;
	
	private Double userFancyPnl;
	
	private Integer betcount;
	
	private Integer cheatBetBundle;
	
//	private ArrayList<EXMultiLiability> multiliab;
	
	private Double resultLiability;
	
	private String adminuserid;
	private String sstuserid;
	private String masteruserid;
	private String dealeruserid;
	
	private Boolean isSstSettled;
	
	private Boolean isMasterSettled;
	
	private Boolean isDealerSettled;
	private String resultName;
	
	private Boolean isUserSettled;
	
	private String username;
	
	private String adminUsername;
	
	private String sstUsername;
	
	private String masterUsername;
	private String dealerUsername;
	private String declared;
	
//	private ArrayList<ExFancyBook> fancyLiab;
//	private ArrayList<ExFancyBook> adminfancyLiab;
//	private ArrayList<ExFancyBook> sstfancyLiab;
//	private ArrayList<ExFancyBook> dealerfancyLiab;
//	private ArrayList<ExFancyBook> masterfancyLiab;
	private Double ssttotalCommission;
	private Double sstfancytotalCommission;
	
	private Double sstotalCommission;
	private Double ssfancytotalCommission;
	
	private Double satotalCommission;
	private Double safancytotalCommission;
	
	
	private Double usertotalCommission;
	private Double userfancytotalCommission;
	
	private Double sstFancyComValue;
	private Double masterFancyComValue;
	private Double dealerFancyComValue;
	private Double userFancyComValue;
	@Indexed
	private Boolean isSuspended;
	
	@Indexed
	private String resultid;
	
	private String result;
	
	
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultid() {
		return resultid;
	}

	public void setResultid(String resultid) {
		this.resultid = resultid;
	}

	public Double getResultLiability() {
		return resultLiability;
	}

	public void setResultLiability(Double resultLiability) {
		this.resultLiability = resultLiability;
	}

	public String getSstid() {
		return sstid;
	}

	public void setSstid(String sstid) {
		this.sstid = sstid;
	}

	public BigDecimal getSstpartnership() {
		return sstpartnership;
	}

	public void setSstpartnership(BigDecimal sstpartnership) {
		this.sstpartnership = sstpartnership;
	}


	public Double getNetpnl() {
		return netpnl;
	}

	public void setNetpnl(Double netpnl) {
		this.netpnl = netpnl;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Double getLiability() {
		return liability;
	}

	public void setLiability(Double liability) {
		this.liability = liability;
	}

	public String getMarketid() {
		return marketid;
	}

	public void setMarketid(String marketid) {
		this.marketid = marketid;
	}

	public int getSelection1() {
		return selection1;
	}

	public void setSelection1(int selection1) {
		this.selection1 = selection1;
	}

	public int getSelection2() {
		return selection2;
	}

	public void setSelection2(int selection2) {
		this.selection2 = selection2;
	}

	public int getSelection3() {
		return selection3;
	}

	public void setSelection3(int selection3) {
		this.selection3 = selection3;
	}

	public Double getPnl1() {
		return pnl1;
	}

	public void setPnl1(Double pnl1) {
		this.pnl1 = pnl1;
	}

	public Double getPnl2() {
		return pnl2;
	}

	public void setPnl2(Double pnl2) {
		this.pnl2 = pnl2;
	}

	public Double getPnl3() {
		return pnl3;
	}

	public void setPnl3(Double pnl3) {
		this.pnl3 = pnl3;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFancyid() {
		return fancyid;
	}

	public void setFancyid(String fancyid) {
		this.fancyid = fancyid;
	}

	public String getDealerid() {
		return dealerid;
	}

	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}

	public String getMasterid() {
		return masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public int getSportid() {
		return sportid;
	}

	public void setSportid(int sportid) {
		this.sportid = sportid;
	}

	public Double getTotalpnl() {
		return totalpnl;
	}

	public void setTotalpnl(Double totalpnl) {
		this.totalpnl = totalpnl;
	}

	public String getMatchname() {
		return matchname;
	}

	public void setMatchname(String matchname) {
		this.matchname = matchname;
	}

	public BigDecimal getAdminpartnership() {
		return adminpartnership;
	}

	public void setAdminpartnership(BigDecimal adminpartnership) {
		this.adminpartnership = adminpartnership;
	}

	public BigDecimal getMasterpartnership() {
		return masterpartnership;
	}

	public void setMasterpartnership(BigDecimal masterpartnership) {
		this.masterpartnership = masterpartnership;
	}

	public BigDecimal getDealerpartnership() {
		return dealerpartnership;
	}

	public void setDealerpartnership(BigDecimal dealerpartnership) {
		this.dealerpartnership = dealerpartnership;
	}

	public int getMatchid() {
		return matchid;
	}

	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}

//	public ArrayList<EXMultiLiability> getMultiliab() {
//		return multiliab;
//	}
//
//	public void setMultiliab(ArrayList<EXMultiLiability> multiliab) {
//		this.multiliab = multiliab;
//	}

	public Integer getBetcount() {
		return betcount;
	}

	public void setBetcount(Integer betcount) {
		this.betcount = betcount;
	}

	public Integer getCheatBetBundle() {
		return cheatBetBundle;
	}

	public void setCheatBetBundle(Integer cheatBetBundle) {
		this.cheatBetBundle = cheatBetBundle;
	}

	public Double getAdminpnl1() {
		return adminpnl1;
	}

	public void setAdminpnl1(Double adminpnl1) {
		this.adminpnl1 = adminpnl1;
	}

	public Double getDealerpnl1() {
		return dealerpnl1;
	}

	public void setDealerpnl1(Double dealerpnl1) {
		this.dealerpnl1 = dealerpnl1;
	}

	public Double getSstpnl1() {
		return sstpnl1;
	}

	public void setSstpnl1(Double sstpnl1) {
		this.sstpnl1 = sstpnl1;
	}

	public Double getMasterpnl1() {
		return masterpnl1;
	}

	public void setMasterpnl1(Double masterpnl1) {
		this.masterpnl1 = masterpnl1;
	}

	public Double getAdminpnl2() {
		return adminpnl2;
	}

	public void setAdminpnl2(Double adminpnl2) {
		this.adminpnl2 = adminpnl2;
	}

	public Double getDealerpnl2() {
		return dealerpnl2;
	}

	public void setDealerpnl2(Double dealerpnl2) {
		this.dealerpnl2 = dealerpnl2;
	}

	public Double getSstpnl2() {
		return sstpnl2;
	}

	public void setSstpnl2(Double sstpnl2) {
		this.sstpnl2 = sstpnl2;
	}

	public Double getMasterpnl2() {
		return masterpnl2;
	}

	public void setMasterpnl2(Double masterpnl2) {
		this.masterpnl2 = masterpnl2;
	}

	public Double getAdminpnl3() {
		return adminpnl3;
	}

	public void setAdminpnl3(Double adminpnl3) {
		this.adminpnl3 = adminpnl3;
	}

	public Double getDealerpnl3() {
		return dealerpnl3;
	}

	public void setDealerpnl3(Double dealerpnl3) {
		this.dealerpnl3 = dealerpnl3;
	}

	public Double getSstpnl3() {
		return sstpnl3;
	}

	public void setSstpnl3(Double sstpnl3) {
		this.sstpnl3 = sstpnl3;
	}

	public Double getMasterpnl3() {
		return masterpnl3;
	}

	public void setMasterpnl3(Double masterpnl3) {
		this.masterpnl3 = masterpnl3;
	}
//
//	public ArrayList<ExFancyBook> getFancyLiab() {
//		return fancyLiab;
//	}
//
//	public void setFancyLiab(ArrayList<ExFancyBook> fancyLiab) {
//		this.fancyLiab = fancyLiab;
//	}

//	public ArrayList<ExFancyBook> getAdminfancyLiab() {
//		return adminfancyLiab;
//	}
//
//	public void setAdminfancyLiab(ArrayList<ExFancyBook> adminfancyLiab) {
//		this.adminfancyLiab = adminfancyLiab;
//	}

//	public ArrayList<ExFancyBook> getSstfancyLiab() {
//		return sstfancyLiab;
//	}
//
//	public void setSstfancyLiab(ArrayList<ExFancyBook> sstfancyLiab) {
//		this.sstfancyLiab = sstfancyLiab;
//	}

//	public ArrayList<ExFancyBook> getDealerfancyLiab() {
//		return dealerfancyLiab;
//	}
//
//	public void setDealerfancyLiab(ArrayList<ExFancyBook> dealerfancyLiab) {
//		this.dealerfancyLiab = dealerfancyLiab;
//	}

//	public ArrayList<ExFancyBook> getMasterfancyLiab() {
//		return masterfancyLiab;
//	}
//
//	public void setMasterfancyLiab(ArrayList<ExFancyBook> masterfancyLiab) {
//		this.masterfancyLiab = masterfancyLiab;
//	}

	public String getRunnerid() {
		return runnerid;
	}

	public void setRunnerid(String runnerid) {
		this.runnerid = runnerid;
	}

	public Double getAdminpnl() {
		return adminpnl;
	}

	public void setAdminpnl(Double adminpnl) {
		this.adminpnl = adminpnl;
	}

	public Double getDealerpnl() {
		return dealerpnl;
	}

	public void setDealerpnl(Double dealerpnl) {
		this.dealerpnl = dealerpnl;
	}

	public Double getSstpnl() {
		return sstpnl;
	}

	public void setSstpnl(Double sstpnl) {
		this.sstpnl = sstpnl;
	}

	public Double getMasterpnl() {
		return masterpnl;
	}

	public void setMasterpnl(Double masterpnl) {
		this.masterpnl = masterpnl;
	}

	public Double getAdminfancypnl() {
		return adminfancypnl;
	}

	public void setAdminfancypnl(Double adminfancypnl) {
		this.adminfancypnl = adminfancypnl;
	}

	public Double getDealerfancypnl() {
		return dealerfancypnl;
	}

	public void setDealerfancypnl(Double dealerfancypnl) {
		this.dealerfancypnl = dealerfancypnl;
	}

	public Double getSstfancypnl() {
		return sstfancypnl;
	}

	public void setSstfancypnl(Double sstfancypnl) {
		this.sstfancypnl = sstfancypnl;
	}

	public Double getMasterfancypnl() {
		return masterfancypnl;
	}

	public void setMasterfancypnl(Double masterfancypnl) {
		this.masterfancypnl = masterfancypnl;
	}

	public Double getUsercommission() {
		return usercommission;
	}

	public void setUsercommission(Double usercommission) {
		this.usercommission = usercommission;
	}

	public Double getDealercommission() {
		return dealercommission;
	}

	public void setDealercommission(Double dealercommission) {
		this.dealercommission = dealercommission;
	}

	public Double getSstcommission() {
		return sstcommission;
	}

	public void setSstcommission(Double sstcommission) {
		this.sstcommission = sstcommission;
	}

	public Double getMastercommission() {
		return mastercommission;
	}

	public void setMastercommission(Double mastercommission) {
		this.mastercommission = mastercommission;
	}

	public Double getUserfancycommission() {
		return userfancycommission;
	}

	public void setUserfancycommission(Double userfancycommission) {
		this.userfancycommission = userfancycommission;
	}

	public Double getDealerfancycommission() {
		return dealerfancycommission;
	}

	public void setDealerfancycommission(Double dealerfancycommission) {
		this.dealerfancycommission = dealerfancycommission;
	}

	public Double getSstfancycommission() {
		return sstfancycommission;
	}

	public void setSstfancycommission(Double sstfancycommission) {
		this.sstfancycommission = sstfancycommission;
	}

	public Double getMasterfancycommission() {
		return masterfancycommission;
	}

	public void setMasterfancycommission(Double masterfancycommission) {
		this.masterfancycommission = masterfancycommission;
	}

	public Double getUserFancyPnl() {
		return userFancyPnl;
	}

	public void setUserFancyPnl(Double userFancyPnl) {
		this.userFancyPnl = userFancyPnl;
	}

	public String getAdminuserid() {
		return adminuserid;
	}

	public void setAdminuserid(String adminuserid) {
		this.adminuserid = adminuserid;
	}

	public String getSstuserid() {
		return sstuserid;
	}

	public void setSstuserid(String sstuserid) {
		this.sstuserid = sstuserid;
	}

	public String getMasteruserid() {
		return masteruserid;
	}

	public void setMasteruserid(String masteruserid) {
		this.masteruserid = masteruserid;
	}

	public String getDealeruserid() {
		return dealeruserid;
	}

	public void setDealeruserid(String dealeruserid) {
		this.dealeruserid = dealeruserid;
	}

	public Boolean getIsSstSettled() {
		return isSstSettled;
	}

	public void setIsSstSettled(Boolean isSstSettled) {
		this.isSstSettled = isSstSettled;
	}

	public Boolean getIsMasterSettled() {
		return isMasterSettled;
	}

	public void setIsMasterSettled(Boolean isMasterSettled) {
		this.isMasterSettled = isMasterSettled;
	}

	public Boolean getIsDealerSettled() {
		return isDealerSettled;
	}

	public void setIsDealerSettled(Boolean isDealerSettled) {
		this.isDealerSettled = isDealerSettled;
	}

	public Boolean getIsUserSettled() {
		return isUserSettled;
	}

	public void setIsUserSettled(Boolean isUserSettled) {
		this.isUserSettled = isUserSettled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getSstUsername() {
		return sstUsername;
	}

	public void setSstUsername(String sstUsername) {
		this.sstUsername = sstUsername;
	}

	public String getMasterUsername() {
		return masterUsername;
	}

	public void setMasterUsername(String masterUsername) {
		this.masterUsername = masterUsername;
	}

	public String getDealerUsername() {
		return dealerUsername;
	}

	public void setDealerUsername(String dealerUsername) {
		this.dealerUsername = dealerUsername;
	}

	public Double getSsttotalCommission() {
		return ssttotalCommission;
	}

	public void setSsttotalCommission(Double ssttotalCommission) {
		this.ssttotalCommission = ssttotalCommission;
	}

	public Double getSstfancytotalCommission() {
		return sstfancytotalCommission;
	}

	public void setSstfancytotalCommission(Double sstfancytotalCommission) {
		this.sstfancytotalCommission = sstfancytotalCommission;
	}

	public Double getSstotalCommission() {
		return sstotalCommission;
	}

	public void setSstotalCommission(Double sstotalCommission) {
		this.sstotalCommission = sstotalCommission;
	}

	public Double getSsfancytotalCommission() {
		return ssfancytotalCommission;
	}

	public void setSsfancytotalCommission(Double ssfancytotalCommission) {
		this.ssfancytotalCommission = ssfancytotalCommission;
	}

	public Double getSatotalCommission() {
		return satotalCommission;
	}

	public void setSatotalCommission(Double satotalCommission) {
		this.satotalCommission = satotalCommission;
	}

	public Double getSafancytotalCommission() {
		return safancytotalCommission;
	}

	public void setSafancytotalCommission(Double safancytotalCommission) {
		this.safancytotalCommission = safancytotalCommission;
	}

	public Double getUsertotalCommission() {
		return usertotalCommission;
	}

	public void setUsertotalCommission(Double usertotalCommission) {
		this.usertotalCommission = usertotalCommission;
	}

	public Double getUserfancytotalCommission() {
		return userfancytotalCommission;
	}

	public void setUserfancytotalCommission(Double userfancytotalCommission) {
		this.userfancytotalCommission = userfancytotalCommission;
	}

	public Double getSstFancyComValue() {
		return sstFancyComValue;
	}

	public void setSstFancyComValue(Double sstFancyComValue) {
		this.sstFancyComValue = sstFancyComValue;
	}

	public Double getMasterFancyComValue() {
		return masterFancyComValue;
	}

	public void setMasterFancyComValue(Double masterFancyComValue) {
		this.masterFancyComValue = masterFancyComValue;
	}

	public Double getDealerFancyComValue() {
		return dealerFancyComValue;
	}

	public void setDealerFancyComValue(Double dealerFancyComValue) {
		this.dealerFancyComValue = dealerFancyComValue;
	}

	public Double getUserFancyComValue() {
		return userFancyComValue;
	}

	public void setUserFancyComValue(Double userFancyComValue) {
		this.userFancyComValue = userFancyComValue;
	}

	public Boolean getIsSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(Boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public String getDeclared() {
		return declared;
	}

	public void setDeclared(String declared) {
		this.declared = declared;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getFancyname() {
		return fancyname;
	}

	public void setFancyname(String fancyname) {
		this.fancyname = fancyname;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public Double getTotalfancyStake() {
		return totalfancyStake;
	}

	public void setTotalfancyStake(Double totalfancyStake) {
		this.totalfancyStake = totalfancyStake;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSelection4() {
		return selection4;
	}

	public void setSelection4(int selection4) {
		this.selection4 = selection4;
	}

	public Double getPnl4() {
		return pnl4;
	}

	public void setPnl4(Double pnl4) {
		this.pnl4 = pnl4;
	}
	
}
