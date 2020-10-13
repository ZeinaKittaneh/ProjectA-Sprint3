
public class CounterFactory {
	
	/**
	 * A method to generate an array of ICounters, has a counter of each type, will be used by wc counter
	 * @param args : represent the file name
	 * @return ICounter interface array
	 */
	public ICounter [] createCounter(String args){
		ICounter[] counters = new ICounter[3];
		counters[0] = new CharCounter(args);
		counters[1] = new WordCounter(args);
		counters[2] = new LineCounter(args);
		return counters;
	}
	
	/**
	 * A method to create a counter object depending on the counterName 
	 * @param counterName
	 * @param fileName
	 * @return a Counter object
	 */
	public Counter getCounter(String counterName, String fileName) {
		if(counterName == null){
	         return null;
	      }		
	      if(counterName.equalsIgnoreCase("charCount")){
	         return new CharCounter(fileName);
	         
	      } else if(counterName.equalsIgnoreCase("lineCount")){
	         return new LineCounter(fileName);
	         
	      } else if(counterName.equalsIgnoreCase("wordCount")){
	         return new WordCounter(fileName);
	      }
	      return null;
	}	
	
}
