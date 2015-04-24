/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.codegen.php.views;

import com.speedment.codegen.base.Generator;
import com.speedment.codegen.base.Transform;
import com.speedment.codegen.lang.models.modifiers.Modifier;
import java.util.Optional;

/**
 *
 * @author Emil Forslund
 */
public class ModifierView implements Transform<Modifier, String> {

	@Override
	public Optional<String> transform(Generator gen, Modifier model) {
		final String result;
		
		switch (model) {
			case PUBLIC :		result = "public"; break;
			case PROTECTED :	result = "protected"; break;
			case PRIVATE :		result = "private"; break;
			case ABSTRACT :		result = "abstract"; break;
			case FINAL :		result = "const"; break;
			case STATIC :		result = "static"; break;
			default :			result = null; break;
		}
		
		return Optional.ofNullable(result);
	}
	
}