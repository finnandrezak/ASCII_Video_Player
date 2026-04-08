ASCII Video Player
------------------

A small Java project that renders videos/frames as ASCII art (OpenCV + terminal rendering).

Requirements
------------
- Java 
- Maven
- OpenCV Java bindings available in your local Maven repository

Quick start (terminal)
----------------------
Change into the project directory and run the following command:

```bash
cd 'Data path of repository'
mvn compile && java -cp "target/classes:$(find ~/.m2/repository -name \"opencv-*.jar\" | head -n 1)" Main
```
can also run by simply running main, results won't look as good however

