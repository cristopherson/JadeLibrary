package agentGreenfoot;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.CyclicBehaviour;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class MainRoboJade extends Agent {
	private AgentController agent;
	private RoboInfo roboInfo = null;
	private boolean helpRequired = false;
	private MainRoboCyclicBehavior behavior = new MainRoboCyclicBehavior(this);
	private String id;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgentController startMyJade(String host, String port, String name) {
		Runtime runtime = Runtime.instance();
		Profile p = new ProfileImpl();
		p.setParameter(Profile.MAIN_HOST, host);
		p.setParameter(Profile.MAIN_PORT, port);
		ContainerController cc = null;

		try {
			cc = runtime.createAgentContainer(p);
		} catch (Exception ex) {
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

	public boolean deregisterAgent() {
		if (agent != null) {
			try {
				agent.kill();
				return true;
			} catch (StaleProxyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	public void setup() {
		System.out.println("Agent is running");
		setEnabledO2ACommunication(true, 0);
		addBehaviour(behavior);

	}

	public void initAgent(String agentName) {
		agent = startMyJade("192.168.96.134", "1099", agentName);
	}

	public void sendMessage(String id, int enemyX, int enemyY, Event event) {
		try {
			if (agent != null) {
				agent.putO2AObject(new RoboInfo(id, enemyX, enemyY, event),
						false);
			} else {
				System.out.println("Agent is null");
			}
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isHelpRequired() {
		return behavior.getAgent().helpRequired;
	}

	public void setHelpRequired(boolean help) {
		this.helpRequired = help;
	}

	public RoboInfo getRoboInfo() {
		return roboInfo;
	}

	public void setRoboInfo(RoboInfo myRoboInfo) {
		this.roboInfo = new RoboInfo(myRoboInfo.getId(),
				myRoboInfo.getEnemyX(), myRoboInfo.getEnemyY(),
				myRoboInfo.getEvent());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
