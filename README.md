GWT PojoBuilder - Enables PojoBuilder in GWT
============================================

GWT PojoBuilder enables [PojoBuilder](http://github.com/mkarneim/pojobuilder)-generated
builders to be used in GWT.

[PojoBuilder](http://github.com/mkarneim/pojobuilder) is a code generator
that generates fluent builder classes for POJOs (Plain Old Java Objects). The
builders it generates include a `clone()` method and catch exceptions that
are not included in GWT's JRE emulation.

This project includes an implementation of these and a workaround for the
`clone()` override issue.

Get Started
-----------

GWT PojoBuilder is available in Maven Central.
To use it, add the following dependency to your POM:

```xml
TODO:

<dependency>
  <groupId>com.thamtech.gwt</groupId>
  <artifactId>gwt-pojobuilder</artifactId>
  <version>1.0.0</version>
</dependency>
```

In your GWT module, inherit from `com.thamtech.gwt.pojobuilder.PojoBuilder`:

```xml
<module>
  <inherits name="com.thamtech.gwt.pojobuilder.PojoBuilder"/>
</module>
```

Usage
-----

Set the baseclass of your builder classes to `NotCloneableObject`:

```java
import com.thamtech.gwt.pojobuilder.client.NotCloneableObject;
...
@GeneratePojoBuilder(withBaseclass=NotCloneableObject.class)
...
```

If your use case requires your own base class, you will need to ensure that
some parent of the generated builder implements the `clone()` method so that
GWT does not complain when it sees the builder class implement
`@Override public Object clone()`.