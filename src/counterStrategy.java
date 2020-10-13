import java.io.IOException;

//This class is used to create a strategy for a counter and to execute its counting process
//It applies the strategy design pattern
public class counterStrategy {
	private ICounter counter;
	
	//Create a strategy for an ICounter
	public counterStrategy(ICounter counter) {
		this.counter = counter;
	}
	
	//Execute the counting process of the counter
	public void execCounting(String file) throws IOException{
		counter.countingProcess(file);
	}
}
