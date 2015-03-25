NumberInWords - a Java library to convert numbers into words.
It supports both the Indian and Western system of conversion.

Eg:
123456
Indian system - One lakh twenty three thousand four hundred fifty six
Western system - One hundred twenty three thousand four hundred fifty six


Gradle is used as the build tool for the library.

To build the jar file, download the source and run the following command
./gradlew build

To run the jar for a demo, run the following command
java -jar <path-to-jar> <number-to-convert> <system>

where system can be "indian" or "western"

Eg:
java -jar <path-to-jar> 123 westerm

Output: one hundred twenty three

