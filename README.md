# rolling-scene
----------------

Implements an infinite scroll scene with a helicopter moving over hills and valleys.

Hills and valleys are generated randomly.

Stars in the background are also generated randomly (location and color)


![](https://github.com/mahmadzadeh/rolling-scene/tree/master/src/main/resources/sample/rollingImage.png)


### Required software

scala 2.10

sbt 0.13.2

<h3>To create .jar and run the game</h3>

```
sbt assembly && java -jar target/scala-2.10/rollinghills.jar
````

To run the game from within sbt:

```
sbt> run Driver
```
