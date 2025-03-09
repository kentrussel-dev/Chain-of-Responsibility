public class RecyclableCollector implements WasteCollector {
    private WasteCollector nextCollector;

    @Override
    public void setNextCollector(WasteCollector nextCollector) {
        this.nextCollector = nextCollector;
    }

    @Override
    public void handleRequest(WasteContainer container) {
        if (container.getType().equalsIgnoreCase("recyclable") && container.isFull()) {
            container.emptyContainer();
        } else if (nextCollector != null) {
            nextCollector.handleRequest(container);
        } else {
            System.out.println("No collector available for " + container.getType() + " waste.");
        }
    }
}