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

package com.starflow.wf.engine.transaction;

import org.springframework.transaction.TransactionStatus;

/**
 * 
 * @author  libinsong1204@gmail.com
 * @date    2011-1-7
 * @version 
 */
public abstract class TransactionCallbackWithoutResult implements TransactionCallback<Object> {

	@Override
	public final Object doInTransaction(TransactionStatus status) {
		doInTransactionWithoutResult(status);
		return null;
	}

	protected abstract void doInTransactionWithoutResult(TransactionStatus status);
}
