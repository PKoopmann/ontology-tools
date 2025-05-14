Various tools frequently used for experiments with ontologies.

Compile with "mvn package"

All classes have main methods and can directly be executed from command line.

To run, use e.g.

java -cp target/ontology-tools-1.0-SNAPSHOT-jar-with-dependencies.jar nl.vu.kai.owl_tools.Consistent OWL_FILE

java -cp target/ontology-tools-1.0-SNAPSHOT-jar-with-dependencies.jar nl.vu.kai.owl_tools.Statistics OWL_FILE

java -cp target/ontology-tools-1.0-SNAPSHOT-jar-with-dependencies.jar nl.vu.kai.owl_tools.RemoveRedundancies OWL_FILE
