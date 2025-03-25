package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import input.Attribute;
import input.Class;
import input.ConcreteMethod;
import input.Constructor;
import input.Interface;
import input.Method;
import input.Parameter;
import input.Enum;

public class TestProgram {
    public static void main(String[] args) throws IOException{
        File directory = new File("../src/output/card/");

        //Interface d'une carte
        File file = new File(directory, "Card.java");
        Interface card = new Interface("Card", "Représentation d'une carte", null, null);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("package output.card;");
            writer.newLine();
            card.generate(writer);
        }

        //Couleur d'une carte
        file = new File(directory, "Color.java");
        String values = "   CLUB, DIAMOND, HEART, SPADE";
        Enum color = new Enum("Color", "Couleur d'une carte", values, null, null);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("package output.card;");
            writer.newLine();
            color.generate(writer);
        }

        //Valeur d'une carte
        file = new File(directory, "Value.java");
        values = "   TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;";
        Enum value = new Enum("Value", "Valeur d'une carte", values, null, null);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("package output.card;");
            writer.newLine();
            value.generate(writer);
        }

        //Instance d'une carte
        ArrayList<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(new Attribute("color", "Couleur de la carte", "Color"));
        attributes.add(new Attribute("value", "Valeur de la carte", "Value"));
        ArrayList<Method> methods = new ArrayList<Method>();
        ArrayList<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(new Parameter("color", "Color"));
        parameters.add(new Parameter("value", "Value"));
        String[] body = {
            "       this.color = color;",
            "       this.value = value;"
        };
        methods.add(new Constructor("ColoredCard", "Initialisation de la couleur et de la valeur", parameters, body));
        String[] getColor = {
            "       return this.color;"
        };
        methods.add(new ConcreteMethod("getColor", "Accesseur de la couleur", "Color", null,getColor));
        String[] getValue = {
            "       return value;"
        };
        methods.add(new ConcreteMethod("getValue", "Accesseur de la valeur", "Value", null,getValue));
        Class coloredCard = new Class("ColoredCard", "Instance d'une carte", null, attributes, methods, card);
        file = new File(directory, "ColoredCard.java");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("package output.card;");
            writer.newLine();
            coloredCard.generate(writer);
        }
    }
    
     
}