module fr.univlille.info.G3 {
    requires transitive cam.player.api.base;
    requires javafx.controls;
    requires javafx.graphics; 
    requires javafx.media;
    requires javafx.base; 
    exports fr.univlille.info.G3;
    exports fr.univlille.info.G3.model.perception;
    exports fr.univlille.info.G3.model.player;
    exports fr.univlille.info.G3.model.maze;
    exports fr.univlille.info.G3.utils;
    opens fr.univlille.info.G3.model.perception to org.jacoco.agent.rt;
    opens fr.univlille.info.G3.model.player to org.jacoco.agent.rt;
    opens fr.univlille.info.G3;
}
