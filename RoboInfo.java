public class RoboInfo {
	private String id;
	private int enemyX;
	private int enemyY;

	public RoboInfo(String id, int enemyX, int enemyY) {
		this.setId(id);
		this.setEnemyX(enemyX);
		this.setEnemyY(enemyY);
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
}
