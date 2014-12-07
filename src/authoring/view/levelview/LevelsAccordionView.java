package authoring.view.levelview;

import java.util.ResourceBundle;

import data.Observable;
import data.Observer;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;
import authoring.model.collections.LevelsCollection;
import authoring.view.baseclasses.ScrollView;
import authoring.view.graphicsview.LevelGraphic;
import engine.level.Level;

public class LevelsAccordionView extends ScrollView implements Observer{
	private static final double VIEW_HEIGHT_RATIO = .70;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();	
	private GameHandler[] myEvents;
	private GameHandler[] levelEvents;
	private String myName;
	
	public LevelsAccordionView(ResourceBundle language, double width,
			double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
	}

	@Override
	public void update(Observable o, Object arg) {
		addLevel((Level) arg);
		
	}
	
	public void setEvents(GameHandler ... gameHandlers){
		myEvents = gameHandlers;
	}
	
	public void setLevelEvents(GameHandler ... gameHandlers){
		levelEvents = gameHandlers;
	}
	
	public void addLevel(Level l){
		myName = l.getIdentifier().getUniqueId();
		LevelGraphic newLevel = new LevelGraphic(myName, myEvents, l,levelEvents);

		myVbox.getChildren().add(newLevel);
	}
	
	public String getMyName(){
		return myName;
	}
}
