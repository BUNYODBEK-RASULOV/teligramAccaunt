package com.example.teligramaccaunt;
import java.util.ArrayList;
import java.util.List;


public class SendTelegramMessage {
//    public static final String PATH = "C:\\Users\\User\\AppData\\Roaming\\Telegram Desktop\\Telegram.exe";
    public static final String PATH = "C:\\Users\\User\\AppData\\Roaming\\Telegram Desktop\\ksc\\Telegram.exe";
    public static final String TEXT = "Nazoratni nazorat qilish kerak";
    public static final String CONTACT = "https://t.me/fozilov_jasur";
    public static List<Runnable> sc=new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Thread.sleep(2000);
//        sc.add(Commands.searchContact());
//        sc.add(Commands.sleep(1000));
//        sc.add(Commands.typeText(CONTACT));
//        sc.add(Commands.sleep(1000));
//        sc.add(Commands.pressEnter());
//        sc.add(Commands.typeText(TEXT));
//        sc.add(Commands.pressEnter());
//        sc.add(Commands.sleep(2000));
//        sc.add(Commands.typeText(TEXT));
//        sc.add(Commands.pressEnter());
//        sc.add(Commands.quit());

        for (int i = 0; i < 500; i++) {
            sc.add(Commands.sleep(10000));
            sc.add(Commands.typeText(TEXT));
            sc.add(Commands.sleep(10));
            sc.add(Commands.pressEnter());
        }



        Accounts account=new Accounts(PATH,sc);
        account.start();
        Thread.sleep(1000);
        account.run();
        Thread.sleep(1000);
        account.stop();
//        Thread.sleep(1000);
//        account.typeText("salom hammaga");

        // Your interactions with Telegram...
//        searchContact("novaSupportbot");
//        pressEnter(); // Open the chat with @novaSupportbot
//        Thread.sleep(2000); // Wait for the chat to open

    }










}
