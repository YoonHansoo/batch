package kr.or.ddit.yogult.model;

public class CycleVo {
 private int cid; //고객번호
 private int pid; //제품번호
 private int day; //요일(일:1, 월:2 ... 토:7)
 private int cnt; //제품수량
 
 public CycleVo() {
	// TODO Auto-generated constructor stub
}

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

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public int getCnt() {
	return cnt;
}

public void setCnt(int cnt) {
	this.cnt = cnt;
}

@Override
public String toString() {
	return "CycleVo [cid=" + cid + ", pid=" + pid + ", day=" + day + ", cnt=" + cnt + "]";
}
 
 
}
