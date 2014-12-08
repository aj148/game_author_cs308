package engine.actions.componentsactions;

import java.util.List;
import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

public class ChangeComponentAction implements Action, Initializable{
	
	protected GameObjectsCollection myGameObjects;
	protected Identifier myComponentID; 
	protected List<Identifier> myObjectIDs; 
	
	public ChangeComponentAction(List<Identifier> ids, Identifier componentID){
		myObjectIDs = ids; 
		myComponentID = componentID; 
		
	}
	

	@Override
	public void initialize(GameManager manager) {
		for (Identifier id: myObjectIDs){
			myGameObjects.add(manager.objectForIdentifier(id));
		}
		
	}


    @Override
    public void execute () {
        // TODO Auto-generated method stub
        
    }

	

}
