package postprocessor.i_registryprocessor;

import org.springframework.stereotype.Component;

@Component
public class Cat extends Animal{

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + "}";
    }
}
