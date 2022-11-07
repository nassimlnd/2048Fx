# Algo de movement :

- Écouter les touches qui sont pressées
  Si les touches des fleches sont pressées ou ZQSD
  Alors Enregistrer quelle touche a été touchée
  
- Switch case en fonction de quelle touche a été touché
  Exemple : Si la touche haut a été touché, alors on move toutes les tiles qui sont movable vers le haut, quand on move une tile vers le haut et qu'elle est en contact avec une autre on check si elles sont mergeable si oui on les merge en additionnant leur valeur. Sinon elle se colle.
  
  Fin du movement
  
  
  
## Fonctions à réaliser :
- isMovable(Direction d) : boolean → True si la cellule adjacente dans la direction touché est libre sinon False 
- isMergeable(Direction d) : boolean → True si la tile adjacente dans la direction touché est de même valeur alors elles sont dites mergeable.
- KeyListener → Écoute toutes les touches du clavier qui sont touchés et ne prend en compte uniquement les touches : { Z, Q, S, D, Flèche { HAUT, BAS, GAUCHE, DROITE }}
- move() : void → Bouge toutes les cellules vers la direction touché jusqu'à que toutes les cellules soient unmovable
- refreshGrid() : void → Refresh la grid suite au movement des cellules
