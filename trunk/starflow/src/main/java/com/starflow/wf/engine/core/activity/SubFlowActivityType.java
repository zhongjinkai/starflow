/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.starflow.wf.engine.core.activity;

import java.util.Date;

import com.starflow.wf.core.key.Keys;
import com.starflow.wf.core.util.PrimaryKeyUtil;
import com.starflow.wf.engine.StarFlowState;
import com.starflow.wf.engine.core.Constants;
import com.starflow.wf.engine.event.AbstractFlowEvent;
import com.starflow.wf.engine.model.ActivityInst;
import com.starflow.wf.engine.model.ProcessInstance;
import com.starflow.wf.engine.model.elements.ActivityXml;

/**
 * 
 * @author libinsong1204@gmail.com
 * @version 1.0
 */
public class SubFlowActivityType extends AbstractActivityType {

	public ActivityInst createActivity(AbstractFlowEvent event, ActivityXml activityXml) {
		String activityDefId = activityXml.getId();
		long processInstId = event.getProcessInstance().getProcessInstId();
		ActivityInst activityInst = this.findWaitingActInst(event, processInstId, activityDefId);
		if(activityInst != null)
			return activityInst;
		
		ProcessInstance procInst = event.getProcessInstance();

		activityInst = new ActivityInst();
		activityInst.setActivityDefId(activityDefId);
		activityInst.setActivityType(Constants.ACT_TYPE_SUBPROCESS);
		activityInst.setActivityInstName(activityXml.getName());
		activityInst.setDescription(activityXml.getDescription());
		activityInst.setCurrentState(StarFlowState.ACT_INST_WAITING);
		activityInst.setCreateTime(new Date());
		activityInst.setProcessInstId(procInst.getProcessInstId());
		
		long actInstId = PrimaryKeyUtil.getPrimaryKey(Keys.ACTIVITYINSTID);
		activityInst.setActivityInstId(actInstId);
		
		event.getActInstRep().inertActivityInst(activityInst);
		return activityInst;
	}

	public boolean isCompleteActivity(AbstractFlowEvent event, ActivityXml activityXml) {
		return true;
	}
}
