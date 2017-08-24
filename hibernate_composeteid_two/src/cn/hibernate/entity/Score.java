package cn.hibernate.entity;

/**
 * 成绩类
 * @author tang
 *
 */
public class Score {
	private ScoreId scoreId;
	public ScoreId getScoreId() {
		return scoreId;
	}
	public void setScoreId(ScoreId scoreId) {
		this.scoreId = scoreId;
	}
	private double result;//成绩

	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
}
