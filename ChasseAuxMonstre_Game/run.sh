mvn install:install-file -Dfile=src/main/resources/jar/cam-player-api-base.jar -DgroupId=fr.univlille.info.G3 -DartifactId=cam-player-api-base -Dversion=1.0 -Dpackaging=jar

mvn package
java --module-path ./lib/ --add-modules javafx.controls,javafx.graphics,javafx.media -jar target/G3-1.0.1.jar


