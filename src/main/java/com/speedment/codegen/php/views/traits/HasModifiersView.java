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
package com.speedment.codegen.php.views.traits;

import static com.speedment.codegen.Formatting.EMPTY;
import static com.speedment.codegen.Formatting.SPACE;
import com.speedment.codegen.base.Generator;
import com.speedment.codegen.base.Transform;
import com.speedment.codegen.lang.interfaces.HasModifiers;
import com.speedment.codegen.lang.models.ClassOrInterface;
import com.speedment.codegen.lang.models.modifiers.Modifier;
import static com.speedment.codegen.lang.models.modifiers.Modifier.FINAL;
import static com.speedment.codegen.lang.models.modifiers.Modifier.PRIVATE;
import static com.speedment.codegen.lang.models.modifiers.Modifier.PROTECTED;
import static com.speedment.codegen.lang.models.modifiers.Modifier.PUBLIC;
import static com.speedment.codegen.lang.models.modifiers.Modifier.STATIC;
import com.speedment.util.CodeCombiner;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Emil Forslund
 * @param <M>
 */
public interface HasModifiersView<M extends HasModifiers<M>> extends Transform<M, String> {
    
    default String renderModifiers(Generator cg, M model) {
		
		final Set<Modifier> modifiers = new HashSet<>();
		modifiers.addAll(model.getModifiers());
		
		if (cg.getRenderStack().fromTop(ClassOrInterface.class).equals(model)) {
			modifiers.remove(PUBLIC);
			modifiers.remove(PROTECTED);
			modifiers.remove(PRIVATE);
		}
		
		if (modifiers.contains(FINAL)) {
			modifiers.remove(PUBLIC);
			modifiers.remove(STATIC);
		}
		
        return cg.onEach(modifiers)
            .collect(CodeCombiner.joinIfNotEmpty(SPACE, EMPTY, SPACE));
    }
}