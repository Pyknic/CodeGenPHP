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

import com.speedment.codegen.lang.models.Enum;
import com.speedment.codegen.base.Generator;
import com.speedment.codegen.base.Transform;
import com.speedment.codegen.lang.models.EnumConstant;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 *
 * @author Emil Forslund
 */
public class EnumConstantView implements Transform<EnumConstant, String> {

	@Override
	public Optional<String> transform(Generator gen, EnumConstant model) {
		return Optional.of(
			"const " + model.getName() + " = " + constantId(gen, model)
		);
	}
	
	private int constantId(Generator gen, EnumConstant model) {
		final Supplier<IllegalArgumentException> ex = () -> new IllegalArgumentException(
			"Specified constant is not located in any 'Enum' model in the " +
			"current render stack."
		);
		
		final List<EnumConstant> enumeration = gen.getRenderStack()
			.fromBottom(Enum.class)
			.findFirst()
			.orElseThrow(ex)
			.getConstants();
		
		for (int i = 0; i < enumeration.size(); i++) {
			if (model.equals(enumeration.get(i))) {
				return i;
			}
		}
		
		throw new IllegalArgumentException(
			"Specified constant could not be found in current Enum."
		);
	}
	
}
