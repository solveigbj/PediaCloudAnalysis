package pediacloud;


public class TestSplit {
	String testString = null;
	String tokens[] = null;

	TestSplit() {
		testString = "STARTED: Fri Mar 28 14:23:05 GMT 2014";
	}

	public boolean split() {
		if (testString.contains(":")) {
			System.out.println(testString);
			tokens = testString.split(":");
			if (tokens[0] == "STARTED") {
				System.out.println(tokens[0]);
				return true;
			};  
		}
		return false;
	}
	public boolean testNumberOfArguments() {
		if (tokens.length == 2) {
			return true;
		}
		return false;
	}
}
