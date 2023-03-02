package postprocessor.h_factoryprocessor;

import org.springframework.stereotype.Component;

@Component
public class Red extends Color{

    @Override
    public String toString() {
        return "Red{" +
                "name='" + name + '\'' +
                '}';
    }
}
