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
package com.speedment.codegen.php;

import com.speedment.codegen.base.DefaultDependencyManager;
import com.speedment.codegen.base.DefaultGenerator;
import com.speedment.codegen.base.TransformFactory;
import com.speedment.codegen.lang.models.File;
import com.speedment.codegen.php.models.FileImpl;

/**
 *
 * @author Emil Forslund
 */
public class PHPGenerator extends DefaultGenerator {
	
	private final static String[] types = new String[] {
		"void", "byte", "short", "char", "int", "long", "float", 
		"double", "boolean"
	};
    
    public PHPGenerator() {
		super (new PHPTransformFactory());
		setModelImplementations();
	}
	
	public PHPGenerator(TransformFactory... factories) {
		super(new DefaultDependencyManager(types), factories);
		setModelImplementations();
	}
	
	private void setModelImplementations() {
		File.setSupplier(() -> new FileImpl(null));
	}
}
