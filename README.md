# :no_entry: [OBSOLETE]

GWT PojoBuilder is no longer necessary since GWT support has been enabled in [PojoBuilder](https://github.com/mkarneim/pojobuilder) as of version [v4.1.0](https://github.com/mkarneim/pojobuilder/releases/tag/v4.1.0).

---

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.thamtech.gwt/gwt-pojobuilder/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.thamtech.gwt/gwt-pojobuilder)
[![Build Status](https://travis-ci.org/thamtech/gwt-pojobuilder.svg?branch=master)](https://travis-ci.org/thamtech/gwt-pojobuilder)

GWT PojoBuilder - Enables PojoBuilder in GWT
============================================

GWT PojoBuilder enables [PojoBuilder](https://github.com/mkarneim/pojobuilder)-generated
builders to be used in GWT.

[PojoBuilder](https://github.com/mkarneim/pojobuilder) is a code generator
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
<dependency>
  <groupId>com.thamtech.gwt</groupId>
  <artifactId>gwt-pojobuilder</artifactId>
  <version>${gwt-pojobuilder.version}</version>
</dependency>
```

(Don't forget to include a separate dependency for
[PojoBuilder](http://github.com/mkarneim/pojobuilder).)

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
