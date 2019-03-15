package kr.or.ddit.yogult.model;

public class DailyVo {
	 private int cid; //고객번호
	 private int pid; //제품번호
	 private String dt; //실적일자(일:1, 월:2 ... 토:7)
	 private int cnt; //제품수량
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getCnt() {
		return cnt;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "DailyVO [cid=" + cid + ", pid=" + pid + ", dt=" + dt + ", cnt=" + cnt + "]";
	}
}
