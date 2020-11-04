package test.finalsubmission;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.*;
import static org.junit.platform.engine.discovery.ClassNameFilter.*;
import org.junit.platform.launcher.*;
import org.junit.platform.launcher.core.*;
import org.junit.platform.launcher.listeners.*;

/**
 * Executes all JUnit tests.
 * 
 * @author Edward Yau
 *
 */
public class Tester {
    SummaryGeneratingListener listener = new SummaryGeneratingListener();
    
    /**
     * Runs all JUnit tests.
     */
	public void runAll() {
	    LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
	      .selectors(selectPackage("test.finalsubmission"))
	      .filters(includeClassNamePatterns(".*Test"))
	      .build();
	    Launcher launcher = LauncherFactory.create();
	    launcher.registerTestExecutionListeners(listener);
	    launcher.execute(request);
	}

	public static void main(String[] args) {
	    Tester test = new Tester();
	    test.runAll();
	    
	    // Output test summary
	    TestExecutionSummary summary = test.listener.getSummary();
	    summary.printTo(new PrintWriter(System.out));
	}
}