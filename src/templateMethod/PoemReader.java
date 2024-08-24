package templateMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */

public class PoemReader extends LogReader {

    private String data;

    @Override
    public Object getDataSource() {
        return data;
    }

    @Override
    public void setDataSource(Object data) {
        this.data = data.toString();
    }

    public PoemReader() {
    }

    public PoemReader(String data) {
        this.data = data;
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        Scanner sc = new Scanner(data);
        List<String> logList = new ArrayList<>();
        int counter = 0;
        while (sc.hasNextLine()){
            counter++;
            if (counter >= position){
                position = counter;
                String line = sc.nextLine();
                logList.add(line);
            }
            else {
                sc.nextLine();
            }
        }
        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
