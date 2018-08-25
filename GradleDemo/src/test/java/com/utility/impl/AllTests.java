package test.java.com.utility.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConnectToHqlDBImpltest.class, InsertQueryTest.class })
public class AllTests {

}
