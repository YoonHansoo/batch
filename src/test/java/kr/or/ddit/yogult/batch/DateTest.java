package kr.or.ddit.yogult.batch;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.yogult.model.CycleVo;
import kr.or.ddit.yogult.model.DailyVo;

public class DateTest {
	private Logger logger = LoggerFactory.getLogger(DateTest.class);
	@Test
	public void test() throws ParseException {
		/***Given***/
		String ym = "201903";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		/***When***/
		Date stDate = sdf.parse(ym + "01"); //시작일자
		Calendar cal =Calendar.getInstance();
		cal.setTime(stDate);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //31
		Date eDate = sdf.parse(ym+lastDay);
		
		System.out.println(eDate);

		/***Then***/
		assertEquals("20190301", sdf.format(stDate));
		assertEquals("20190331", sdf.format(eDate));
	}
	
	@Test
	public void testDtWhile() throws ParseException{
		String ym = "201903";
		CycleVo cycleVo = new CycleVo();
		cycleVo.setCid(1);
		cycleVo.setPid(100);
		cycleVo.setDay(2);
		cycleVo.setCnt(2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date stDate = sdf.parse(ym+"01");
		Calendar cal = Calendar.getInstance();
		cal.setTime(stDate);
		
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		Date edDate = sdf.parse(ym+lastDay);
		
		//시작날짜, 종료날짜
		List<DailyVo> dailyVoList = new ArrayList<>();
		while(cal.getTimeInMillis() <= edDate.getTime()){
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			
			//애음주기 요일이랑 cal 날짜 요일이 같으면 일실적으로 생성할 대상
			if(dayOfWeek == cycleVo.getDay()){
				DailyVo dailyVO = new DailyVo();
				dailyVO.setCid(cycleVo.getCid());
				dailyVO.setPid(cycleVo.getPid());
				dailyVO.setDt(sdf.format(cal.getTime()));
				dailyVO.setCid(cycleVo.getCnt());
				dailyVoList.add(dailyVO);
			}
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		logger.debug("dailyVoList : {}", dailyVoList);
	}

}