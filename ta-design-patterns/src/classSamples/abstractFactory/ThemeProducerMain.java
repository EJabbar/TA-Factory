package classSamples.abstractFactory;

interface Theme {
    void show();
}

class CustomLight implements Theme {
    @Override
    public void show() {
        System.out.println("Showing custom light.");
    }
}

class CustomDark implements Theme {
    @Override
    public void show() {
        System.out.println("Showing custom dark.");
    }
}

class NativeLight implements Theme {
    @Override
    public void show() {
        System.out.println("Showing native light.");
    }
}

class NativeDark implements Theme {
    @Override
    public void show() {
        System.out.println("Showing native dark.");
    }
}

abstract class AbstractThemeFactory {
    public abstract Theme getTheme(String themeType);
}

class CustomThemeFactory extends AbstractThemeFactory {
    @Override
    public Theme getTheme(String themeType) {
        if ( themeType.equalsIgnoreCase("LIGHT")) {
            return new CustomLight();
        } else if (themeType.equalsIgnoreCase("DARK")) {
            return new CustomDark();
        } else {
            return null;
        }
    }
}

class NativeThemeFactory extends AbstractThemeFactory {
    @Override
    public Theme getTheme(String themeType) {
        if ( themeType.equalsIgnoreCase("LIGHT")) {
            return new NativeLight();
        } else if (themeType.equalsIgnoreCase("DARK")) {
            return new NativeDark();
        } else {
            return null;
        }
    }
}

class ThemeProducer {
    public static AbstractThemeFactory getFactory(boolean isNative) {
        if (isNative) {
            return new NativeThemeFactory();
        } else {
            return new CustomThemeFactory();
        }
    }
}


public class ThemeProducerMain {
    public static void main(String[] args) {
        boolean isNative = false;
        AbstractThemeFactory themeFactory = ThemeProducer.getFactory(isNative);
        Theme theme = themeFactory.getTheme("DARK");
        theme.show();
    }
}
