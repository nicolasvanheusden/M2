# VAN HEUSDEN NICOLAS 208938

## TP NOTÉ REDIS

Ce projet est le tp noté de NoSQL/NewSQL.

## La base de donnée

<p>J'ai refais une base de donnée plus petite avec moins de champs pour simplifier le tp.</p>
<p>On peut trouver le dump dans le fichier drug_dump.sql sinon voici le code sql pour re-créer la table vide</p>

```sql
CREATE TABLE drug(
  cip7 INTEGER PRIMARY KEY,
  name VARCHAR(50),
  cis BIGINT
);
```

<p>Pour la configuration de la base de donnée, je n'ai rien eu à configurer sur mon PC mais cela peut varier en fonction
du PC de chacun.</p>

<p>Pour modifier la configuration à la base de donnée voir le constructeur de </p>
 
`DrugRepositoryPSQL`

## Application

<p>L'application a pour rôle d'ajouter 5 médicaments dans la BDD.</p>

<p>
Pour cela elle commence par ajouter 3 médicaments ce qui rempli le cache.<br>
Ensuite on simule une demande des médicaments de cip7:1 et cip7:3.<br>
On ajoute ensuite un 4ème médicament et le cache étant plein, il va retirer le médicament cip7:2 car il est le moins utilisé.<br>
On utilise ensuite ce médicament plus de fois que le cip7:3.<br>
Puis on ajoute le 5ème médicament et le cache vient retirer le cip7:3 car il est le moins utilisé.<br>
Enfin on vient ré-utiliser le cip7:2, donc on retire le 5ème médicament car il est le moins utilisé.<br>
</p>

<p>Maintant si on regarde dans la BDD, on a bien les 5 médicaments et le cache continer le zSet ainsi que 3 médicaments.</p>


