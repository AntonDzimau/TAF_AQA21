package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadItemsProperties {
    private static final Properties propertiesForAddItems;
    private static final Properties propertiesForRemoveItems;

    static {
        propertiesForAddItems = new Properties();
        propertiesForRemoveItems = new Properties();
        try {
            propertiesForAddItems.load(ReadItemsProperties.class.getClassLoader().getResourceAsStream("addItemsId.properties"));
            propertiesForRemoveItems.load(ReadItemsProperties.class.getClassLoader().getResourceAsStream("removeItemsId.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getIdToAddBackPack() {
        return propertiesForAddItems.getProperty("backpack");
    }

    public static String getIdToAddBikeLight() {
        return propertiesForAddItems.getProperty("bikeLight");
    }

    public static String getIdToAddBoltTShirt() {
        return propertiesForAddItems.getProperty("boltTShirt");
    }

    public static String getIdToAddFleeceJacket() {
        return propertiesForAddItems.getProperty("fleeceJacket");
    }

    public static String getIdToAddOnesie() {
        return propertiesForAddItems.getProperty("onesie");
    }

    public static String getIdToAddAllTheThingsTShirt() {
        return propertiesForAddItems.getProperty("allTheThingsTShirt");
    }

    public static String getIdToRemoveBackPack() {
        return propertiesForRemoveItems.getProperty("backpack");
    }

    public static String getIdToRemoveBikeLight() {
        return propertiesForRemoveItems.getProperty("bikeLight");
    }
    public static String getIdToRemoveBoltTShirt() {
        return propertiesForRemoveItems.getProperty("boltTShirt");
    }

    public static String getIdToRemoveFleeceJacket() {
        return propertiesForRemoveItems.getProperty("fleeceJacket");
    }

    public static String getIdToRemoveOnesie() {
        return propertiesForRemoveItems.getProperty("onesie");
    }

    public static String getIdToRemoveAllTheThingsTShirt() {
        return propertiesForRemoveItems.getProperty("allTheThingsTShirt");
    }
}
