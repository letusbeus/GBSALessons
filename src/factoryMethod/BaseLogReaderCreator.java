package factoryMethod;
import templateMethod.LogReader;

public abstract class BaseLogReaderCreator {

    protected LogReader createLogReader(LogType logType, Object data) {
        LogReader logReader = createLogReaderInstance(logType);
        // TODO: Выполнение подготовительных действий
        logReader.setDataSource(data);
        logReader.setCurrentPosition(5);

        return logReader;
    }

    protected abstract LogReader createLogReaderInstance(LogType logType);
}

