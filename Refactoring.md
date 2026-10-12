# Refactoring du Mastermind

## 1. Correction de la comparaison des lettres

**Probleme** : L'algorithme ne gérait pas correctement les occurences d'une lettre.

**Mofication** :
 - Ajout d'un tableau boolean[] utilise : pour savoir quelles occurences ont été parcourus
 - Comparaison en 2 passages : d'abord les placées puis les lettres mal placées

**Tests** : Ajout de tests sur les lettres répétées et la priorité des lettres bien placées.

**Pourquoi** : Pour corriger un bug et améliorer la maniere de verifier un mot !

## 2. Simplification de Joueur

**Probleme** : Le joueur faisait manuellement la méthode equals(), alors que celle ci est généré automatiquement avec les records.

**Mofication** :
 - Transformation de classe en record
 - Suppression de equals()

**Tests** : Verification de getNom() et equals()

**Pourquoi** : Reduction de code inutile, améliore la lisibilité