# Ship24-4J

Ship24-4J is a Java wrapper for the Ship24 API, allowing you to easily integrate tracking functionality into your Java applications.

## Why use Ship24-4J?

Ship24's API is great, but using it in Java can be complex and time-consuming. That's where Ship24-4J comes in! With Ship24-4J, you can easily and quickly integrate Ship24's tracking functionality into your Java application. Whether you're building a shipping application or just need to track packages for your business, Ship24-4J makes it easy.

# Installation (Coming Soon)

To use it in your Maven build add:
```xml
  <repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
  </repositories>
```

and the dependency:

```xml
	<dependency>
		<groupId>com.github.fyzrdc</groupId>
		<artifactId>Ship24-4j</artifactId>
		<version>v0.1-beta</version>
	</dependency>
```


## Get Started

You can find the Java doc here : https://fyzrdc.github.io/Ship24-4j/

To get started with Ship24-4J, simply create a new Ship24 object with your API token, create a tracking object with a tracking number and carrier, and then retrieve the tracking information.

```java
Ship24 ship = Ship24.create("api token"); // Create the Ship24 instance
Tracker tracker = ship.createTracking("tracking number", new String[] {"fujie-express"}); // Create a new tracking
Tracking updated = ship.getTracking("tracking number"); // Get the new tracking
System.out.println(updated.getTracker().isSubscribed()); // Check if you are subscribed to the tracking
```

# Infos

For now, **only the created trackings are accessible**, this wrapper is a WIP and a lot of work have to be done, but you can get all **informations in the Ship24's REST API Docs** and be pretty sure that you can access It with this wrapper. Fell free to contribute !

# Examples

Get status of the first event of the tracking :
```java
Tracking updated = ship.getTracking("tracking number"); //Get tracking from tracking number
System.out.println(updated.getEvents()[0].getStatus()); //Get status of the first event of the tracking
```

Get all the available couriers :
```java
List<Courier> carriers = ship.getAllCouriers();
for (Courier carrier : carriers) {
	System.out.println(carrier.getCourierCode());
}
```
# Conclusion
That's it! With Ship24-4J, you can easily and quickly integrate Ship24's tracking functionality into your Java application. If you have any questions or issues, please feel free to open an issue on our GitHub repository. Thank you for using Ship24-4J!

