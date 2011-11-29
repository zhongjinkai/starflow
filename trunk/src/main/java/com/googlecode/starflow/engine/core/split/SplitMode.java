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

package com.googlecode.starflow.engine.core.split;

import java.util.List;

import com.googlecode.starflow.engine.event.AbstractFlowEvent;
import com.googlecode.starflow.engine.model.ActivityInst;
import com.googlecode.starflow.engine.model.elements.ActivityElement;

/**
 * 
 * @author libinsong1204@gmail.com
 * @version 1.0
 */
public interface SplitMode {
	/**
	 * 根据当前环节查找的的所有分支。过滤去满足条件的分支。并生成环节实例返回
	 * @return
	 */
	public List<ActivityInst> createNextActInsts(AbstractFlowEvent event, List<ActivityElement> activityXmls);
}
