<b>NumberInWords</b> - a Java library to convert numbers into words.
It supports both the Indian and Western system of conversion.

<b>Eg:</b>
123456
Indian system - One lakh twenty three thousand four hundred fifty six
Western system - One hundred twenty three thousand four hundred fifty six

<b>Build tool used:</b> Gradle

To build the jar file, download the source and run the following command

<b>./gradlew build</b>

To run the jar for a demo, run the following command

<b>java -jar \<path-to-jar\> \<number-to-convert\> \<number_system\></b>

where system can be "indian" or "western"

Eg:
java -jar <path-to-jar> 123 westerm

Output: one hundred twenty three

