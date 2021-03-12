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
		
		if("DONE".equals(getFieldValue("qualUsrexamEtat")) || isExamOver(getFieldValue("qualUsrexamDateLimite"))){
			setFieldValue("qualUsrexamScore", calculateScore(getRowId()));
			setFieldValue("qualUsrexamEtat", "SCORED");
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
				createTestElement(exExam.getFieldValue("qualExamexExId"));
			}
			catch(Exception e){
				AppLog.error(getClass(), "postCreate", "Error creating test element", e, getGrant());
			}
			
		}
		
		return null;
		
	}
	
	private double calculateScore(String testId){
		
		Grant g = getGrant();
		
		int total = Integer.parseInt(g.simpleQuery("select count(*) from qual_ex_usr where qual_exusr_usrexam_id = '"+testId+"'"));
		int ok = Integer.parseInt(g.simpleQuery("select count(*) from qual_ex_usr where qual_exusr_check = 'OK' and qual_exusr_usrexam_id = '"+testId+"'"));

		return total > 0 ? (ok*20)/total : 0;
		
	}
	
	
	public static boolean isExamOver(String endDate){
		return LocalDate.parse(Tool.getCurrentDate()).isAfter(LocalDate.parse(endDate));
	}
	
	private void createTestElement(String exId) throws Exception{
		
			ObjectDB test = getGrant().getTmpObject("QualExUsr");
			test.setFieldValue("qualExusrUsrexamId", getRowId());
			test.setFieldValue("qualExusrExId", exId);
			BusinessObjectTool bot = new BusinessObjectTool(test);
			bot.validateAndCreate();
			
	}
	
}
