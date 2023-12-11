package com.example.demo4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Global
{
    public static Global global;
    public String current_user;
    int memoryIndex;
    int score;
    int cnt=0;
    boolean flag=false;
    public Global()
    {
        this.memoryIndex = 0;
        this.score=0;
        this.current_user=null;
    }

    public static synchronized Global getInstance()
    {
        if(global==null) global = new Global();
        return global;
    }
    public static synchronized Global getScore()
    {
        if(global==null) global = new Global();
        return global;
    }
    public int getMemoryIndex() {
        return memoryIndex;
    }

    public void setMemoryIndex(int memoryIndex) {
        this.memoryIndex = memoryIndex;
    }

    public String get_date_time()
    {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dateTimeFormatter);
    }
}
