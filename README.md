# CodeGenPHP
An extension for CodeGen that allows you to generate PHP code from the same models as the standard Java module use.

## Example
```java
System.out.println(
  new PHPGenerator().on(
    new FileImpl(FILENAME)
    	.add("BasicExample::main();")
        .add(Class.of("BasicExample")
          .add(
            Field.of("BASIC_MESSAGE", STRING)
            .public_().final_().static_()
            .set(new TextValue("Hello, world!"))
          )
          .add(
            Method.of("main", VOID)
            .set(Javadoc.of(
              "This is a very basic example of ",
              "the capabilities of the Code Generator."
            ))
            .public_().static_()
            .add(Field.of("params", 
                STRING.setArrayDimension(1))
			        .set(new ArrayValue())
	          )
            .add(
              "echo (BasicExample::BASIC_MESSAGE);"
            )
          )
        ).call(new AutoJavadoc<>())
  ).get()
);
```

## Resulting file
```php
<?php
	BasicExample::main();
	
	/**
	 * Write some documentation here.
	 * 
	 * @author Your Name 
	 */
	class BasicExample {
		
		const BASIC_MESSAGE = "Hello, world!";
		
		/**
		 * This is a very basic example of 
		 * the capabilities of the Code Generator.
		 * 
		 * @param params 
		 */
		public static function main($params = array()) {
			echo (BasicExample::BASIC_MESSAGE);
		}
	}
?>
```
