import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.CyclicBehaviour;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class MainRoboJade extends Agent {

	public AgentController startMyJade(String host, String port, String name) {
		Runtime runtime = Runtime.instance();
		Profile p = new ProfileImpl();
		p.setParameter(Profile.MAIN_HOST, host);
		p.setParameter(Profile.MAIN_PORT, port);
		ContainerController cc = null;
		
		try {
			cc = runtime.createAgentContainer(p);
		} catch(Exception ex){
			return null;			
		}
		if (cc != null) {
			try {
				AgentController ac = cc.createNewAgent(name, "MainRoboJade",
						null);
				ac.start();
				return ac;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public void setup() {
		System.out.println("Agent is running");
		setEnabledO2ACommunication(true, 0);

		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				RoboInfo info = (RoboInfo) myAgent.getO2AObject();
				if (info != null) {
					System.out.println("I got this info " + info.getId()+":"+info.getEnemyX() + "," + info.getEnemyY());					
				} else {
					block();
				}
			}
		});

	}

}
