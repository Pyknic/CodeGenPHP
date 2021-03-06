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

import com.speedment.codegen.base.DefaultTransformFactory;
import com.speedment.codegen.java.views.InterfaceFieldView;
import com.speedment.codegen.java.views.InterfaceMethodView;
import com.speedment.codegen.java.views.JavadocTagView;
import com.speedment.codegen.java.views.JavadocView;
import com.speedment.codegen.java.views.TypeView;
import com.speedment.codegen.java.views.values.BooleanValueView;
import com.speedment.codegen.java.views.values.EnumValueView;
import com.speedment.codegen.java.views.values.NumberValueView;
import com.speedment.codegen.java.views.values.ReferenceValueView;
import com.speedment.codegen.java.views.values.TextValueView;
import com.speedment.codegen.lang.models.Class;
import com.speedment.codegen.lang.models.Constructor;
import com.speedment.codegen.lang.models.Enum;
import com.speedment.codegen.lang.models.EnumConstant;
import com.speedment.codegen.lang.models.Field;
import com.speedment.codegen.lang.models.File;
import com.speedment.codegen.lang.models.Import;
import com.speedment.codegen.lang.models.Interface;
import com.speedment.codegen.lang.models.InterfaceField;
import com.speedment.codegen.lang.models.InterfaceMethod;
import com.speedment.codegen.lang.models.Javadoc;
import com.speedment.codegen.lang.models.JavadocTag;
import com.speedment.codegen.lang.models.Method;
import com.speedment.codegen.lang.models.Type;
import com.speedment.codegen.lang.models.modifiers.Modifier;
import com.speedment.codegen.lang.models.values.ArrayValue;
import com.speedment.codegen.lang.models.values.BooleanValue;
import com.speedment.codegen.lang.models.values.EnumValue;
import com.speedment.codegen.lang.models.values.NumberValue;
import com.speedment.codegen.lang.models.values.ReferenceValue;
import com.speedment.codegen.lang.models.values.TextValue;
import com.speedment.codegen.php.views.ArrayValueView;
import com.speedment.codegen.php.views.ClassView;
import com.speedment.codegen.php.views.ConstructorView;
import com.speedment.codegen.php.views.EnumConstantView;
import com.speedment.codegen.php.views.EnumView;
import com.speedment.codegen.php.views.FieldView;
import com.speedment.codegen.php.views.FileView;
import com.speedment.codegen.php.views.ImportView;
import com.speedment.codegen.php.views.InterfaceView;
import com.speedment.codegen.php.views.MethodView;
import com.speedment.codegen.php.views.ModifierView;

/**
 *
 * @author Emil Forslund
 */
public class PHPTransformFactory extends DefaultTransformFactory {
	
	public PHPTransformFactory() {
		this ("PHPInstaller");
	}

	public PHPTransformFactory(String name) {
		super (name);
		
		// Inherited from Java implementation.
		install(Type.class, TypeView.class);
		install(Javadoc.class, JavadocView.class);
		install(JavadocTag.class, JavadocTagView.class);
		install(BooleanValue.class, BooleanValueView.class);
		install(EnumValue.class, EnumValueView.class);
		install(NumberValue.class, NumberValueView.class);
		install(ReferenceValue.class, ReferenceValueView.class);
		install(TextValue.class, TextValueView.class);
		install(InterfaceMethod.class, InterfaceMethodView.class);
		install(InterfaceField.class, InterfaceFieldView.class);
		
		// Custom views for PHP
		install(Interface.class, InterfaceView.class);
		install(Class.class, ClassView.class);
		install(File.class, FileView.class);
		install(Field.class, FieldView.class);
		install(Method.class, MethodView.class);
		install(Import.class, ImportView.class);
		install(ArrayValue.class, ArrayValueView.class);
		install(Enum.class, EnumView.class);
		install(EnumConstant.class, EnumConstantView.class);
		install(Constructor.class, ConstructorView.class);
		install(Modifier.class, ModifierView.class);
	}
	
}