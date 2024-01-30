package com.example.teligramaccaunt;


import java.io.IOException;
import java.util.List;

public class Accounts {
    private ProcessBuilder processBuilder;
    private Process telegramProcess;
    private String path ;
    public List<Runnable> scenarios;
    public Accounts(String telegramPath,List<Runnable> scenarios)  { if (telegramPath !=null) this.path=telegramPath; this.scenarios=scenarios;}

    public void start()throws IOException{
        processBuilder = new ProcessBuilder(path);
        telegramProcess=processBuilder.start();
    }

    public void stop() {
        if (telegramProcess != null) {
            try {
                // Forcefully terminate the process using taskkill command on Windows
                Runtime.getRuntime().exec("taskkill /F /PID " + telegramProcess.pid());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public  void run() { scenarios.forEach(Runnable::run);}

}
