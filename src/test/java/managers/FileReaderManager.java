package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {
    private static final FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    public FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader(){
        return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
    }
}
