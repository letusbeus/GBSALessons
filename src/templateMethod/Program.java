package templateMethod;

public class Program {

    public static String data = """
            У лукоморья дуб зеленый,
            Златая цепь на дубе том:
            И днем и ночью кот ученый
            Все ходит по цепи кругом;
            Идёт направо - песнь заводит,
            Налево - сказку говорит.""";

    public static void main(String[] args) {
        LogReader logReader = new PoemReader(data);
        logReader.setCurrentPosition(3);

        for (LogEntry log : logReader.readLogEntry()){
            System.out.println(log.getText());
        }
    }

}
