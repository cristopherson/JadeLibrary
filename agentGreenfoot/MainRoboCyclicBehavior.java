package agentGreenfoot;
import jade.core.behaviours.CyclicBehaviour;

public class MainRoboCyclicBehavior extends CyclicBehaviour {
	
	public MainRoboCyclicBehavior(MainRoboJade agent){
		super(agent);		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		RoboInfo myRoboInfo = (RoboInfo) myAgent.getO2AObject();

		if (myRoboInfo != null) {
			System.out.println("I got this info: event "
					+ myRoboInfo.getEvent() + " = " + myRoboInfo.getId() + ":"
					+ myRoboInfo.getEnemyX() + "," + myRoboInfo.getEnemyY());
			if (myRoboInfo.getEvent() == Event.HELP) {
				MainRoboJade myMainRoboJade = (MainRoboJade) (myAgent);
				myMainRoboJade.setHelpRequired(true);
				myMainRoboJade.setRoboInfo(myRoboInfo);
			}
		} else {
			block();
		}
	}
	
	public MainRoboJade getAgent(){
		return (MainRoboJade)(myAgent);
	}

}
