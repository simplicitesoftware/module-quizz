package com.simplicite.objects.Qualification;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

import com.simplicite.commons.Qualification.*;
import java.time.LocalDate;

/**
 * Business object QualUserExam
 */
public class QualUserExam extends ObjectDB {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void postLoad() {
		
		if(QualTool.isCandidate(getGrant())){
			setSearchSpec("qual_usrexam_usr_id = "+getGrant().getUserUniqueId());
			getField("qualUsrexamId").setVisibility(ObjectField.VIS_HIDDEN);
			getField("usr_login").setVisibility(ObjectField.VIS_HIDDEN);
		}
	}
	
	@Override
	public String getUserKeyLabel(String[] row) {
		String label = getFieldValue("qualUsrexamUsrId.usr_first_name") + " " + getFieldValue("qualUsrexamUsrId.usr_last_name") + " - " + getFieldValue("qualUsrexamExamId.qualExamName");
		return label;
	}
	
	@Override
	public List<String> preValidate() {
		List<String> msgs = new ArrayList<>();
		
		Grant g = getGrant();
		
		if(isNew() && !isTmpInstance()){
			String id = getFieldValue("qualUsrexamUsrId.usr_login")+"-"+getFieldValue("qualUsrexamExamId.qualExamName")+"-"+Tool.getCurrentDateTime();
			setFieldValue("qualUsrexamId", id);
		}
		
		if(!isNew()){
			if("DONE".equals(getFieldValue("qualUsrexamEtat")) || isExamOver(getFieldValue("qualUsrexamDateLimite"))){
				AppLog.info(getClass(), "preValidate", "EXAM IS OVER", getGrant());
				/*
				double score = calculateScore(getRowId());
				setFieldValue("qualUsrexamScore", score);
				setFieldValue("qualUsrexamEtat", "SCORED");
				*/
			}
			
			if("DONE".equals(getField("qualUsrexamEtat").getOldValue()) && "SCORED".equals(getField("qualUsrexamEtat").getValue())){
				double score = calculateScore(getRowId());
				setFieldValue("qualUsrexamScore", score);
				setFieldValue("qualUsrexamEtat", "SCORED");
			}
		}
		
		
		
		return msgs;
	}
	
	@Override
	public boolean isUpdateEnable(String[] row) {
		return !QualExUsr.isCandidate(getGrant());
	}
	
	@Override
	public String postCreate() {
		
		Grant g = getGrant();
		
		ObjectDB exExam = g.getTmpObject("QualExamEx");
		
		exExam.resetValues();
		exExam.setFieldFilter("qualExamexExamId", getFieldValue("qualUsrexamExamId"));
		List<String[]> rslts = exExam.search();
		
		for(String[] row : rslts){
			exExam.setValues(row, false);
			try{
				//createTestElement(exExam.getFieldValue("qualExamexExId"));
				createTestElement(exExam.getRowId());
			}
			catch(Exception e){
				AppLog.error(getClass(), "postCreate", "Error creating test element", e, getGrant());
			}
			
		}
		
		return null;
		
	}
	
	private double calculateScore(String testId){
		
		Grant g = getGrant();
		
		String ok = "select sum(qual_examex_score) from qual_ex_usr q join qual_exam_ex qex on q.QUAL_EXUSR_EXAMEX_ID = qex.row_id where qual_exusr_usrexam_id = '"+testId+"' and QUAL_EXUSR_CHECK='OK';";
		AppLog.info(ok, g);
		String total = "select sum(qual_examex_score) from qual_ex_usr q join qual_exam_ex qex on q.QUAL_EXUSR_EXAMEX_ID = qex.row_id where qual_exusr_usrexam_id = '"+testId+"';";
		AppLog.info(total, g);
		int totalScore = Integer.parseInt("".equals(g.simpleQuery(total)) ? "0" : g.simpleQuery(total));
		int okScore = Integer.parseInt("".equals(g.simpleQuery(ok)) ? "0" : g.simpleQuery(ok));

		return totalScore > 0 ? (okScore*100)/totalScore : 0;
		
	}
	
	
	public static boolean isExamOver(String endDate){
		if(!"".equals(endDate)){
			return LocalDate.parse(Tool.getCurrentDate()).isAfter(LocalDate.parse(endDate));
		}
			return false;
	}
	
	private void createTestElement(String exId) throws Exception{
		
			ObjectDB test = getGrant().getTmpObject("QualExUsr");
			test.setFieldValue("qualExusrUsrexamId", getRowId());
			test.setFieldValue("qualExusrExamexId", exId);
			BusinessObjectTool bot = new BusinessObjectTool(test);
			bot.validateAndCreate();
			
	}
	
}
