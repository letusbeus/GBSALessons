package task1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class ProductService {

    private ArrayList<String> res;

    public void process1(){

    }

    public void process2(){
        res = null;
    }
    public Collection<String> readTextFile(File file) {

        // ПРЕДУСЛОВИЕ

        if (file.exists()) {
            if (file.length() > 5000)
                throw new RuntimeException("Размер файла более 5мб. Чтение файла запрещено!");
        }
        else {
            throw new RuntimeException("Файл не найден");
        }

        // TODO: Считывание данных...
        // TODO: Выполнение основного кода ...
        res = new ArrayList<>();
        res.add("AAAA");
        res.add("BBBB");
        res.add("CCCC");
        process1();
        // ИНВАРИАНТ
        validateResult(res);
        process2();
        // ИНВАРИАНТ
        validateResult(res);

        // ПОСТУСЛОВИЕ

        if (res == null) {
            throw new RuntimeException("Ошибка обработки данныз");
        }

        // TODO: Возвращаем результат выполнения задачи ...
        res = new ArrayList<>();
        return res;
    }

    private void validateResult(Collection<String> res) {
        if (res == null || res.size() == 0) {
            throw new RuntimeException("Некорректное состояние объекта");
        }
    }
}
