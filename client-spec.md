SCREENING INSTRUCTIONS

Create a simple class using native java* (no 3rd party libraries like apache commons, spring, etc) that will accept a url as an input (either via arguments or a properties file) and consume a REST endpoint (HTTP GET) and process the output.

1. The main method should read in a URL via command line arguments  or via properties file

2. The numeric being summed are not keys, they are contained in a JSON array with the key of “numbers”, the summation for the single document and for the execution will need to be done based on that array.

IMPORTANT: Instructions must be followed! They want the least complex solution to a fairly simple problem.

SCREENING QUESTIONS

1. The rest endpoint will emit an array of JSON documents, each JSON document will be a complete flat (non nested) record.

2. For each document display all of the keys of the JSON in standard out

3. There will be a json array with the key of "numbers", sum all of the numbers and display it on standard out, add that sum to a running total for the program

4. Display the total of the numbers that were summed for the execution

*Because java does not have a native JSON parser you can use a JSON library of your choosing (JSON.simple, GSON, Jackson, jettison, JSONP etc).



SUBMISSION CRITERIA:

FIRST: Tech screen (Apex on core java)

1. The source code should be checked into a github (https://github.com/) and a url provided for us for evaluation purposes.

2. Only the code that is used to form a solution to the problem presented here will be evaluated, all other test data and programs will not be evaluated.

 