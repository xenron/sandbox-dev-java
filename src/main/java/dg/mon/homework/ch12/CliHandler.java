package dg.mon.homework.ch12;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class CliHandler {

    private String dir ;

    public void setDir(String _dir){
        this.dir = _dir;
    }

    public Tuple[] filterKeyword (String keyword){

        List<Tuple> ret2 = new ArrayList<Tuple>();

        try {
            List<String> fileList = FileUtils.readLines(new File(dir),"UTF-8");
            for(String file:fileList)
            {
                if(!file.contains("`") || file.split("`").length <3)continue;
                String fileName = file.split("`")[0];
                String filePath = file.split("`")[1];
                String fileCont = file.split("`")[2];
                if(fileName.contains(keyword) || fileCont.contains(keyword))
                    ret2.add(new Tuple(fileName,filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Tuple[] ret = new Tuple[ret2.size()];
        ret2.toArray(ret);
        return ret;
    }

    private void filterKeyword(List<String> fileList, String keyword){
        for(String file:fileList)
            if(file.contains(keyword)) System.out.println(file);
    }

    //accept user input and then filter the index file then output the filename
    public void handleCmd() throws IOException
    {
        List<String> fileList = FileUtils.readLines(new File(dir),"UTF-8");
        for(String file:fileList)
            System.out.println(file);

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the keyword you want to search:");
        String keyword = bfr.readLine();
        while(!keyword.equals("exit")){
            //print keyword in the filename
            filterKeyword(fileList,keyword);
            System.out.println("Please input the keyword you want to search:");
            keyword = bfr.readLine();
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("testabc " );
        sb.append("\n  abcdefg");
        sb.append("\r    xxxxx");
        sb.append("\r\n     yyyyyy");
        System.out.println(sb.toString());
        System.out.println(sb.toString().replaceAll("\r|\n", " "));
    }


}
