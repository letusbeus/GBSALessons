package factoryMethod;

import templateMethod.LogEntry;
import templateMethod.LogReader;

public class TextFileReader extends LogReader {

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {
        // Реализация метода установки источника данных
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}
