INSERT INTO roles (design_r) VALUES ('admin');
INSERT INTO roles (design_r) VALUES ('commercial');


INSERT INTO user (actif, email, nomuser, password, user_update, usercreation, id_role) VALUES (1, 'chamakhwassim1@gmail.com', 'wassim', 'wassim2', 1, 1, 2)
INSERT INTO user (actif, email, nomuser, password, user_update, usercreation, id_role) VALUES (1, 'melekboubaker@gmail.com', 'melek', 'melek2', 1, 1, 2)
INSERT INTO user (actif, email, nomuser, password, user_update, usercreation, id_role) VALUES (1, 'hafedh@gmail.com', 'hafedh', 'hafedj2', 1, 1, 1)
INSERT INTO user (actif, email, nomuser, password, user_update, usercreation, id_role) VALUES (1, 'adel@gmail.com', 'adell', 'adel2', 1, 1, 1)
INSERT INTO user (actif, email, nomuser, password, user_update, usercreation, id_role) VALUES (1, 'amal@gmail.com', 'amal', 'amal2', 1, 1, 2)


INSERT INTO types_mission (nom_type) VALUES ("mission_prix");
INSERT INTO types_mission (nom_type) VALUES ("mission_gamme");
INSERT INTO types_mission (nom_type) VALUES ("mission_liste");

INSERT INTO structuremarchandise (depart,libelle_depart,groupe,libelle_grp,rayon,libelle_rayon,famille,code_fam,libelle_fam,sous_famille,libelle_sfamille,categorie,libelle_categ,sous_categ,libelle_scateg) VALUES (1,"ALIMENTAIRE",11,"PGC",1101,"EPICERIE SUCREE",1101101,101,"BISCOTTE ET ASSIMILES",110110101,"BISCOTTES NORMALES",11011,"AUTRES BISCOTTES",110111,"JUSQU A 250 GR");
INSERT INTO structuremarchandise (depart,libelle_depart,groupe,libelle_grp,rayon,libelle_rayon,famille,code_fam,libelle_fam,sous_famille,libelle_sfamille,categorie,libelle_categ,sous_categ,libelle_scateg) VALUES (1,'ALIMENTAIRE',11,'PGC',1101,'EPICERIE SUCREE',1101101,101,'BISCOTTE ET ASSIMILES',110110103,'PAINS BRAISES',11012,'SANS SEL',110121,'JUSQU A 250 GR');
INSERT INTO structuremarchandise (depart,libelle_depart,groupe,libelle_grp,rayon,libelle_rayon,famille,code_fam,libelle_fam,sous_famille,libelle_sfamille,categorie,libelle_categ,sous_categ,libelle_scateg) VALUES (1,'ALIMENTAIRE',11,'PGC',1101,'EPICERIE SUCREE',1101101,101,'BISCOTTE ET ASSIMILES',110110105,'PAINS GRILLES',11013,'TARTINES',110131,'JUSQU A 250 GR');
INSERT INTO structuremarchandise (depart,libelle_depart,groupe,libelle_grp,rayon,libelle_rayon,famille,code_fam,libelle_fam,sous_famille,libelle_sfamille,categorie,libelle_categ,sous_categ,libelle_scateg) VALUES (1,'ALIMENTAIRE',11,'PGC',1101,'EPICERIE SUCREE',1101101,101,'BISCOTTE ET ASSIMILES',110110104,'PAINS GRILLES',11014,'SANS SEL',110141,'JUSQU A 250 GR');
INSERT INTO structuremarchandise (depart,libelle_depart,groupe,libelle_grp,rayon,libelle_rayon,famille,code_fam,libelle_fam,sous_famille,libelle_sfamille,categorie,libelle_categ,sous_categ,libelle_scateg) VALUES (1,'ALIMENTAIRE',11,'PGC',1101,'EPICERIE SUCREE',1101101,101,'BISCOTTE ET ASSIMILES',110110109,'ASSIMILES',11015,'TOAST',110151,'JUSQU A 250 GR');
