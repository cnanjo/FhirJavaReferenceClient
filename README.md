FhirJavaReferenceClient
=======================

Reference implementation of the Java Rest Client

Other Implementations
---------------------

For those who prefer coding in C#, please take a look at the Ewout Kramer's C# Reference Implementation on GitHub at the following location:

https://github.com/ewoutkramer/fhir-net-api

In need of a JavaScript FHIR client, please take a look at Josh Mandel's implementation:

https://github.com/jmandel/fhir-js-client

Feedback
--------

If you are using the client and encounter bugs or have feedback on how to improve this implementation, please do so by submitting an issue:

https://github.com/cnanjo/FhirJavaReferenceClient/issues

All feedback is greatly appreciated.

Build
-----

The FHIR Java Reference Client can be built using Maven. Please refer to the [Maven documentation] (http://maven.apache.org/) for more information.

If you wish to include a Maven dependency for this reference client, the following dependencies will be made available shortly on the following Sonatype Maven Repository:

https://oss.sonatype.org/content/repositories/snapshots/

Dependency for the upcoming client release:

```
dependency>
	<groupId>me.fhir</groupId>
	<artifactId>fhir-java-client</artifactId>
	<version>0.12.0-RELEASE</version>
</dependency>
```

Dependency for the latest snapshot (note, snapshot version TBD) :

```
dependency>
	<groupId>me.fhir</groupId>
	<artifactId>fhir-java-client</artifactId>
	<version>rnnnn-SNAPSHOT</version>
</dependency>
```
