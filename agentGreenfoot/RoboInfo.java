package agentGreenfoot; 

public class RoboInfo {
	private String id;
	private int enemyX;
	private int enemyY;
	private Event event;

	public RoboInfo(String id, int enemyX, int enemyY, Event event) {
		this.setId(id);
		this.setEnemyX(enemyX);
		this.setEnemyY(enemyY);
		this.setEvent(event);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEnemyX() {
		return enemyX;
	}

	public void setEnemyX(int enemyX) {
		this.enemyX = enemyX;
	}

	public int getEnemyY() {
		return enemyY;
	}

	public void setEnemyY(int enemyY) {
		this.enemyY = enemyY;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
