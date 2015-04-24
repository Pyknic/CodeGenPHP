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

import com.speedment.codegen.lang.models.Method;
import com.speedment.codegen.base.Generator;
import com.speedment.codegen.base.Transform;
import com.speedment.codegen.java.views.interfaces.HasCodeView;
import com.speedment.codegen.java.views.interfaces.HasFieldsView;
import com.speedment.codegen.java.views.interfaces.HasJavadocView;
import com.speedment.codegen.java.views.interfaces.HasNameView;
import com.speedment.codegen.php.views.traits.HasModifiersView;
import java.util.Optional;

/**
 *
 * @author Emil Forslund
 */
public class MethodView implements Transform<Method, String>, HasJavadocView<Method>,
	HasModifiersView<Method>, HasNameView<Method>, HasFieldsView<Method>,
	HasCodeView<Method> {

	@Override
	public Optional<String> transform(Generator gen, Method model) {
		return Optional.of(
			renderJavadoc(gen, model) +
			renderModifiers(gen, model) +
			"function " +
			renderName(gen, model) + "(" +
			renderFields(gen, model) + ") " + 
			renderCode(gen, model)
		);
	}

	@Override
	public String fieldSeparator() {
		return ", ";
	}
}