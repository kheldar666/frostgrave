/*
 * Copyright (c) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.libermundi.frostgrave.domain.jpa.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.libermundi.frostgrave.domain.jpa.base.Identity;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public final class Picture extends Identity {

	private String contentType;

	@Lob
	private Byte[] data;

	public Picture() {}

}
