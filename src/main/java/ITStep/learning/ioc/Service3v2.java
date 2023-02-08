package ITStep.learning.ioc;

import com.google.inject.Singleton;

@Singleton
public class Service3v2 implements IService3{
    @Override
    public void show() {
        System.out.println("I am " + this);
    }
}
