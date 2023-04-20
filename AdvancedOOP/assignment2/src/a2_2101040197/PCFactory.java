package a2_2101040197;

/**
 * @overview PCFactory is a singleton factory class that creates instances of PC objects.
 */
public class PCFactory {
    private static PCFactory factory = new PCFactory();
    private PCFactory() {

    }

    /**
     * @effects Returns the singleton instance of PCFactory.
     * @return The singleton instance of PCFactory.
     */
    public static PCFactory getFactory() {
        return factory;
    }

    /**
     *
     * @param model the model of the PC
     * @param year the year of the PC
     * @param manufacturer the manufacturer of the PC
     * @param components the components of the PC
     * @return A new PC object with the given model, year, manufacturer, and components.
     */
    public PC createPC(String model, Integer year, String manufacturer, Set<String> components) {
        return new PC(model, year, manufacturer, components);
    }
}
