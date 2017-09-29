/*
 * Copyright (C) 2017 Thamtech, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thamtech.gwt.pojobuilder.client;

/**
 * Base class providing {@link Object java.lang.Object's} clone
 * method.
 *
 * GWT does not support the clone() method and will throw an error if a
 * class tries to declare one with an {@code @Override} annotation.
 * Such classes may extend this class so that the GWT compiler
 * accepts the override annotation.
 *
 * @author Tyler Ham {@literal <tyler@thamtech.com>}
 */
public class NotCloneableObject {
	/**
	 * Only throws CloneNotSupportedException.
	 *
	 * Child implementations should not call this method.
	 *
	 * @throws CloneNotSupportedException always
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
