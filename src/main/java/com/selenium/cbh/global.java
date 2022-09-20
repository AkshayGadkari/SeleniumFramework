package com.selenium.cbh;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/main/java/com/selenium/cbh/global.properties")
public interface global extends Config {


    //Currently using only Strings , However Approach can be enhanced in the future.
    String URL();

    String runOnBrowserStack();

    String runOnLambdaTest();

    String runOnSauceLabs();

    String BS_Username();

    String BS_AccessKey();

    String LT_Username();

    String LT_AccessKey();


}
