#!/bin/bash

# Se dirige dans le dossier src
cd ./src

# Compile les fichiers .java du dossier src sous javafx
javac --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml *.java

# Condition si la première commande s'est effectué
if [ $? -eq 0 ]; then
  # Déplace les fichiers .class dans le dossier bin
  mv *.class ../bin/
  # Se déplace dans ce fichiers bin
  cd ../bin/
  # Compile l'Executable du dossier bin
  java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls Executable
else
  # Si la compilation échoue, nous renvoyons le message suivant :
  echo "La compilation a échoué, regardez les messages d'erreurs ce-dessus"
  # On implique que les messages d'erreurs de compilation java ce sont affcihés au dessus
fi
