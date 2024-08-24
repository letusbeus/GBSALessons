package factoryMethod;

import templateMethod.LogEntry;
import templateMethod.LogReader;

public class Program {
    public static String data = """
            Ночь, улица, фонарь, аптека,
            Бессмысленный и тусклый свет.
            Живи ещё хоть четверть века —
            Всё будет так. Исхода нет.
            Умрёшь — начнёшь опять сначала
            И повторится всё, как встарь:
            Ночь, ледяная рябь канала,
            Аптека, улица, фонарь.""";

    public static void main(String[] args) {
        LogReader logReader = new ConcreteReaderCreator()
                .createLogReader(LogType.Poem, data);

        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }
    }
}
