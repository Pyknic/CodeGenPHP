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
import static com.speedment.codegen.Formatting.indent;
import static com.speedment.codegen.Formatting.nl;
import com.speedment.codegen.base.Generator;
import com.speedment.codegen.base.Transform;
import com.speedment.codegen.java.views.interfaces.HasClassesView;
import com.speedment.codegen.java.views.interfaces.HasImportsView;
import com.speedment.codegen.lang.interfaces.HasCode;
import com.speedment.codegen.lang.models.File;
import com.speedment.codegen.php.models.FileImpl;
import static com.speedment.util.CodeCombiner.joinIfNotEmpty;
import java.util.Optional;

/**
 *
 * @author Emil Forslund
 */
public class FileView implements Transform<File, String>, 
    HasClassesView<File>, HasImportsView<File> {
	
	@Override
	public Optional<String> transform(Generator gen, File model) {
		return Optional.of(
			"<?php" + nl() + indent(
				renderImports(gen, model) +
				renderCode(model) +
				renderClasses(gen, model)
			) + nl() + "?>"
		);
	}
	
	private String renderCode(File model) {
		if (model instanceof HasCode) {
			return ((HasCode<FileImpl>) model).getCode()
				.stream().collect(joinIfNotEmpty(nl(), "", dnl()));
		} else {
			return "";
		}
	}
}
