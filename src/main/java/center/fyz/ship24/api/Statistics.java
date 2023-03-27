/**
 * The Statistics class represents statistical information about shipments
 * associated with a given set of timestamps.
 *
 * @author FyzRDC
 */
package center.fyz.ship24.api;

public class Statistics {

	// The timestamps associated with the statistics
	private Timestamps timestamps;

	/**
	 * Constructs a new Statistics object with the given timestamps.
	 *
	 * @param timestamps the timestamps associated with the statistics
	 */
	public Statistics(Timestamps timestamps) {
		this.timestamps = timestamps;
	}

	/**
	 * Returns the timestamps associated with the statistics.
	 *
	 * @return the timestamps associated with the statistics
	 */
	public Timestamps getTimestamps() {
		return timestamps;
	}

}
