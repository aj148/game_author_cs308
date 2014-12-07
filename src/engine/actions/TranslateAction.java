package engine.actions;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * Action that performs GameObject Transforms/Movements
 * @author Will
 *
 */

public abstract class TranslateAction implements Action, Initializable {
    protected GameObject mySprite;
    protected Identifier myGameObjectID;
    protected double myValue;
    
    public TranslateAction (Identifier iD, double value) {
        myGameObjectID = iD;
        myValue = value;
    }
    
    @Override
    public void execute () {
        applyTransform();
    }
    
    @Override
    public void initialize (GameManager manager) {
        mySprite = manager.objectForIdentifier(myGameObjectID);
    }
    
    /**
     * Applies the specific transform in X and Y
     */
    public abstract void applyTransform ();
    
}
