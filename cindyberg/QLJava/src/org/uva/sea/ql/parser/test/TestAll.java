package org.uva.sea.ql.parser.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		TestExpressions.class, 
        TestStatements.class, 
        TestTypes.class,
        TestForm.class
		})

public class TestAll {

}
