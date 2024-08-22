package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private MyFirstClass myFirstClass;
    private Environment environment;

    @Autowired
    public void setMyFirstClass(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;  }


    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;  }

    public String getJavaVersion() {
        return environment.getProperty("java.version");	}

    public String getOsName() {	return environment.getProperty("os.version");	}

    public String tellStory() {  return "The Dependency injection : "+myFirstClass.sayHello();	}

    public String getreadproperty() { return environment.getProperty("my.custom.property"); }

}

