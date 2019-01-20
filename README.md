#Cours sur l'affichage

[Le cours](https://docs.google.com/presentation/d/e/2PACX-1vT5St4R9cJ3z-QVzDCprlz-2D3XOwqtyLkBb244emAAhK8JFKzP6gz0OaBBJQQBE2wENRPmAAi9XblB/pub?start=false&loop=false&delayms=3000)
[Le tp](https://docs.google.com/document/d/e/2PACX-1vSaMAIPdUgjNPen2LZIO7ajB679JJ4pZhjOffGOCU7WzRpb-E8iQUuah_gkFyP1ZffCHmMMThYLIOZz/pub)

# Avertissement

Sur les postes, il existe un problème lors du lancement du serveur via Intellij (les jsps sont mal detectés).
Pour pouvoir lancer le projet, utilisez le terminal dans intellij (alt + F12) et passer la commande suivante :
```bash
./gradlew 'module':bootRun
```

Par exemple pour lancer le server view java :
```bash
./gradlew server-views-java:bootRun
```

