package com.JoeSorensen;

import processing.core.PApplet;

import controlP5.*;


public class ChatBotGUI extends PApplet {

    private static String[] processingArgs = {"ChatBotGUI"};
    private ControlP5 cp5;
    private Textarea myTextarea;
    private Textfield myTextfield;
    private Chatbot chat;
    private String s;

    public void settings() {
        size(960, 540);
    }

    public void setup() {
        cp5 = new ControlP5(this);
        background(0);
        myTextfield = cp5.addTextfield("input").setPosition(0, 520).setSize(920, 20).setAutoClear(false);
        cp5.addBang("Submit").setPosition(920, 520).setSize(40, 20);
        myTextarea = cp5.addTextarea("txt").setPosition(0,0).setSize(960,520).setLineHeight(14)
                .setColorBackground(color(0,100)).setColorForeground(color(255,100))
                .scroll(1);
        chat = new Chatbot();
        s = myTextarea.getText();
        s += chat.getGreeting()+"\n";
        myTextarea.setText(s);
    }


    public void draw() {
        background(0);
    }

    public void keyPressed() {
        if (keyCode == ENTER) {
            Submit();
        }
    }

    private void Submit() {
        String input = cp5.get(Textfield.class, "input").getText();
        myTextfield.clear();
        if(input.contains("Bye"))
            System.exit(0);
        if(input.contains("Satan"))
            System.exit(666);
        String response = chat.getResponse(input);
        s += input+"\n"+response+"\n";
        myTextarea.setText(s);
    }

    public static void main(String[] args) {
        ChatBotGUI front = new ChatBotGUI();
        PApplet.runSketch(processingArgs, front);
        System.out.println();
        System.out.println("Chatbot started!");
        System.out.println("==========================================\n"+"   AP CSA Final Project: Magpie ChatBot\n"+"   Main Graphical Frontend: JoeSorensen\n"+"   Extra Graphical Frontend: Mikerific\n"+" ChatBot Code: Mikerific, and JoeSorensen\n"+"\t   Nerdy References: Everyone!\n"+"==========================================");
    }
}
