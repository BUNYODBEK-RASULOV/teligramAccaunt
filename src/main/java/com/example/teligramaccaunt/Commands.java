package com.example.teligramaccaunt;

import java.awt.*;
import java.awt.event.KeyEvent;

public  class Commands {


    public static   void sendMessageToContact(String contact, String message) throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // Assuming you need to open the chat with a specific contact (e.g., Ctrl+T in Telegram)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Wait for the new chat to open
        Thread.sleep(2000);

        // Type the contact name or user ID
        typeText(contact);
        pressEnter();

        // Type the message
        typeText(message);
        pressEnter();
    }

    public static Runnable sleep(int t) {
        return ()->{ try { Thread.sleep(t);} catch (InterruptedException ignored) { } };
    }

    public static Runnable searchContact() throws Exception {
        Robot robot = new Robot();
        return ()->{
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        };
    }

    public static Runnable quit() throws Exception {
        Robot robot = new Robot();
        return ()->{
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_Q);
            robot.keyRelease(KeyEvent.VK_Q);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        };
    }

    public static  Runnable pressEnter() throws AWTException {
        Robot robot = new Robot();
        return ()->{
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        };
    }
    public static Runnable typeText(String text) throws AWTException {
        Robot robot = new Robot();
        return () -> {
                for (char c : text.toCharArray()) {
                 robot.delay(10);

                    // Use VK constants for specific keys
                    int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

                    // Special handling for ":" character
                    if (c == ':') {
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                    } else {
                        robot.keyPress(keyCode);
                        robot.keyRelease(keyCode);
                    }
                }
        };
        }

}
