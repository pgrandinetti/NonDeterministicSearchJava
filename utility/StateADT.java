package utility;
/**
 * A partial implementation of the State interface, to diminish the burden of
 * future subclasses.
 */

/**
 * @author Pietro Grandinetti
 *
 */
public abstract class StateADT implements State {
	
	/*
	 * A way to force sub-classes to implements equals
	 */
	@Override
	public abstract boolean equals (Object o);
	
	
	@Override
	public boolean isContained (State s){
		if (this.equals(s))
			return true;
		
		State tmp = s;
		while (tmp!=null){
			if (this.equals(tmp))
				return true;
			tmp = tmp.getPreviousInPath();
		}
		
		return false;
	}

	
	@Override
	public State executeAction (Action a){
		
		State novel = deepCopy();
		novel.updateState(a);
		novel.setPreviousInPath(this);
		return novel;
		
	}

}
