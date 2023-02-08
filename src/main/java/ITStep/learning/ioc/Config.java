package ITStep.learning.ioc;

import com.google.inject.Singleton;

public class Config implements IConfig{


   @Singleton
    @Override
    public void show() {
        System.out.println("I am " + this);
    }
}
