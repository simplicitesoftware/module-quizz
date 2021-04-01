package com.simplicite.extobjects.Qualification;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import org.json.*;
import com.simplicite.webapp.web.*;
/**
 * External object QualPostTraining
 */
public class QualPostTraining extends ExternalObject {
	private static final long serialVersionUID = 1L;

	/**
	 * Display method
	 * @param params Request parameters
	*/
	@Override
	public String display(Parameters params) {
		try {
			Grant g = getGrant();
					
			boolean pub = isPublic();
			setDecoration(!pub);
			
			String token = params.getParameter("token");
			
			String userId = g.simpleQuery("select row_id from m_user where qual_usr_token = '"+token+"'");
			
			ObjectDB examEx = g.getTmpObject("QualExamEx");
			examEx.resetValues();
			examEx.resetFilters();
			
			String examId = "";
			String userExam = "";
			boolean generic = false;
			
			if("".equals(userId)){
				//USER TOKEN IS UNKNOWN - HANDLE
			}
			else{
				if("GEN".equals(g.simpleQuery("select qual_usr_typedutilisateur from m_user where row_id = "+userId))){
					//CHECK IF USER IS GENERIC -> IF SO, QST IS GENERATED AUTOMATICALLY
					userExam = g.simpleQuery("select qual_usr_tests from m_user where row_id = "+userId);
					generic = true;
				}
				else{
					//IF USER ISN'T GENERIC TESTS W
					userExam = g.simpleQuery("select qual_usr_tests from m_user where row_id = "+userId);
				}
			}
			
			JSONArray exams = new JSONArray();
			for(String exType : userExam.split(";")){
				examId = g.simpleQuery("select row_id from qual_exam where qual_ex_type = '"+exType+"'");
				String examName = g.simpleQuery("select qual_exam_name from qual_exam where row_id = '"+examId+"'");
				JSONObject exam = new JSONObject();
				JSONArray qsts = new JSONArray();
				if(!"".equals(examId)){
					examEx.setFieldFilter("qualExamexExamId", examId);
					
					for(String[] row : examEx.search()){
						
						examEx.setValues(row);
						JSONObject qst = new JSONObject();
						qst.put("examTitle", examEx.getFieldValue("qualExamexExamId.qualExamName"));
						qst.put("title", examEx.getFieldValue("qualExamexExId.qualExQuestion"));
						qst.put("type", examEx.getFieldValue("qualExamexExId.qualExAnswerType"));
						qst.put("enum", examEx.getFieldValue("qualExamexExId.qualExChoicesEnumeration"));
						qst.put("id", examEx.getFieldValue("qualExamexExId.qualExId"));
						qsts.put(qst);
						
					}
					
					JSONObject end = new JSONObject();
					end.put("type", "END_QST");
					qsts.put(end);
					
					exam.put("questions", qsts);
					exam.put("examTitle", examName);
				}
				exams.put(exam);
			}
						
			String template = HTMLTool.getResourceHTMLContent(this, "QUAL_TEMPLATE");
			JSONObject renderParams = params.toJSONObject().put("pub", pub).put("exams", exams);
			
			renderParams.put("generic", generic);
			renderParams.put("examId", examId);
			renderParams.put("userId", userId);
			
			String render = getName() + ".render(" + renderParams.toString() +",'"+template.replaceAll("(\\r|\\n|\\r\\n)+", "\\\\n")+ "');";
			if (pub) { // Public page version (standalone Bootstrap page)
				BootstrapWebPage wp = new BootstrapWebPage(params.getRoot(), getDisplay());
				wp.setFavicon(HTMLTool.getResourceIconURL(this, "FAVICON"));
				wp.appendAjax(true);
				wp.appendVue();
				wp.appendJSInclude(HTMLTool.getResourceJSURL(this, "SCRIPT"));
				wp.appendCSSInclude(HTMLTool.getResourceCSSURL(this, "STYLES"));
				wp.append(HTMLTool.getResourceHTMLContent(this, "HTML"));
				
				
				wp.setReady(render);
				return wp.toString();
			} else { // Private page version
				appendVue();
				return javascript(render);
			}
		} catch (Exception e) {
			AppLog.error(getClass(), "display", null, e, getGrant());
			return e.getMessage();
		}
	} 
}
