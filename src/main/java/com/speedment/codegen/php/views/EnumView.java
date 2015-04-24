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

import static com.speedment.codegen.Formatting.dnl;
import static com.speedment.codegen.Formatting.scnl;
import com.speedment.codegen.base.Generator;
import com.speedment.codegen.lang.models.Enum;
import com.speedment.codegen.java.views.ClassOrInterfaceView;
import com.speedment.codegen.php.views.traits.HasModifiersView;
import static java.util.stream.Collectors.joining;


/**
 *
 * @author Emil Forslund
 */
public class EnumView extends ClassOrInterfaceView<Enum> 
	implements HasModifiersView<Enum> {
	
    @Override
	protected String renderDeclarationType() {
		return "class";
	}

	@Override
	public String extendsOrImplementsInterfaces() {
		return "implements";
	}

	@Override
	protected String renderSupertype(Generator cg, Enum model) {
		return "";
	}

	@Override
	protected String onBeforeFields(Generator gen, Enum model) {
		return gen.onEach(model.getConstants())
			.collect(joining(scnl()));
	}

    @Override
    protected String renderConstructors(Generator cg, Enum model) {
        return cg.onEach(model.getConstructors())
            .collect(joining(dnl()));
    }
	
	@Override
	public String renderModifiers(Generator cg, Enum model) {
		return HasModifiersView.super.renderModifiers(cg, model);
	}
}