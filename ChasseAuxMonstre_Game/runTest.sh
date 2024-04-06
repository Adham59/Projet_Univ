mvn install:install-file -Dfile=src/main/resources/jar/cam-player-api-base.jar -DgroupId=com.project -DartifactId=cam-player-api-base -Dversion=1.0 -Dpackaging=jar

mvn clean verify
mvn jacoco:report

open ./target/site/jacoco/index.html