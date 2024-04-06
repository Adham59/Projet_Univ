package fr.univlille.info.G3.view.game.menu;

import fr.univlille.info.G3.controller.parameter.HunterBotShowViewRadio;
import fr.univlille.info.G3.controller.parameter.DiagonaleDeplacementCheckBox;
import fr.univlille.info.G3.controller.parameter.FogModeCheckBox;
import fr.univlille.info.G3.controller.parameter.FogRangeSpinner;
import fr.univlille.info.G3.controller.parameter.HunterBotIsCleverRadio;
import fr.univlille.info.G3.controller.parameter.HunterBotIsRandomRadio;
import fr.univlille.info.G3.controller.parameter.HunterIsBotCheckBox;
import fr.univlille.info.G3.controller.parameter.LoadMapRadio;
import fr.univlille.info.G3.controller.parameter.LoadRandomMapRadio;
import fr.univlille.info.G3.controller.parameter.MonsterBotIsAStarRadio;
import fr.univlille.info.G3.controller.parameter.MonsterBotShowViewRadio;
import fr.univlille.info.G3.controller.parameter.MonsterIsBotCheckBox;
import fr.univlille.info.G3.controller.parameter.MonsterBotIsRandomRadio;
import fr.univlille.info.G3.controller.parameter.SaveButton;
import fr.univlille.info.G3.model.game.Parameter;
import fr.univlille.info.G3.model.player.hunter.Hunter;
import fr.univlille.info.G3.model.player.monster.Monster;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ParameterView extends Stage {

    private static int WINDOW_LENGTH = 1500;
    private static int WINDOW_HEIGHT = 600;
    private static int ROOT_PADDING = 20;
    private static int AREAS_PADDING = 20;
    

    public ParameterView(){
        setTitle("Parametre");
        Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
        super.getIcons().add(icon);
        Parameter.resetParameters();
        setupParameterView();
        show();
    }

    public void setupParameterView(){
        // initialize layouts

        VBox root = new VBox();
        root.getStyleClass().add("root");
        root.setPadding(new javafx.geometry.Insets(ROOT_PADDING));

        HBox layoutParameters = new HBox();
        root.getChildren().add(layoutParameters);


        //Left side of the window
        VBox layoutLeftTop = new VBox(10);
        layoutLeftTop.getStyleClass().add("layout");
        layoutLeftTop.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutLeftTop.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        VBox layoutLeftBottom = new VBox(10);
        layoutLeftBottom.getStyleClass().add("layout");
        layoutLeftBottom.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutLeftBottom.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        VBox layoutLeftArea = new VBox(10);
        layoutLeftArea.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutLeftArea.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        //Middle side of the window
        VBox layoutMiddleArea = new VBox(10);
        layoutMiddleArea.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutMiddleArea.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        VBox layoutMiddleTop = new VBox(10);
        layoutMiddleTop.getStyleClass().add("layout");
        layoutMiddleTop.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutMiddleTop.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        VBox layoutMiddleBottom = new VBox(10);
        layoutMiddleBottom.getStyleClass().add("l");
        layoutMiddleBottom.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutMiddleBottom.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        VBox layoutForMonsterBotAndVue = new VBox(10);
        layoutForMonsterBotAndVue.setSpacing(3);

        VBox layoutForHunterBotAndVue = new VBox(10);
        layoutForHunterBotAndVue.setSpacing(3);


        VBox layoutForBotMonster = new VBox(10);    
        layoutForBotMonster.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutForBotMonster.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        VBox layoutForBotHunter = new VBox(10);
        layoutForBotHunter.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutForBotHunter.setPadding(new javafx.geometry.Insets(AREAS_PADDING));


        VBox layoutForVueMonster = new VBox(10);
        layoutForVueMonster.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutForVueMonster.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        VBox layoutForVueHunter = new VBox(10);
        layoutForVueHunter.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutForVueHunter.setPadding(new javafx.geometry.Insets(AREAS_PADDING));


        //Right side of the window
        VBox layoutRightArea = new VBox(10);
        layoutMiddleBottom.getStyleClass().add("l");
        layoutRightArea.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutRightArea.setPadding(new javafx.geometry.Insets(AREAS_PADDING));

        HBox layoutForFogMod = new HBox(10);
        layoutForFogMod.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutForFogMod.setPadding(new javafx.geometry.Insets(AREAS_PADDING));    
        
        VBox layoutForDiagonaleDeplacement = new VBox(10);
        layoutForDiagonaleDeplacement.setMinWidth(WINDOW_LENGTH / 3 - ROOT_PADDING);
        layoutForDiagonaleDeplacement.setPadding(new javafx.geometry.Insets(AREAS_PADDING));



        // Settings titles
        Text probaWallsText = new Text("Taux d'apparition des murs");
        Text gridSizeTextRow = new Text("Largeur du labyrinth: ");
        Text gridSizeTextCol = new Text("Longuer de labyrinth : ");
        Text pseudoMonsterText = new Text("Pseudo du monstre");
        Text pseudoHunterText = new Text("Pseudo du chasseur");


        // Walls spawn rate
        Slider probaWalls = new Slider(0, 0.5, 0.2);
        probaWalls.setShowTickLabels(true);
        probaWalls.setShowTickMarks(true);
        probaWalls.setMajorTickUnit(0.1);
        probaWalls.setBlockIncrement(0.05);
        probaWalls.setSnapToTicks(true);

        // Maze width
        Slider gridRowSize = new Slider(6, 16, 8);
        gridRowSize.setShowTickLabels(true);
        gridRowSize.setShowTickMarks(true);
        gridRowSize.setMinorTickCount(0);
        gridRowSize.setMajorTickUnit(1);
        gridRowSize.setBlockIncrement(1);
        gridRowSize.setSnapToTicks(true);

        // Maze height
        Slider gridColSize = new Slider(6, 24, 12);
        gridColSize.setShowTickLabels(true);
        gridColSize.setMinorTickCount(1);
        gridColSize.setShowTickMarks(true);
        gridColSize.setMajorTickUnit(2);
        gridColSize.setBlockIncrement(1);
        gridColSize.setSnapToTicks(true);

        // Pseudos
        TextField pseudoMonster = new TextField(Monster.getPseudo());
        TextField pseudoHunter = new TextField(Hunter.getPseudo());

        // Listeners
        probaWalls.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Proba Walls : " + newValue);
        });
    
        gridRowSize.valueProperty().addListener((observable, oldValue, newValue) -> {
            gridRowSize.setValue(newValue.intValue());
            System.out.println("Grid Size : " + newValue);
        });

        gridColSize.valueProperty().addListener((observable, oldValue, newValue) -> {
            gridColSize.setValue(newValue.intValue());
            System.out.println("Grid Size : " + newValue);
        });



        LoadRandomMapRadio mapRandom = new LoadRandomMapRadio();
        LoadMapRadio mapFile = new LoadMapRadio();

        MonsterIsBotCheckBox makeMonsterBot = new MonsterIsBotCheckBox();
        MonsterBotIsRandomRadio makeMonsterRandom = new MonsterBotIsRandomRadio();
        MonsterBotIsAStarRadio makeMonsterAStar = new MonsterBotIsAStarRadio();

        HunterIsBotCheckBox makeHunterBot = new HunterIsBotCheckBox();
        HunterBotIsRandomRadio makeHunterRandom = new HunterBotIsRandomRadio();
        HunterBotIsCleverRadio makeHunterClever = new HunterBotIsCleverRadio();


        MonsterBotShowViewRadio makeMonsterBotVue = new MonsterBotShowViewRadio();
        HunterBotShowViewRadio makeHunterBotVue = new HunterBotShowViewRadio();

        FogModeCheckBox fogMode = new FogModeCheckBox();
        FogRangeSpinner fogRange = new FogRangeSpinner();

        DiagonaleDeplacementCheckBox diagonaleDeplacementPossible = new DiagonaleDeplacementCheckBox();




        ToggleGroup groupMap = new ToggleGroup();
        mapRandom.setToggleGroup(groupMap);
        mapFile.setToggleGroup(groupMap);

        ToggleGroup groupMonster = new ToggleGroup();
        makeMonsterRandom.setToggleGroup(groupMonster);
        makeMonsterAStar.setToggleGroup(groupMonster);


        ToggleGroup groupHunter = new ToggleGroup();
        makeHunterRandom.setToggleGroup(groupHunter);
        makeHunterClever.setToggleGroup(groupHunter);


        // les getChldren pour chaque layout;

        // Left side
        layoutLeftTop.getChildren().addAll(probaWallsText, probaWalls, gridSizeTextCol, gridColSize, gridSizeTextRow, gridRowSize);
        layoutLeftBottom.getChildren().addAll(mapRandom, mapFile);
        layoutForFogMod.getChildren().addAll(fogMode, fogRange);
        layoutLeftArea.getChildren().addAll(layoutLeftBottom , layoutLeftTop , layoutForFogMod);

        // Middle side

        layoutForVueMonster.getChildren().addAll(makeMonsterBotVue);
        layoutForVueHunter.getChildren().addAll(makeHunterBotVue);

        layoutForBotMonster.getChildren().addAll(makeMonsterRandom, makeMonsterAStar);
        layoutForBotHunter.getChildren().addAll(makeHunterRandom, makeHunterClever);

        layoutForMonsterBotAndVue.getChildren().addAll(layoutForBotMonster, layoutForVueMonster);
        layoutForHunterBotAndVue.getChildren().addAll(layoutForBotHunter, layoutForVueHunter);

        layoutMiddleTop.getChildren().addAll(makeMonsterBot, makeHunterBot);
        layoutMiddleBottom.getChildren().addAll(layoutForMonsterBotAndVue, layoutForHunterBotAndVue);
        layoutMiddleArea.getChildren().addAll(layoutMiddleTop , layoutMiddleBottom);



        // Right side
        layoutForDiagonaleDeplacement.getChildren().addAll(diagonaleDeplacementPossible);
        layoutRightArea.getChildren().addAll(pseudoMonsterText, pseudoMonster, pseudoHunterText, pseudoHunter , layoutForDiagonaleDeplacement);


        // Add all layouts to the root layout
        layoutParameters.getChildren().addAll(layoutLeftArea, layoutMiddleArea , layoutRightArea);
        HBox.setHgrow(layoutLeftArea, Priority.ALWAYS);
        HBox.setHgrow(layoutMiddleArea, Priority.ALWAYS);
        HBox.setHgrow(layoutRightArea, Priority.NEVER);

        SaveButton save = new SaveButton(pseudoMonster, pseudoHunter, probaWalls, gridColSize, gridRowSize, this);
        root.getChildren().add(save);

        layoutLeftTop.visibleProperty().bind(mapRandom.selectedProperty());
        layoutForBotMonster.visibleProperty().bind(makeMonsterBot.selectedProperty());
        layoutForBotHunter.visibleProperty().bind(makeHunterBot.selectedProperty());

        layoutForVueMonster.visibleProperty().bind(makeMonsterRandom.selectedProperty().and(makeMonsterBot.selectedProperty()).or(makeMonsterAStar.selectedProperty()).and(makeMonsterBot.selectedProperty()));

        layoutForVueHunter.visibleProperty().bind(makeHunterRandom.selectedProperty().and(makeHunterBot.selectedProperty()).or(makeHunterClever.selectedProperty()).and(makeHunterBot.selectedProperty()));
        layoutForFogMod.visibleProperty().bind((makeHunterBot.selectedProperty().not().and(makeMonsterBot.selectedProperty().not())));

        layoutForDiagonaleDeplacement.visibleProperty().bind(makeHunterBot.selectedProperty().not().and(makeMonsterBot.selectedProperty().not()));

        Scene scene = new Scene(root, WINDOW_LENGTH, WINDOW_HEIGHT);
        scene.getStylesheets().add("file:src/main/resources/css/parameter.css");
        setScene(scene);        

    }


}

 