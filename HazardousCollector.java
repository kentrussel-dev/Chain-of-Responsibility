public class HazardousCollector implements WasteCollector {
    private WasteCollector nextCollector;

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    @Override
    public void handleRequest(WasteContainer container) {
        if (container.getType().equalsIgnoreCase("hazardous") && container.isFull()) {
            container.emptyContainer();
        } else if (nextCollector != null) {
            nextCollector.handleRequest(container);
        } else {
            System.out.println("No collector available for " + container.getType() + " waste.");
        }
    }
}