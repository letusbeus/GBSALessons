import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Program {

    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * <p>
     * - Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
     * - Какие задачи можно делать – функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * - Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация ..., в файловой системе компьютера).
     * <p>
     * - Предложить варианты связывания всех уровней – сценарии использования. 3-4 сценария.
     * - Сквозная функция – создать новую 3D модель, сделать рендер для печати на принтере...
     */

    public static void main(String[] args) {

    }
}


class EditorDatabase implements Database {

    @Override
    public void load() {
        //TODO: Loading all project entities (models, textures, etc.)
    }

    @Override
    public void save() {
        //TODO: Saving the current state of all project entities (models, textures, etc.)
    }
}

/**
 * Database interface
 */
interface Database {
    void load();

    void save();
}

/**
 * 3D Model
 */
class Model3D implements Entity {
    private static int counter = 10000;
    private int id;

    private Collection<Texture> textures = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    {
        id = ++counter;
    }

    public Model3D() {
    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return String.format("Model3D #%s", id);
    }
}

/**
 * Texture
 */
class Texture implements Entity {
    private static int counter = 50000;

    private int id;

    {
        id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s", id);
    }
}

/**
 * Entity
 */
interface Entity {
    int getId();
}

/**
 * Project file
 */
class ProjectFile {
    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public ProjectFile(String fileName) {
        this.fileName = fileName;
        // TODO: load project settings from the file
        setting1 = 1;
        setting2 = "...";
        setting3 = false;
    }

    public String getFileName() {
        return fileName;
    }

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean isSetting3() {
        return setting3;
    }
}
