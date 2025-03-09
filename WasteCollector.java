public interface WasteCollector {
    void handleRequest(WasteContainer container);
    void setNextCollector(WasteCollector nextCollector);
}