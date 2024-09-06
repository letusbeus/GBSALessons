import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;


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



/**
 * Business logical layer implementation
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer{

    private DatabaseAccess databaseAccess;


    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels())
            processRender(model);
    }

    private Random random = new Random();

    private void processRender(Model3D model){
        try
        {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * Business logical layer interface
 */
interface BusinessLogicalLayer {
    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();
}

/**
 * Database access layer interface
 */
interface DatabaseAccess {
    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}

/**
 * Database interface
 */
interface Database {
    void load();

    void save();

    Collection<Entity> getAll();
}

/**
 * Entity
 */
interface Entity {
    int getId();
}

/**
 * Database implementation
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> textures = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                textures.add((Texture) entity);
            }
        }
        return textures;
    }


    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }
}

/**
 * Database
 **/
class EditorDatabase implements Database {

    private final ProjectFile projectFile;
    private final Random random = new Random();
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Loading all project entities (models, textures, etc.)
    }

    @Override
    public void save() {
        //TODO: Saving the current state of all project entities (models, textures, etc.)
    }

    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }

}

/**
 * 3D Model
 */
class Model3D implements Entity {
    private static int counter = 10000;
    private final int id;

    private Collection<Texture> textures = new ArrayList<>();

    {
        id = ++counter;
    }

    public Model3D() {
    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    @Override
    public int getId() {
        return id;
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

    private final int id;

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
 * Project file
 */
class ProjectFile {
    private final String fileName;
    private final int setting1;
    private final String setting2;
    private final boolean setting3;

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
