For Spec see client-spec.md.

To run - Load as Intellij IDEA project and run Main.java as Java CLI.
Supply single argument - the URL to GET from.
It should return an array of JSON documents, each only with a "numbers" field.
Said field should contain an array of integers.
See src/test/resources/simpleArray for example.

If you get an error like "Could not find or load main class in intelliJ IDEA"
then you'll need to change the "output" directory under File -> Project Structure.