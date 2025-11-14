package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
		
		this.speedometer = speedometer;
		this.speedSet = null;
		this.speedLimit = null;

	}

	
	
	/*
	 * Method to code
	 */
	public void setSpeedSet(int speedSet) {
		if (speedSet <= 0) {
			throw new IncorrectSpeedSetException("Speed set must be greater than zero.");
		}

		if (this.speedLimit != null && speedSet > this.speedLimit) {
			throw new SpeedSetAboveSpeedLimitException("Speed set cannot exceed speed limit.");
		}
		this.speedSet = speedSet;
		
		
	}

	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public Integer getSpeedSet() {
		return speedSet;
	}

	class IncorrectSpeedSetException extends RuntimeException {
		public IncorrectSpeedSetException(String message) {
			super(message);
		}
	}

	class SpeedSetAboveSpeedLimitException extends RuntimeException {
		public SpeedSetAboveSpeedLimitException(String message) {
			super(message);
		}
	}

}
