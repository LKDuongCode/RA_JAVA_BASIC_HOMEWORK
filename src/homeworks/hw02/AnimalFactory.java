package homeworks.hw02;

import java.util.logging.Logger;

public class AnimalFactory {
    public static final Logger logger = Logger.getLogger(AnimalFactory.class.getName());

    public static Animal createAnimal(String type) {
        try {
            if (type.equalsIgnoreCase("dog")) {
                return new Dog();
            }

            if (type.equalsIgnoreCase("cat")) {
                return new Cat();
            } else {
                throw new IllegalArgumentException("Unknown " + type);
            }
        } catch (IllegalArgumentException e) {
            logger.warning(e.getMessage());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

        return new Cat();
    }
}
