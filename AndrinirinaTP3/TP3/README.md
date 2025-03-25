L’ajout des Jokers nécessite une structure flexible. L’interface Card permet de généraliser la gestion des cartes en regroupant les méthodes communes (getValue(), getColor(), compareTo()).

Avantages :

    Extensibilité : Facile d’ajouter de nouveaux types de cartes.
    Uniformité : Hand et Battle manipulent des Card sans se soucier du type (BasicCard ou Joker).
    Lisibilité : Sépare clairement les cartes normales et spéciales sans duplication de code.

Conclusion : Ce choix rend le système plus modulaire, évolutif et réutilisable. 