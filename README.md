# IHM_TP2_GROSDAILLON_BAMBA

Réalisé par Hugo GROS-DAILLON et Samuel BAMBA.

## Execution du programme

Lancer le fichier MarkingMenuView.java.

## Choix d'implémentation.

Nous avons décidés de faire pour ce TP un MarkingMenu avec un mode expert qui comporte un menu et deux sous menu.

Notre MarkingMenu aura un comportement identique à celui présenté sur cette video : https://www.youtube.com/watch?v=dtH9GdFSQaw
Pour gagner énormément en rapidité lorsqu'on est expert, il n'y a pas besoin de cliquer pour sélectionner un outil ou une couleur. Déplacer le curseur dans la bonne direction permet la sélection et l'application.

Le premier menu comporte deux boutons : "Outils" et "Couleurs".

En déplaçant le curseur vers "Outils", un Marking Menu est réouvert avec 4 outils, "pen", "rectangle", "ellipse" et "line", déplacer le curseur vers un de ces outils permet de changer l'outil de dessin courrant.

En déplaçant le curseur vers "Couleurs", un Marking Menu est réouvert avec 8 couleurs différentes, déplacer le curseur vers une de ces couleurs permet de changer la couleur courrante de dessin.


Dans notre implémentation, nous avons décidés de faire un marking menu avec un maximum de 8 boutons car nous avions vu en cours qu'un Marking Menu ne devait pas avoir plus de 7 à 9 éléments pour être accepté par l'utilisateur. Nous avons donc décidés d'avoir un maximum de 8 éléments par marking menu, il est tout de même possible d'avoir plus de 8 éléments en combinant les marking menus comme nous l'avons fait (Par exemple la selection de Outils ouvre un autre marking menu avec la liste des outils).

## Touches

Pour dessiner sur la zone de dessin, utilisais simplement le clic gauche, restez appuyés et bougez votre souris.

Pour activer le marking menu, restez appuyés sur le clic droit de la souris, tout en restant appuyés sur le bouton, selectionnez ce que vous souhaitez sélectionner et relacher le bouton droit pour fermer le marking menu.

Nous avons fait le choix de rester appuyé sur le clic droit de la souris pour ouvrir le marking menu ainsi que de relacher le clic droit de la souris pour fermer le marking menu pour rester dans le même schema que le marking menu présenté sur la vidéo citée plus haut, ainsi que sur les marking menu que nous connaissions (Jeux Video -> League of Legends.)


