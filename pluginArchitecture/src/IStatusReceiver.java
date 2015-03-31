
/***
 * Interface for classes that are expected to handle simple
 * status messages from various sources.
 * @author uphusar
 *
 */
public interface IStatusReceiver {
	
	void HandleStatusMessage(String message);
	
}
