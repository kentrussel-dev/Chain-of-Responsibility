public class Main {
    public static void main(String[] args) {
        // Create the chain of responsibility
        WasteCollector organicCollector = new OrganicCollector();
        WasteCollector recyclableCollector = new RecyclableCollector();
        WasteCollector hazardousCollector = new HazardousCollector();

        organicCollector.setNextCollector(recyclableCollector);
        recyclableCollector.setNextCollector(hazardousCollector);

        // Create waste containers
        WasteContainer organicContainer = new WasteContainer("organic", 100, 100);
        WasteContainer recyclableContainer = new WasteContainer("recyclable", 100, 80);
        WasteContainer hazardousContainer = new WasteContainer("hazardous", 100, 100);

        // Trigger waste collection
        organicCollector.handleRequest(organicContainer);
        organicCollector.handleRequest(recyclableContainer);
        organicCollector.handleRequest(hazardousContainer);
    }
}