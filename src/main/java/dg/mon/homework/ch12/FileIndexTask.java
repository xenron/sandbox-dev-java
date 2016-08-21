package dg.mon.homework.ch12;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class FileIndexTask implements Runnable {

    private File dir;

    private String indexFile;

    public File getDir() {
        return dir;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public void setDir(String dir) {
        this.dir = new File(dir);
    }

    private String[] extensions = {"txt", "log", "csv"};

    public void setIndexFile(String _indexfile) {
        this.indexFile = _indexfile;
    }

    @Override
    public void run() {
        System.out.println(dir.getAbsolutePath());
        List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
        System.out.println("find files:" + files.size());
        StringBuilder sb = new StringBuilder();

        try {
            for (File file : files) {
                String fileCont = FileUtils.readFileToString(file, Charset.forName("UTF-8")).replace("`", "").replaceAll("\r|\n", " ");
                sb.append(file.getName() + "`" + file.getAbsolutePath() + "`" + fileCont + "\n");
                System.out.println(file.getName() + ":" + fileCont);
            }
            FileUtils.writeStringToFile(new File(indexFile), sb.toString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
