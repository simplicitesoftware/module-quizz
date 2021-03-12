package com.simplicite.commons.Qualification;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Shared code QualTool
 */
public class QualTool implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


	public static boolean isCandidate(Grant g){
		return g.hasResponsibility("QUAL_CANDIDATE") && !g.hasResponsibility("QUAL_ADMIN");
	}
	
}
